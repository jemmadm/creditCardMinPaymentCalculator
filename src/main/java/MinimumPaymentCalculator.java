import java.text.DecimalFormat;
import java.util.Scanner;

class MinimumPaymentCalculator {
    public String calculateDurationGivenMonthlyPaymentCalculator(int fullBalanceOwed, double interestRate, double monthlyPayment) {

        double fullBalancePlusInterestMinusMonthlyPayment = fullBalanceOwed + (fullBalanceOwed * interestRate / 100) / 12 - monthlyPayment;
        int monthsCount = 0;
        double totalInterest = 0;

        do {
            double currentBalance = 0;
            currentBalance += (fullBalancePlusInterestMinusMonthlyPayment + (fullBalancePlusInterestMinusMonthlyPayment * interestRate / 100) / 12) - monthlyPayment;
            totalInterest += (fullBalancePlusInterestMinusMonthlyPayment * interestRate / 100) / 12;
            fullBalancePlusInterestMinusMonthlyPayment = currentBalance;
            monthsCount++;
        } while (fullBalancePlusInterestMinusMonthlyPayment > 0);

        String timeToPayOffCardAndTotalInterest = "It will take " + monthsCount/12 + " years and " + monthsCount%12 + " months to pay off the balance of £" + fullBalanceOwed + ". You will have paid £" + new DecimalFormat("##.##").format(totalInterest) + " in interest.";
        System.out.println(timeToPayOffCardAndTotalInterest);
        return timeToPayOffCardAndTotalInterest;

    }

    public static void main(String[] args) {
        System.out.println("Minimum Payments Credit Card Calculator!");
        System.out.println("Calculate how long it will take for you to pay off your balance making only the minimum payment each month");
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("What is your current total balance?");
            int outstandingBalance = input.nextInt();
            System.out.println("What is the annual interest rate (APR) on your credit card?");
            double interestRate = input.nextDouble();
            System.out.println("What is the minimum monthly payment for your credit card?");
            double monthlyPayment = input.nextDouble();
            MinimumPaymentCalculator minimumPaymentCalculator = new MinimumPaymentCalculator();
            minimumPaymentCalculator.calculateDurationGivenMonthlyPaymentCalculator(outstandingBalance, interestRate, monthlyPayment);
            System.out.println("Would you like to see how much quicker you could be debt free if you increased your monthly payment?");
            String compareHigherPayment = input.next();
            if (compareHigherPayment.equalsIgnoreCase("y") || compareHigherPayment.equalsIgnoreCase("yes")) {
                System.out.println("How much can you afford to pay each month?");
                double higherMonthlyPayment = input.nextDouble();
                minimumPaymentCalculator.calculateDurationGivenMonthlyPaymentCalculator(outstandingBalance, interestRate, higherMonthlyPayment);
            }
        } finally {
            input.close();
        }
    }
}
