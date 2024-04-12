/**
 * @author Chris Hunt
 * @version 1
 * <p>
 * @Problem: Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * <p>
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * <p>
 * @Constraints: <p>
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 * @Difficulty: Medium
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Finds the length of the longest substring. Using a sliding window algorithm.
     *
     * @param s the string to search
     * @return the length of the longest substring
     */
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        for (int right = 0, left = 0; right < s.length(); right++) {
            int indexOfFirstAppearanceInSubstring = s.indexOf(s.charAt(right), left);

            if (indexOfFirstAppearanceInSubstring != right) left = indexOfFirstAppearanceInSubstring + 1;

            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}