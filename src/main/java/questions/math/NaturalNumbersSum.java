package questions.math;

public class NaturalNumbersSum {

    // Time - O(1), Space - O(1)
    public int getSumNaturalNumbers(final int number) {
        return (number * (number + 1)) / 2;
    }

    // Time - O(N), Space - O(1)
    public int getSumNaturalNumbers2(final int number) {
        int sum = 0;
        for (int i = 0; i <= number; i++) {
            sum += i;
        }

        return sum;
    }
}
