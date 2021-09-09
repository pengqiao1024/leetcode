package easy;

import utils.TreeNode;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/9/6 19:48
 * @Description: 翻转一棵二叉树。
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 */
public class E226InvertTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        System.out.println(root);
        invertTree(root);
        System.out.println(root);
    }

    public static TreeNode invertTree(TreeNode root) {
        invertTree2(root);
        return root;
    }

    public static void invertTree2(TreeNode root) {
        if (root != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            invertTree2(root.left);
            invertTree2(root.right);
        }
    }

}
