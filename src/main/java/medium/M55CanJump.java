package medium;

import utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/8/9 17:09
 * @Description: 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * <p>
 * 示例 1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * <p>
 * 示例 2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *  
 * <p>
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 */
public class M55CanJump {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0};
        System.out.println(canJump(nums));
        ArrayList<Integer> list = new ArrayList<>(10);
        list.ensureCapacity(100);
    }

    /**
     * 只要是不必落在0的点，即可达到最后坐标
     *
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int[] fastIndexes = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            fastIndexes[i] = i + nums[i];
        }
        Utils.printArray(fastIndexes);
        int fastIndex = fastIndexes[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (fastIndex < fastIndexes[i]) {
                fastIndex = fastIndexes[i];
            }
            if (fastIndexes[i] <= i && fastIndex <= i) {
                return false;
            }
        }
        return true;
    }
}
