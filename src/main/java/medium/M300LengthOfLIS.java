package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/9/17 15:03
 * @Description: 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 *  
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * <p>
 * 示例 2：
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * <p>
 * 示例 3：
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 *  
 * 提示：
 * 1 <= nums.length <= 2500
 * -10^4 <= nums[i] <= 10^4
 *  
 * 进阶：
 * 你可以设计时间复杂度为 O(n2) 的解决方案吗？
 * 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
 */
public class M300LengthOfLIS {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS2(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        List<List<Integer>> incrLISs = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        incrLISs.add(list);
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> nIncrLISs = new ArrayList<>(incrLISs);
            boolean flag = false;
            for (List<Integer> lis : incrLISs) {
                if (nums[i] > lis.get(lis.size() - 1)) {
                    flag = true;
                    List<Integer> nlis = new ArrayList<>(lis);
                    nlis.add(nums[i]);
                    nIncrLISs.add(nlis);
                }
            }
            if (!flag) {
                List<Integer> nlis = new ArrayList<>();
                nlis.add(nums[i]);
                nIncrLISs.add(nlis);
            }
            incrLISs = nIncrLISs;
        }
        int maxLen = 0;
        for (List<Integer> lis : incrLISs) {
            if (lis.size() > maxLen) {
                maxLen = lis.size();
            }
        }
        return maxLen;
    }

    public static int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] f = new int[nums.length];
        f[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        int max = f[0];
        for (int i = 1; i < f.length; i++) {
            if (f[i] > max) {
                max = f[i];
            }
        }
        return max;
    }
}
