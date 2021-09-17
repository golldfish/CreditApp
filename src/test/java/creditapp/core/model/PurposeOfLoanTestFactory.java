package creditapp.core.model;

import static org.junit.jupiter.api.Assertions.*;

public class PurposeOfLoanTestFactory {

    public static PurposeOfLoan create(LoanType loanType, double amount, byte period) {
        return new PurposeOfLoan(loanType, amount, period);
    }

}