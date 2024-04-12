/**
 * @author Chris Hunt
 * @version 1
 * @Problem: Given an integer x, return true if x is a palindrome, and false otherwise.
 * <p>
 * Example 1:
 * <p>
 * Input: x = 121 <p>
 * Output: true <p>
 * Explanation: 121 reads as 121 from left to right and from right to left.<p>
 * Example 2:<p>
 * Input: x = -121<p>
 * Output: false<p>
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore, it is not a palindrome.<p>
 * Example 3:<p>
 * Input: x = 10<p>
 * Output: false<p>
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 * <p>
 * Follow up: Could you solve it without converting the integer to a string?
 * @Constraints: -231 <= x <= 231 - 1
 * @Difficulty: Easy
 */
public class PalindromeNumber {
    /**
     * Determines if a number is palindromic.
     *
     * @param input number to assess.
     * @return true if it is, false if it isn't.
     */
    public boolean isPalindrome(int input) {
        int reverseInt = 0;

        // Temp storing the unmodified input
        int temp = input;

        // Negative numbers are not classed as palindromic
        if (temp < 0) return false;

        while (input > 0) {
            // Take the remainder (which will be the right most digit)
            int remainder = input % 10;
            // Shift the current left most digit to the left by 1 dp and add the remainder to it
            reverseInt = (reverseInt * 10) + remainder;
            // Remove the right most digit from the input
            input /= 10;
        }
        return reverseInt == temp;
    }
}