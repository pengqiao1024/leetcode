package self;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/4/8 14:29
 * @Description:单链表反转
 */
public class ReverseList {

    public static void main(String[] args) {
        Node root = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));
        System.out.println(root);
//        System.out.println(reverse1(root));
        System.out.println(reverse2(root));
    }
    

    /**
     * 重新构造
     *
     * @param node
     * @return
     */
    public static Node reverse1(Node node) {
        Node nNode = null;
        while (node != null) {
            Node next = node.next;
            node.next = nNode;
            nNode = node;
            node = next;
        }
        return nNode;
    }

    /**
     * 原链表操作
     *
     * @param node
     * @return
     */
    public static Node reverse2(Node node) {
        Node pre = null;
        Node cur = node;
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    static class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
        }

        Node(int x, Node next) {
            val = x;
            this.next = next;
        }

        @Override
        public String toString() {
            if (next != null) {
                return val + "->" + next;
            } else {
                return "" + val;
            }
        }
    }
}
