import java.util.Random;
import java.util.Scanner;

public class RandomArraySelection {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();

        int[] array = new int[size];
        System.out.print("Enter the elements of the array: ");

        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
        }

        System.out.print("Enter the number of random elements to select: ");
        int numRandom = input.nextInt();

        System.out.print("Randomly selected elements: ");
        for (int i = 0; i < numRandom; i++) {
            int index = rand.nextInt(size);
            System.out.print(array[index] + " ");
        }
    }
}