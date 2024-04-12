import java.util.HashMap;

/**
 * @author Chris Hunt
 * @version 1
 * <p>
 * @Problem:
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * <p>
 * <p>
 * @Constraints:
 * <p>
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 * <p>
 * <p>
 * Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 * @Difficulty:
 * Easy
 */
public class TwoSum {
    /**
     * Finds the index of two values that sum to make the target.
     *
     * @param nums   array of ints to search.
     * @param target the target total.
     * @return indices of the two numbers such that they add up to target
     */
    public int[] twoSum(int[] nums, int target) {
        // Complement, index hashmap
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer complementIndex = map.get(nums[i]);
            if (complementIndex != null) return new int[]{i, complementIndex};
            map.put(target - nums[i], i);
        }
        return null;
    }
}