public class QuickSort {

    public void quickSort(int[] array) {
        int low = 0, high = array.length - 1;
        quickSort(array, low, high);
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int i = low - 1;
        int pivot = array[high];
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    private void swap(int[] array, int i1, int i2) {
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }

    public static void main(String[] args) {
        QuickSort sorter = new QuickSort();
        int[] array = { 10, 7, 8, 9, 1, 5 };
        sorter.quickSort(array);

        System.out.println("Sorted array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println("\n");
    }
}
