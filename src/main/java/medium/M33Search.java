package medium;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/7/16 14:26
 * @Description: 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * 示例 1：
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * <p>
 * 示例 2：
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * <p>
 * 示例 3：
 * 输入：nums = [1], target = 0
 * 输出：-1
 * <p>
 * 提示：
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -10^4 <= target <= 10^4
 *  
 * <p>
 * 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
 */
public class M33Search {
    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2, 3}, 3));
    }

    public static int search(int[] nums, int target) {
        int n = nums.length / 2;
        int left = 0;
        int right = nums.length - 1;
        int index;
        while (true) {
            if (nums[n] <= nums[right] && nums[n] >= nums[left]) {
                index = left;
                break;
            }
            if (nums[n] > nums[right]) {
                left = n + 1;
                n = (left + right) / 2;
                continue;
            }
            if (nums[n] < nums[left]) {
                right = n;
                n = (left + right) / 2;
                continue;
            }
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0;
        int r = nums.length - 1;
        if (target > nums[nums.length - 1]) {
            r = index - 1;
        } else {
            l = index;
        }
        while (l <= r) {
            int i = (l + r) / 2;
            if (nums[i] == target) {
                return i;
            }
            if (nums[i] > target) {
                r = i-1;
                continue;
            }
            if (nums[i] < target) {
                l = i+1;
            }
        }
        return -1;
    }
}
