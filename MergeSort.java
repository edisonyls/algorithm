public class MergeSort {

    public static void main(String[] args) {
        int[] array = { 38, 27, 43, 3, 9, 82, 10 };

        System.out.println("Original Array:");
        printArray(array);

        mergeSort(array, 0, array.length - 1);

        System.out.println("Sorted Array:");
        printArray(array);
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftSubArray = new int[n1];
        int[] rightSubArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftSubArray[i] = array[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightSubArray[i] = array[mid + 1 + i];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftSubArray[i] < rightSubArray[j]) {
                array[k] = leftSubArray[i];
                i++;
            } else {
                array[k] = rightSubArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k++] = leftSubArray[i++];
        }
        while (j < n2) {
            array[k++] = rightSubArray[j++];
        }
    }

    // Helper method to print the array
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
