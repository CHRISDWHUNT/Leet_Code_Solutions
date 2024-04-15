/**
 * @author Chris Hunt
 * @version 1
 * @Problem: You are given an integer array height of length n. There are n vertical lines drawn such that the two
 * endpoints of the ith line are (i, 0) and (i, height[i]).
 * <p>
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * <p>
 * Return the maximum amount of water a container can store.
 * <p>
 * Notice that you may not slant the container.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49 <p>
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of
 * water (blue section) the container can contain is 49.
 * <p>
 * Example 2:
 * <p>
 * Input: height = [1,1]
 * Output: 1
 * <p>
 * @Constraints: <p>
 * n == height.length <p>
 * 2 <= n <= 105 <p>
 * 0 <= height[i] <= 104 <p>
 * @Difficulty: Medium
 */
public class ContainerWithMostWater {
    /**
     * Finds two values that together with the x-axis form a container, such that the container contains the most water.
     *
     * @param height array of container heights.
     * @return the max value that the area can be.
     */
    public int maxArea(int[] height) {
        int n = height.length;
        int stepNumber = 1;
        int area = 0;

        int frontPtr = 0;
        int backPtr = n - 1;
        while (frontPtr != backPtr) {
            int overFlowPoint = Math.min(height[frontPtr], height[backPtr]);
            area = Math.max(overFlowPoint * (n - stepNumber), area);

            if (overFlowPoint == height[frontPtr]) frontPtr++;
            else backPtr--;
            stepNumber++;
        }
        return area;
    }
}