package easy;

/**
 * @Author: pengqiao01
 * @date: 2019/7/1 17:22
 */

/**
 * 二叉搜索树的范围和
 * <p>
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 * 二叉搜索树保证具有唯一的值。
 * <p>
 * 示例 1：
 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 * 输出：32
 * <p>
 * 示例 2：
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * 输出：23
 *  
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-of-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E938RangeSumBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(3), new TreeNode(7)), new TreeNode(15, null, new TreeNode(18)));
        System.out.println(rangeSumBST(root, 7, 15));
    }

    public static int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        int num = 0;
        if (root.val < L) {//节点值小于最小值 则只需要处理右节点
            num += rangeSumBST(root.right, L, R);
        } else if (root.val > R) {//节点值大于最大值 则只需要处理左节点
            num += rangeSumBST(root.left, L, R);
        } else if (root.val > L && root.val < R) {//节点值位于中间 处理节点值及左右节点
            num += root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        } else if (root.val == L) {//节点值等于最小值  处理当前节点及左节点
            num += root.val + rangeSumBST(root.right, L, R);
        } else {//节点值等于最大值  处理当前节点及右节点
            num += root.val + rangeSumBST(root.left, L, R);
        }
        return num;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}

