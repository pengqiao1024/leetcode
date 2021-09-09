package medium;

import utils.Utils;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/8/16 14:32
 * @Description: 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：5
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 *  
 * <p>
 * 提示：
 * 1 <= n <= 19
 */
public class M96NumTrees {
    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }

    public static int numTrees(int n) {
        int[] nums = new int[n + 1];//i存储i个节点可组成的数的个数
        nums[0] = 1;//设置为1,方便计算
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            int num = 0;//总数
            for (int j = 1; j <= i; j++) {//第j个节点作为跟节点
                int left = j - 1;//左边节点个数
                int right = i - j;//右边节点个数
                num = num + nums[left] * nums[right];
            }
            nums[i] = num;
        }
        Utils.printArray(nums);
        return nums[n];
    }
}
