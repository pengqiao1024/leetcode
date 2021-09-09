package medium;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/8/12 19:44
 * @Description: 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例 1：
 * 输入：board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, word = 'ABCCED'
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, word = 'SEE'
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, word = 'ABCB'
 * 输出：false
 *  
 * 提示：
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 */
public class M79Exist {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCESEEEFS";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == words[0]) {
                    boolean[][] used = new boolean[board.length][board[0].length];
                    used[i][j] = true;
                    if (exist(board, words, used, i, j, 1)) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    private static boolean exist(char[][] board, char[] words, boolean[][] used, int i, int j, int index) {
        if (index >= words.length) {//查找结束
            return true;
        }
        boolean res = judgeAndExist(board, words, used, i - 1, j, index);
        if (res) {
            return true;
        }
        res = judgeAndExist(board, words, used, i + 1, j, index);
        if (res) {
            return true;
        }
        res = judgeAndExist(board, words, used, i, j - 1, index);
        if (res) {
            return true;
        }
        res = judgeAndExist(board, words, used, i, j + 1, index);
        if (res) {
            return true;
        }
        return false;
    }

    private static boolean judgeAndExist(char[][] board, char[] words, boolean[][] used, int i, int j, int index) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1) {
            return false;
        }
        if (!used[i][j] && board[i][j] == words[index]) {
            used[i][j] = true;
            boolean res = exist(board, words, used, i, j, index + 1);
            if (!res) {
                used[i][j] = false;
            }
            return res;
        }
        return false;
    }

}
