package creditapp.core;

import creditapp.core.model.DecisionType;
import creditapp.core.model.LoanApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.UUID;

public class CreditApplicationService {
    private static final Logger log = LoggerFactory.getLogger(CreditApplicationService.class);
    private final PersonScoringCalculator personScoringCalculator;
    private final CreditRatingCalculator creditRatingCalculator;

    public CreditApplicationService(PersonScoringCalculator personScoringCalculator, CreditRatingCalculator creditRatingCalculator) {
        this.personScoringCalculator = personScoringCalculator;
        this.creditRatingCalculator = creditRatingCalculator;
    }

    public CreditApplicationDecision getDecision(final LoanApplication loanApplication) {
        String id = UUID.randomUUID().toString();
        log.info("App ID: " + id);
        MDC.put("id", id);


        int scoring = personScoringCalculator.calculate(loanApplication.getPerson());
        double creditRating = creditRatingCalculator.calculate(loanApplication);
        CreditApplicationDecision decision;

        if (scoring < 300) {
            decision = new CreditApplicationDecision(DecisionType.NEGATIVE_SCORING, loanApplication.getPerson().getPersonalData(), creditRating);
        } else if (scoring >= 300 && scoring <= 400) {
            decision = new CreditApplicationDecision(DecisionType.CONTACT_REQUIRED, loanApplication.getPerson().getPersonalData(), creditRating);
        } else if (scoring > 400 && creditRating >= loanApplication.getPurposeOfLoan().getAmount()) {
            decision = new CreditApplicationDecision(DecisionType.POSITIVE, loanApplication.getPerson().getPersonalData(), creditRating);
        } else {
            decision = new CreditApplicationDecision(DecisionType.NEGATIVE_CREDIT_RATING, loanApplication.getPerson().getPersonalData(), creditRating);
        }
        log.info("Decision = " + decision.getDecisionType());
        return decision;
    }
}
