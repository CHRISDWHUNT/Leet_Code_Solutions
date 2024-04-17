import java.util.Arrays;

/**
 * @author Chris Hunt
 * @version 1
 * @Problem: Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
 * <p>
 * You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,0]
 * Output: 3
 * Explanation: The numbers in the range [1,2] are all in the array.
 * Example 2:
 * <p>
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Explanation: 1 is in the array but 2 is missing.
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 * Explanation: The smallest positive integer 1 is missing.
 * <p>
 * <p>
 * @Constraints: <p>
 * 1 <= nums.length <= 105
 * <p>
 * -231 <= nums[i] <= 231 - 1
 * @Difficulty: Hard
 */
public class FirstMissingPositive {
    /**
     * Finds the first positive integer missing.
     *
     * @param nums the number to search.
     * @return the first positive integer missing.
     */
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);

        int value = 1;
        for (int num : nums) {
            if (num <= 0) continue;
            if (num == value) value++;
            else if (num != value - 1) return value;
        }
        return value;
    }
}