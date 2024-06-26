import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Chris Hunt
 * @version 1
 * @Problem: Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
 * <p>
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
 * <p>
 * Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
 * <p>
 * Return k.
 * <p>
 * Custom Judge:
 * <p>
 * The judge will test your solution with the following code:
 * <p>
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 * <p>
 * int k = removeDuplicates(nums); // Calls your implementation
 * <p>
 * assert k == expectedNums.length;
 * <p>
 * for (int i = 0; i < k; i++) {
 * <p>
 * assert nums[i] == expectedNums[i];
 * }
 * <p>
 * If all assertions pass, then your solution will be accepted.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * Example 2:
 * <p>
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * <p>
 * <p>
 * @Constraints: <p>
 * 1 <= nums.length <= 3 * 104
 * <p>
 * -100 <= nums[i] <= 100
 * <p>
 * nums is sorted in non-decreasing order.
 * @Difficulty: Easy
 */
public class RemoveDuplicatesFromSortedArray {
    /**
     * Removed duplicates from a sorted array.
     *
     * @param nums the array of numbers to remove duplicates from.
     * @return the number of elements left.
     */
    public int removeDuplicates(int[] nums) {
        int countNumberLeft = 0;
        int empty = -1;

        Queue<Integer> freeIndex = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();

        for (int index = 0; index < nums.length; index++) {
            int value = nums[index];
            if (seen.contains(value)) {
                nums[index] = empty;
                freeIndex.add(index);
                continue;
            } else if (!freeIndex.isEmpty()) {
                nums[freeIndex.poll()] = value;
                nums[index] = empty;
                freeIndex.add(index);
            }
            countNumberLeft++;
            seen.add(value);
        }
        return countNumberLeft;
    }
}