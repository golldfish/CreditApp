package creditapp.core;

import creditapp.core.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
class CreditApplicationServiceTest {

    @InjectMocks
    private CreditApplicationService cut;

    @Mock
    private PersonScoringCalculator personScoringCalculator;

    @Mock
    private CreditRatingCalculator creditRatingCalculator;


    @Test
    @DisplayName("Positive decision")
    public void test1() {
        //given
        LoanApplication loanApplication = LoanApplicationTestFactory.create(1000, 2, Education.PRIMARY, MaritalStatus.MARRIED, LoanType.PERSONAL_LOAN, 20, (byte) 30);
        BDDMockito.given(personScoringCalculator.calculate(eq(loanApplication.getPerson()))).willReturn(500);
        BDDMockito.given(creditRatingCalculator.calculate(loanApplication)).willReturn(30.0);

        //when
        CreditApplicationDecision decision = cut.getDecision(loanApplication);
        //then
        assertEquals(DecisionType.POSITIVE, decision.getDecisionType());
    }

    @Test
    @DisplayName("Negative scoring decision")
    public void test2() {
        //given
        LoanApplication loanApplication = LoanApplicationTestFactory.create(1000, 2, Education.PRIMARY, MaritalStatus.MARRIED, LoanType.PERSONAL_LOAN, 20, (byte) 30);
        BDDMockito.given(personScoringCalculator.calculate(eq(loanApplication.getPerson()))).willReturn(100);
        //when
        CreditApplicationDecision decision = cut.getDecision(loanApplication);
        //then
        assertEquals(DecisionType.NEGATIVE_SCORING, decision.getDecisionType());
    }

    @Test
    @DisplayName("Negative credit rating decision")
    public void test3() {
        //given
        LoanApplication loanApplication = LoanApplicationTestFactory.create(1000, 2, Education.PRIMARY, MaritalStatus.MARRIED, LoanType.PERSONAL_LOAN, 20, (byte) 30);
        BDDMockito.given(personScoringCalculator.calculate(eq(loanApplication.getPerson()))).willReturn(450);
        BDDMockito.given(creditRatingCalculator.calculate(loanApplication)).willReturn(10.0);
        //when
        CreditApplicationDecision decision = cut.getDecision(loanApplication);
        //then
        assertEquals(DecisionType.NEGATIVE_CREDIT_RATING, decision.getDecisionType());
    }

    @Test
    @DisplayName("Contact required decision")
    public void test4() {
        //given
        LoanApplication loanApplication = LoanApplicationTestFactory.create(1000, 2, Education.PRIMARY, MaritalStatus.MARRIED, LoanType.PERSONAL_LOAN, 20, (byte) 30);
        BDDMockito.given(personScoringCalculator.calculate(eq(loanApplication.getPerson()))).willReturn(350);
        //when
        CreditApplicationDecision decision = cut.getDecision(loanApplication);
        //then
        assertEquals(DecisionType.CONTACT_REQUIRED, decision.getDecisionType());
    }

}