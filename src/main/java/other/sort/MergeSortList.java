package other.sort;

import utils.ListNode;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/7/21 17:11
 * @Description: 归并排序 链表
 */
public class MergeSortList {
    public static void main(String[] args) {
        ListNode root = new ListNode(19, new ListNode(22, new ListNode(31, new ListNode(24, new ListNode(55, new ListNode(3,
                new ListNode(2, new ListNode(9, new ListNode(17, new ListNode(25, new ListNode(53)))))))))));
        System.out.println(root);
        System.out.println(mergeSortList(root));
    }

    private static ListNode mergeSortList(ListNode root) {
        System.out.println("本次排序链表:" + root);
        if (root == null || root.next == null) {
            return root;
        }
        ListNode fast = root.next;
        ListNode mid = root;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            mid = mid.next;
        }
        ListNode right = mergeSortList(mid.next);
        mid.next = null;//断掉
        ListNode left = mergeSortList(root);
        return merge(left, right);
    }


    /**
     * @param left
     * @param right
     */
    private static ListNode merge(ListNode left, ListNode right) {
        System.out.println("本次合并链表 l:" + left);
        System.out.println("本次合并链表 r:" + right);
        ListNode res = new ListNode();
        ListNode tmp = res;
        while (left != null || right != null) {
            if (left == null) {
                tmp.next = right;
                break;
            }
            if (right == null) {
                tmp.next = left;
                break;
            }
            if (left.val < right.val) {
                tmp.next = left;
                left = left.next;
            } else {
                tmp.next = right;
                right = right.next;
            }
            tmp = tmp.next;
        }
        System.out.println("本次合并链表 res:" + res.next);
        return res.next;
    }
}
