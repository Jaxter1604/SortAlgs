package algs;

public class selection {

    public static int[] selectionSort(int[] array) {

        int length = array.length;

        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swapping.swap(array, i, minIndex);
        }

        return array;

    }

}
