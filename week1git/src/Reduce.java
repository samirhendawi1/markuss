package week1git.src;

public class Reduce {
    // Method to calculate how many steps it takes to reduce n to 0
    public static int reduceToZero(int n) {
        int steps = 0;

        // Keep applying the reduction rules until n becomes 0
        while (n > 0) {
            if (n % 2 == 0) {
                n = n / 2;  // If n is even, divide by 2
            } else {
                n = n - 1;  // If n is odd, subtract 1
            }
            steps++;  // Increment the step counter
        }

        return steps;  // Return the total number of steps
    }

    public static void main(String[] args) {
        // Parse the command line argument for n
        if (args.length < 1) {
            System.out.println("Please provide a positive integer n.");
            return;
        }

        // Convert the argument from a string to an integer
        int n = Integer.parseInt(args[0]);

        // Call the reduceToZero method and get the result
        int result = reduceToZero(n);

        // Print the result
        System.out.println("It took " + result + " steps to reduce " + n + " to 0.");
    }
}
