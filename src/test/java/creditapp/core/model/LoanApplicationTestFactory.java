package creditapp.core.model;

public class LoanApplicationTestFactory {

    public static LoanApplication create(int numberOfFamilyDependents, LoanType loanType, double amount, byte period, SourceOfIncome... sourceOfIncomes) {
        Person person = PersonTestFactory.create(2, sourceOfIncomes);
        PurposeOfLoan purposeOfLoan = PurposeOfLoanTestFactory.create(loanType, amount, period);
        return new LoanApplication(person, purposeOfLoan);
    }

    public static LoanApplication create(Person person, LoanType loanType, double amount, byte period) {
        PurposeOfLoan purposeOfLoan = PurposeOfLoanTestFactory.create(loanType, amount, period);
        return new LoanApplication(person, purposeOfLoan);
    }

    public static LoanApplication create(double income, int numOfDependants, Education education, MaritalStatus maritalStatus, LoanType loanType, double amount, byte period) {
        Person person = PersonTestFactory.create(income, numOfDependants, education, maritalStatus);
        PurposeOfLoan purposeOfLoan = PurposeOfLoanTestFactory.create(loanType, amount, period);
        return new LoanApplication(person, purposeOfLoan);
    }


}
