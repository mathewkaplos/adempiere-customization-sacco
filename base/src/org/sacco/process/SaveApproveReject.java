package org.sacco.process;

import org.compiere.model.SLoan;
import org.compiere.process.SvrProcess;

public class SaveApproveReject extends SvrProcess {

	@Override
	protected void prepare() {

	}

	@Override
	protected String doIt() throws Exception {
		SLoan loan = new SLoan(getCtx(), getRecord_ID(), get_TrxName());
		if (loan.isApproved()) {
			loan.setapproval_done(true);
			loan.setloanstatus("APPROVED");
			loan.save();
		}
		return null;
	}

}
