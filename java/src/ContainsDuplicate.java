import java.util.Arrays;

/**
 * @author Chris Hunt
 * @version 1
 * @Problem: Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: false
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * @Constraints: <p>
 * 1 <= nums.length <= 10^5 <p>
 * -10^9 <= nums[i] <= 10^9
 * @Difficulty: Easy
 */
public class ContainsDuplicate {
    /**
     * Check for duplicates in an array.
     *
     * @param nums array of ints to check.
     * @return true there are duplicates false if not.
     */
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return true;
        }
        return false;
    }
}