package easy;

import utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/10/25 20:38
 * @Description: 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 * <p>
 * 示例 1：
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 * <p>
 * 示例 2：
 * 输入：nums = [1,1]
 * 输出：[2]
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 10^5
 * 1 <= nums[i] <= n
 * 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。
 */
public class E448FindDisappearedNumbers {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1};
        System.out.println(findDisappearedNumbers2(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] numFlags = new boolean[nums.length + 1];
        for (int num : nums) {
            numFlags[num] = true;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < numFlags.length; i++) {
            if (!numFlags[i]) {
                res.add(i);
            }
        }
        return res;
    }

    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 == i) {//位置对了
                continue;
            }
            int tmp = nums[i];
            while (true) {
                int next = nums[tmp - 1];
                if (next == tmp) {
                    break;
                }
                nums[tmp - 1] = tmp;
                tmp = next;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
