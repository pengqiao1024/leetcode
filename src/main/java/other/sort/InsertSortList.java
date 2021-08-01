package other.sort;

import utils.ListNode;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/7/21 15:24
 * @Description: 插入排序  单链表
 */
public class InsertSortList {
    public static void main(String[] args) {
        ListNode root = new ListNode(19, new ListNode(22, new ListNode(31, new ListNode(24, new ListNode(55, new ListNode(3,
                new ListNode(2, new ListNode(9, new ListNode(17, new ListNode(25, new ListNode(53)))))))))));
        System.out.println(root);
        System.out.println(insertSortList(root));
    }

    private static ListNode insertSortList(ListNode root) {
        ListNode header = new ListNode();
        header.next = root;
        /**
         * 将要插入的节点
         */
        ListNode cp = header;
        ListNode cur = root;
        while (cur != null) {
            /**
             * 已排好序的节点
             */
            ListNode fp = header;
            ListNode find = header.next;
            boolean change = false;//是否交换
            while (find != cur) {//两者相等，代表该节点无需移动
                if (find.val > cur.val) {//两节点进行交换,交换完成后cur节点已到达指定位置
                    ListNode cn = cur.next;
                    fp.next = cur;
                    cur.next = find;
                    cp.next = cn;
                    change = true;
                    break;
                }
                fp = fp.next;
                find = fp.next;
            }
            if (!change) {
                cp = cp.next;
            }
            cur = cp.next;
        }
        return header.next;
    }


}
