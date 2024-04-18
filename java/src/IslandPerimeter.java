/**
 * @author Chris Hunt
 * @version 1
 * @Problem: You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
 * <p>
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 * <p>
 * The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * Output: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image above.
 * <p>
 * Example 2:
 * <p>
 * Input: grid = [[1]]
 * Output: 4
 * <p>
 * Example 3:
 * <p>
 * Input: grid = [[1,0]]
 * Output: 4
 * <p>
 * <p>
 * @Constraints: <p>
 * row == grid.length
 * <p>
 * col == grid[i].length
 * <p>
 * 1 <= row, col <= 100
 * <p>
 * grid[i][j] is 0 or 1.
 * <p>
 * There is exactly one island in grid.
 * @Difficulty: Easy
 */
public class IslandPerimeter {
    /**
     * Determine the perimeter of the island represented by the given grid.
     *
     * @param grid an 2D int array containing 1 to signify land and 0 no land.
     * @return the perimeter of the landmass.
     */
    public int islandPerimeter(int[][] grid) {
        int islands = 0;
        int neighbors = 0;

        for (int row = 0; row < grid.length; row++)
            for (int column = 0; column < grid[0].length; column++)
                if (grid[row][column] == 1) {
                    islands++;
                    if (row - 1 >= 0 && grid[row - 1][column] == 1) neighbors++;
                    if (column - 1 >= 0 && grid[row][column - 1] == 1) neighbors++;
                }
        // The number of islands * 4 is the total possible parameter if all were separate.
        // You then remove the joining edges i.e. [1,2] against [1,3]. This is one for [1,2]
        // and one for [1,3] hence the neighbours value is doubled.
        return islands * 4 - neighbors * 2;
    }
}