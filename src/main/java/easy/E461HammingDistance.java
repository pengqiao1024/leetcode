package easy;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/10/27 14:45
 * @Description: 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 * <p>
 * 示例 1：
 * 输入：x = 1, y = 4
 * 输出：2
 * 解释：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 * <p>
 * 示例 2：
 * 输入：x = 3, y = 1
 * 输出：1
 * <p>
 * 提示：
 * 0 <= x, y <= 2^31 - 1
 */
public class E461HammingDistance {
    public static void main(String[] args) {
        System.out.println(hammingDistance(5, 4));
    }

    public static int hammingDistance(int x, int y) {
        int t = x ^ y;
        int count = 0;
        while (t > 0) {
            if ((t & 1) == 1) {
                count++;
            }
            t = t >> 1;
        }
        return count;
    }
}
