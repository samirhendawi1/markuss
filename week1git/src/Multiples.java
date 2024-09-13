public class Multiples {

    // Helper method that calculates multiples and returns a String
    public static String calculateMultiples(int limit, int multiple1, int multiple2) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= limit; i++) {
            if (i % multiple1 == 0 || i % multiple2 == 0) {
                result.append(i).append(" ");
            }
        }
        return result.toString().trim();  // return the result instead of printing
    }

    // Overloaded main method that returns a String instead of void
    public static String main(int limit, int multiple1, int multiple2) {
        // Return the result from the helper method
        return calculateMultiples(limit, multiple1, multiple2);
    }

    // Original main method with String[] for command-line usage
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
