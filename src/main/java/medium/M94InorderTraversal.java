package medium;

/**
 * @Author: pengqiao01
 * @date: 2019/7/1 19:16
 */


import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序遍历  。
 * <p>
 * 示例:
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * 输出: [1,3,2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M94InorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(root);
        System.out.println(inorderTraversal(root));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
//        iprintRecursion(root, list);
        iprint(root,list);
        return list;
    }

    /**
     * 非递归调用
     *
     * @param root
     * @param list
     */
    private static void iprint(TreeNode root, List<Integer> list) {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();//遍历完成 node为空 则取出最后的左节点
            list.add(node.val);//打印该节点
            node = node.right;//处理右子树
        }
    }

    /**
     * 递归调用
     *
     * @param root
     * @param list
     */
    private static void iprintRecursion(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        iprintRecursion(root.left, list);
        list.add(root.val);
        iprintRecursion(root.right, list);
    }
}
