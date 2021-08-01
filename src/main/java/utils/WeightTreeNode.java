package utils;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/7/29 16:26
 * @Description:
 */
public class WeightTreeNode {
    public int val;
    public int weight;
    public WeightTreeNode left;//左子树
    public WeightTreeNode right;//右子树

    public WeightTreeNode() {
    }

    public WeightTreeNode(int val) {
        this.val = val;
    }

    public WeightTreeNode(int val, int weight) {
        this.val = val;
        this.weight = weight;
    }

    public WeightTreeNode(int val, WeightTreeNode left, WeightTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public WeightTreeNode(int val, int weight, WeightTreeNode left, WeightTreeNode right) {
        this.val = val;
        this.weight = weight;
        this.left = left;
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public WeightTreeNode getLeft() {
        return left;
    }

    public void setLeft(WeightTreeNode left) {
        this.left = left;
    }

    public WeightTreeNode getRight() {
        return right;
    }

    public void setRight(WeightTreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", weight=" + weight +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
