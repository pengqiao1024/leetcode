package medium;

/**
 * @Author: pengqiao01
 * @date: 2019/7/8 14:37
 */

/**
 * 盛最多水的容器
 * <p>
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * 详见 resources\picture\medium\M11.jpg
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * 示例:
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M11MaxArea {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    /**
     * 暴力解法
     * O(n2)
     *
     * @param height
     * @return
     */
    private static int maxAreaForce(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int h = height[i] < height[j] ? height[i] : height[j];
                int w = j - i;
                max = max > h * w ? max : h * w;
            }
        }
        return max;
    }

    /**
     * 双指针法
     * 初始面积是相隔最远的两条边构成。如果面积更大，只能是高度更大(因为宽度已经最大),则较矮的游标移动，存储最大面积
     * O(n)
     *
     * @param height
     * @return
     */
    private static int maxArea(int[] height) {
        int max = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        while (leftIndex < rightIndex) {
            int lh = height[leftIndex];
            int rh = height[rightIndex];
            int area;
            //计算面积  小边*长度   小边下标向中间移动
            if (lh > rh) {
                area = rh * (rightIndex - leftIndex);
                rightIndex--;
            } else {
                area = lh * (rightIndex - leftIndex);
                leftIndex++;
            }
            max = max > area ? max : area;
        }
        return max;
    }

}
