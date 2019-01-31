package org.sacco.callout;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.CalloutEngine;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.Repayment;
import org.compiere.model.SLoan;
import org.compiere.model.SLoanType;
import org.compiere.model.Sacco;
import org.compiere.util.Env;
import org.sacco.loan.Formula;
import zenith.util.Util;

public class LoanRemmittanceCallout extends CalloutEngine {
	public String newRecord(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value) {
		if (value == null)
			return "";
		int remmittanceTabID = 1000035;
		int refundTabID = 1000044;
		int val = (Integer) value;
		SLoan loan = new SLoan(Env.getCtx(), val, null);

		// period
		Sacco sacco = Sacco.getSaccco();
		int C_Period_ID = sacco.getsaccoperiod_ID();
		mTab.setValue("C_Period_ID", C_Period_ID);
	

		if (mTab.getAD_Tab_ID() == remmittanceTabID) {

			BigDecimal expectedPrincipal = Util.round(loan.getPeriodPrincipal(C_Period_ID));
			BigDecimal expectedInterest = Util.round(loan.getPeriodInterest(C_Period_ID));
			BigDecimal gross = expectedPrincipal.add(expectedInterest);
			mTab.setValue("PaymentAmount", gross);
			mTab.setValue("Principal", expectedPrincipal);
			mTab.setValue("expectedinterest", expectedInterest);
			mTab.setValue("gross_amount_due", gross);

			mTab.setValue("bankgl_Acct", loan.getbankgl_Acct());
			mTab.setValue("s_loantype_ID", loan.gets_loantype_ID());
			mTab.setValue("loan_gl_Acct", loan.getloan_gl_Acct());

			// interestgl_Acct
			SLoanType loanType = new SLoanType(Env.getCtx(), loan.gets_loantype_ID(), null);
			mTab.setValue("interestgl_Acct", loanType.getloantypeinterestgl_Acct());
			mTab.setValue("is_repayment", true);
			//

		} else if (mTab.getAD_Tab_ID() == refundTabID) {
			String l_repayments_ID_String = Env.getContext(Env.getCtx(), 2, 1, "l_repayments_ID");

			if (l_repayments_ID_String != null && !"".equals(l_repayments_ID_String)) {
				try {
					int l_repayments_ID = Integer.parseInt(l_repayments_ID_String);
					if (l_repayments_ID > 0) {
						isRefund(ctx, WindowNo, mTab, mField, true);
						Repayment repayment = new Repayment(Env.getCtx(), l_repayments_ID, null);
						mTab.setValue("PaymentAmount", repayment.getPaymentAmount());
						mTab.setValue("Principal", repayment.getPrincipal());
						mTab.setValue("interest", repayment.getInterest());
					}
				} catch (NumberFormatException e) {
					System.out.println("This is not a number: l_repayments_ID_String");
				}

			} else {
				isTopUp(ctx, WindowNo, mTab, mField, true);
			}

			mTab.setValue("LoanNo", loan.getDocumentNo());
			mTab.setValue("loanbalance", loan.getloanbalance());
			mTab.setValue("s_loantype_ID", loan.gets_loantype_ID());
		}
		return NO_ERROR;
	}

	//
	public String paymentAmount(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value) {
		if (value == null)
			return "";
		if (mTab.getAD_Tab_ID() == 1000044)
			return null;
		double gross = ((BigDecimal) value).doubleValue();
		double interest = ((BigDecimal) mTab.getValue("expectedinterest")).doubleValue();
		// Gross = P+I
		// P=Gross- I
		double P = gross - interest;
		if (P > 0) {
			mTab.setValue("Principal", BigDecimal.valueOf(P));
		} else {
			mTab.setValue("Principal", Env.ZERO);
		}

		return NO_ERROR;
	}

	//
	public String documentNo(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value) {
		if (value == null)
			return "";
		String documentNo = (String) mTab.getValue("DocumentNo");
		mTab.setValue("ReceiptNo", documentNo);
		mTab.setValue("VoucherNo", documentNo);
		return NO_ERROR;
	}

	// org.sacco.callout.LoanRemmittanceCallout.isRefund
	public String isRefund(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value) {
		if (value == null)
			return "";
		boolean val = (Boolean) value;

		if (val) {
			mTab.setValue("is_topup", false);
			mTab.setValue("Comments", "Loan Refund");
		}

		else {
			mTab.setValue("is_topup", true);
			mTab.setValue("Comments", "Loan Top-Up");
		}
		return NO_ERROR;
	}

	// org.sacco.callout.LoanRemmittanceCallout.isTopUp
	public String isTopUp(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value) {
		if (value == null)
			return "";
		boolean val = (Boolean) value;

		if (val) {
			mTab.setValue("is_refund", false);
			mTab.setValue("Comments", "Loan To-Up");
		}

		else {
			mTab.setValue("is_refund", true);
			mTab.setValue("Comments", "Loan Refund");
		}
		return NO_ERROR;
	}

	// PaymentDate
	// org.sacco.callout.LoanRemmittanceCallout.PaymentDate
	public String PaymentDate(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value) {
		if (value == null)
			return "";
		int s_loantype_ID = (int) mTab.getValue("s_loantype_ID");
		SLoanType type = new SLoanType(ctx, s_loantype_ID, null);
		if (type.getmonthlyintcalc().equals("0")) {
			Timestamp paymentDate = (Timestamp) value;
			int s_loans_ID = (int) mTab.getValue("s_loans_ID");
			SLoan loan = new SLoan(ctx, s_loans_ID, null);
			long days = loan.getLastRepayPeriodInDays(paymentDate);
			double P = loan.getloanbalance().doubleValue();
			double R = loan.getloaninterestrate().doubleValue();
			double yearDays = 365;
			double T = days / yearDays;

			String method = type.getinterestformula();
			Formula formula = new Formula(P, R, T, method);
			BigDecimal interet = formula.getInterest();
			mTab.setValue("expectedinterest", interet);
		}
		return NO_ERROR;
	}
}
