package algs;

import java.util.Arrays;

public class heap {

    public static void maxHeapify(int[] array, int i, int n) {

        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest;

        if (left < n && array[left] > array[i]) {
            largest = left;
        } else {
            largest = i;
        }
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            swapping.swap(array, i, largest);
            maxHeapify(array, largest, n);
        }

    }

    public static void buildMaxHeap(int[] array, int n) {

        for (int i = (n / 2) - 1; i >= 0; i--) {
            maxHeapify(array, i, n);
        }

    }

    public static void maxHeapSort(int[] array, int n) {

        buildMaxHeap(array, n);
        int s = n;

        for (int i = n - 1; i > 0; i--) {
            swapping.swap(array, 0, i);
            s--;
            maxHeapify(array, 0, s);
        }

    }

    public static void minHeapify(int[] array, int i, int n) {

        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;

        if (left < n && array[left] < array[smallest]) {
            smallest = left;
        }
        if (right < n && array[right] < array[smallest]) {
            smallest = right;
        }
        if (smallest != i) {
            swapping.swap(array, i, smallest);
            minHeapify(array, smallest, n);
        }

    }

    public static void buildMinHeap(int[] array, int n) {

        for (int i = (n / 2) - 1; i >= 0; i--) {
            minHeapify(array, i, n);
        }

    }

    public static void minHeapSort(int[] array, int n) {

        buildMinHeap(array, n);
        int s = n;

        for (int i = n - 1; i > 0; i--) {
            swapping.swap(array, 0, i);
            s--;
            minHeapify(array, 0, s);
        }

    }

    public static void findTopKVideos(int[] views, int k) {
        
        int n = views.length;
        if (k >= n) {
            Arrays.sort(views);
            return;
        }

        int[] heap = Arrays.copyOfRange(views, 0, k);
        buildMinHeap(heap, k);

        for (int i = k; i < n; i++) {
            if (views[i] > heap[0]) {
                heap[0] = views[i];
                minHeapify(heap, 0, k);
            }
        }

        for (int i = k - 1; i >= 0; i--) {
            swapping.swap(heap, 0, i);
            minHeapify(heap, 0, i);
        }
        
    }

}
