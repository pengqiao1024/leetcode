package medium;

import utils.Utils;

import java.util.Arrays;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/8/12 14:10
 * @Description: 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * <p>
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * <p>
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[0]
 * <p>
 * 示例 4：
 * 输入：nums = [1]
 * 输出：[1]
 *  
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 * <p>
 * 进阶：
 * 你可以不使用代码库中的排序函数来解决这道题吗？
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class M75SortColors {
    public static void main(String[] args) {
        int[] nums = new int[]{0};
        sortColors(nums);
        Utils.printArray(nums);
    }

    public static void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        for (int index = 0; index <= right; index++) {
            if (nums[index] == 0) {
                nums[index] = nums[left];
                nums[left] = 0;
                left++;
            } else if (nums[index] == 1) {
            } else if (nums[index] == 2) {
                while (index < right && nums[right] == 2) {
                    right--;
                }
                if (index < right) {
                    nums[index] = nums[right];
                    nums[right] = 2;
                    index--;
                }
            }
        }
    }
}
