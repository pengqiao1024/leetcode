package medium;

/**
 * @Author: pengqiao01
 * @date: 2019/7/4 14:03
 */

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 零钱兑换
 * <p>
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * <p>
 * 示例 2:
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * <p>
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M322CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
//        int[] coins = {2};
//        int amount = 3;
        System.out.println(coinChange(coins, amount));
    }

    /**
     * 动态规划  把多阶段过程转化为一系列单阶段问题，利用各阶段之间的关系，逐个求解
     * F(11)=min{F(11-1),F(11-2),F(11-5)}+1  由于此方式递归过多(指数型增长)，故需要变更为迭代模式
     * 都是整数  则可以使用数组  存储F(0)~F(amount)之间所有的值  从0开始计算遍历计算
     * 根据定义 F(0)=0  F(n)若不存在,则用Integer.MAX_VALUE标记(不用负值,因为有取最小值操作,可能导致问题)
     *
     * @param coins  硬币种类
     * @param amount 总金额
     * @return
     */
    private static int coinChange(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        f[0] = 0;
        for (int i = 1; i <= amount; i++) {//逐步计算所有值
            int num = Integer.MAX_VALUE;//记录计算F(n)时 F(n-cl)【cl为数组里的值】的值，取最小值
            for (int j = 0; j < coins.length; j++) {//遍历数组  确定其可实现的下标  如题  当n=3时  可计算f[2] f[1]
                if (i - coins[j] >= 0) {
                    if (f[i - coins[j]] != Integer.MAX_VALUE) {
                        num = Math.min(num, f[i - coins[j]] + 1);
                    }
                }
            }
            f[i] = num;//获取到最小值
        }
        return f[amount] == Integer.MAX_VALUE ? -1 : f[amount];
    }

}
