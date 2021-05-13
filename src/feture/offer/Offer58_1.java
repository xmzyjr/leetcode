package feture.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lanshan
 */
public class Offer58_1 {
    /**
     *输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
     *
     *  
     *
     * 示例 1：
     *
     * 输入: "the sky is blue"
     * 输出: "blue is sky the"
     * 示例 2：
     *
     * 输入: "  hello world!  "
     * 输出: "world! hello"
     * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 示例 3：
     *
     * 输入: "a good   example"
     * 输出: "example good a"
     * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     *  
     *
     * 说明：
     *
     * 无空格字符构成一个单词。
     * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0)
            return s;
        s = s.trim();
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                if (sb.length() != 0) {
                    list.add(sb.toString());
                    sb.delete(0, sb.length());
                }
                continue;
            }
            sb.append(c);
        }
        if (sb.length() != 0) {
            list.add(sb.toString());
        }
        Collections.reverse(list);
        return String.join(" ", list);
    }

    public static void main(String[] args) {
        Offer58_1 o = new Offer58_1();
        System.out.println(o.reverseWords("  hello world!  "));
        System.out.println(o.reverseWords("a good   example"));
    }
}
