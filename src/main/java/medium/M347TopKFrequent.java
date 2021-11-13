package medium;

import utils.Utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/9/24 17:39
 * @Description: 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <p>
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * <p>
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^5
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 *  
 * <p>
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 */
public class M347TopKFrequent {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        topKFrequent(nums, 1);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            counts.merge(nums[i], 1, Integer::sum);
        }
        System.out.println(counts);
        int[][] res = new int[k][2];//res[i][0]表示数  res[i][1]表示次数
        int index = 0;
        Iterator<Map.Entry<Integer, Integer>> iterator = counts.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (index < k) {
                res[index++] = new int[]{entry.getKey(), entry.getValue()};
                if (index == k) {
                    for (int i = k / 2; i >= 0; i--) {
                        balance(res, i);
                    }
                }
                continue;
            }
            if (entry.getValue() > res[0][1]) {
                res[0] = new int[]{entry.getKey(), entry.getValue()};
                balance(res, 0);
            }
        }
        int[] r = new int[k];
        for (int i = 0; i < k; i++) {
            r[i] = res[i][0];
        }
        Utils.printArray(r);
        return r;
    }

    private static void balance(int[][] res, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        if (left >= res.length) {
            return;
        }
        if (right >= res.length) {//仅有左子树
            if (res[left][1] < res[index][1]) {
                swap(res, left, index);
            }
            return;
        }
        if (res[left][1] < res[index][1] || res[right][1] < res[index][1]) {
            if (res[left][1] < res[right][1]) {
                swap(res, index, left);
                balance(res, left);
            } else {
                swap(res, index, right);
                balance(res, right);
            }
        }
    }

    private static void swap(int[][] res, int i, int j) {
        int[] tmp = res[i];
        res[i] = res[j];
        res[j] = tmp;
    }

}
