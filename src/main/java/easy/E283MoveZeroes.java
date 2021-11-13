package easy;

import utils.Utils;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/9/14 19:44
 * @Description: 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class E283MoveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1};
        moveZeroes(nums);
        Utils.printArray(nums);
    }

    public static void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[left];
                nums[left++] = tmp;
            }
        }
    }

}
