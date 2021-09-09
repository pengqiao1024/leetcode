package hard;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/8/3 19:26
 * @Description: 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *  
 * <p>
 * 提示：
 * <p>
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 */
public class H42Trap {
    public static void main(String[] args) {
        int[] height = new int[]{4,2,0,3,2,5};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int trap = 0;
        int j;
        for (int i = 0; i < height.length - 1; ) {
            boolean iIsMax = true;
            j = i + 1;
            int partMaxIndex = j;
            //寻找第一个比i大的;若无，则找剩下里面最大的
            for (; j < height.length; j++) {
                if (height[j] >= height[partMaxIndex]) {
                    partMaxIndex = j;
                }
                if (height[j] >= height[i]) {
                    iIsMax = false;
                    break;
                }
            }
            int end = iIsMax ? partMaxIndex : j;
            int h = iIsMax ? height[end] : height[i];
            int tmp = h * (end - i - 1) - getSum(height, i + 1, end - 1);
            trap += tmp;
            i = end;
        }
        return trap;
    }

    private static int getSum(int[] height, int start, int end) {
        int sum = 0;
        for (; start <= end; start++) {
            sum += height[start];
        }
        return sum;
    }
}
