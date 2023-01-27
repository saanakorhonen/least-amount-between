package app.leastamountbetween;

import java.util.Arrays;

/**
 * Class for determining the least amount of numbers fitting between two numbers in an array consisting
 * of positive integers, in this implementation zero is also included.
 * 
 * @author Saana Korhonen
 * @version 24 Jan 2023
 *
 */
public class LeastAmountBetween {
    
    /**
     * Counts the least amount of numbers between two numbers in an array. Given array is assumed to continue
     * only positive integers (including zero).
     * 
     * Implementation assumes that numbers between two same values is not counted and two adjacent values both have the amount
     * of zero numbers between them.
     * 
     * @param arr given array of positive integers
     * @return least amount fitting between two numbers in the array, -1 if the amount cannot be counted.
     */
    public static int count(int[] arr) {
        // Sort array and remove duplicates as a preprocessing
        int[] sorted = sort(arr);
        
        return findLeastBetween(sorted);
    }
    
    /**
     * Finds least amount of numbers between a sorted array.
     * @param arr
     * @return
     */
    private static int findLeastBetween(int[] arr) {
        int result = Integer.MAX_VALUE;
        
        for (int i = 0, k = 1; i < arr.length - 1 && k < arr.length; i++, k++) {
            int numbersBetween = Math.abs(arr[i] - arr[k]) - 1;
            
            if (numbersBetween < result) {
                result = numbersBetween;
            }
        }
        
        return result != Integer.MAX_VALUE ? result : -1;
    }
    
    /**
     * Basic merge sort algorithm that removes duplicates.
     * 
     * @param arr array to be sorted
     * @return array sorted array in ascending order with no duplicates
     */
    private static int[] sort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        
        int[] arr1 = sort(Arrays.copyOfRange(arr, 0, arr.length / 2));
        int[] arr2 = sort(Arrays.copyOfRange(arr, arr.length / 2, arr.length));
        
        int[] result = new int[arr1.length + arr2.length];
        
        // Length of array to be returned. Decreases if some duplicates are removed.
        int n = result.length;
        
        // Indexes for array halves and result array
        int i = 0;
        int j = 0;
        int k = 0;
        
        // Sort the two halves into one result array
        while (j < arr1.length && k < arr2.length) {
            if (arr1[j] < arr2[k]) {
                result[i] = arr1[j];
                j++;
            } else if (arr2[k] < arr1[j]){
                result[i] = arr2[k];
                k++;
            } else {
                // If numbers are the same, remove one
                result[i] = arr1[j];
                n--;
                j++;
                k++;
            }
            i++;
        }
        
        // Add reminder from the arrays
        while (j < arr1.length) {
            result[i] = arr1[j];
            j++;
            i++;
        }
        
        while (k < arr2.length) {
            result[i] = arr2[k];
            k++;
            i++;
        }
        
        // Return array in range from first index to n. If duplicates are removed,
        // Indexes beyond n don't hold a value.
        return Arrays.copyOfRange(result, 0, n);
    }
    
    public static void main(String[] args) {
        int[] arr = {2, 15, 8, 4, 15, 60, 100, 1, 3, 80};
        System.out.println(count(arr));
    }
}