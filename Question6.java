

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ForkJoinPool;

public class Question6 {


    //function to merge sort
    private static class MergeSortingTask extends RecursiveAction {
        private final int[] arr;
        private final int start;
        private final int end;

        public MergeSortingTask(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {

            //base case
            if (end - start <= 1) {
                return;
            }

            int midIndex = (start + end) / 2;

            //recurisve call to sort left side
            MergeSortingTask leftTask = new MergeSortingTask(arr, start, midIndex);

            //recurisve call to sort right side
            MergeSortingTask rightTask = new MergeSortingTask(arr, midIndex, end);

            invokeAll(leftTask, rightTask);

            merge(arr, start, midIndex, end);
        }

        private void merge(int[] array, int start, int midIndex, int end) {
            int[] merged = new int[end - start];
            int leftIndex = start;
            int rightIndex = midIndex;
            int mergedIndex = 0;

            while (leftIndex < midIndex && rightIndex < end) {
                if (array[leftIndex] < array[rightIndex]) {
                    merged[mergedIndex++] = array[leftIndex++];
                } else {
                    merged[mergedIndex++] = array[rightIndex++];
                }
            }

            while (leftIndex < midIndex) {
                merged[mergedIndex++] = array[leftIndex++];
            }

            while (rightIndex < end) {
                merged[mergedIndex++] = array[rightIndex++];
            }

            System.arraycopy(merged, 0, array, start, merged.length);
        }
    }

    public static void Question6(int[] array) {
        ForkJoinPool pool = new ForkJoinPool();
        MergeSortingTask task = new MergeSortingTask(array, 0, array.length);
        pool.invoke(task);
    }

    public static void main(String[] args) {

        //testing with input 1
        int[] inputArray1 = {5, 3, 9, 1, 7, 2, 8, 4, 6};
        Question6(inputArray1);
        System.out.println("Sorted array 1: " + Arrays.toString(inputArray1));


        //testing with input 2
        int[] inputArray2 = {1,2,3,4,5,6};
        Question6(inputArray2);
        System.out.println("Sorted array 2: " + Arrays.toString(inputArray2));

        //testing with input 3
        int[] inputArray3 = {6,5,4,3,2,1};
        Question6(inputArray3);
        System.out.println("Sorted array 3: " + Arrays.toString(inputArray3));

    }
}
