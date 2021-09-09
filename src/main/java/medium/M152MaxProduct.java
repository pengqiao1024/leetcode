package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/8/24 15:58
 * @Description: 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积
 * 。
 * 示例 1:
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class M152MaxProduct {
    public static void main(String[] args) {
        int[] nums = new int[]{-2};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        List<Integer> minusIndexes = new ArrayList<>();
        List<Integer> maxProducts = new ArrayList<>();
        int left = 0;
        boolean hasZero = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                maxProducts.add(i == 0 ? 0 : maxProduct(nums, left, i - 1, minusIndexes));
                left = i + 1;
                minusIndexes = new ArrayList<>();
                hasZero = true;
                continue;
            }
            if (nums[i] < 0) {
                minusIndexes.add(i);
            }
            if (i == nums.length - 1) {
                maxProducts.add(maxProduct(nums, left, nums.length - 1, minusIndexes));
            }
        }
        int maxProduct = maxProducts.get(0);
        for (Integer product : maxProducts) {
            if (product > maxProduct) {
                maxProduct = product;
            }
        }
        if (maxProduct < 0 && hasZero) {
            maxProduct = 0;
        }
        return maxProduct;
    }

    /**
     * 计算nums【left,right】区间计算的最大值，区间中无0值
     *
     * @param nums
     * @param left
     * @param right
     * @param minusIndexes
     * @return
     */
    private static int maxProduct(int[] nums, int left, int right, List<Integer> minusIndexes) {
        if (left == right) {
            return nums[left];
        }
        if (minusIndexes.size() % 2 == 0) {
            return product(nums, left, right);
        }
        if (minusIndexes.size() == 1) {
            int index = minusIndexes.get(0);
            if (index == 0) {
                return product(nums, index + 1, right);
            }
            if (index == nums.length - 1) {
                return product(nums, left, index - 1);
            }
        }
        return Math.max(product(nums, minusIndexes.get(0) + 1, right), product(nums, left, minusIndexes.get(minusIndexes.size() - 1) - 1));
    }

    /**
     * 计算nums【left,right】区间的值
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private static int product(int[] nums, int left, int right) {
        int product = nums[left];
        for (left = left + 1; left <= right; left++) {
            product = product * nums[left];
        }
        return product;
    }
}
