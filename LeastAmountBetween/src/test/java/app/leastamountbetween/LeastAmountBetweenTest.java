package app.leastamountbetween;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Test class for least amount between counting method.
 * 
 * @author Saana Korhonen
 * @version 24 Jan 2023
 *
 */
public class LeastAmountBetweenTest {

    /**
     * Tests the counter with array with random integers.
     */
    @Test
    public void testWithRandomIntegers() {
        int[] arr = {3, 8, 6, 10};
        
        int result = LeastAmountBetween.count(arr);
        assertEquals(1, result);
    }
    
    /**
     * Tests with an array containing some same values. Verifies that number between
     * two same numbers is count as zero.
     */
    @Test
    public void testWithArrayContainingSomeSameValues() {
        int[] arr = {3, 6, 5, 4, 2, 3};
        
        int result = LeastAmountBetween.count(arr);
        assertEquals(0, result);
    }
    
    /**
     * Tests with an empty array. Verifies that signal for no counting -1
     * is returned.
     */
    @Test
    public void testWithEmptyArry() {
        int result = LeastAmountBetween.count(new int[] {});
        assertEquals(-1, result);
    }
    
    /**
     * Tests with an array containing one integer. Verifies that no counting
     * signal -1 is returned when one integer is tested.
     */
    @Test
    public void testWithArrayWithOneInteger() {
        int result = LeastAmountBetween.count(new int[] {1});
        assertEquals(-1, result);
    }
    
    /**
     * Tests array with two integers. Verifies that program returns correct
     * number of numbers between numbers.
     */
    @Test
    public void testWithTwoIntegers() {
        int[] arr = {2, 6};
        
        int result = LeastAmountBetween.count(arr);
        assertEquals(3, result);
    }
    
    /**
     * Tests with array of adjacent numbers. Verifies that numbers between adjacent
     * numbers is count as zero.
     */
    @Test
    public void testWithAdjacentNumbers() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        
        int result = LeastAmountBetween.count(arr);
        assertEquals(0, result);
    }
    
    /**
     * Tests with maximum number between two integers. Verifies that returns the correct
     * value and that return value is never default value of Integer.MAX_VALUE.
     */
    @Test
    public void testWithMaxAmountOfNumbersBetweenTwoNumbers() {
        int[] arr = {0, Integer.MAX_VALUE};
        
        int result = LeastAmountBetween.count(arr);
        assertEquals(Integer.MAX_VALUE - 1, result);
    }
    
    /**
     * Tests an array containing same numbers. Verifies that the numbers between same
     * numbers is not counted.
     */
    @Test
    public void testWithSameNumbers() {
        int[] arr = {5, 5, 5, 5};
        
        int result = LeastAmountBetween.count(arr);
        assertEquals(-1, result);
    }
}
