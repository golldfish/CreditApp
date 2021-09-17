package creditapp.core.scoring;

import org.slf4j.Logger;
import creditapp.core.model.Person;
import org.slf4j.LoggerFactory;
import creditapp.core.model.MaritalStatus;

public class MartialStatusCalculator {

    private static final Logger log = LoggerFactory.getLogger(MartialStatusCalculator.class);

    public int calculate(Person person) {
        MaritalStatus martialStatus = person.getPersonalData().getMartialStatus();
        int pointsForMartial = martialStatus.getScoringPoints();

        log.info("Marital status = " + martialStatus + " "+ScoringUtils.getPointsString(pointsForMartial)+ ")");
        return pointsForMartial;
    }
}
