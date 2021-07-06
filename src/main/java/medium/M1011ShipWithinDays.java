package medium;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/4/26 16:07
 * @Description: 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * 传送带上的第i个包裹的重量为weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 * <p>
 * 示例1：
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重15就能够在5天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 * <p>
 * 示例2：
 * 输入：weights = [3,2,2,4,1,4], D = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 * <p>
 * 示例3：
 * 输入：weights = [1,2,3,1,1], D = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 * <p>
 * 提示：
 * 1 <= D <= weights.length <= 50000
 * 1 <= weights[i] <= 500
 */
public class M1011ShipWithinDays {
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int D = 5;
        System.out.println(shipWithinDays(weights, D));
    }

    public static int shipWithinDays(int[] weights, int D) {
        int left = 0;//左边界 不可分割，最大值
        int right = 0;//右边界 所有重量之和(1天运输完)
        for (Integer weight : weights) {
            if (weight > left) {
                left = weight;
            }
            right += weight;
        }
        if (weights.length <= D) {
            return left;
        }
        while (left < right) {
            int mid = (left + right) / 2;
            int sum = 0;
            int day = 1;
            for (Integer weight : weights) {
                if (sum + weight > mid) {
                    sum = 0;//重置
                    day++;
                    if (day > D) {
                        break;
                    }
                }
                sum = sum + weight;
            }
            if (day <= D) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
