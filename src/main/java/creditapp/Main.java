package creditapp;

import creditapp.client.ConsoleReader;
import creditapp.core.CreditApplicationDecision;
import creditapp.core.CreditApplicationService;
import creditapp.core.CreditRatingCalculator;
import creditapp.core.PersonScoringCalculator;
import creditapp.core.model.LoanApplication;
import creditapp.core.scoring.EducationCalculator;
import creditapp.core.scoring.IncomeCalculator;
import creditapp.core.scoring.MartialStatusCalculator;

public class Main {
    public static void main(String[] args) {
        PersonScoringCalculator calculator = new PersonScoringCalculator(new EducationCalculator(), new MartialStatusCalculator(), new IncomeCalculator());
        CreditApplicationService service = new CreditApplicationService(calculator, new CreditRatingCalculator());
        LoanApplication loanApplication = new ConsoleReader().readInputParameters();
        CreditApplicationDecision decision = service.getDecision(loanApplication);

        System.out.println(decision.getDecisionString());
    }
}
