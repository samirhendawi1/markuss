public class Multiples {

    // Helper method that calculates the number of multiples and returns an int
    public static int calculateMultiples(int limit, int multiple1, int multiple2) {
        int count = 0;

        for (int i = 1; i <= limit; i++) {
            if (i % multiple1 == 0 || i % multiple2 == 0) {
                count++;  // Increment the count if it's a multiple of multiple1 or multiple2
            }
        }

        return count;  // Return the count of multiples
    }

    // Overloaded main method that returns an int (used by tests)
    public static int main(int limit, int multiple1, int multiple2) {
        return calculateMultiples(limit, multiple1, multiple2);
    }

    // Overloaded main method with no arguments for default test case
    public static int main() {
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

            // Print the count of multiples
            System.out.println("Count of multiples: " + calculateMultiples(limit, multiple1, multiple2));
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please ensure all arguments are integers.");
        }
    }
}

