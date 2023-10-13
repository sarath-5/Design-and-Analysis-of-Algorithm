import java.util.*;

public class BacktrackingExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for input array
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] input = new int[n];
        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }

        // Ask user for k
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        // Call the backtracking function to generate k unique random elements
        List<Integer> selectedElements = new ArrayList<>();
        backtracking(input, k, selectedElements);

        // Output the selected elements
        System.out.println("Selected elements:");
        for (int element : selectedElements) {
            System.out.print(element + " ");
        }
    }

    private static void backtracking(int[] input, int k, List<Integer> selectedElements) {
        if (selectedElements.size() == k) {
            // Base case: k elements have been selected
            return;
        }
        
        // Try adding each element that hasn't already been selected
        for (int i = 0; i < input.length; i++) {
            int element = input[i];
            if (!selectedElements.contains(element)) {
                selectedElements.add(element);
                backtracking(input, k, selectedElements);
                if (selectedElements.size() == k) {
                    // We've found k elements, so return
                    return;
                }
                selectedElements.remove(selectedElements.size() - 1);
            }
        }
    }
}