package medium;

import utils.ListNode;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/7/12 16:03
 * @Description: 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗？
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * <p>
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 */
public class M19RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3)));
        System.out.println(removeNthFromEnd(head, 1));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = new ListNode(0, head);
        ListNode second = head;
        for (int i = 0; i < n; i++) {
            second = second.next;
        }
        if (second == null) {//代表删除的是头结点
            return tmp.next.next;
        }
        ListNode pre;
        ListNode first = head;
        while (true) {
            pre = first;
            first = first.next;
            second = second.next;
            if (second == null) {
                pre.next = first.next;
                break;
            }
        }
        return tmp.next;
    }
}
