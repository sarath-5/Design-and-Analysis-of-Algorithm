import java.util.Scanner;
import java.util.Random;

public class RandomArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }
        System.out.print("The generated array is: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }
}