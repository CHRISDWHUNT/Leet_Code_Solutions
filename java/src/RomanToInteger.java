/**
 * @author Chris Hunt
 * @version 1
 * @Problem: Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value   <p>
 * I             1      <p>
 * V             5      <p>
 * X             10     <p>
 * L             50     <p>
 * C             100    <p>
 * D             500    <p>
 * M             1000   <p>
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.<p>
 * X can be placed before L (50) and C (100) to make 40 and 90.<p>
 * C can be placed before D (500) and M (1000) to make 400 and 900.<p>
 * Given a roman numeral, convert it to an integer.<p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "III"<p>
 * Output: 3
 * Explanation: III = 3.
 * <p>
 * Example 2:<p>
 * Input: s = "LVIII"<p>
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.<p>
 * Example 3:<p>
 * <p>
 * Input: s = "MCMXCIV"<p>
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * <p>
 * @Constraints: <p>
 * 1 <= s.length <= 15 <p>
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').<p>
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].<p>
 * @Difficulty: Easy
 */
public class RomanToInteger {
    /**
     * Turn a Roman numeral to its integer value.
     *
     * @param s the string representing the Roman numeral.
     * @return the integer representation of the number.
     */
    public int romanToInt(String s) {
        // Values of each numeral
        String symbol = "MDCLXVI";
        int[] value = {1000, 500, 100, 50, 10, 5, 1};

        int prev = 0;
        int num = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            // Find the value of the char at representing the number
            int current = value[symbol.indexOf(s.charAt(i))];
            // If previous value is <= current value add the number
            // if they are greater or equal then take away as this is a case where the value is for example IV (4)
            if (prev <= current) num += current;
            else num -= current;
            prev = current;
        }
        return num;
    }
}