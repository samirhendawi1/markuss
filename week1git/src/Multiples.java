public class Multiples {

    // Existing helper method that handles the logic for multiples.
    public static String calculateMultiples(int limit, int multiple1, int multiple2) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= limit; i++) {
            if (i % multiple1 == 0 || i % multiple2 == 0) {
                result.append(i).append(" ");
            }
        }
        return result.toString().trim();
    }

    // Overloaded main method that accepts int arguments as per the test cases
    public static void main(int limit, int multiple1, int multiple2) {
        // Call the helper method and print the result
        String result = calculateMultiples(limit, multiple1, multiple2);
        System.out.println(result);
    }

    // Original main method that accepts String[] as required by the JVM
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Please provide three integers: limit, multiple1, and multiple2");
            return;
        }

        // Parse the input arguments as integers
        try {
            int limit = Integer.parseInt(args[0]);
            int multiple1 = Integer.parseInt(args[1]);
            int multiple2 = Integer.parseInt(args[2]);

            // Call the helper method and output the result
            String result = calculateMultiples(limit, multiple1, multiple2);
            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please ensure all arguments are integers.");
        }
    }
}
