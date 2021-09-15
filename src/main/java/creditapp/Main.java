package creditapp;

import creditapp.client.ConsoleReader;
import creditapp.core.CreditApplicationService;
import creditapp.core.model.LoanApplication;

public class Main {
    public static void main(String[] args) {
        LoanApplication loanApplication = new ConsoleReader().readInputParameters();
        System.out.println(new CreditApplicationService().getDecision(loanApplication));
    }
}
