package medium;

/**
 * @Author: pengqiao01
 * @date: 2019/7/3 19:19
 */

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的锯齿形层次遍历
 * <p>
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * [[3],[20,9],[15,7]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M103ZigzagLevelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9, new TreeNode(4), new TreeNode(5)), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(zigzagLevelOrder(root));
    }

    /**
     * 使用队列存储  每取出一个节点将其左右节点存储进下一个队列  增加标记 用于标记存储顺序
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        boolean flag = false;//标记输出顺序 true:右->左  false:左->右
        while (!nodes.isEmpty()) {
            LinkedList<Integer> levelResult = new LinkedList<>();
            LinkedList<TreeNode> nextLevelNodes = new LinkedList<>();
            while (!nodes.isEmpty()) {
                TreeNode treeNode = nodes.pop();
                if (treeNode != null) {//节点不为空  则将其输出(根据标记)  并将左右节点存入下一队列
                    if(flag){
                        levelResult.push(treeNode.val);
                    }else {
                        levelResult.addLast(treeNode.val);
                    }
                    nextLevelNodes.addLast(treeNode.left);
                    nextLevelNodes.addLast(treeNode.right);
                }
            }
            if (!levelResult.isEmpty()) {
                result.add(levelResult);
            }
            nodes = nextLevelNodes;
            flag = flag ? false : true;
        }
        return result;
    }
}
