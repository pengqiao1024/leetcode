package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/8/31 19:53
 * @Description: 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，
 * 表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：numCourses = 2, prerequisites = {{1,0}}
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * <p>
 * 示例 2：
 * 输入：numCourses = 2, prerequisites = {{1,0},{0,1}}
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 * <p>
 * 提示：
 * 1 <= numCourses <= 105
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * prerequisites[i] 中的所有课程对 互不相同
 */
public class M207CanFinish {
    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{1, 0}, {0, 3}, {0, 2}, {3, 2}, {2, 5}, {4, 5}, {5, 6}, {2, 4}};
        System.out.println(canFinish(7, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer> scanIndex = new HashSet<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (scanIndex.contains(i)) {
                continue;
            }
            Set<Integer> scan = new HashSet<>();
            scan.add(prerequisites[i][0]);
            scanIndex.add(i);
            if (!find(prerequisites, prerequisites[i][1], scan, scanIndex)) {
                return false;
            }
        }
        return true;
    }

    private static boolean find(int[][] prerequisites, int course, Set<Integer> scanCourse, Set<Integer> scanIndex) {
        for (int i = 0; i < prerequisites.length; i++) {
            if (prerequisites[i][0] == course) {
                if (!scanCourse.add(course)) {
                    return false;
                }
                scanIndex.add(i);
                if (!find(prerequisites, prerequisites[i][1], scanCourse, scanIndex)) {
                    return false;
                }
            }
        }
        return true;
    }
}
