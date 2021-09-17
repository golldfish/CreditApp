package creditapp.core;

import creditapp.core.model.Person;
import creditapp.core.scoring.EducationCalculator;
import creditapp.core.scoring.IncomeCalculator;
import creditapp.core.scoring.MartialStatusCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonScoringCalculator {

    private static final Logger log = LoggerFactory.getLogger(PersonScoringCalculator.class);
    private final EducationCalculator educationCalculator;
    private final MartialStatusCalculator martialStatusCalculator;
    private final IncomeCalculator incomeCalculator;

    public PersonScoringCalculator(EducationCalculator educationCalculator, MartialStatusCalculator martialStatusCalculator, IncomeCalculator incomeCalculator) {
        this.educationCalculator = educationCalculator;
        this.martialStatusCalculator = martialStatusCalculator;
        this.incomeCalculator = incomeCalculator;
    }

    public int calculate(final Person person) {
        int scoring = educationCalculator.calculate(person) + martialStatusCalculator.calculate(person) + incomeCalculator.calculate(person);
        log.info("Calculated scoring = " + scoring + " points");
        return scoring;
    }


}
