package medium;

import utils.Utils;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/9/10 17:43
 * @Description: 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 * 示例:
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *  
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class M238ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        Utils.printArray(productExceptSelf(nums));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] lp = new int[nums.length];
        lp[0] = 1;
        int[] rp = new int[nums.length];
        rp[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            lp[i] = lp[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            rp[i] = rp[i + 1] * nums[i + 1];
        }
        int[] res = new int[nums.length];
        res[0] = rp[0];
        res[nums.length - 1] = lp[nums.length - 1];
        for (int i = 1; i < res.length - 1; i++) {
            res[i] = lp[i] * rp[i];
        }
        return res;
    }
}
