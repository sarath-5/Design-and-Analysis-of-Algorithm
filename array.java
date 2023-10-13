import java.util.*;

public class array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the number of unique elements to select: ");
        int k = sc.nextInt();
        if (k > n) {
            System.out.println("Invalid input. k should be less than or equal to n.");
            return;
        }
        Random random = new Random();
        Set<Integer> set = new HashSet<>();
        while (set.size() < k) {
            int index = random.nextInt(n);
            set.add(arr[index]);
        }
        System.out.println("The randomly selected unique elements are: ");
        for (int element : set) {
            System.out.print(element + " ");
        }
    }
}