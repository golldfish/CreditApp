package creditapp.core;

import creditapp.core.model.LoanApplication;
import creditapp.core.model.Person;
import static creditapp.core.Constants.*;

public class PersonScoringCalculator {


    public int calculate(final Person person) {
        //scoring
        int score = 0;

        double incomePerMember = (person.getPersonalData().getTotalMonthlyIncomeInPln() / person.getPersonalData().getNumberOfFamilyDependents());

        score += (int) incomePerMember / 1000 * 100;

        if (person.getPersonalData().getMartialStatus().name().equals("SEPARATED") || person.getPersonalData().getMartialStatus().name().equals("MARRIED")) {
            score += 100;
        }

        String educationLevel = String.valueOf(person.getPersonalData().getEducation());

        switch (educationLevel) {
            case "NONE":
                score -= 200;
                break;
            case "PRIMARY":
                score -= 100;

                break;
            case "TERTIARY":
                score += 100;
                break;
        }

        return score;
    }

    public double calculateCreditRating(LoanApplication loanApplication) {
        double incomePerFamilyMember = loanApplication.getPerson().getPersonalData().getTotalMonthlyIncomeInPln() / loanApplication.getPerson().getPersonalData().getNumberOfFamilyDependents();

        if (loanApplication.getPurposeOfLoan().getLoanType().name().equals("MORTGAGE")) {
            return MORTGAGE_LOAN_RATE * incomePerFamilyMember * 12 * loanApplication.getPurposeOfLoan().getPeriod();
        } else {
            return PERSONAL_LOAN_LOAN_RATE * incomePerFamilyMember * 12 * loanApplication.getPurposeOfLoan().getPeriod();

        }
    }
}
