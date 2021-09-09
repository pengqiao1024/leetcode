package hard;

import utils.Utils;

import java.util.*;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/8/13 10:51
 * @Description: 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *  
 * 示例 1:
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 * <p>
 * 示例 2：
 * 输入： heights = [2,4]
 * 输出： 4
 * <p>
 * 提示：
 * 1 <= heights.length <=105
 * 0 <= heights[i] <= 104
 */
public class h84LargestRectangleArea {
    public static void main(String[] args) {
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        Set<Integer> hs = new HashSet<>();
        for (int i = 0; i < heights.length; i++) {
            hs.add(heights[i]);
        }
        Integer[] sortHeights = hs.toArray(Integer[]::new);
        Arrays.sort(sortHeights);
        int maxArea = 0;
        boolean[] breakIndexes = new boolean[heights.length];
        for (int i = 0; i < sortHeights.length; i++) {
            int len = 0;
            for (int j = 0; j < breakIndexes.length; j++) {
                if (breakIndexes[j]) {
                    int tmp = len * sortHeights[i];
                    if (tmp > maxArea) {
                        maxArea = tmp;
                    }
                    len = 0;
                } else if (j == breakIndexes.length - 1) {
                    int tmp = (len + 1) * sortHeights[i];
                    if (tmp > maxArea) {
                        maxArea = tmp;
                    }
                } else {
                    len++;
                }
                if (heights[j] == sortHeights[i]) {
                    breakIndexes[j] = true;
                }
            }
        }
        return maxArea;
    }


}
