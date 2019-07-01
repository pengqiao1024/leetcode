package easy;

/**
 * @Author: pengqiao01
 * @date: 2019/7/1 16:47
 */

/**
 * 翻转图像
 * <p>
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 * <p>
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 * <p>
 * 示例 1:
 * 输入: [[1,1,0],[1,0,1],[0,0,0]]
 * 输出: [[1,0,0],[0,1,0],[1,1,1]]
 * 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 * 然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 * <p>
 * 示例 2:
 * 输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 * 然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * <p>
 * 说明:
 * <p>
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 */
public class E832FlipAndInvertImage {

    public static void main(String[] args) {
        int[][] A = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        flipAndInvertImage(A);
        System.out.println("处理后==============");
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int[] a : A) {
            sb.append("{");
            for (int b : a) {
                sb.append(b + ",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("}");
        }
        sb.append("}");
        System.out.println(sb.toString());
    }

    public static int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int[] b = A[i];
            for (int j = 0; j < b.length; j++) {
                if (j < b.length / 2) {
                    int tmp = b[j];
                    b[j] = b[b.length - j - 1];
                    b[b.length - j - 1] = tmp;
                }
                b[j] = b[j] == 0 ? 1 : 0;
            }
        }
        return A;
    }
}
