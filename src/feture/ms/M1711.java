package feture.ms;

/**
 * @author lanshan
 */
public class M1711 {
    /**
     * 有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。
     * 如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
     *
     * 示例：
     *
     * 输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
     * 输出：1
     * 提示：
     *
     * words.length <= 100000
     */
    public int findClosest(String[] words, String word1, String word2) {
        if (words == null || words.length == 0)
            return 0;
        Integer index1 = null, index2 = null;
        int min = Integer.MAX_VALUE;
        for (int i = 0, wordsLength = words.length; i < wordsLength; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                index1 = i;
            } else if (word.equals(word2)) {
                index2 = i;
            }
            if (index1 != null && index2 != null) {
                min = Math.min(min, Math.abs(index1 - index2));
            }
            if (min == 1)
                return 1;
        }
        return min;
    }
}
