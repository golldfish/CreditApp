package creditapp.core.scoring;

import creditapp.core.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IncomeCalculator {
    private static final Logger log = LoggerFactory.getLogger(IncomeCalculator.class);

    public int calculate(Person person) {
        double incomePerMember = person.getIncomePerFamilyMember();
        int pointsPerIncome = (int) incomePerMember / 1000 * 100;
        log.info("Income per family member = " + incomePerMember + " " + ScoringUtils.getPointsString(pointsPerIncome) + ")");

        if (person.getFinanceData().getSourcesOfIncome().length > 1) {
            pointsPerIncome += 100;
            log.info("Extra points for " + person.getFinanceData().getSourcesOfIncome().length + " sources of income " + ScoringUtils.getPointsString(100) + ")");
        }

        return pointsPerIncome;
    }


}
