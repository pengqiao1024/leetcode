package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/8/12 17:31
 * @Description: 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *  
 * <p>
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 */
public class M78Subsets {
    public static void main(String[] args) {
        int[] nums=new int[]{1};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tmp = new ArrayList<>(res);
            for (List<Integer> list : res) {
                List<Integer> l = new ArrayList<>(list);
                l.add(nums[i]);
                tmp.add(l);
            }
            res = tmp;
        }
        return res;
    }
}
