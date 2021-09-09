package medium;

import utils.TreeNode;

import java.util.List;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/8/16 15:05
 * @Description: 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 示例 1:
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * <p>
 * 示例 2:
 * 输入:
 * 5
 * / \
 * 1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class M98IsValidBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null) {
            if (root.left.val >= root.val) {
                return false;
            }
            TreeNode tmp = root.left.right;
            if (tmp != null) {
                while (tmp.right != null) {
                    tmp = tmp.right;
                }
                if (tmp.val >= root.val) {
                    return false;
                }
            }
        }
        if (root.right != null) {
            if (root.right.val <= root.val) {
                return false;
            }
            TreeNode tmp = root.right.left;
            if (tmp != null) {
                while (tmp.left != null) {
                    tmp = tmp.left;
                }
                if (tmp.val <= root.val) {
                    return false;
                }
            }
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }
}
