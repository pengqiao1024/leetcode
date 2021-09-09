package other.self;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/8/17 20:25
 * @Description: 两个栈实现链表功能
 */
public class StackToQueue {
    public static void main(String[] args) {
        StackToQueue queue = new StackToQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(4);
        queue.push(5);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }

    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    public void push(Integer i) {
        in.push(i);
    }

    public Integer pop() {
        if (out.empty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }
        if (out.empty()) {
            throw new RuntimeException("empty");
        }
        return out.pop();
    }
}
