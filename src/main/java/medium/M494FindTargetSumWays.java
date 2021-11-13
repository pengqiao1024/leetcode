package medium;

import utils.Utils;

import java.util.*;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/10/27 15:32
 * @Description: 给你一个整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * <p>
 * 示例 2：
 * 输入：nums = [1], target = 1
 * 输出：1
 *  
 * <p>
 * 提示：
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 */
public class M494FindTargetSumWays {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1};
        System.out.println(findTargetSumWays(nums, 3));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (target > sum || target < -sum) {
            return 0;
        }
        //dp[i][j]=n 代表第0~i个元素，可以组成j-target的方法数为n
        //j对应位置:j+sum
        int[][] dp = new int[nums.length][2 * sum + 1];//-sum 0  sum
        if (nums[0] == 0) {
            dp[0][sum] = 2;
        } else {
            dp[0][sum + nums[0]] = 1;
            dp[0][sum - nums[0]] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < 2 * sum + 1; j++) {
                if (dp[i - 1][j] == 0) {
                    continue;
                }
                dp[i][j + nums[i]] = dp[i][j + nums[i]] + dp[i - 1][j];
                dp[i][j - nums[i]] = dp[i][j - nums[i]] + dp[i - 1][j];
            }
        }
        return dp[nums.length - 1][target + sum];
    }

}
