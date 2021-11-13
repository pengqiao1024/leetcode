package medium;

import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/10/28 20:13
 * @Description: 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * <p>
 * 示例 1：
 * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * <p>
 * 示例 2：
 * 输入：root = [0,null,1]
 * 输出：[1,null,1]
 * <p>
 * 示例 3：
 * 输入：root = [1,0,2]
 * 输出：[3,3,2]
 * <p>
 * 示例 4：
 * 输入：root = [3,2,4,1]
 * 输出：[7,9,4,10]
 * <p>
 * 提示：
 * 树中的节点数介于 0 和 104 之间。
 * 每个节点的值介于 -104 和 104 之间。
 * 树中的所有值 互不相同 。
 * 给定的树为二叉搜索树。
 */
public class M538ConvertBST {
    //[-48,null,20,7,39,-6,19,30,42,-25,-3,11,null,22,35,41,49,-33,-15,-5,1,9,12,null,29,34,38,null,null,47,null,-43,-32,-18,-13,null,null,0,2,null,10,null,null,27,null,null,null,null,null,45,null,-46,-40,null,-26,-21,-17,-14,-8,null,null,null,4,null,null,23,null,44,null,null,null,null,-37,-28,null,null,null,null,-16,null,null,null,null,null,null,null,24,null,null,null,-36,-31]
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(4, new TreeNode(1, new TreeNode(0), new TreeNode(2, null, new TreeNode(3))),
//                new TreeNode(6, new TreeNode(5), new TreeNode(7, null, new TreeNode(8))));
        TreeNode root = new TreeNode(42, new TreeNode(41),
                new TreeNode(49, new TreeNode(47, new TreeNode(45, new TreeNode(44), null), null), null));
        System.out.println(root);
        convertBST(root);
        System.out.println(root);
    }

    public static TreeNode convertBST(TreeNode root) {
        convertBST(root, 0);
        return root;
    }

    public static void convertBST(TreeNode root, int pv) {
        Deque<TreeNode> rNodeQue = new LinkedList<>();
        TreeNode tmp = root;
        while (tmp != null) {
            rNodeQue.add(tmp);
            tmp = tmp.right;
        }
        while (!rNodeQue.isEmpty()) {
            TreeNode node = rNodeQue.pollLast();
            //node:left  node.val=node.val+node.right的子树的最左树+parent.val
            //node:right node.val=node.val+node.right的子树的最左树
            int val = node.val;
            if (node.right != null) {
                TreeNode tt = node.right;
                while (tt.left != null) {
                    tt = tt.left;
                }
                val += tt.val;
            }
            node.val = val + pv;
            pv = 0;//仅计算一次即清空
            convertBST(node.left, node.val);
        }
    }
}
