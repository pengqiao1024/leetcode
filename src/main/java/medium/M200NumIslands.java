package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/8/30 19:47
 * @Description: 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：grid = [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * 输出：3
 *  
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 */
public class M200NumIslands {
    public static void main(String[] args) {

//        char[][] gird = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        char[][] gird = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(numIslands(gird));
    }

    public static int numIslands(char[][] grid) {
        boolean[][] finds = new boolean[grid.length][grid[0].length];//记录是否被处理
        int count = 0;//岛屿数量
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (finds[i][j]) {
                    continue;
                }
                if (grid[i][j] == '1') {
                    count++;
                    findRound(grid, finds, i, j);
                }
                finds[i][j] = true;
            }
        }

        return count;
    }

    /**
     * 查找相连的陆地
     *
     * @param grid
     * @param finds
     * @param i
     * @param j
     */
    private static void findRound(char[][] grid, boolean[][] finds, int i, int j) {
        int[][] round = new int[][]{{i, j + 1}, {i, j - 1}, {i - 1, j}, {i + 1, j}};
        for (int[] indexes : round) {
            int ii = indexes[0];
            int jj = indexes[1];
            if (ii < 0 || ii > grid.length - 1 || jj < 0 || jj > grid[0].length - 1 || finds[ii][jj]) {
                continue;
            }
            finds[ii][jj] = true;
            if (grid[ii][jj] == '1') {
                findRound(grid, finds, ii, jj);
            }
        }
    }
}
