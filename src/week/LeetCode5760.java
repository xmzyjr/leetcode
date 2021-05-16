package week;

/**
 * @author lanshan
 */
public class LeetCode5760 {
    /**
     * 给你一个二进制字符串 s ，现需要将其转化为一个 交替字符串 。请你计算并返回转化所需的 最小 字符交换次数，如果无法完成转化，返回 -1 。
     *
     * 交替字符串 是指：相邻字符之间不存在相等情况的字符串。例如，字符串 "010" 和 "1010" 属于交替字符串，但 "0100" 不是。
     *
     * 任意两个字符都可以进行交换，不必相邻 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "111000"
     * 输出：1
     * 解释：交换位置 1 和 4："111000" -> "101010" ，字符串变为交替字符串。
     * 示例 2：
     *
     * 输入：s = "010"
     * 输出：0
     * 解释：字符串已经是交替字符串了，不需要交换。
     * 示例 3：
     *
     * 输入：s = "1110"
     * 输出：-1
     *
     * 1 <= s.length <= 1000
     * s[i] 的值为 '0' 或 '1'
     */
    public int minSwaps(String s) {
        if (s.length() == 1)
            return 0;
        int count = 0;
        char[] chars = s.toCharArray();
        for (char j : chars) {
            count = j == '1' ? ++count : --count;
        }
        if (Math.abs(count) > 1)
            return -1;
        return Math.min(swap(chars, '1'), swap(chars, '0'));
    }

    private int swap(char[] chars, char firstChar) {
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i % 2 == 0) {
                count = chars[i] == firstChar ? count : ++count;
            } else {
                count = chars[i] != firstChar ? count : ++count;
            }
        }
        return count % 2 == 1 ? Integer.MAX_VALUE : count / 2;
    }

    public static void main(String[] args) {
        LeetCode5760 l = new LeetCode5760();
        System.out.println(l.minSwaps("111000"));
        System.out.println(l.minSwaps("010"));
        System.out.println(l.minSwaps("1110"));
        System.out.println(l.minSwaps("100"));
        System.out.println(l.minSwaps("001"));
    }
}
