package creditapp.core;

import creditapp.core.model.DecisionType;
import creditapp.core.model.LoanApplication;
import creditapp.core.model.Person;
import creditapp.core.model.PersonalData;

public class CreditApplicationDecision {
    private final DecisionType decisionType;
    private final PersonalData personalData;
    private final double creditRating;

    public CreditApplicationDecision(DecisionType decisionType, PersonalData personalData, double creditRating) {
        this.decisionType = decisionType;
        this.personalData = personalData;
        this.creditRating = creditRating;
    }

    public String getDecisionString() {
        switch (decisionType) {
            case POSITIVE:
                return "Congratulations " + personalData.getName() + " " + personalData.getLastName() + ", decision is positive.";
            case CONTACT_REQUIRED:
                return "Sorry " + personalData.getName() + " " + personalData.getLastName() + ", bank required additional documents. Our Consultant will contact you.";
            case NEGATIVE_CREDIT_RATING:
                return "Sorry " + personalData.getName() + " " + personalData.getLastName() + ", decision is negative. Bank can borrow only " + creditRating;
            case NEGATIVE_SCORING:
                return "Sorry " + personalData.getName() + " " + personalData.getLastName() + ", decision is negative.";
        }
        return "";
    }

    public DecisionType getDecisionType() {
        return decisionType;
    }
}
