package easy;

/**
 * @Author: pengqiao01
 * @date: 2019/7/1 17:40
 */

/**
 * 有序数组的平方
 * <p>
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 * 示例 1：
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * <p>
 * 示例 2：
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 * <p>
 * 提示：
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E977SortedSquares {
    public static void main(String[] args) {
        int[] A = {-7, -3, 2, 3, 11};
        int[] B = sortedSquares(A);
        System.out.print("{");
        for (int i = 0; i < B.length; i++) {
            System.out.print(B[i]);
            if (i != B.length - 1) {
                System.out.print(",");
            }
        }
        System.out.print("}");
    }

    public static int[] sortedSquares(int[] A) {
        int index = 0;
        //找到绝对值最小的点
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                index = i;
                if (i > 0 && A[i - 1] * A[i - 1] < A[i] * A[i]) {
                    index = i - 1;
                }
                break;
            }
        }
        int[] B = new int[A.length];
        int nIndex = 0;
        B[nIndex++] = A[index] * A[index];//计算第一个值
        //两侧同时推进 比较放入新数组
        int left = index - 1;
        int right = index + 1;
        while (true) {
            if (left < 0 && right == A.length) {
                break;
            }
            if (left >= 0 && right < A.length) {
                int lv = A[left] * A[left];
                int rv = A[right] * A[right];
                if (lv < rv) {
                    B[nIndex++] = lv;
                    left--;
                } else {
                    B[nIndex++] = rv;
                    right++;
                }
            } else if (left >= 0) {//右侧遍历完成
                int lv = A[left] * A[left];
                B[nIndex++] = lv;
                left--;
            } else {//左侧遍历完成
                int rv = A[right] * A[right];
                B[nIndex++] = rv;
                right++;
            }
        }
        return B;
    }
}
