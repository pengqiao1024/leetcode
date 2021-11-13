package medium;

import utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/9/22 15:17
 * @Description: 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * <p>
 * 示例:
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
public class M309MaxProfit {

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 0, 2, 1};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int[][] f = new int[prices.length][3];//0:持有股票最大累计收益 1:不持有股票且当天未卖出的最大累计收益 2:不持有股票且当天卖出的最大累计收益
        f[0][0] = -prices[0];
        f[0][1] = 0;
        f[0][2] = 0;
        Utils.printArray(f[0]);
        for (int i = 1; i < prices.length; i++) {
            //持有股票最大累计收益：a.i-1天持有股票  b.i-1天未持有股票,第i天买入
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1] - prices[i]);
            //不持有股票且当天未卖出的最大累计收益:i-1不持有股票最大累计收益的两种情况中的较大值
            f[i][1] = Math.max(f[i - 1][1], f[i - 1][2]);
            //不持有股票且当天卖出的最大累计收益:i-1一定持有股票
            f[i][2] = f[i - 1][0] + prices[i];
        }
        return Math.max(f[prices.length - 1][1], f[prices.length - 1][2]);
    }
}
