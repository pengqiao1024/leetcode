package medium;

/**
 * @Author: pengqiao01
 * @date: 2019/7/2 14:00
 */

import utils.TreeNode;

import java.util.*;

/**
 * 二叉树的层次遍历
 * <p>
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * [[3],[9,20],[15,7]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M102LevelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(levelOrder(root));
    }

    /**
     * 使用队列存储  每取出一个节点将其左右节点存储进下一个队列
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> nodeList = new LinkedList<>();//存储需要输出的节点
        nodeList.add(root);
        while (!nodeList.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            LinkedList<TreeNode> nextLevelNodeList = new LinkedList<>();//存储下一级的节点
            while (!nodeList.isEmpty()) {
                TreeNode treeNode = nodeList.pop();
                if (treeNode != null) {//节点不为空  则将其输出  并将左右节点存入下一队列
                    list.add(treeNode.val);
                    nextLevelNodeList.addLast(treeNode.left);
                    nextLevelNodeList.addLast(treeNode.right);
                }
            }
            if (list.size() > 0) {
                result.add(list);
            }
            nodeList = nextLevelNodeList;
        }
        return result;
    }

}
