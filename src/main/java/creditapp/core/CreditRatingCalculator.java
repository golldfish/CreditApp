package creditapp.core;

import creditapp.core.model.LoanApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

import static creditapp.core.Constants.MORTGAGE_LOAN_RATE;
import static creditapp.core.Constants.PERSONAL_LOAN_LOAN_RATE;

public class CreditRatingCalculator {
    private static final Logger log = LoggerFactory.getLogger(CreditRatingCalculator.class);

    public double calculate(LoanApplication loanApplication) {
        double incomePerFamilyMember = loanApplication.getPerson().getIncomePerFamilyMember();
        double creditRate = incomePerFamilyMember * 12 * loanApplication.getPurposeOfLoan().getPeriod();
        if (loanApplication.getPurposeOfLoan().getLoanType().name().equals("MORTGAGE")) {
            creditRate *= MORTGAGE_LOAN_RATE;
        } else {
            creditRate *= PERSONAL_LOAN_LOAN_RATE;
        }
        log.info("Calculated rating = " + new BigDecimal(creditRate).setScale(2));
        return creditRate;
    }
}
