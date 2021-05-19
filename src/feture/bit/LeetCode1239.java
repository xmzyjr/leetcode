package feture.bit;

import java.util.Arrays;
import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode1239 {
    /**
     * 给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
     *
     * 请返回所有可行解 s 中最长长度。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：arr = ["un","iq","ue"]
     * 输出：4
     * 解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4。
     * 示例 2：
     *
     * 输入：arr = ["cha","r","act","ers"]
     * 输出：6
     * 解释：可能的解答有 "chaers" 和 "acters"。
     * 示例 3：
     *
     * 输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
     * 输出：26
     *  
     *
     * 提示：
     *
     * 1 <= arr.length <= 16
     * 1 <= arr[i].length <= 26
     * arr[i] 中只含有小写英文字母
     */
    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0)
            return 0;
        return find(arr, 0, 0);
    }

    private int find(List<String> arr, int index, int bit) {
        if (index == arr.size())
            return 0;
        String now = arr.get(index);
        int newBit = check(bit, now);
        if (newBit == -1) {
            return find(arr, index + 1, bit);
        }
        return Math.max(find(arr, index + 1, bit), find(arr, index + 1, newBit) + now.length());
    }

    private int check(int bit, String str) {
        char[] chars = str.toCharArray();
        int temp = 0;
        for (char aChar : chars) {
            int i = 1 << (aChar - 'a');
            if ((i & temp) != 0)
                return -1;
            temp |= i;
            if ((temp & bit) != 0)
                return -1;
        }
        return bit | temp;
    }

    public static void main(String[] args) {
        LeetCode1239 l = new LeetCode1239();
        System.out.println(l.maxLength(Arrays.asList("un", "iq", "ue")));
        System.out.println(l.maxLength(Arrays.asList("cha","r","act","ers")));
        System.out.println(l.maxLength(Arrays.asList("abcdefghijklmnopqrstuvwxyz")));
        System.out.println(l.maxLength(Arrays.asList("ueu")));
    }
}
