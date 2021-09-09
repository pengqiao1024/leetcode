package medium;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/8/18 18:51
 * @Description: 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *  
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * 示例：
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * M146LRUCache.put(1, 1); // 缓存是 {1=1}
 * M146LRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * M146LRUCache.get(1);    // 返回 1
 * M146LRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * M146LRUCache.get(2);    // 返回 -1 (未找到)
 * M146LRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * M146LRUCache.get(1);    // 返回 -1 (未找到)
 * M146LRUCache.get(3);    // 返回 3
 * M146LRUCache.get(4);    // 返回 4
 * <p>
 * 提示：
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 105
 * 最多调用 2 * 105 次 get 和 put
 */
public class M146LRUCache {

    public static void main(String[] args) {
        M146LRUCache cache = new M146LRUCache(2);
        cache.put(1, 1); // 缓存是 {1=1}
        System.out.println("put 1 ==>" + cache);
        cache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println("put 2 ==>" + cache);
        System.out.println("get 1 res ==>" + cache.get(1));
        System.out.println("get 1 ==>" + cache);
        cache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println("put 3 ==>" + cache);
        System.out.println("get 2 res ==>" + cache.get(2)); // 返回 -1 (未找到)
        System.out.println("get 2 ==>" + cache);
        cache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println("put 4 ==>" + cache);
        System.out.println("get 1 res ==>" + cache.get(1));
        System.out.println("get 1 ==>" + cache);
        System.out.println("get 3 res ==>" + cache.get(3));// 返回 3
        System.out.println("get 3 ==>" + cache);
        System.out.println("get 4 res ==>" + cache.get(4));// 返回 4
        System.out.println("get 4 ==>" + cache);
    }

    private int capacity;
    private int size;
    public Map<Integer, Node> map;
    private Node head = new Node(11111, 11111);
    private Node tail = new Node(99999, 99999);


    public M146LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        head.next = tail;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
            return;
        }
        node = new Node(key, value);
        map.put(key, node);
        addHead(node);
        size++;
        if (size > capacity) {
            size--;
            removeTail();
        }
    }

    private void removeTail() {
        Node moved = tail.pre;
        if (moved == head) {
            return;
        }
        moved.pre.next = tail;
        tail.pre = moved.pre;
        map.remove(moved.key);
    }

    private void moveToHead(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    private void addHead(Node node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    @Override
    public String toString() {
        StringBuilder hsb = new StringBuilder();
        Node htmp = head;
        while (htmp != null) {
            hsb.append(htmp.value).append(" -> ");
            htmp = htmp.next;
        }
        hsb.delete(hsb.length() - 4, hsb.length());
        StringBuilder tsb = new StringBuilder();
        Node ttmp = tail;
        while (ttmp != null) {
            tsb.append(ttmp.value).append(" <- ");
            ttmp = ttmp.pre;
        }
        tsb.delete(tsb.length() - 4, tsb.length());
        return "capacity=" + capacity +
                ", size=" + size +
                ", map=" + map.keySet() +
                ", head=" + hsb +
                ", tail=" + tsb;
    }

    class Node {
        public Node pre;
        public Node next;
        public int key;
        public int value;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
