package medium;

import utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/10/11 20:12
 * @Description: 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，
 * 前面 正好 有 ki 个身高大于或等于 hi 的人。
 * <p>
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，
 * 其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 * <p>
 * 示例 1：
 * 输入：people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}}
 * 输出：{{5,0},{7,0},{5,2},{6,1},{4,4},{7,1}}
 * 解释：
 * 编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
 * 编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
 * 编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
 * 编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
 * 编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
 * 编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
 * 因此 {{5,0},{7,0},{5,2},{6,1},{4,4},{7,1}} 是重新构造后的队列。
 * 示例 2：
 * <p>
 * 输入：people = {{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}}
 * 输出：{{4,0},{5,0},{2,2},{3,2},{1,4},{6,0}}
 * <p>
 * 提示：
 * <p>
 * 1 <= people.length <= 2000
 * 0 <= hi <= 106
 * 0 <= ki < people.length
 * 题目数据确保队列可以被重建
 */
public class M406ReconstructQueue {
    public static void main(String[] args) {
        int[][] people = new int[][]{{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}};
        int[][] res = reconstructQueue(people);
        Utils.printArray(res);
    }

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });
        List<int[]> res = new ArrayList<>();
        int count = 0;
        for (int[] p : people) {
            if (p[1] >= count) {
                res.add(new int[]{p[0], p[1]});
            } else {
                res.add(p[1], new int[]{p[0], p[1]});
            }
            count++;
        }
        return res.toArray(new int[0][]);
    }
}
