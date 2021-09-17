package creditapp.core.scoring;

import creditapp.core.model.IncomeType;
import creditapp.core.model.Person;
import creditapp.core.model.PersonTestFactory;
import creditapp.core.model.SourceOfIncome;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IncomeCalculatorTest {

    private IncomeCalculator cut = new IncomeCalculator();

    @Test
    @DisplayName("Should return 100 points for each 1000 zł per family member")
    public void test1() {
        //given
        SourceOfIncome sourceOfIncome = new SourceOfIncome(IncomeType.SELF_EMPLOYMENT, 5000);
        Person person = PersonTestFactory.create(2, sourceOfIncome);
        //when
        int scoring = cut.calculate(person);
        //then
        assertEquals(200, scoring);
    }

    @Test
    @DisplayName("Should return 100 extra points when more than 1 source income")
    public void test2() {
        //given
        SourceOfIncome sourceOfIncome1 = new SourceOfIncome(IncomeType.SELF_EMPLOYMENT, 4000);
        SourceOfIncome sourceOfIncome2 = new SourceOfIncome(IncomeType.RETIREMENT, 1000);
        Person person = PersonTestFactory.create(2, sourceOfIncome1, sourceOfIncome2);
        //when
        int scoring = cut.calculate(person);
        //then
        assertEquals(300, scoring);
    }
}