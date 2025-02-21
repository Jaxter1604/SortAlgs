package algs;

public class insertion {

    public static int[] insertionSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }

        return array;
        
    }

    public static void insertionForMerge(int[] array, int p, int r) {

        for (int i = p + 1; i <= r; i++) {
            for (int j = i; j > p && array[j] < array[j - 1]; j--) {
                swapping.swap(array, j, j - 1);
            }
        }

    }

}
