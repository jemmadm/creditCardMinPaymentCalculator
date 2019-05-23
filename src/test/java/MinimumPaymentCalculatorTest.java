import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MinimumPaymentCalculatorTest {

    MinimumPaymentCalculator minimumPaymentCalculator = new MinimumPaymentCalculator();

    @Test
    public void doesCalculateDurationGivenMinimumPaymentCalculatorWork(){

        assertThat(minimumPaymentCalculator.calculateDurationGivenMinimumPaymentCalculator(1000,10,25))
                .isEqualTo("It will take 48 months to pay off the balance of £1000. You will have paid £213.14 in interest");
    }

    @Test
    public void doesHigherPaymentCalculatorWork(){

        assertThat(minimumPaymentCalculator.calculateDurationGivenHigherPaymentCalculator(1000,10,2))
    }



}