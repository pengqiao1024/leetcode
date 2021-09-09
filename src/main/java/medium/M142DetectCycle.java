package medium;

import utils.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/8/18 15:24
 * @Description: 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * 说明：不允许修改给定的链表。
 * <p>
 * 进阶：
 * 你是否可以使用 O(1) 空间解决此题？
 * <p>
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 */
public class M142DetectCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        System.out.println(detectCycle(head).val);
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                /**
                 * 此时相遇了，fast走过了2*step节点，slow走过了step节点
                 *头节点到入环点距离记为a  入环点到相遇点记为b  相遇点到入环点记为c
                 * 则有：
                 * 1.a+b=step
                 * 2.a+b+n*(c+b)=2step ==>a+(n+1)b+n*c=2step
                 * 故：
                 * a+(n+1)b+n*c=2(a+b) ==>a=c+(n-1)(b+c) ==>a=c+(n-1)L [L为环长]
                 * 即从相遇点到入环点与从头结点到入环点距离一致
                 */
                ListNode tmp = head;
                while (tmp != slow) {
                    tmp = tmp.next;
                    slow = slow.next;
                }
                return tmp;
            }
        }
        return null;
    }
}
