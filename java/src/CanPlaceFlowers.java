/**
 * @author Chris Hunt
 * @version 1
 * @Problem: You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
 * <p>
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false

 * <p>
 * @Constraints:
 * <p>
 * 1 <= flowerbed.length <= 2 * 104
 * <p>
 * flowerbed[i] is 0 or 1.
 * <p>
 * There are no two adjacent flowers in flowerbed.
 * <p>
 * 0 <= n <= flowerbed.length
 * @Difficulty: Easy
 */

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int spaces = 0;

        for (int i = 0; i < flowerbed.length; i++) {
            if (spaces >= n) return true;
            int before = i - 1;
            int after = i + 1;
            if (unseeded(flowerbed, before) && unseeded(flowerbed, i) && unseeded(flowerbed, after)) {
                spaces++;
                i++;
            }
        }
        return spaces >= n;
    }

    private boolean unseeded(int[] flowerbed, int position) {
        return position == -1 || position == flowerbed.length || flowerbed[position] == 0;
    }
}
