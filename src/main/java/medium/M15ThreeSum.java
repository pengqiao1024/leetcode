package medium;

/**
 * @Author: pengqiao01
 * @date: 2019/7/1 18:11
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * <p>
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [[-1, 0, 1],[-1, -1, 2]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M15ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    /**
     * 选定一个数  另外两个数从左右同时逼近比较  复杂度o(n^2)
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);//升序排序
        List<List<Integer>> list = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {//与前一个数一样的数不进行处理
                continue;
            }
            if (nums[i] > 0) {//最小值都大于0  遍历结束
                break;
            }
            //左右下标同时逼近
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int tmp = nums[i] + nums[left] + nums[right];
                if (tmp == 0) {//相加满足条件  则记录  并比较
                    List<Integer> a = new ArrayList();
                    a.add(nums[i]);
                    a.add(nums[left]);
                    a.add(nums[right]);
                    list.add(a);
                    //左右下标跳过重复值  防止重复结果
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (tmp > 0) {//相加大于0  则说明大值需要减少
                    right--;
                } else {//相加小于0  则说明小指需要增加
                    left++;
                }
            }
        }
        return list;
    }
}
