package creditapp.core.model;

import static org.junit.jupiter.api.Assertions.*;

public class LoanApplicationTestFactory {

    public static LoanApplication create(double totalMonthlyIncomeInPln, int numOfDependants, Education education, MaritalStatus maritalStatus, LoanType loanType, double amount, byte period) {
        Person person = PersonTestFactory.create(totalMonthlyIncomeInPln, numOfDependants, education, maritalStatus);
        PurposeOfLoan purposeOfLoan = PurposeOfLoanTestFactory.create(loanType, amount, period);
        return new LoanApplication(person, purposeOfLoan);
    }
}