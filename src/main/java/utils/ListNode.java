package utils;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/7/12 16:04
 * @Description:
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }
    public ListNode(int x) {
        val = x;
    }

    public ListNode(int x, ListNode node) {
        val = x;
        next = node;
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
