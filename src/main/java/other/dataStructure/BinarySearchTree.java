package other.dataStructure;

import utils.ListNode;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/7/29 17:19
 * @Description:
 */
public class BinarySearchTree {
    //私有属性
    private TreeNode root;//根节点

    //构造方法
    BinarySearchTree() {
        this.root = null;
    }

    //置空操作
    public void makeEmpty() {
        this.root = null;
    }

    //判断是否为空
    public boolean isEmpty() {
        return this.root == null;
    }

    //判断是否包含某节点
    public boolean contains(int x) {
        return find(x, root) != null;
    }

    //查找最小的元素
    public int findMin() {
        if (root == null) {
            throw new RuntimeException("empty tree....");
        }
        return findMin(root).val;
    }

    //查找最大的元素
    public int findMax() {
        if (root == null) {
            throw new RuntimeException("empty tree....");
        }
        return findMax(root).val;
    }

    public void removeMax() {
        if (root == null) {
            throw new RuntimeException("empty tree....");
        }
        removeMax(root, null);
    }

    //插入操作
    public void insert(int x) {
        if (root == null) {
            root = new TreeNode(x);
            return;
        }
        insert(x, root);
    }

    //删除操作
    public void remove(int x) {
        remove(x, root);
    }

    //获取树的最大深度
    public int maxDeep() {
        return maxDeep(this.root);
    }

    //获取树的最小深度
    public int minDeep() {
        return minDeep(this.root);
    }

    //先序打印操作
    public void prePrintTree() {
        prePrintTree(this.root);
    }

    //中序打印操作
    public void infPrintTree() {
        infPrintTree(this.root);
    }

    //后序打印操作
    public void epiPrintTree() {
        epiPrintTree(this.root);
    }

    public void floorPrintTree() {
        floorPrintTree(this.root);
    }

    //判断是否是AVL树
    public boolean isAVL() {
        return false;
    }

    /**
     * 查询某个节点
     *
     * @param x
     * @param t
     * @return 存在:返回当前节点 不存在:返回其理论父节点
     */
    public TreeNode find(int x, TreeNode t) {
        if (t == null) {
            return null;
        }
        if (t.val == x) {
            return t;
        }
        return t.val < x ? find(x, t.right) : find(x, t.left);
    }

    public TreeNode findMin(TreeNode t) {
        if (t == null) {
            return null;
        }
        if (t.left == null) {
            return t;
        }
        return findMin(t.left);
    }

    public TreeNode findMax(TreeNode t) {
        if (t == null) {
            return null;
        }
        if (t.right == null) {
            return t;
        }
        return findMax(t.right);
    }

    /**
     * 移除最大元素
     *
     * @param t
     * @return
     */
    public TreeNode removeMax(TreeNode t, TreeNode parent) {
        if (t == null) {
            return null;
        }
        while (t.right != null) {
            parent = t;
            t = t.right;
        }
        if (parent != null) {
            parent.right = t.left;
        } else {//只有根节点无parent
            this.root = t.left;
        }
        return t;
    }

    public void insert(int x, TreeNode t) {
        if (t == null) {
            return;
        }
        if (t.val == x) {
            return;
        }
        if (t.val > x) {
            if (t.left != null) {
                insert(x, t.left);
            } else {
                t.left = new TreeNode(x);
            }
        } else {
            if (t.right != null) {
                insert(x, t.right);
            } else {
                t.right = new TreeNode(x);
            }
        }
    }

    /**
     * 移除某个元素
     *
     * @param x
     * @param t
     * @return 返回被移除的元素，无该元素则返回null
     */
    public TreeNode remove(int x, TreeNode t) {
        if (t == null) {
            return null;
        }
        if (t.val < x) {
            t.right = remove(x, t.right);
        } else if (t.val > x) {
            t.left = remove(x, t.left);
        } else {
            if (t.left != null && t.right != null) {
                TreeNode tmp = removeMax(t.left, t);
                t.val = tmp.val;
            } else {
                t = t.left == null ? t.right : t.left;
            }
        }
        return t;
    }

    public int maxDeep(TreeNode t) {
        if (t == null) {
            return 0;
        }
        int left = maxDeep(t.left);
        int right = maxDeep(t.right);
        return (left > right ? left : right) + 1;
    }

    public int minDeep(TreeNode t) {
        if (t == null) {
            return 0;
        }
        int left = minDeep(t.left);
        int right = minDeep(t.right);
        return (left > right ? right : left) + 1;
    }

    /**
     * 先序遍历
     *
     * @param t
     */
    public void prePrintTree(TreeNode t) {
//        if (t == null) {
//            return;
//        }
//        System.out.print(t.val + "  ");
//        prePrintTree(t.left);
//        prePrintTree(t.right);
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        while (tmp != null || !stack.empty()) {
            if (tmp != null) {
                System.out.print(tmp.val + "  ");
                stack.push(tmp);
                tmp = tmp.left;
            } else {
                tmp = stack.pop().right;
            }
        }
    }

    /**
     * 中序遍历
     *
     * @param t
     */
    public void infPrintTree(TreeNode t) {
//        if (t == null) {
//            return;
//        }
//        infPrintTree(t.left);
//        System.out.print(t.val + "  ");
//        infPrintTree(t.right);
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = t;
        while (tmp != null || !stack.empty()) {
            if (tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            } else {
                tmp = stack.pop();
                System.out.print(tmp.val + "  ");
                tmp = tmp.right;
            }
        }

    }

    /**
     * 后序遍历
     *
     * @param t
     */
    public void epiPrintTree(TreeNode t) {
//        if (t == null) {
//            return;
//        }
//        epiPrintTree(t.left);
//        epiPrintTree(t.right);
//        System.out.print(t.val + "  ");
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> val = new Stack<>();
        TreeNode tmp = t;
        while (tmp != null || !stack.empty()) {
            if (tmp != null) {
                stack.push(tmp);
                val.add(tmp.val);
                tmp = tmp.right;
            } else {
                tmp = stack.pop();
                tmp = tmp.left;
            }
        }
        while (!val.empty()) {
            System.out.print(val.pop() + "  ");
        }
    }

    /**
     * 层序遍历
     *
     * @param t
     */
    public void floorPrintTree(TreeNode t) {
        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(t);
        while (!treeNodes.isEmpty()) {
            List<TreeNode> tmps = new ArrayList<>();
            for (TreeNode treeNode : treeNodes) {
                if (treeNode != null) {
                    tmps.add(treeNode.left);
                    tmps.add(treeNode.right);
                    System.out.print(treeNode.val + "  ");
                }
            }
            System.out.println();
            treeNodes = tmps;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{19, 22, 31, 24, 55, 3, 2, 9, 17, 25, 53};
        BinarySearchTree bst = new BinarySearchTree();
        System.out.println(bst);
        for (int i = 0; i < array.length; i++) {
            bst.insert(array[i]);
        }
        System.out.println(bst);
        System.out.println(bst.contains(1));
        System.out.println("最小值:" + bst.findMin());
        System.out.println("最大值:" + bst.findMax());
//        bst.remove(53);
//        System.out.println(bst);
        System.out.println("最大深度:" + bst.maxDeep());
        System.out.println("最小深度:" + bst.minDeep());
        bst.prePrintTree();
        System.out.println();
        bst.infPrintTree();
        System.out.println();
        bst.epiPrintTree();
        System.out.println();
        bst.floorPrintTree();
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }
}
