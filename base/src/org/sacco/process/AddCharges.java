package org.sacco.process;

import java.math.BigDecimal;
import java.util.logging.Level;

import org.compiere.model.ChargeSetup;
import org.compiere.model.SLoan;
import org.compiere.model.Sloan_charges;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.Env;

public class AddCharges extends SvrProcess {

	private int s_accountsetup_ID = 0;
	private ChargeSetup chargeSetup = null;
	private BigDecimal amt = Env.ZERO;
	private String Description = "";
	private BigDecimal loanAmt = Env.ZERO;

	private SLoan loan = null;

	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();
		for (int i = 0; i < para.length; i++) {
			String name = para[i].getParameterName();
			if (para[i].getParameter() == null)
				;
			else if (name.equals("s_accountsetup_ID"))
				s_accountsetup_ID = para[i].getParameterAsInt();
			else if (name.equals("Description"))
				Description = para[i].getParameterAsString();
			else
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
		}
		if (s_accountsetup_ID > 0) {
			chargeSetup = new ChargeSetup(getCtx(), s_accountsetup_ID, get_TrxName());
		}
		loan = new SLoan(getCtx(), getRecord_ID(), get_TrxName());
		loanAmt = loan.getappliedamount();

	}

	@Override
	protected String doIt() throws Exception {
		if (chargeSetup != null) {
			amt = chargeSetup.getAmount();
		}
		add();
		return null;
	}

	private void add() {
		String formula = chargeSetup.getchargeformula();
		formula = formula.replace("P", loanAmt.stripTrailingZeros().toPlainString());
		formula = formula.replace("[", "").replace("]", "");
		double d = eval(formula);
		BigDecimal f_amt = BigDecimal.valueOf(d);

		Sloan_charges charges = new Sloan_charges(getCtx(), 0, get_TrxName());
		charges.sets_loans_ID(getRecord_ID());
		charges.sets_accountsetup_ID(s_accountsetup_ID);
		charges.setDescription(Description);
		charges.setAmount(f_amt);
		charges.save();

	}

	public static void main(String[] arg) {
		String rr = "[5+9]";
		String s = "y % x + y / x * 2";
		int x = 3;
		int y = 5;
		double m = 0.5 * (x);
		System.out.println(m);
		System.out.println(rr);
		System.out.println(eval(rr));

	}

	private static double eval(final String str) {
		return new Object() {
			int pos = -1, ch;

			void nextChar() {
				ch = (++pos < str.length()) ? str.charAt(pos) : -1;
			}

			boolean eat(int charToEat) {
				while (ch == ' ')
					nextChar();
				if (ch == charToEat) {
					nextChar();
					return true;
				}
				return false;
			}

			double parse() {
				nextChar();
				double x = parseExpression();
				if (pos < str.length())
					throw new RuntimeException("Unexpected: " + (char) ch);
				return x;
			}

			// Grammar:
			// expression = term | expression `+` term | expression `-` term
			// term = factor | term `*` factor | term `/` factor
			// factor = `+` factor | `-` factor | `(` expression `)`
			// | number | functionName factor | factor `^` factor

			double parseExpression() {
				double x = parseTerm();
				for (;;) {
					if (eat('+'))
						x += parseTerm(); // addition
					else if (eat('-'))
						x -= parseTerm(); // subtraction
					else
						return x;
				}
			}

			double parseTerm() {
				double x = parseFactor();
				for (;;) {
					if (eat('*'))
						x *= parseFactor(); // multiplication
					else if (eat('/'))
						x /= parseFactor(); // division
					else
						return x;
				}
			}

			double parseFactor() {
				if (eat('+'))
					return parseFactor(); // unary plus
				if (eat('-'))
					return -parseFactor(); // unary minus

				double x;
				int startPos = this.pos;
				if (eat('(')) { // parentheses
					x = parseExpression();
					eat(')');
				} else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
					while ((ch >= '0' && ch <= '9') || ch == '.')
						nextChar();
					x = Double.parseDouble(str.substring(startPos, this.pos));
				} else if (ch >= 'a' && ch <= 'z') { // functions
					while (ch >= 'a' && ch <= 'z')
						nextChar();
					String func = str.substring(startPos, this.pos);
					x = parseFactor();
					if (func.equals("sqrt"))
						x = Math.sqrt(x);
					else if (func.equals("sin"))
						x = Math.sin(Math.toRadians(x));
					else if (func.equals("cos"))
						x = Math.cos(Math.toRadians(x));
					else if (func.equals("tan"))
						x = Math.tan(Math.toRadians(x));
					else
						throw new RuntimeException("Unknown function: " + func);
				} else {
					throw new RuntimeException("Unexpected: " + (char) ch);
				}

				if (eat('^'))
					x = Math.pow(x, parseFactor()); // exponentiation

				return x;
			}
		}.parse();
	}

	private void tryFetch() {

	}

} // dd
