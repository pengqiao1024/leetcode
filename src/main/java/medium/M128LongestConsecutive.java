package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/8/17 15:14
 * @Description: 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *  
 * <p>
 * 提示：
 * 0 <= nums.length <= 105
 * -10^9 <= nums[i] <= 10^9
 */
public class M128LongestConsecutive {
    public static void main(String[] args) {
//        double i = Math.pow(10,9);
//        System.out.println(i);
        int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> ns = new HashSet<>();
        for (Integer num : nums) {
            ns.add(num);
        }
        int longest = 0;
        for (Integer num : ns) {
            if (ns.contains(num - 1)) {
                continue;
            }
            int tmp = 1;
            while (ns.contains(++num)) {
                tmp++;
            }
            if (tmp > longest) {
                longest = tmp;
            }
        }
        return longest;
    }
}
