package creditapp.core.scoring;

import creditapp.core.model.Education;
import creditapp.core.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EducationCalculator {

    private static final Logger log = LoggerFactory.getLogger(EducationCalculator.class);

    public int calculate(Person person) {
        Education education = person.getPersonalData().getEducation();
        int pointsForEducation = education.getScoringPoints();

        log.info("Education = " + education + " " + ScoringUtils.getPointsString(pointsForEducation) + ")");
        return pointsForEducation;
    }

}
