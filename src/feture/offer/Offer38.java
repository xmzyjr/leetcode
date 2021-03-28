package feture.offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lanshan
 */
public class Offer38 {
    /**
     *输入一个字符串，打印出该字符串中字符的所有排列。
     *
     *  
     *
     * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
     *
     *  
     *
     * 示例:
     *
     * 输入：s = "abc"
     * 输出：["abc","acb","bac","bca","cab","cba"]
     *  
     *
     * 限制：
     *
     * 1 <= s 的长度 <= 8
     */
    Set<String> res;
    public String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }
        char[] chars = s.toCharArray();
        res = new HashSet<>();
        find(chars,0);
        return res.toArray(new String[0]);
    }

    private void find(char[] chars, int index) {
        if (index == chars.length) {
            res.add(new String(chars));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            find(chars, index + 1);
            swap(chars, index, i);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }

    public static void main(String[] args) {
        Offer38 o = new Offer38();
        System.out.println(Arrays.toString(o.permutation("abc")));

    }
}
