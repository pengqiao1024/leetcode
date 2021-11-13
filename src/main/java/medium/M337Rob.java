package medium;

import utils.TreeNode;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/9/23 15:30
 * @Description: 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
 * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * <p>
 * 示例 1:
 * 输入: [3,2,3,null,3,null,1]
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * <p>
 * 示例 2:
 * 输入: [3,4,5,1,3,null,1]
 * 3
 * / \
 * 4   5
 * / \   \
 * 1   3   1
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 */
public class M337Rob {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(3)), new TreeNode(5, null, new TreeNode(1)));
        System.out.println(rob(root));
    }

    public static int rob(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    /**
     * 抢劫
     *
     * @param root
     * @return r[0]:包含入口的最大值  r[1]:不包含入口的最大值
     */
    private static int[] robSub(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] robLeft = robSub(root.left);
        int[] robRight = robSub(root.right);
        int[] res = new int[2];
        res[0] = robLeft[1] + robRight[1] + root.val;
        res[1] = Math.max(robLeft[0], robLeft[1]) + Math.max(robRight[0], robRight[1]);
        System.out.println(root);
        System.out.println(res[0] + "  " + res[1]);
        return res;
    }
}
