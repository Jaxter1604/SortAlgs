package algs;

import java.util.Arrays;

public class quick {

    public static int[] quickSort(int[] array) {

        if (array.length <= 1) {
            return array;
        }

        int[] sortedArray = Arrays.copyOf(array, array.length);
        quicksortRecursive(sortedArray, 0, sortedArray.length - 1);
        return sortedArray;

    }

    public static void quicksortRecursive(int[] array, int p, int r) {

        if (p < r) {
            int q = partition(array, p, r);
            quicksortRecursive(array, p, q - 1);
            quicksortRecursive(array, q + 1, r);
        }

    }

    public static int[] insertionQuickSort(int[] array, int n) {

        if (array.length <= 1) {
            return array;
        }

        int[] sortedArray = Arrays.copyOf(array, array.length);
        insertionQuickSortRecursion(sortedArray, 0, sortedArray.length - 1, n);
        insertion.insertionSort(sortedArray);
        return sortedArray;

    }

    public static void insertionQuickSortRecursion(int[] array, int p, int r, int n) {

        if (r - p <= n) {
            return;
        }

        int q = partition(array, p, r);
        insertionQuickSortRecursion(array, p, q - 1, n);
        insertionQuickSortRecursion(array, q + 1, r, n);

    }

    public static int[] medianQuickSort(int[] array) {

        if (array.length <= 1) {
            return array;
        }

        int[] sortedArray = Arrays.copyOf(array, array.length);
        medianQuickSortRecursion(sortedArray, 0, sortedArray.length - 1);
        return sortedArray;

    }

    public static void medianQuickSortRecursion(int[] array, int p, int r) {

        if (r <= p) {
            return;
        }

        // select median index
        swapping.swap(array, (p + r) / 2, r);

        if (array[r - 1] < array[p]) {
            swapping.swap(array, p, r - 1);
        }
        if (array[r] < array[p]) {
            swapping.swap(array, p, r);
        }
        if (array[r] < array[r - 1]) {
            swapping.swap(array, r - 1, r);
        }

        int q = partition(array, p, r - 1);
        medianQuickSortRecursion(array, p, q - 1);
        medianQuickSortRecursion(array, q + 1, r);

    }

    public static int[] quickSort3Way(int[] array) {

        if (array.length <= 1) {
            return array;
        }

        int[] sortedArray = Arrays.copyOf(array, array.length);
        quickSort3WayRecursion(sortedArray, 0, array.length - 1);
        return sortedArray;

    }

    public static void quickSort3WayRecursion(int[] array, int l, int r) {

        if (r <= l) {
            return;
        }

        int v = array[r];
        int i = l - 1;
        int j = r;
        int p = l - 1;
        int q = r;

        // inf loop
        for (;;) {
            while (array[++i] < v)
                ;

            while (v < array[--j]) {
                if (j == l) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }
            swapping.swap(array, i, j);
            if (array[i] == v) {
                p++;
                swapping.swap(array, p, i);
            }
            if (array[j] == v) {
                q--;
                swapping.swap(array, q, j);
            }

        }

        swapping.swap(array, i, r);
        j = i - 1;
        i++;

        for (int k = l; k <= p; k++, j--) {
            swapping.swap(array, k, j);
        }
        for (int k = r - 1; k >= q; k--, i++) {
            swapping.swap(array, k, i);
        }

        quickSort3WayRecursion(array, l, j);
        quickSort3WayRecursion(array, i, r);

    }

    public static int partition(int[] array, int p, int r) {

        int x = array[r];
        int i = p - 1;

        for (int j = p; j <= r - 1; j++) {
            if (array[j] <= x) {
                i++;
                swapping.swap(array, i, j);
            }
        }

        swapping.swap(array, i + 1, r);
        return i + 1;

    }

}
