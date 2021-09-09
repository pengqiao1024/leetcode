package medium;

import utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/8/10 15:09
 * @Description: 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * 示例 1：
 * 输入：intervals = [[1,3},{2,6},{8,10},{15,18]]
 * 输出：[[1,6},{8,10},{15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 示例 2：
 * 输入：intervals = [[1,4},{4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *  
 * <p>
 * 提示：
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class M56Merge {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{0, 0}, {1, 2}, {5, 5}, {2, 4}, {3, 3}, {5, 6}, {5, 6}, {4, 6}, {0, 0}, {1, 2}, {0, 2}, {4, 5}};
//        Utils.printArray(intervals);
        int[][] res = merge2(intervals);
        Utils.printArray(res);
    }

    public static int[][] merge(int[][] intervals) {
        while (true) {
            int dep = 0;
            boolean[] mergeTags = new boolean[intervals.length];//用于标记该数组是否已被合并
            for (int i = 0; i < intervals.length; i++) {
                if (mergeTags[i]) {
                    continue;
                }
                for (int j = i + 1; j < intervals.length; j++) {
                    if (mergeTags[j]) {
                        continue;
                    }
                    if (canMerge(intervals[i], intervals[j])) {
                        intervals[i][0] = intervals[i][0] < intervals[j][0] ? intervals[i][0] : intervals[j][0];
                        intervals[i][1] = intervals[i][1] > intervals[j][1] ? intervals[i][1] : intervals[j][1];
                        mergeTags[j] = true;
                        dep++;
                    }
                }
            }
            int[][] res = new int[intervals.length - dep][2];
            int tmp = 0;
            for (int i = 0; i < mergeTags.length; i++) {
                if (!mergeTags[i]) {
                    res[tmp++] = intervals[i];
                }
            }
            if (dep == 0) {
                return res;
            }
            intervals = res;
        }
    }

    private static boolean canMerge(int[] i, int[] j) {
        return !(i[0] > j[1] || i[1] < j[0]);
    }

    private static int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
//        sort(intervals, 0, intervals.length - 1);
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (merged.size() == 0) {
                merged.add(intervals[i]);
                continue;
            }
            int[] pre = merged.get(merged.size() - 1);
            if (intervals[i][0] <= pre[1]) {
                pre[1] = intervals[i][1] < pre[1] ? pre[1] : intervals[i][1];
            } else {
                merged.add(intervals[i]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    /**
     * 按照start开始排序
     *
     * @param nums
     * @param left
     * @param right
     */
    private static void sort(int[][] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int[] tmp = nums[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && nums[j][0] > tmp[0]) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }
            while (i < j && nums[i][0] < tmp[0]) {
                i++;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = tmp;
        sort(nums, left, i - 1);
        sort(nums, i + 1, right);
    }
}
