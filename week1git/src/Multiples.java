public class Multiples {
    // Method to calculate sum of multiples of 'a' and 'b' below 'n'
    public static int multiples(int n, int a, int b) {
        int sum = 0;

        // Iterate over all numbers below n
        for (int i = 1; i < n; i++) {
            // Check if the number is divisible by either a or b
            if (i % a == 0 || i % b == 0) {
                sum += i;
            }
        }

        return sum; // Return the calculated sum
    }

    public static void main(String[] args) {
        // Parse command line arguments for n, a, and b
        if (args.length < 3) {
            System.out.println("Please provide three positive integers: n, a, b");
            return;
        }

        // Convert arguments from strings to integers
        int n = Integer.parseInt(args[0]);
        int a = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);

        // Handle cases where a == b
        if (a == b) {
            System.out.println("a and b cannot be the same. Please provide different values.");
            return;
        }

        // Call the multiples method and store the result
        int result = multiples(n, a, b);

        // Print the result
        System.out.println("The sum of multiples of " + a + " and " + b + " below " + n + " is: " + result);
    }
}
