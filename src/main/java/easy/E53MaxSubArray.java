package easy;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/8/6 17:08
 * @Description: 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * <p>
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：nums = [0]
 * 输出：0
 * <p>
 * 示例 4：
 * 输入：nums = [-1]
 * 输出：-1
 * <p>
 * 示例 5：
 * 输入：nums = [-100000]
 * 输出：-100000
 *  
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * -105 <= nums[i] <= 105
 *  
 * <p>
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 */
public class E53MaxSubArray {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, -2, 4, -2};
        System.out.println(maxSubArray2(nums));
    }

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int maxSum = nums[0];
        int sum = nums[0];
        int left = 0;
        int right = nums.length - 1;
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            if (sum < nums[i]) {
                sum = nums[i];
                left = i;
            }
            if (maxSum < sum) {
                maxSum = sum;
                right = i;
            }
        }
        System.out.println("left: " + left + " right:" + right);
        return maxSum;
    }

    public static int maxSubArray2(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int[] maxSums = new int[nums.length];
        maxSums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxSums[i] = Math.max(maxSums[i - 1] + nums[i], nums[i]);
        }
        int maxSum = maxSums[0];
        for (Integer sum : maxSums) {
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }
}
