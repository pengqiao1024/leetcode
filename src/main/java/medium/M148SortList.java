package medium;


import utils.ListNode;

import java.util.List;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/4/25 17:07
 * @Description: 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class M148SortList {
    public static void main(String[] args) {
        ListNode head = new ListNode(5, new ListNode(3, new ListNode(10, new ListNode(4, new ListNode(-2, new ListNode(-5, null))))));
        System.out.println(head);
//        sort1(root);
//        sort2(root);
//        head = mergerSort(head);
//        System.out.println(head);
        head = quickSort(head);
        System.out.println(head);
    }

    /**
     * 最简单粗暴的做法
     *
     * @param head
     */
    private static void sort1(ListNode head) {
        ListNode n = new ListNode(Integer.MIN_VALUE, null);
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            ListNode tmp = new ListNode(cur.val);
            ListNode nn = n;
            ListNode nprev = null;
            while (nn != null) {
                if (cur.val < nn.val) {
                    tmp.next = nn;
                    if (nprev != null) {
                        nprev.next = tmp;
                    } else {
                        n = tmp;
                    }
                    break;
                }
                if (nn.next == null) {
                    nn.next = tmp;
                    break;
                }
                nprev = nn;
                nn = nn.next;
            }
            cur = next;
        }
        System.out.println(n.next);
    }

    /**
     * 交换值排序
     *
     * @param head
     */
    private static void sort2(ListNode head) {
        if (head == null) {
            return;
        }
        while (true) {
            ListNode cur = head;
            boolean change = false;
            while (cur.next != null) {
                ListNode next = cur.next;
                if (cur.val > next.val) {
                    int tmp = cur.val;
                    cur.val = next.val;
                    next.val = tmp;
                    change = true;
                }
                cur = cur.next;
            }
            if (!change) {
                break;
            }
        }
        System.out.println(head);

    }

    /**
     * 归并
     *
     * @param head
     */
    private static ListNode mergerSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p = head;
        while (p != null) {
            if (p.next != null) {
                p1.next = p;
                p2.next = p.next;
                p1 = p1.next;
                p2 = p2.next;
                p = p.next.next;
                p1.next = null;
                p2.next = null;
            } else {
                p1.next = p;
                p1 = p1.next;
                p = p.next;
                p1.next = null;
            }
        }
        l1 = mergerSort(l1.next);
        l2 = mergerSort(l2.next);
        return merge(l1, l2);
    }

    /**
     * 合并两个有序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode nh = new ListNode();
        ListNode p = nh;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return nh.next;
    }

    private static ListNode quickSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = new ListNode();
        ListNode right = new ListNode();
        ListNode p1 = left;
        ListNode p2 = right;
        ListNode p = head.next;
        ListNode base = head;
        base.next = null;
        while (p != null) {
            ListNode next = p.next;
            if (p.val < base.val) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            p = next;
        }
        left.next = quickSort(left.next);
        right.next = quickSort(right.next);
        base.next = right.next;
        if (left.next != null) {
            p = left.next;
            while (p.next != null) {
                p = p.next;
            }
            p.next = base;
            return left.next;
        } else {
            return base;
        }
    }
}
