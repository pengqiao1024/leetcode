package easy;

/**
 * @Author: pengqiao01
 * @date: 2019/7/1 17:14
 */

/**
 * 二叉树的最大深度
 * <p>
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *       3
 *      / \
 *     9  20
 *       /  \
 *      15   7
 * 返回它的最大深度 3 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E104MaxDepth {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        System.out.println(maxDepth(root));

    }
    public static int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null){
            return root.right==null?1:maxDepth(root.right)+1;
        }else if(root.right==null){
            return maxDepth(root.left)+1;
        }else{
            int r=maxDepth(root.right)+1;
            int l=maxDepth(root.left)+1;
            return r>l?r:l;
        }
    }

    static   class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
        TreeNode(int x,TreeNode left , TreeNode right) {
            val=x;
            this.left=left;
            this.right=right;
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

