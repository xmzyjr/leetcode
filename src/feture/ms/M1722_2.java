package feture.ms;

import java.util.*;

/**
 * @author lanshan
 */
public class M1722_2 {

    /**
     * 给定字典中的两个词，长度相等。写一个方法，把一个词转换成另一个词， 但是一次只能改变一个字符。每一步得到的新词都必须能在字典中找到。
     *
     * 编写一个程序，返回一个可能的转换序列。如有多个可能的转换序列，你可以返回任何一个。
     *
     * 示例 1:
     *
     * 输入:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     *
     * 输出:
     * ["hit","hot","dot","lot","log","cog"]
     * 示例 2:
     *
     * 输入:
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log"]
     *
     * 输出: []
     *
     * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
     */
    
    private static class Node {

        public String word;

        public List<String> relatedWords = new ArrayList<>();
    }
    private Map<String, Node> wordNodeMap;

    boolean finish = false;

    Set<String> wordSet = new HashSet<>();


    List<String> result = new ArrayList<>();

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || beginWord.length() == 0 || endWord == null || endWord.length() == 0 || wordList == null
                || wordList.size() == 0 || beginWord.length() != endWord.length())
            return new ArrayList<>();
        if (!wordList.contains(endWord))
            return new ArrayList<>();
        int length = beginWord.length();

        List<String> newWordList = new ArrayList<>(wordList.size());
        for (String s : wordList) {
            if (s.length() == length)
                newWordList.add(s);
        }

        wordNodeMap = new HashMap<>(newWordList.size());

        for (String s : newWordList) {
            Node w = new Node();
            w.word = s;
            wordNodeMap.put(s, w);
        }

        Node begin = wordNodeMap.get(beginWord);
        if (begin == null) {
            begin = new Node();
            begin.word = beginWord;
            wordNodeMap.put(beginWord, begin);
        }

        for (String s : wordNodeMap.keySet()) {
            buildRelatedWords(s, newWordList);
        }
        dfs(begin, endWord);
        return finish ? result : new ArrayList<>();
    }

    private void dfs(Node item, String endWord) {
        if (finish || wordSet.contains(item.word))
            return;
        if (item.word.equals(endWord)) {
            result.add(endWord);
            finish = true;
            return;
        }
        wordSet.add(item.word);
        result.add(item.word);
        for (String relatedWord : item.relatedWords) {
            dfs(wordNodeMap.get(relatedWord), endWord);
            if (finish)
                return;
        }
        result.remove(item.word);
        wordSet.remove(item.word);
    }
    
    private void buildRelatedWords(String word, List<String> wordList) {
        Node node = wordNodeMap.get(word);
        for (String s : wordList) {
            if (!s.equals(word) && diffOneChar(word, s))
                node.relatedWords.add(s);
        }
    }

    private boolean diffOneChar(String first, String second) {
        int length = first.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (first.charAt(i) != second.charAt(i))
                count++;
        }
        return count == 1;
    }

    public static void main(String[] args) {
        M1722_2 m = new M1722_2();
        System.out.println(m.findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }
}
