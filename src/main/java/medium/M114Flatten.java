package medium;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/8/16 19:21
 * @Description: 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *  
 * 示例 1：
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * <p>
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：root = [0]
 * 输出：[0]
 *  
 * <p>
 * 提示：
 * 树中结点数在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 *  
 */
public class M114Flatten {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
        flatten(root);
        System.out.println(root);
    }

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            TreeNode tmp = root.right;
            TreeNode lr = root.left;
            while (lr.right != null) {
                lr = lr.right;
            }
            root.right = root.left;
            root.left = null;
            lr.right = tmp;
        }
        flatten(root.right);
    }
}
