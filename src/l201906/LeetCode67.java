
package l201906;

/**
 * @author lanshan
 */
public class LeetCode67 {

    /**
     * 给定两个二进制字符串，返回他们的和（用二进制表示）。
     * 输入为非空字符串且只包含数字 1 和 0。
     * 示例 1:
     * 输入: a = "11", b = "1"
     * 输出: "100"
     * 示例 2:
     * 输入: a = "1010", b = "1011"
     * 输出: "10101"
     */
    public String addBinary(String a, String b) {
        if (a == null && b != null) {
            return b;
        } else if (a != null && b == null) {
            return a;
        } else if (a == null) {
            return null;
        }
        char[] chars = a.toCharArray();
        char[] chars1 = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i, j;
        int out = 0;
        for (i = chars.length - 1, j = chars1.length - 1; i >= 0 && j >= 0; i--, j--) {
            int now = (chars[i] - '0') + (chars1[j] - '0') + out;
            if (now == 2) {
                sb.insert(0, 0);
                out = 1;
            } else if (now == 3) {
                sb.insert(0, 1);
                out = 1;
            } else {
                sb.insert(0, now);
                out = 0;
            }
        }
        if (i >= 0) {
            for (int i1 = i; i1 >= 0; i1--) {
                int now = chars[i1] - '0' + out;
                if (now == 2) {
                    sb.insert(0, 0);
                    out = 1;
                } else {
                    sb.insert(0, now);
                    out = 0;
                }
            }
        }
        if (j >= 0) {
            for (int i1 = j; i1 >= 0; i1--) {
                int now = chars1[i1] - '0' + out;
                if (now == 2) {
                    sb.insert(0, 0);
                    out = 1;
                } else {
                    sb.insert(0, now);
                    out = 0;
                }
            }
        }
        if (out == 1) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode67 l = new LeetCode67();
        System.out.println(l.addBinary("11", "1"));
    }
}
