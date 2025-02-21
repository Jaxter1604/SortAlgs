import algs.*;
import java.io.*;
import java.util.*;

public class timeAll {

    interface SortingAlgorithm {
        void sort(int[] array);
    }

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Long> results = new ArrayList<>();
        ArrayList<Long> dutch = new ArrayList<>();
        ArrayList<Long> bad = new ArrayList<>();

        String[] filenames = {
            "algorithms/src/test/test-data/int10.txt",
            "algorithms/src/test/test-data/int50.txt",
            "algorithms/src/test/test-data/int100.txt",
            "algorithms/src/test/test-data/int1000.txt",
            "algorithms/src/test/test-data/int20k.txt",
            "algorithms/src/test/test-data/bad.txt",
            "algorithms/src/test/test-data/int500k.txt",
            "algorithms/src/test/test-data/intBig.txt",
            "algorithms/src/test/test-data/dutch.txt"
        };

        int runs = 10;
        
        // Define all sorting algorithms
        List<SortingAlgorithm> algorithms = Arrays.asList(
            array -> insertion.insertionSort(array),            
            array -> merge.mergeSort(array, 0, array.length - 1), 
            array -> merge.insertionMergeSort(array, 0, array.length - 1, 20), 
            array -> merge.bottomUpMergeSort(array),   
            array -> quick.quickSort(array),           
            array -> quick.insertionQuickSort(array, 20), 
            array -> quick.medianQuickSort(array),     
            array -> quick.quickSort3Way(array),  
            array -> selection.selectionSort(array),
            array -> shell.shellSort(array)
        );

        for (String fileName : filenames) {
            int[] array = readArray(fileName);
            System.out.println("--------------------");
            System.out.println("Time to sort: " + fileName);
            
            for (SortingAlgorithm algorithm : algorithms) {
                long time = timeSorting(array, runs, algorithm);
                categorizeResult(fileName, time, results, dutch, bad);
            }
        }

        saveResults("results/results.csv", results);
        saveResults("results/dutch.csv", dutch);
        saveResults("results/bad.csv", bad);
        
    }

    private static long timeSorting(int[] array, int runs, SortingAlgorithm algorithm) {
        
        long time = 0;
    
        for (int i = 0; i < runs; i++) {
            int[] tempArray = array.clone();
            long startTime = System.nanoTime();
            algorithm.sort(tempArray);
            long finishTime = System.nanoTime();
            time += finishTime - startTime;
        }
    
        return time / runs;

    }

    private static void categorizeResult(String fileName, long result, ArrayList<Long> results, ArrayList<Long> dutch, ArrayList<Long> bad) {

        if (fileName.contains("dutch")) {
            dutch.add(result);
        } else if (fileName.contains("bad")) {
            bad.add(result);
        } else {
            results.add(result);
        }

    }

    private static void saveResults(String filename, List<Long> data) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(data.toString().replaceAll("[\\[\\] ]", ""));
            System.out.println(filename + " written successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public static int[] readArray(String path) throws FileNotFoundException {

        try (Scanner sc = new Scanner(new File(path))) {
            List<Integer> data = new ArrayList<>();
            while (sc.hasNextInt()) {
                data.add(sc.nextInt());
            }
            return data.stream().mapToInt(i -> i).toArray();
        }

    }
    
}
