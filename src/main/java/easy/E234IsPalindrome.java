package easy;

import utils.ListNode;

import java.util.List;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/9/7 20:21
 * @Description: 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：false
 */
public class E234IsPalindrome {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(1))))));
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while (true) {
            if (fast == null) {
                break;
            }
            if (fast.next == null) {
                slow = slow.next;
                break;
            }
            fast = fast.next.next;
            ListNode tmp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = tmp;

        }
        while (pre != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }
}
