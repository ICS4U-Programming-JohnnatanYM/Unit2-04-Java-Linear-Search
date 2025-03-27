import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This program generates 10 random numbers, sorts them,
 * and allows the user to search for a number using Linear Search.
 *
 * @author Johnnatan Yasin Medina
 * @version 1.1
 * @since 2025-03-26
 */
public final class LinearSearch {

    /** Constant for the size of the array. */
    private static final int ARRAY_SIZE = 10;
    /** Constant for the max random value. */
    private static final int MAX_RANDOM = 101;

    /**
     * Private constructor.
     */
    private LinearSearch() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Main method.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Generate random numbers
        int[] numbers = new int[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE; i++) {
            numbers[i] = random.nextInt(MAX_RANDOM);
        }

        // Sort the array
        Arrays.sort(numbers);

        System.out.println("Sorted list of numbers: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        String input;

        // Loop until the user enters "q" to quit
        do {
            System.out.print("\nEnter the number you are"
            + " searching for (or 'q' to quit): ");
            input = scanner.nextLine().trim().toLowerCase();

            if (!input.equals("q")) {
                try {
                    int target = Integer.parseInt(input);
                    int index = linearSearch(numbers, target);

                    if (index != -1) {
                        System.out.println("The number " + target
                        + " is found at index " + index + ".");
                    } else {
                        System.out.println("The number " + target
                        + " is not found in the list.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a"
                     + "valid number or 'q' to quit.");
                }
            }
        } while (!input.equals("q"));

        System.out.println("Thank you for playing!");
        scanner.close();
    }

    /**
     * Linear Search on the array.
     *
     * @param arr The array to search.
     * @param target The number to find.
     * @return The index of the target if found, or -1 if not found.
     */
    private static int linearSearch(final int[] arr, final int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;  // Return the index of the found number
            }
        }
        return -1;  // Return -1 if not found
    }
}
