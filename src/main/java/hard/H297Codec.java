package hard;

import utils.TreeNode;

import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/9/16 16:32
 * @Description: 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采
 * 取相反方式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为
 * 一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。
 * 你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * <p>
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * <p>
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[1,2]
 */
public class H297Codec {
    public static void main(String[] args) {
        //[4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2));
        System.out.println(treeNode);
        String s = serialize(treeNode);
        System.out.println(s);
        System.out.println(deserialize(s));
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        return serialize(root, "");
    }

    public static String serialize(TreeNode root, String str) {
        if (root == null) {
            str += "Null,";
        } else {
            str += root.val + ",";
            str = serialize(root.left, str);
            str = serialize(root.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        List<String> list =new ArrayList<>(Arrays.asList(data.split(",")));
        return deserialize(list);
    }

    public static TreeNode deserialize(List<String> list) {
        if ("Null".equals(list.get(0))) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = deserialize(list);
        root.right = deserialize(list);
        return root;
    }

    public static int getTreeIndex(String data) {
        char[] chars = data.toCharArray();
        Deque<Character> deque = new LinkedList<>();
        int start = -1;
        int end = data.length() - 1;
        for (int i = 0; i <= end; i++) {
            if (chars[i] == '[') {
                deque.addFirst('[');
                start = i;
                break;
            }
        }
        if (start == -1) {
            return -1;
        }
        for (int i = start + 1; i <= end; i++) {
            if (chars[i] == '[') {
                deque.addFirst('[');
            } else if (chars[i] == ']') {
                deque.pollFirst();
                if (deque.isEmpty()) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static TreeNode buildTree(String[] pre, String[] inf, int preStart, int preEnd, int infStart, int infEnd) {
        if (preStart > preEnd || infStart > infEnd) {
            return null;
        }
        int val = Integer.parseInt(pre[preStart]);//根节点
        int index = infStart;
        for (; index < infEnd; index++) {
            if (Integer.parseInt(inf[index]) == val) {
                break;
            }
        }
        int preIndex = preStart + index - infStart;
        TreeNode root = new TreeNode(val);
        root.left = buildTree(pre, inf, preStart + 1, preIndex, infStart, index - 1);
        root.right = buildTree(pre, inf, preIndex + 1, preEnd, index + 1, infEnd);
        return root;
    }

    private static String pre(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        pre(root, sb);
        return sb.substring(0, sb.length() - 1);
    }

    private static void pre(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val + ",");
        pre(root.left, sb);
        pre(root.right, sb);
    }

    private static String inf(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        inf(root, sb);
        return sb.substring(0, sb.length() - 1);
    }

    private static void inf(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        inf(root.left, sb);
        sb.append(root.val + ",");
        inf(root.right, sb);
    }

}
