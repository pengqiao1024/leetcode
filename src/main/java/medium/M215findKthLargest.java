package medium;

import utils.Utils;

import java.util.Arrays;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/9/2 19:09
 * @Description: 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * <p>
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= nums.length <= 104
 * -104 <= nums[i] <= 104
 */
public class M215findKthLargest {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(t(nums, 4));
    }

    public static int t(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static int findKthLargest(int[] nums, int k) {
        int[] minTop = new int[k];
        for (int i = 0; i < k; i++) {
            minTop[i] = nums[i];
        }
        for (int i = (k - 1) / 2; i >= 0; i--) {
            balance(minTop, i);
        }
        Utils.printArray(minTop);
        for (int i = k; i < nums.length; i++) {
            if (minTop[0] < nums[i]) {
                minTop[0] = nums[i];
                balance(minTop, 0);
                Utils.printArray(minTop);
            }
        }
        return minTop[0];
    }

    private static void balance(int[] minTop, int index) {
        int left = getLeft(index);
        int right = getRight(index);
        if (left > minTop.length - 1) {//无子节点
            return;
        }
        if (right > minTop.length - 1) {//仅有左节点
            if (minTop[left] < minTop[index]) {
                int tmp = minTop[left];
                minTop[left] = minTop[index];
                minTop[index] = tmp;
            }
            return;
        }
        int changeIndex = minTop[left] > minTop[right] ? right : left;
        if (minTop[changeIndex] > minTop[index]) {
            return;
        }
        int tmp = minTop[changeIndex];
        minTop[changeIndex] = minTop[index];
        minTop[index] = tmp;
        balance(minTop, changeIndex);
    }


    private static int getLeft(int i) {
        return (i + 1) * 2 - 1;
    }

    private static int getRight(int i) {
        return (i + 1) * 2;
    }


}
