package medium;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/9/16 10:28
 * @Description: 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 * 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
 * <p>
 * 示例 1：
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：nums = [3,1,3,4,2]
 * 输出：3
 * <p>
 * 示例 3：
 * 输入：nums = [1,1]
 * 输出：1
 * <p>
 * 示例 4：
 * 输入：nums = [1,1,2]
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10^5
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
 */
public class M287FindDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[]{3,1,3,4,2};
        System.out.println(findDuplicate2(nums));
    }

    public static int findDuplicate(int[] nums) {
        int l = 1;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                    if (count > mid) {
                        r = mid;
                        break;
                    }
                }
            }
            if (count <= mid) {
                l = mid + 1;
            }
        }
        return l;
    }

    public static int findDuplicate2(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (nums[slow] == nums[fast]) {
                break;
            }
        }
        slow = 0;
        while (nums[slow] != nums[fast]) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return nums[slow];
    }
}
