package medium;

import java.util.Arrays;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/9/2 17:21
 * @Description: Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。
 * 这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * <p>
 * 请你实现 Trie 类：
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 * <p>
 * 示例：
 * 输入
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出
 * [null, null, true, false, true, null, true]
 * <p>
 * 解释
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 True
 * trie.search("app");     // 返回 False
 * trie.startsWith("app"); // 返回 True
 * trie.insert("app");
 * trie.search("app");     // 返回 True
 *  
 * <p>
 * 提示：
 * 1 <= word.length, prefix.length <= 2000
 * word 和 prefix 仅由小写英文字母组成
 * insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次
 */
public class M208Trie {

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public M208Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode trieNode = root;
        for (char c : chars) {
            TrieNode[] trieNodes = trieNode.next;
            if (trieNodes == null) {
                trieNodes = new TrieNode[26];
                trieNode.next = trieNodes;
            }
            int index = getIndex(c);
            if (trieNodes[index] == null) {
                trieNodes[index] = new TrieNode();
            }
            trieNode = trieNodes[index];
        }
        trieNode.end = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TrieNode trieNode = root;
        for (char c : chars) {
            if (trieNode.next == null) {
                return false;
            }
            TrieNode tmp = trieNode.next[getIndex(c)];
            if (tmp == null) {
                return false;
            }
            trieNode = tmp;
        }
        return trieNode.end;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode trieNode = root;
        for (char c : chars) {
            if (trieNode.next == null) {
                return false;
            }
            TrieNode tmp = trieNode.next[getIndex(c)];
            if (tmp == null) {
                return false;
            }
            trieNode = tmp;
        }
        return true;
    }

    private static int getIndex(char c) {
        return c - 'a';
    }

    public static void main(String[] args) {
        M208Trie trie = new M208Trie();
//        trie.insert("apple");
        System.out.println(trie.search("apple"));
//        System.out.println(trie.search("app"));
//        System.out.println(trie.startsWith("app"));
//        trie.insert("app");
//        System.out.println(trie.search("app"));
    }


    static class TrieNode {
        TrieNode[] next;
        boolean end = false;

        public TrieNode() {

        }

        public TrieNode(TrieNode[] next) {
            this.next = next;
        }

    }
}
