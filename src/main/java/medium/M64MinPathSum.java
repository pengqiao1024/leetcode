package medium;

import utils.Utils;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/8/11 12:53
 * @Description: 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 *  
 * 示例 1：
 * 输入：grid = {{1,3,1},{1,5,1},{4,2,1}}
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 示例 2：
 * 输入：grid = {{1,2,3},{4,5,6}}
 * 输出：12
 *  
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 */
public class M64MinPathSum {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,2,3},{4,5,6}};
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
//        Utils.printArrayToMatrix(grid);
        int[][] sum = new int[grid.length][grid[0].length];
        sum[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            sum[i][0] = grid[i][0] + sum[i - 1][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            sum[0][i] = grid[0][i] + sum[0][i - 1];
        }
//        Utils.printArrayToMatrix(sum);
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
            }
        }
//        Utils.printArrayToMatrix(sum);
        return sum[grid.length - 1][grid[0].length - 1];
    }
}
