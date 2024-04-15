import java.util.Arrays;

/**
 * @author Chris Hunt
 * @version 1
 * @Problem: Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"<p>
 * Example 2:
 * <p>
 * Input: strs = ["dog","racecar","car"]
 * Output: ""<p>
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * <p>
 * @Constraints: <p>
 * 1 <= strs.length <= 200 <p>
 * 0 <= strs[i].length <= 200 <p>
 * strs[i] consists of only lowercase English letters.<p>
 * @Difficulty: Easy
 */
public class LongestCommonPrefix {
    /**
     * Finds the longest common prefix out of an array of strings.
     *
     * @param strs the array of string to find a prefix for.
     * @return the prefix.
     */
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();

        // Ordered lexicographically
        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];

        // Only check up to the length of the smallest string (the max prefix is this string)
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) == last.charAt(i)) sb.append(first.charAt(i));
            else break;
        }

        return sb.toString();
    }
}