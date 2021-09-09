package medium;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/9/9 19:52
 * @Description: 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：
 * 对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 示例 1：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * <p>
 * 示例 2：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * 示例 3：
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 *  
 * 提示：
 * 树中节点数目在范围 [2, 105] 内。
 * -109 <= Node.val <= 109
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
 * <p>
 */
public class M236LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4)))
                , new TreeNode(1, new TreeNode(0), new TreeNode(8)));
        System.out.println(lowestCommonAncestor(root, new TreeNode(4), new TreeNode(2)));
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pParents = new ArrayList<>();
        List<TreeNode> qParents = new ArrayList<>();
        findParents(root, p, pParents);
        findParents(root, q, qParents);
        print(pParents);
        print(qParents);
        Set<Integer> values;
        List<TreeNode> finds;
        if (pParents.size() > qParents.size()) {
            values = pParents.stream().map(node -> node.val).collect(Collectors.toSet());
            finds = qParents;
            
        } else {
            values = qParents.stream().map(TreeNode::getVal).collect(Collectors.toSet());
            finds = pParents;
        }
        for (int i = finds.size() - 1; i >= 0; i--) {
            TreeNode tmp = finds.get(i);
            if (values.contains(tmp.val)) {
                return tmp;
            }
        }
        return null;
    }

    public static boolean findParents(TreeNode root, TreeNode node, List<TreeNode> parents) {
        if (root == null) {
            return false;
        }
        parents.add(root);
        if (root.val == node.val) {
            return true;
        }
        boolean right = findParents(root.right, node, parents);
        boolean left = findParents(root.left, node, parents);
        if (!right && !left) {
            parents.remove(parents.size() - 1);
            return false;
        }
        return true;
    }

    private static void print(List<TreeNode> treeNodes) {
        for (TreeNode node : treeNodes) {
            System.out.print(node.val + " -> ");
        }
        System.out.println();
    }
}
