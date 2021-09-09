package hard;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/8/13 16:51
 * @Description: 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * <p>
 * 示例 1：
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：6
 * 解释：最大矩形如上图所示。
 * <p>
 * 示例 2：
 * 输入：matrix = []
 * 输出：0
 * <p>
 * 示例 3：
 * 输入：matrix = [["0"]]
 * 输出：0
 * <p>
 * 示例 4：
 * 输入：matrix = [["1"]]
 * 输出：1
 * <p>
 * 示例 5：
 * 输入：matrix = [["0","0"]]
 * 输出：0
 *  
 * <p>
 * 提示：
 * rows == matrix.length
 * cols == matrix[0].length
 * 0 <= row, cols <= 200
 * matrix[i][j] 为 '0' 或 '1'
 */
public class H85MaximalRectangle {
    public static void main(String[] args) {

    }

    public static int maximalRectangle(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
            }
        }
        return 0;
    }
}
