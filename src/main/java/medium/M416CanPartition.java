package medium;

import utils.Utils;

import java.util.*;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/10/19 19:58
 * @Description: 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 示例 1：
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 * <p>
 * 提示：
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
public class M416CanPartition {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 3, 5};
        System.out.println(canPartition(nums));
    }

    /**
     * 动规
     *
     * @param nums
     * @return
     */
    public static boolean canPartition2(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        Arrays.sort(nums);
        if (nums[nums.length - 1] > target) {
            return false;
        }
        if (nums[nums.length - 1] == target) {
            return true;
        }
        target = target - nums[nums.length - 1];//如果可以分割，最后一个一定会在其中一个结果里面
        boolean[][] dp = new boolean[nums.length - 1][target + 1];
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < nums.length - 1; i++) {//计算[0,nums.length-2] 之间的数
            for (int j = 0; j <= target; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                    if (j + nums[i] <= target) {
                        dp[i][j + nums[i]] = true;
                    }
                }
            }
        }
        return dp[nums.length - 2][target];
    }

    public static boolean canPartition(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        Arrays.sort(nums);
        if (nums[nums.length - 1] > target) {
            return false;
        }
        if (nums[nums.length - 1] == target) {
            return true;
        }
        target = target - nums[nums.length - 1];//如果可以分割，最后一个一定会在其中一个结果里面
        Deque<Integer> indexes = new LinkedList<>();
        indexes.add(0);
        if (findTarget(nums, target, 1, indexes)) {
            return true;
        }
        return false;
    }

    private static boolean findTarget(int[] nums, int target, int index, Deque<Integer> indexes) {
        if (index == nums.length - 1) {
            if (indexes.isEmpty()) {
                return false;
            }
            int lindex = indexes.pollLast();
            if (lindex == nums.length - 2) {
                return false;
            }
            if (findTarget(nums, target, lindex + 1, indexes)) {
                return true;
            }
        } else {
            indexes.addLast(index);
            int nSum = getSum(nums, indexes);
            if (nSum == target) {
                return true;
            }
            if (nSum < target) {
                if (findTarget(nums, target, index + 1, indexes)) {
                    return true;
                }
            }
            if (nSum > target) {
                indexes.pollLast();
                if (indexes.isEmpty()) {
                    return false;
                }
                if (findTarget(nums, target, indexes.pollLast() + 1, indexes)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int getSum(int[] nums, Deque<Integer> indexes) {
        int sum = 0;
        for (Integer index : indexes) {
            sum += nums[index];
        }
        return sum;
    }
}
