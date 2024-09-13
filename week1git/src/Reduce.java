public class Reduce {

    // This method returns the number of steps to reduce n to 0
    public static int main(int n) {
        int steps = 0;

        // Repeat the process until n becomes 0
        while (n > 0) {
            if (n % 2 == 0) {
                // n is even, divide by 2
                n /= 2;
            } else {
                // n is odd, subtract 1
                n -= 1;
            }
            steps++; // Increment step count
        }

        // Return the number of steps it took to reach 0
        return steps;
    }

    // Command-line version of main
    public static void main(String[] args) {
        // Example: start at 100 and print the steps
        int n = 100;
        int steps = main(n);
        System.out.println("Steps to reduce " + n + " to 0: " + steps);
    }
}
