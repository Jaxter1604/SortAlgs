package algs;

import java.util.Arrays;

public class merge {

    public static void mergeSort(int[] array, int p, int r){

        if (p < r){
            int q = (p + r) / 2;
            mergeSort(array, p, q);
            mergeSort(array, q + 1, r);
            combine(array, p, q, r);
        }
        
    }

    public static void bottomUpMergeSort(int[] array) {

        int n = array.length;

        for (int i = 1; i < n; i *= 2){

            for (int j = 0; j < n - i; j += 2 * i){
                int mid = j + i - 1;
                int right = Math.min(j + 2 * i - 1, n - 1);
                combine(array, j, mid, right);
            }

        }

    }

    public static void insertionMergeSort(int[] array, int p, int r, int n){

        if (r <= p + n - 1){
            insertion.insertionForMerge(array, p, r);
            return;
        }

        if (p < r){
            int q = p + (r - p) / 2;
            insertionMergeSort(array, p, q, n);
            insertionMergeSort(array, q + 1, r, n);
            combine(array, p, q, r);
        }

    }

    public static void combine(int[] array, int p, int q, int r){

        int n1 = q - p + 1;
        int n2 = r - q;
        int[] left = Arrays.copyOfRange(array, p, q + 1);
        int[] right = Arrays.copyOfRange(array, q + 1, r + 1);

        int i = 0;
        int j = 0;
        int k = p;

        while (i < n1 && j < n2){
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < n1) {
            array[k++] = left[i++];
        }

        while (j < n2){
            array[k++] = right[j++];
        }

    }
    
}
