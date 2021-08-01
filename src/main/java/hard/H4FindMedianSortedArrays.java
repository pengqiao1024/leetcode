package hard;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/7/8 20:39
 * @Description:
 */

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * <p>
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * <p>
 * 示例 3：
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * <p>
 * 示例 4：
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * <p>
 * 示例 5：
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *  
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *  
 * <p>
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class H4FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (n + m == 0) {
            return 0;
        }
        boolean hasTwo = (m + n) % 2 == 0;
        int mid = hasTwo ? (m + n) / 2 : (m + n) / 2 + 1;
        int index = 0;
        Integer tmp = null;
        for (int i = 0, j = 0; ; ) {
            int num;
            if (i < nums1.length && j < nums2.length) {
                num = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
            } else if (i < nums1.length) {//nums2已达到边界
                num = nums1[i++];
            } else {//nums1已达到边界
                num = nums2[j++];
            }
            if (++index >= mid) {
                if (!hasTwo) {
                    return num;
                }
                if (tmp != null) {
                    return (double) (tmp + num) / 2;
                }
                tmp = num;
            }
        }
    }
}
