package medium;

import utils.TreeNode;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/10/19 19:59
 * @Description: 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 示例 1：
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * <p>
 * 示例 2：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 */
public class M437PathSum {
    public static void main(String[] args) {
        TreeNode root =
                new TreeNode(1, null,
                        new TreeNode(2, null, new TreeNode(3))
                );
        System.out.println(root);
        System.out.println(pathSum(root, 3));
    }

    public static int pathSum(TreeNode root, int targetSum) {
        int res = rootPath(root, targetSum);
        int left = pathSum(root.left, targetSum);
        int right = pathSum(root.right, targetSum);
        return res + left + right;
    }

    public static int rootPath(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        int ntarget = targetSum - root.val;
        if (ntarget == 0) {
            res++;
        }
        int left = rootPath(root.left, ntarget);
        int right = rootPath(root.right, ntarget);
        return res + left + right;
    }

}
