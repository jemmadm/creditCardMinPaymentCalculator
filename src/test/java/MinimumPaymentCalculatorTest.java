import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MinimumPaymentCalculatorTest {

    private MinimumPaymentCalculator minimumPaymentCalculator = new MinimumPaymentCalculator();

    @Test
    public void doesCalculateDurationGivenMinimumPaymentCalculatorWork() {

        assertThat(minimumPaymentCalculator.calculateDurationGivenMonthlyPaymentCalculator(1000, 10, 25))
                .isEqualTo("It will take 48 months to pay off the balance of £1000. You will have paid £213.14 in interest.");
    }

    @Test
    public void doesHigherPaymentCalculatorWork() {

        assertThat(minimumPaymentCalculator.calculateDurationGivenMonthlyPaymentCalculator(1000, 10, 50))
                .isEqualTo("It will take 21 months to pay off the balance of £1000. You will have paid £90.15 in interest.");
    }


}