package creditapp.core;

import creditapp.core.model.*;
import creditapp.core.scoring.EducationCalculator;
import creditapp.core.scoring.IncomeCalculator;
import creditapp.core.scoring.MartialStatusCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.eq;


import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PersonScoringCalculatorTest {
    @InjectMocks
    PersonScoringCalculator cut;

    @Mock
    EducationCalculator educationCalculator;

    @Mock
    MartialStatusCalculator martialStatusCalculator;

    @Mock
    IncomeCalculator incomeCalculator;


    @Test
    @DisplayName("Should return sum of calculations")
    public void test1() {
        //given
        Person person = PersonTestFactory.create();
        BDDMockito.given(educationCalculator.calculate(eq(person))).willReturn(100);
        BDDMockito.given(martialStatusCalculator.calculate(eq(person))).willReturn(200);
        BDDMockito.given(incomeCalculator.calculate(eq(person))).willReturn(50);
        //when
        int score = cut.calculate(person);
        //then
        assertEquals(350, score);
    }


}