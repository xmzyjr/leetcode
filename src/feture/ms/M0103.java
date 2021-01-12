package feture.ms;

import java.util.Arrays;

/**
 * @author lanshan
 */
public class M0103 {
    /**
     * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，
     * 并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
     *
     *
     * 示例 1：
     *
     * 输入："Mr John Smith    ", 13
     * 输出："Mr%20John%20Smith"
     * 示例 2：
     *
     * 输入："               ", 5
     * 输出："%20%20%20%20%20"
     *  
     *
     * 提示：
     *
     * 字符串长度在 [0, 500000] 范围内。
     */
    public String replaceSpaces(String S, int length) {
        if (S == null || S.length() == 0) {
            return "";
        }
        char[] chars = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length && i < length; i++) {
            if (chars[i] == ' ') {
                sb.append("%20");
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    public String replaceSpaces2(String S, int length) {
        if (S == null || S.length() == 0) {
            return S;
        }

        char[] chars = S.toCharArray();
        int index = chars.length - 1;
        for (int i=length-1; i>=0; i--) {
            // %20
            if (chars[i] == ' ') {
                chars[index--] = '0';
                chars[index--] = '2';
                chars[index--] = '%';
            }else {
                chars[index--] = chars[i];
            }
        }

        if (index >= 0) {
            chars = Arrays.copyOfRange(chars, index + 1, chars.length);
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        M0103 m = new M0103();
        System.out.println(m.replaceSpaces2("Mr John Smith    ", 13));
    }
}
