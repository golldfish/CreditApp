package creditapp.core;

import creditapp.core.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreditRatingCalculatorTest {
    @InjectMocks
    CreditRatingCalculator cut = new CreditRatingCalculator();

    @Test
    @DisplayName("Check credit rating when MORTGAGE_LOAN")
    public void test5() {
        //given
        LoanApplication loanApplication = LoanApplicationTestFactory.create(9000, 3, Education.TERTIARY, MaritalStatus.SINGLE, LoanType.MORTGAGE, 20, (byte) 30);
        //when
        double creditRating = cut.calculate(loanApplication);
        //then
        assertEquals(216000, creditRating);
    }

    @Test
    @DisplayName("Check credit rating when PERSONAL_LOAN")
    public void test6() {
        //given
        LoanApplication loanApplication = LoanApplicationTestFactory.create(9000, 3, Education.TERTIARY, MaritalStatus.SINGLE, LoanType.PERSONAL_LOAN, 20, (byte) 30);
        //when
        double creditRating = cut.calculate(loanApplication);
        //then
        assertEquals(108000, creditRating);
    }
}