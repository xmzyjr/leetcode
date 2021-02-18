package feture.ms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lanshan
 */
public class M1715 {

    /**
     * 给定一组单词words，编写一个程序，找出其中的最长单词，且该单词由这组单词中的其他单词组合而成。
     * 若有多个长度相同的结果，返回其中字典序最小的一项，若没有符合要求的单词则返回空字符串。
     *
     * 示例：
     *
     * 输入： ["cat","banana","dog","nana","walk","walker","dogwalker"]
     * 输出： "dogwalker"
     * 解释： "dogwalker"可由"dog"和"walker"组成。
     * 提示：
     *
     * 0 <= len(words) <= 200
     * 1 <= len(words[i]) <= 100
     */
    static class Node {

        Node[] nodes = new Node[26];

        boolean isEnd;
    }
    public String longestWord(String[] words) {
        if (words == null || words.length == 0)
            return "";
        String[] newWords = filter(words);
        if (newWords.length == 0)
            return "";
        Arrays.sort(newWords, (o1, o2) -> {
            if (o1.length() != o2.length())
                return o1.length() - o2.length();
            return o1.compareTo(o2);
        });
        Node head = buildTree(newWords);
        String res = null;
        for (int i = newWords.length - 1; i >= 0; i--) {
            if (check(newWords[i].toCharArray(), 0, head)) {
                if (res == null) {
                    res = newWords[i];
                } else {
                    if (newWords[i].length() < res.length())
                        return res;
                    if (newWords[i].compareTo(res) < 0) {
                        res = newWords[i];
                    }
                }
            }
        }
        return res == null ? "" : res;
    }

    private String[] filter(String[] words) {
        List<String> newWords = new ArrayList<>(words.length);
        for (String word : words) {
            if (!"".equals(word)) {
                newWords.add(word);
            }
        }
        return newWords.toArray(new String[0]);
    }

    private boolean check(char[] word, int index, Node head) {
        if (index == word.length)
            return true;
        Node temp = head;
        for (int i = index; i < word.length; i++) {
            int nodeIndex = word[i] - 'a';
            if (temp.nodes[nodeIndex] == null)
                return false;
            if (temp.nodes[nodeIndex].isEnd) {
                if (i == word.length-1 && index == 0)
                    return false;
                boolean check = check(word, i + 1, head);
                if (check)
                    return true;
            }
            temp = temp.nodes[nodeIndex];
        }
        return false;
    }

    private Node buildTree(String[] words) {
        Node head = new Node();
        for (String word : words) {
            char[] chars = word.toCharArray();
            Node temp = head;
            for (int i = 0; i < chars.length; i++) {
                int index = chars[i] - 'a';
                if (temp.nodes[index] == null) {
                    temp.nodes[index] = new Node();
                }
                if (i == chars.length - 1)
                    temp.nodes[index].isEnd = true;
                temp = temp.nodes[index];
            }
        }
        return head;
    }

    public static void main(String[] args) {
        M1715 m = new M1715();
        System.out.println(m.longestWord(new String[] {"cat", "banana", "dog", "nana", "walk", "walker", "dogwalker"}));
        System.out.println(m.longestWord(new String[] {"ttaaaa","pp","tpa","kpaqkt","tktpqq","aqppatp"}));
    }
}
