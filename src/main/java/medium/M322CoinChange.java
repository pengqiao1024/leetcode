package medium;

/**
 * @Author: pengqiao01
 * @date: 2019/7/4 14:03
 */

import java.util.Arrays;

/**
 * 零钱兑换
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
     * @param coins  硬币种类
     * @param amount 总金额
     * @return
     */
    private static int coinChange(int[] coins, int amount) {
        //F(n)=min(F(n-1),F(n-2),...)+1
        int[] f = new int[amount + 1];
        f[0] = 0;
        Arrays.sort(coins);
        for (int i = 1; i <= amount; i++) {
            int fn = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] < 0) {
                    break;
                }
                fn = Math.min(fn, f[i - coins[j]] + 1);
            }
            f[i] = fn;
        }
        return f[amount] == Integer.MAX_VALUE ? -1 : f[amount];
    }

}
