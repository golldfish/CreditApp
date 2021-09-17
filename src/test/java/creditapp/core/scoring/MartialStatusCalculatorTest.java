package creditapp.core.scoring;

import creditapp.core.model.Education;
import creditapp.core.model.MaritalStatus;
import creditapp.core.model.Person;
import creditapp.core.model.PersonTestFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class MartialStatusCalculatorTest {

    private MartialStatusCalculator cut = new MartialStatusCalculator();

    @ParameterizedTest
    @DisplayName("should return point attached to enum element")
    @EnumSource(MaritalStatus.class)
    public void test(MaritalStatus maritalStatus) {
        //given
        Person person = PersonTestFactory.create(maritalStatus);
        //when
        int scoring = cut.calculate(person);
        //then
        assertEquals(maritalStatus.getScoringPoints(), scoring);
    }
}
