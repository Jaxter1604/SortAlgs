import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import algs.*;

@SuppressWarnings("unused")
public class testAll {

    int[][] testCases = {
            {}, // empty set
            { 1 }, // one element
            { 2, 1 }, // two elements
            { 1, 2, 3, 4, 5, 6 }, // pre-ordered
            { 6, 5, 4, 3, 2, 1 }, // reversed
            { 2, 5, 7, 9, 3, 4 }, // random
            { 1, 1, 1, 1 }, // same element
            { -2, 0, 1, -1, -5, 6 } // negatives
    };

    int[][] expected = {
            {},
            { 1 },
            { 1, 2 },
            { 1, 2, 3, 4, 5, 6 },
            { 1, 2, 3, 4, 5, 6 },
            { 2, 3, 4, 5, 7, 9 },
            { 1, 1, 1, 1 },
            { -5, -2, -1, 0, 1, 6 }
    };

    @Test
    void testInsertionSort() {
        for (int i = 0; i < testCases.length; i++) {
            int[] testCase = testCases[i];
            int[] waitingValue = expected[i];
            int[] result = insertion.insertionSort(testCase);
            assertArrayEquals(result, waitingValue);
        }

    }

    @Test
    void testquickSort() {
        for (int i = 0; i < testCases.length; i++) {
            int[] testCase = testCases[i];
            int[] waitingValue = expected[i];
            int[] result = quick.quickSort(testCase);
            assertArrayEquals(result, waitingValue);
        }

    }

    @Test
    void testInsertionQuickSort() {
        for (int i = 0; i < testCases.length; i++) {
            int[] testCase = testCases[i];
            int[] waitingValue = expected[i];
            int[] result = quick.insertionQuickSort(testCase, 3);
            assertArrayEquals(result, waitingValue);
        }

    }

    @Test
    void testMedianquickSort() {
        for (int i = 0; i < testCases.length; i++) {
            int[] testCase = testCases[i];
            int[] waitingValue = expected[i];
            int[] result = quick.medianQuickSort(testCase);
            assertArrayEquals(result, waitingValue);
        }

    }

    @Test
    void testquickSort3Way() {
        for (int i = 0; i < testCases.length; i++) {
            int[] testCase = testCases[i];
            int[] waitingValue = expected[i];
            int[] result = quick.quickSort3Way(testCase);
            assertArrayEquals(result, waitingValue);
        }

    }

    @Test
    void testSelectionSort() {
        for (int i = 0; i < testCases.length; i++) {
            int[] testCase = testCases[i];
            int[] waitingValue = expected[i];
            int[] result = selection.selectionSort(testCase);
            assertArrayEquals(result, waitingValue);
        }

    }

    @Test
    void testShellSort() {
        for (int i = 0; i < testCases.length; i++) {
            int[] testCase = testCases[i];
            int[] waitingValue = expected[i];
            int[] result = shell.shellSort(testCase);
            assertArrayEquals(result, waitingValue);
        }

    }

    @Test
    void testMergeSort() {

        for (int i = 0; i < testCases.length; i++) {
            int[] testCase = testCases[i];
            int[] waitingValue = expected[i];
            merge.mergeSort(testCase, 0, testCase.length - 1);
            assertArrayEquals(testCase, waitingValue);
        }

    }

    @Test
    void testBottomUpMergeSort() {

        for (int i = 0; i < testCases.length; i++) {
            int[] testCase = testCases[i];
            int[] waitingValue = expected[i];
            merge.bottomUpMergeSort(testCase);
            assertArrayEquals(testCase, waitingValue);
        }

    }

    @Test
    void testInsertionMergeSort() {

        for (int i = 0; i < testCases.length; i++) {
            int[] testCase = testCases[i];
            int[] waitingValue = expected[i];
            merge.insertionMergeSort(testCase, 0, testCase.length - 1, 3);
            assertArrayEquals(testCase, waitingValue);
        }

    }

    @Test
    void testMinHeapSort() {
        int[] testData = {95, 12, 87, 44, 63, 29, 78, 16, 11, 36, 
                          50, 93, 84, 41, 21, 66, 55, 32, 98, 25, 
                          72, 80, 20, 62, 99, 45, 37, 10, 18, 74, 
                          47, 60, 88, 81, 53, 30, 17, 23, 34, 92, 
                          14, 56, 70, 19, 67, 76, 33, 82, 90, 48};

        int[] expectedData = {99, 98, 95, 93, 92, 90, 88, 87, 84, 82, 
                              81, 80, 78, 76, 74, 72, 70, 67, 66, 63, 
                              62, 60, 56, 55, 53, 50, 48, 47, 45, 44, 
                              41, 37, 36, 34, 33, 32, 30, 29, 25, 23, 
                              21, 20, 19, 18, 17, 16, 14, 12, 11, 10};
        
        heap.minHeapSort(testData, 5);
        assertEquals(testData, expectedData);     
    }

}
