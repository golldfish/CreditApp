package creditapp.core;

import creditapp.core.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CreditRatingCalculatorTest {
    @InjectMocks
    CreditRatingCalculator cut = new CreditRatingCalculator();

    @Test
    @DisplayName("Check credit rating when MORTGAGE_LOAN")
    public void test1() {
        //given
        SourceOfIncome sourceOfIncome1 = new SourceOfIncome(IncomeType.SELF_EMPLOYMENT, 4000);
        SourceOfIncome sourceOfIncome2 = new SourceOfIncome(IncomeType.RETIREMENT, 1000);
        LoanApplication loanApplication = LoanApplicationTestFactory.create(2, LoanType.MORTGAGE, 200000.0, (byte) 30, sourceOfIncome1, sourceOfIncome2);
        //when
        double creditRating = cut.calculate(loanApplication);
        //then
        assertEquals(180000, creditRating);
    }


    @Test
    @DisplayName("Check credit rating when PERSONAL_LOAN")
    public void test2() {
        //given
        SourceOfIncome sourceOfIncome1 = new SourceOfIncome(IncomeType.SELF_EMPLOYMENT, 5000);
        LoanApplication loanApplication = LoanApplicationTestFactory.create(2, LoanType.PERSONAL_LOAN, 200000.0, (byte) 30, sourceOfIncome1);        //when
        double creditRating = cut.calculate(loanApplication);
        //then
        assertEquals(90000, creditRating);
    }
}