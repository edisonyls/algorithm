public class CountingSort {

    public static void main(String[] args) {
        int[] array = { 4, 2, 2, 8, 3, 3, 1 };

        System.out.println("Original array:");
        printArray(array);

        countingSort(array);

        System.out.println("Sorted array:");
        printArray(array);
    }

    public static void countingSort(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        int[] countArray = new int[max + 1];
        for (int i = 0; i < max; i++) {
            countArray[i] = 0;
        }

        for (int i = 0; i < array.length; i++) {
            countArray[array[i]] += 1;
        }

        for (int i = 1; i < max + 1; i++) {
            countArray[i] += countArray[i - 1];
        }
        int[] outputArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            countArray[array[i]] -= 1;
            outputArray[countArray[array[i]]] = array[i];
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = outputArray[i];
        }
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
