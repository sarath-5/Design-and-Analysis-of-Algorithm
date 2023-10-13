import java.util.Scanner;

public class Binarysearch {
    public static int binarySearch(int[] arr, int key, int low, int high) {
        if (low > high) {
            return -1;//element not found
        }
        int mid = low + (high - low) / 2;
        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid] > key) {
            return binarySearch(arr, key, low, mid - 1);
        } else {
            return binarySearch(arr, key, mid + 1, high);
        }
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user to input array
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        
        int[] arr = new int[size];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.print("array elements are:");
        for (int i = 0; i < size; i++) {
         System.out.print(arr[i]+"\t");
        } 
        System.out.print("\n");  
        // Prompt user to input key element
        System.out.print("Enter the key element: ");
        int key = scanner.nextInt();
        
        int index = binarySearch(arr, key, 0, arr.length - 1);
        
        if (index == -1) {
            System.out.println("key not found");
        } else {
            System.out.println("key found at index " + index);
        }
    }
}