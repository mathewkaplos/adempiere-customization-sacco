package org.sacco.loan;

import java.math.BigDecimal;
import org.compiere.model.LoanSchedule;
import org.compiere.util.Env;

import z.mathew.Finance;
import z.mathew.FinanceLib;

public class Amortized extends Schedule implements InterestPayMethod {

	public Amortized(int loanID) {
		super(loanID);
		// TODO Auto-generated constructor stub
	}

	// Amortized
	public void execute() {

		BigDecimal tempPaid = Env.ZERO;
		System.out.println(loanSchedules);
		for (int i = 0; i < loanSchedules.length; i++) {
			LoanSchedule ls = loanSchedules[i];
			if (ls == null)
				continue;
			double annaulRate = R;
			double percent = 100;
			//double period = periods;
			double rPer = annaulRate / percent;
			System.out.println("Amortized..");

			double r = rPer;
			double p = loan.getloanamount().doubleValue();
			double inter = Finance.ipmt(r, i + 1, loanSchedules.length, p);
			interest = BigDecimal.valueOf(Math.round(inter * 100D) / 100D);
			total_interest = total_interest.add(interest);

			double principal = Finance.ppmt(r, i + 1, loanSchedules.length, p, 0, 0);
			double pmt = Finance.pmt(r, loanSchedules.length, p);

			BigDecimal constantRepayment = BigDecimal.valueOf(Math.round(pmt * 100D) / 100D);

			ls.setmonthlyrepayment(constantRepayment.negate());

			double pv = FinanceLib.pv(r, loanSchedules.length - (i + 1), pmt, 0, false);
			BigDecimal balance = BigDecimal.valueOf(Math.round(pv * 100D) / 100D);

			ls.setloanbalance(balance);
			BigDecimal principalRepayment = BigDecimal.valueOf(Math.round(principal * 100D) / 100D);
			ls.setprincipalrepayment(principalRepayment.negate());
			ls.setinterestamount(interest.negate());

			ls.save();
			// paid amount
			tempPaid = tempPaid.add(ls.getamountdue());
			ls.setamountpaid(tempPaid);

			ls.save();

			loan.setstatementbal(constantRepayment.multiply(BigDecimal.valueOf(loanSchedules.length)).abs());
			loan.save();
		}
	}
}
