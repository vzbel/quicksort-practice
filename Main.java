import java.util.Random;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[10];
        populate(array, 1482);

        // Before
        System.out.println("Before:");
        System.out.println(Arrays.toString(array));

        // Quicksort
        quicksort(array, 0, array.length - 1);
        // After
        System.out.println("After:");
        System.out.println(Arrays.toString(array));
    }

    public static void quicksort(int[] array, int lowIndex, int highIndex) {
        // Base case: array of size 1 or less.
        if (lowIndex >= highIndex) {
            return;
        }

        // Choose a pivot value (We will choose the rightmost value)
        int pivot = array[highIndex];

        // Create left and right pointers to help with partitions
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        // Partition the current sub-array
        // The goal is to move all values greater than the pivot towards the right
        // And to move all values less than the pivot towards the left
        while (leftPointer < rightPointer) {
            // Increment the left pointer up until a value greater than the pivot is found
            // or the left and right pointers intersect.
            while ((array[leftPointer] <= pivot) && (leftPointer < rightPointer)) {
                leftPointer++;
            }
            // Decrement the right pointer down until a value greater than the pivot is
            // found or the left and right pointers intersect.
            while ((array[rightPointer] >= pivot) && (leftPointer < rightPointer)) {
                rightPointer--;
            }

            // Swap the left and right values
            swap(array, leftPointer, rightPointer);
        }

        // Once the left and right pointers reach the same position,
        // We must swap the pivot with either of the two.
        swap(array, leftPointer, highIndex);

        // Recursively sort the left sub-array
        quicksort(array, lowIndex, leftPointer - 1);
        quicksort(array, leftPointer + 1, highIndex);
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void populate(int[] array, int bound) {
        // Create random integer generator
        Random random = new Random();
        // Fill array with sample values that do not cross the given bound.
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(bound);
        }
    }
}