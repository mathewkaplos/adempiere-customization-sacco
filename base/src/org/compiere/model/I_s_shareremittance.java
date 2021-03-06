/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2007 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
package org.compiere.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.util.KeyNamePair;

/** Generated Interface for s_shareremittance
 *  @author Adempiere (generated) 
 *  @version Release 3.8.0
 */
public interface I_s_shareremittance 
{

    /** TableName=s_shareremittance */
    public static final String Table_Name = "s_shareremittance";

    /** AD_Table_ID=1000029 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 7 - System - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(7);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name affectsdr */
    public static final String COLUMNNAME_affectsdr = "affectsdr";

	/** Set Affects DR	  */
	public void setaffectsdr (boolean affectsdr);

	/** Get Affects DR	  */
	public boolean isaffectsdr();

    /** Column name AmountInWords */
    public static final String COLUMNNAME_AmountInWords = "AmountInWords";

	/** Set AmountInWords	  */
	public void setAmountInWords (String AmountInWords);

	/** Get AmountInWords	  */
	public String getAmountInWords();

    /** Column name bankaccount */
    public static final String COLUMNNAME_bankaccount = "bankaccount";

	/** Set bankaccount	  */
	public void setbankaccount (String bankaccount);

	/** Get bankaccount	  */
	public String getbankaccount();

    /** Column name BankAccount_Acct */
    public static final String COLUMNNAME_BankAccount_Acct = "BankAccount_Acct";

	/** Set Bank Account	  */
	public void setBankAccount_Acct (String BankAccount_Acct);

	/** Get Bank Account	  */
	public String getBankAccount_Acct();

    /** Column name btn_save_deposit */
    public static final String COLUMNNAME_btn_save_deposit = "btn_save_deposit";

	/** Set Save	  */
	public void setbtn_save_deposit (String btn_save_deposit);

	/** Get Save	  */
	public String getbtn_save_deposit();

    /** Column name btn_save_share_remittance */
    public static final String COLUMNNAME_btn_save_share_remittance = "btn_save_share_remittance";

	/** Set Save Withdrawal	  */
	public void setbtn_save_share_remittance (String btn_save_share_remittance);

	/** Get Save Withdrawal	  */
	public String getbtn_save_share_remittance();

    /** Column name C_Bank_ID */
    public static final String COLUMNNAME_C_Bank_ID = "C_Bank_ID";

	/** Set Bank.
	  * Bank
	  */
	public void setC_Bank_ID (int C_Bank_ID);

	/** Get Bank.
	  * Bank
	  */
	public int getC_Bank_ID();

    /** Column name ChequeDate */
    public static final String COLUMNNAME_ChequeDate = "ChequeDate";

	/** Set Cheque Date	  */
	public void setChequeDate (Timestamp ChequeDate);

	/** Get Cheque Date	  */
	public Timestamp getChequeDate();

    /** Column name ChequeNo */
    public static final String COLUMNNAME_ChequeNo = "ChequeNo";

	/** Set Cheque No	  */
	public void setChequeNo (String ChequeNo);

	/** Get Cheque No	  */
	public String getChequeNo();

    /** Column name CommissionAmt */
    public static final String COLUMNNAME_CommissionAmt = "CommissionAmt";

	/** Set Commission Amount.
	  * Commission Amount
	  */
	public void setCommissionAmt (BigDecimal CommissionAmt);

	/** Get Commission Amount.
	  * Commission Amount
	  */
	public BigDecimal getCommissionAmt();

    /** Column name contributionrate */
    public static final String COLUMNNAME_contributionrate = "contributionrate";

	/** Set Contribution Rate	  */
	public void setcontributionrate (BigDecimal contributionrate);

	/** Get Contribution Rate	  */
	public BigDecimal getcontributionrate();

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name DebitRaiseAffected */
    public static final String COLUMNNAME_DebitRaiseAffected = "DebitRaiseAffected";

	/** Set Affects Monthly Debit Raise	  */
	public void setDebitRaiseAffected (boolean DebitRaiseAffected);

	/** Get Affects Monthly Debit Raise	  */
	public boolean isDebitRaiseAffected();

    /** Column name disp001 */
    public static final String COLUMNNAME_disp001 = "disp001";

	/** Set disp001	  */
	public void setdisp001 (boolean disp001);

	/** Get disp001	  */
	public boolean isdisp001();

    /** Column name DocStatus */
    public static final String COLUMNNAME_DocStatus = "DocStatus";

	/** Set Document Status.
	  * The current status of the document
	  */
	public void setDocStatus (String DocStatus);

	/** Get Document Status.
	  * The current status of the document
	  */
	public String getDocStatus();

    /** Column name DocumentNo */
    public static final String COLUMNNAME_DocumentNo = "DocumentNo";

	/** Set Document No.
	  * Document sequence number of the document
	  */
	public void setDocumentNo (String DocumentNo);

	/** Get Document No.
	  * Document sequence number of the document
	  */
	public String getDocumentNo();

    /** Column name intbalance */
    public static final String COLUMNNAME_intbalance = "intbalance";

	/** Set Interest Balance	  */
	public void setintbalance (BigDecimal intbalance);

	/** Get Interest Balance	  */
	public BigDecimal getintbalance();

    /** Column name is_supervised */
    public static final String COLUMNNAME_is_supervised = "is_supervised";

	/** Set Is Supervised	  */
	public void setis_supervised (boolean is_supervised);

	/** Get Is Supervised	  */
	public boolean is_supervised();

    /** Column name is_withdrawal */
    public static final String COLUMNNAME_is_withdrawal = "is_withdrawal";

	/** Set Is Withdrawal	  */
	public void setis_withdrawal (boolean is_withdrawal);

	/** Get Is Withdrawal	  */
	public boolean is_withdrawal();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name IsComplete */
    public static final String COLUMNNAME_IsComplete = "IsComplete";

	/** Set Complete.
	  * It is complete
	  */
	public void setIsComplete (boolean IsComplete);

	/** Get Complete.
	  * It is complete
	  */
	public boolean isComplete();

    /** Column name mcode */
    public static final String COLUMNNAME_mcode = "mcode";

	/** Set Member #	  */
	public void setmcode (String mcode);

	/** Get Member #	  */
	public String getmcode();

    /** Column name monthclosingbal */
    public static final String COLUMNNAME_monthclosingbal = "monthclosingbal";

	/** Set Month Closing Balance	  */
	public void setmonthclosingbal (BigDecimal monthclosingbal);

	/** Get Month Closing Balance	  */
	public BigDecimal getmonthclosingbal();

    /** Column name needs_supervision */
    public static final String COLUMNNAME_needs_supervision = "needs_supervision";

	/** Set Needs To Be Supervised	  */
	public void setneeds_supervision (boolean needs_supervision);

	/** Get Needs To Be Supervised	  */
	public boolean isneeds_supervision();

    /** Column name othercharges */
    public static final String COLUMNNAME_othercharges = "othercharges";

	/** Set Other Charges	  */
	public void setothercharges (BigDecimal othercharges);

	/** Get Other Charges	  */
	public BigDecimal getothercharges();

    /** Column name paymode */
    public static final String COLUMNNAME_paymode = "paymode";

	/** Set Pay Mode	  */
	public void setpaymode (String paymode);

	/** Get Pay Mode	  */
	public String getpaymode();

    /** Column name payroll_no */
    public static final String COLUMNNAME_payroll_no = "payroll_no";

	/** Set Payroll NO	  */
	public void setpayroll_no (String payroll_no);

	/** Get Payroll NO	  */
	public String getpayroll_no();

    /** Column name Posted */
    public static final String COLUMNNAME_Posted = "Posted";

	/** Set Posted.
	  * Posting status
	  */
	public void setPosted (boolean Posted);

	/** Get Posted.
	  * Posting status
	  */
	public boolean isPosted();

    /** Column name Processed */
    public static final String COLUMNNAME_Processed = "Processed";

	/** Set Processed.
	  * The document has been processed
	  */
	public void setProcessed (boolean Processed);

	/** Get Processed.
	  * The document has been processed
	  */
	public boolean isProcessed();

    /** Column name receiptamount */
    public static final String COLUMNNAME_receiptamount = "receiptamount";

	/** Set Receipt Amount	  */
	public void setreceiptamount (BigDecimal receiptamount);

	/** Get Receipt Amount	  */
	public BigDecimal getreceiptamount();

    /** Column name receiptmode */
    public static final String COLUMNNAME_receiptmode = "receiptmode";

	/** Set Receipt Mode	  */
	public void setreceiptmode (String receiptmode);

	/** Get Receipt Mode	  */
	public String getreceiptmode();

    /** Column name ReceiptNo */
    public static final String COLUMNNAME_ReceiptNo = "ReceiptNo";

	/** Set Receipt No	  */
	public void setReceiptNo (String ReceiptNo);

	/** Get Receipt No	  */
	public String getReceiptNo();

    /** Column name recover_from_share_transfer */
    public static final String COLUMNNAME_recover_from_share_transfer = "recover_from_share_transfer";

	/** Set Recover Total Amount From Share Transfer	  */
	public void setrecover_from_share_transfer (boolean recover_from_share_transfer);

	/** Get Recover Total Amount From Share Transfer	  */
	public boolean isrecover_from_share_transfer();

    /** Column name Remarks */
    public static final String COLUMNNAME_Remarks = "Remarks";

	/** Set Remarks.
	  * Remarks
	  */
	public void setRemarks (String Remarks);

	/** Get Remarks.
	  * Remarks
	  */
	public String getRemarks();

    /** Column name remittancedate */
    public static final String COLUMNNAME_remittancedate = "remittancedate";

	/** Set Remittance Date	  */
	public void setremittancedate (Timestamp remittancedate);

	/** Get Remittance Date	  */
	public Timestamp getremittancedate();

    /** Column name remittanceper */
    public static final String COLUMNNAME_remittanceper = "remittanceper";

	/** Set Remittance Period	  */
	public void setremittanceper (int remittanceper);

	/** Get Remittance Period	  */
	public int getremittanceper();

    /** Column name remittanceremarks */
    public static final String COLUMNNAME_remittanceremarks = "remittanceremarks";

	/** Set Remittance Remarks	  */
	public void setremittanceremarks (String remittanceremarks);

	/** Get Remittance Remarks	  */
	public String getremittanceremarks();

    /** Column name remittanceyear */
    public static final String COLUMNNAME_remittanceyear = "remittanceyear";

	/** Set Remittance Year	  */
	public void setremittanceyear (int remittanceyear);

	/** Get Remittance Year	  */
	public int getremittanceyear();

    /** Column name s_branch_ID */
    public static final String COLUMNNAME_s_branch_ID = "s_branch_ID";

	/** Set Member Branch	  */
	public void sets_branch_ID (int s_branch_ID);

	/** Get Member Branch	  */
	public int gets_branch_ID();

    /** Column name s_member_ID */
    public static final String COLUMNNAME_s_member_ID = "s_member_ID";

	/** Set Member	  */
	public void sets_member_ID (int s_member_ID);

	/** Get Member	  */
	public int gets_member_ID();

	public I_s_member gets_member() throws RuntimeException;

    /** Column name s_membershares_ID */
    public static final String COLUMNNAME_s_membershares_ID = "s_membershares_ID";

	/** Set Member Shares	  */
	public void sets_membershares_ID (int s_membershares_ID);

	/** Get Member Shares	  */
	public int gets_membershares_ID();

	public I_s_membershares gets_membershares() throws RuntimeException;

    /** Column name s_shareremittance_ID */
    public static final String COLUMNNAME_s_shareremittance_ID = "s_shareremittance_ID";

	/** Set s_shareremittance ID	  */
	public void sets_shareremittance_ID (int s_shareremittance_ID);

	/** Get s_shareremittance ID	  */
	public int gets_shareremittance_ID();

    /** Column name s_sharetype_ID */
    public static final String COLUMNNAME_s_sharetype_ID = "s_sharetype_ID";

	/** Set Share Type	  */
	public void sets_sharetype_ID (int s_sharetype_ID);

	/** Get Share Type	  */
	public int gets_sharetype_ID();

	public I_s_sharetype gets_sharetype() throws RuntimeException;

    /** Column name serialid */
    public static final String COLUMNNAME_serialid = "serialid";

	/** Set serialid	  */
	public void setserialid (int serialid);

	/** Get serialid	  */
	public int getserialid();

    /** Column name ShareBalance */
    public static final String COLUMNNAME_ShareBalance = "ShareBalance";

	/** Set Share Balance	  */
	public void setShareBalance (BigDecimal ShareBalance);

	/** Get Share Balance	  */
	public BigDecimal getShareBalance();

    /** Column name sharegl_Acct */
    public static final String COLUMNNAME_sharegl_Acct = "sharegl_Acct";

	/** Set Share Type GL Code	  */
	public void setsharegl_Acct (int sharegl_Acct);

	/** Get Share Type GL Code	  */
	public int getsharegl_Acct();

	public I_C_ValidCombination getsharegl_A() throws RuntimeException;

    /** Column name supervision_time */
    public static final String COLUMNNAME_supervision_time = "supervision_time";

	/** Set Supervision Time	  */
	public void setsupervision_time (Timestamp supervision_time);

	/** Get Supervision Time	  */
	public Timestamp getsupervision_time();

    /** Column name Supervisor_ID */
    public static final String COLUMNNAME_Supervisor_ID = "Supervisor_ID";

	/** Set Supervisor.
	  * Supervisor for this user/organization - used for escalation and approval
	  */
	public void setSupervisor_ID (int Supervisor_ID);

	/** Get Supervisor.
	  * Supervisor for this user/organization - used for escalation and approval
	  */
	public int getSupervisor_ID();

	public org.compiere.model.I_AD_User getSupervisor() throws RuntimeException;

    /** Column name TransactionTime */
    public static final String COLUMNNAME_TransactionTime = "TransactionTime";

	/** Set Transaction Time	  */
	public void setTransactionTime (Timestamp TransactionTime);

	/** Get Transaction Time	  */
	public Timestamp getTransactionTime();

    /** Column name TransactionType */
    public static final String COLUMNNAME_TransactionType = "TransactionType";

	/** Set Transaction Type	  */
	public void setTransactionType (String TransactionType);

	/** Get Transaction Type	  */
	public String getTransactionType();

    /** Column name TransDate */
    public static final String COLUMNNAME_TransDate = "TransDate";

	/** Set Transaction Date	  */
	public void setTransDate (Timestamp TransDate);

	/** Get Transaction Date	  */
	public Timestamp getTransDate();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();
}
