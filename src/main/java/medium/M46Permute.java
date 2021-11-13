package medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/8/4 15:22
 * @Description: 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * <p>
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 * <p>
 */
public class M46Permute {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        result.add(List.of(nums[0]));
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> nr = new ArrayList<>();
            Iterator<List<Integer>> iterator = result.iterator();
            while (iterator.hasNext()) {
                List<Integer> list = iterator.next();
                for (int j = 0; j <= list.size(); j++) {
                    List<Integer> tmp = new ArrayList<>(list);
                    tmp.add(j, nums[i]);
                    nr.add(tmp);
                }
            }
            result = nr;
        }
        return result;
    }
}
