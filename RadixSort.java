import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int[] array = { 170, 45, 75, 90, 802, 24, 2, 66 };

        System.out.println("Original Array: " + Arrays.toString(array));

        radixSort(array);

        System.out.println("Sorted Array: " + Arrays.toString(array));
    }

    public static void radixSort(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }

        for (int place = 1; max / place > 0; place *= 10) {
            countingSortInDigit(array, place);
        }
    }

    private static void countingSortInDigit(int[] array, int place) {
        int size = array.length;
        int[] output = new int[size];
        // each digit can never be greater than 9
        int[] count = new int[10];

        // Calculate count of elements
        for (int i = 0; i < size; i++) {
            int index = (array[i] / place) % 10;
            count[index]++;
        }
        // Calculate cumulative count
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        // Place the elements in sorted order
        for (int i = size - 1; i >= 0; i--) {
            int index = (array[i] / place) % 10;
            output[count[index] - 1] = array[i];
            count[index]--;
        }
        // Copy the sorted elements into original array
        for (int i = 0; i < size; i++) {
            array[i] = output[i];
        }
    }
}
