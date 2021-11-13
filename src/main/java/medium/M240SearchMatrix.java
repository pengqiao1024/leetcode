package medium;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/9/14 9:52
 * @Description: 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * <p>
 * 示例 1：
 * 输入：matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, target = 5
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, target = 20
 * 输出：false
 *  
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109 <= matrix[i][j] <= 109
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 * -109 <= target <= 109
 */
public class M240SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{10}};
        System.out.println(searchMatrix(matrix, -10));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        return searchMatrix(matrix, target, 0, matrix[0].length - 1);
    }

    public static boolean searchMatrix(int[][] matrix, int target, int row, int col) {
        if (row < 0 || col < 0) {
            return false;
        }
        int i = 0;
        for (; i <= col; i++) {
            if (matrix[row][i] == target) {
                return true;
            }
            if (matrix[row][i] > target) {
                i--;
                break;
            }
            if (i == col) {
                break;
            }
        }
        if (i < 0) {
            return false;
        }
        for (int j = row; j < matrix.length; j++) {
            if (matrix[j][i] == target) {
                return true;
            }
            if (matrix[j][i] > target) {
                return searchMatrix(matrix, target, j, i - 1);
            }
        }
        return false;
    }
}
