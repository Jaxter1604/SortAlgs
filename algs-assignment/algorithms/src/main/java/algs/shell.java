package algs;

public class shell {

    public static int[] shellSort(int[] array) {

        int h = 1;
        int n = array.length;

        while (h < n / 3) {
            h = h * 3 + 1;
        }

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && array[j] < array[j - h]; j = j - h) {
                    swapping.swap(array, j, j - h);
                }
            }
            h /= 3;
        }

        return array;

    }

}
