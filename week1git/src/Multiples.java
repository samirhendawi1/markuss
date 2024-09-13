public class Multiples {

    // Helper method that calculates multiples and returns a String
    public static String calculateMultiples(int limit, int multiple1, int multiple2) {
        StringBuilder result = new StringBuilder();
        boolean first = true;  // A flag to avoid adding an extra space

        for (int i = 1; i <= limit; i++) {
            if (i % multiple1 == 0 || i % multiple2 == 0) {
                if (!first) {
                    result.append(" ");  // Add space before numbers after the first
                }
                result.append(i);  // Append the number
                first = false;  // Update the flag after appending the first number
            }
        }

        return result.toString();  // Return the final string without any trailing spaces
    }

    // Overloaded main method that returns a String instead of void (used by tests)
    public static String main(int limit, int multiple1, int multiple2) {
        return calculateMultiples(limit, multiple1, multiple2);
    }

    // Overloaded main method with no arguments for the default test case
    public static String main() {
        // Provide default values, e.g. limit = 1000, multiple1 = 3, multiple2 = 5
        return calculateMultiples(1000, 3, 5);
    }

    // Original main method for command-line usage
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Please provide three integers: limit, multiple1, and multiple2");
            return;
        }

        // Parse input arguments and call calculateMultiples
        try {
            int limit = Integer.parseInt(args[0]);
            int multiple1 = Integer.parseInt(args[1]);
            int multiple2 = Integer.parseInt(args[2]);

            // Print the result from the helper method
            System.out.println(calculateMultiples(limit, multiple1, multiple2));
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please ensure all arguments are integers.");
        }
    }
}
