package feture.ms;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lanshan
 */
public class M1713 {
    /**
     * 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
     *
     * 注意：本题相对原题稍作改动，只需返回未识别的字符数
     *
     *  
     *
     * 示例：
     *
     * 输入：
     * dictionary = ["looked","just","like","her","brother"]
     * sentence = "jesslookedjustliketimherbrother"
     * 输出： 7
     * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
     * 提示：
     *
     * 0 <= len(sentence) <= 1000
     * dictionary中总字符数不超过 150000。
     * 你可以认为dictionary和sentence中只包含小写字母。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/re-space-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    Set<String> wordMap;
    Set<Integer> wordLength;
    Integer[] num;

    public int respace(String[] dictionary, String sentence) {
        if (dictionary == null || dictionary.length == 0) {
            if (sentence == null || sentence.length() == 0)
                return 0;
            return sentence.length();
        }
        wordMap = new HashSet<>(dictionary.length);
        wordLength = new HashSet<>(dictionary.length);
        for (String s : dictionary) {
            wordLength.add(s.length());
            wordMap.add(s);
        }
        num = new Integer[sentence.length()];
        return sentence.length() - find(sentence, 0);
    }

    private int find(String sentence, int index) {
        if (index >= sentence.length())
            return 0;
        if (num[index] != null)
            return num[index];
        int max = 0;
        for (int i = 0; i < sentence.length() - index; i++) {
            int temp = 0;
            if (wordLength.contains(i + 1) && wordMap.contains(sentence.substring(index, index + i + 1))) {
                temp = i + 1;
            }
            max = Math.max(max, temp + find(sentence, index + i + 1));
        }
        num[index] = max;
        return max;
    }

    public static void main(String[] args) {
        M1713 m = new M1713();
        System.out.println(m.respace(new String[] {"looked", "just", "like", "her", "brother"}, "jesslookedjustliketimherbrother"));
    }
}
