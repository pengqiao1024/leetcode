package easy;

/**
 * @Author: pengqiao01
 * @date: 2019/7/1 16:28
 */

import utils.ListNode;

/**
 * 删除链表中的节点
 * <p>
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * <p>
 * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:  4-->5-->7-->9
 * <p>
 * 示例 1:
 * <p>
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * <p>
 * 输入: head = [4,5,1,9], node = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *  
 * <p>
 * 说明:
 * <p>
 * 链表至少包含两个节点。
 * 链表中所有节点的值都是唯一的。
 * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * 不要从你的函数中返回任何结果。
 * 在真实的面试中遇到过这道题？
 */

public class E237DeleteNode {
    public static void main(String[] args) {
        ListNode root = new ListNode(4);
        ListNode second = new ListNode(5);
        ListNode third = new ListNode(1);
        ListNode fourth = new ListNode(9);
//        ListNode root = new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(9))));
        root.next = second;
        second.next = third;
        third.next = fourth;
        System.out.println(root);
        deleteNode(second);
        System.out.println(root);
    }

    public static void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;//将该节点赋值为下一个节点
        node.next = next.next;//删除下一个节点
    }



}
