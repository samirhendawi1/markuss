public class Multiples {

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Please provide three arguments");
            return;
        }

        int limit = Integer.parseInt(args[0]);
        int firstMultiple = Integer.parseInt(args[1]);
        int secondMultiple = Integer.parseInt(args[2]);

        printMultiples(limit, firstMultiple, secondMultiple);
    }

    // New method to handle int arguments directly
    public static String printMultiples(int limit, int firstMultiple, int secondMultiple) {
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= limit; i++) {
            if (i % firstMultiple == 0 || i % secondMultiple == 0) {
                result.append(i).append(", ");
            }
        }

        // Remove the last comma and space
        if (result.length() > 0) {
            result.setLength(result.length() - 2);
        }

        // For testing purposes, return the result
        return result.toString();
    }
}
