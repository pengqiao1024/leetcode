package other.sort;

import utils.ListNode;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/7/22 19:39
 * @Description: 快排 链表
 */
public class QuickSortList {
    public static void main(String[] args) {
        ListNode root = new ListNode(19, new ListNode(22, new ListNode(31, new ListNode(24, new ListNode(55, new ListNode(3,
                new ListNode(2, new ListNode(9, new ListNode(17, new ListNode(25, new ListNode(53)))))))))));
        System.out.println(root);
        System.out.println(quickSortList(root));
    }

    private static ListNode quickSortList(ListNode root) {
        System.out.println("root:" + root);
        if (root == null || root.next == null) {
            return root;
        }
        ListNode left = new ListNode();
        ListNode lefth = left;
        ListNode right = new ListNode();
        ListNode righth = right;
        int tmpV = root.val;
        ListNode tmp = root.next;
        while (tmp != null) {
            if (tmp.val > tmpV) {
                right.next = tmp;
                right = right.next;
//                right.next = null;
            } else {
                left.next = tmp;
                left = left.next;
//                left.next = null;
            }
            tmp = tmp.next;
        }
        right.next = null;
        left.next = null;
        System.out.println("left:" + lefth.next);
        System.out.println("right:" + righth.next);
        lefth.next = quickSortList(lefth.next);
        righth.next = quickSortList(righth.next);
        root.next = righth.next;
        tmp = lefth.next;
        if (tmp != null) {
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = root;
            System.out.println("拼接后 :" + lefth.next);
            return lefth.next;
        }
        System.out.println("拼接后 :" + root);
        return root;


    }

}
