package creditapp.core.scoring;

import static org.junit.jupiter.api.Assertions.*;

import creditapp.core.model.Education;
import creditapp.core.model.Person;
import creditapp.core.model.PersonTestFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;


class EducationCalculatorTest {
    private EducationCalculator cut = new EducationCalculator();

    @ParameterizedTest
    @DisplayName("should return point attached to enum element")
    @EnumSource(Education.class)
    public void test(Education education) {
        //given
        Person person = PersonTestFactory.create(education);
        //when
        int scoring = cut.calculate(person);
        //then
        assertEquals(education.getScoringPoints(), scoring);
    }

}