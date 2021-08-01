package hard;

import utils.ListNode;

import java.util.List;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/7/13 18:24
 * @Description: 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class H23MergeKLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));
        System.out.println(mergeKLists((new ListNode[]{l1, l2, l3})));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        while (true) {
            int tmpLen = lists.length % 2 == 0 ? lists.length / 2 : lists.length / 2 + 1;
            ListNode[] tmp = new ListNode[tmpLen];
            int i = 0;
            int j = 0;
            while (i < lists.length) {
                if (i + 1 < lists.length) {
                    tmp[j++] = merge(lists[i], lists[i + 1]);
                    i = i + 2;
                    continue;
                }
                tmp[j] = lists[i];
                break;
            }
            lists = tmp;
            if (lists.length == 1) {
                return lists[0];
            }
        }

    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode tmp = new ListNode();
        ListNode header = tmp;
        while (true) {
            if (l1 == null || l2 == null) {
                tmp.next = l1 == null ? l2 : l1;
                break;
            }
            if (l1.val < l2.val) {
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        return header.next;
    }
}
