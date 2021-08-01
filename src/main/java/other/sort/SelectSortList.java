package other.sort;

import utils.ListNode;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/7/20 10:06
 * @Description: 选择排序 链表
 */
public class SelectSortList {
    public static void main(String[] args) {
        ListNode root = new ListNode(19, new ListNode(22, new ListNode(31, new ListNode(24, new ListNode(55, new ListNode(3,
                new ListNode(2, new ListNode(9, new ListNode(17, new ListNode(25, new ListNode(53)))))))))));
        System.out.println(root);
        System.out.println(selectSortList(root));
    }

    public static ListNode selectSortList(ListNode root) {
        ListNode header = new ListNode();
        header.next = root;
        ListNode cpre = header;
        ListNode cur = root;

        while (cur.next != null) {
            System.out.println("cpre:" + cpre);
            System.out.println("cur:" + cur);
            ListNode mpre = cpre;
            ListNode min = cur;
            ListNode fpre = cpre.next;
            ListNode find = cur.next;
            while (find != null) {
                if (min.val > find.val) {
                    mpre = fpre;
                    min = find;
                }
                fpre = find;
                find = find.next;
            }
            ListNode cnext = cur.next;
            ListNode mnext = min.next;
            if (cnext != min) {
                mpre.next = cur;
                min.next = cnext;
                cur.next = mnext;
                cpre.next = min;
            } else {
                min.next = cur;
                cpre.next = min;
                cur.next = mnext;
            }
            cpre = cpre.next;
            cur = cpre.next;
            System.out.println("change ==>" + header);
        }
        return header.next;
    }

}
