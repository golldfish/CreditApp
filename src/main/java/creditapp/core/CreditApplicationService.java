package creditapp.core;

import creditapp.core.model.LoanApplication;
public class CreditApplicationService {

    public String getDecision(final LoanApplication loanApplication) {

        int score = new PersonScoringCalculator().calculate(loanApplication.getPerson());
        double creditRating = new PersonScoringCalculator().calculateCreditRating(loanApplication);
        final String negativeDecision = "Sorry " + loanApplication.getPerson().getPersonalData().getName() + " " + loanApplication.getPerson().getPersonalData().getLastName() + ", decision is negative.";
        final String documentsRequiredDecision = "Sorry " + loanApplication.getPerson().getPersonalData().getName() + " " + loanApplication.getPerson().getPersonalData().getLastName() + ", bank required additional documents. Our Consultant will contact you.";
        final String positiveDecision = "Congratulations " + loanApplication.getPerson().getPersonalData().getName() + " " + loanApplication.getPerson().getPersonalData().getLastName() + ", decision is positive.";
        final String tooMuchMoneyNegativeDecision = "Sorry " + loanApplication.getPerson().getPersonalData().getName() + " " + loanApplication.getPerson().getPersonalData().getLastName() + ", decision is negative. Bank can borrow only " + creditRating;

        if (score < 300) {
            return negativeDecision;
        } else if (score >= 300 && score <= 400) {
            return documentsRequiredDecision;
        } else if (score > 400 && creditRating >= loanApplication.getPurposeOfLoan().getAmount()) {
            return positiveDecision;
        } else
            return tooMuchMoneyNegativeDecision;
    }
}
