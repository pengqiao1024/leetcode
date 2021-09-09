package medium;

/**
 * @Author: pengqiao01
 * @date: 2019/7/5 10:10
 */

import utils.TreeNode;

/**
 * 从前序与中序遍历序列构造二叉树
 * <p>
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M105BuildTree {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        System.out.println(buildTree(preorder, inorder));

    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    /**
     * @param preorder                      前序遍历的所有数组
     * @param inorder                       中序遍历的所有数组
     * @param preStart/preEnd/inStart/inEnd 此次生成节点中 所用到的数组的起始下标和终止下标
     * @return
     */
    private static TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int val = preorder[preStart];//前序遍历的第一个节点即为根节点
        TreeNode root = new TreeNode(val);
        //查找该节点在中序遍历中的位置
        int inIndex = inStart;
        for (; inIndex <= inEnd; inIndex++) {
            if (inorder[inIndex] == val) {
                break;
            }
        }
        int preIndex = inIndex - inStart + preStart;//inIndex - inStart为左子树元素个数 则preStart+个数 为前序遍历中的左子树
        root.left = build(preorder, inorder, preStart + 1, preIndex, inStart, inEnd - 1);//inEnd preStart 为根节点
        root.right = build(preorder, inorder, preIndex + 1, preEnd, inIndex + 1, inEnd);
        return root;
    }
}
