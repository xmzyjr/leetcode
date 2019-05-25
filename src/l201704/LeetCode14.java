package l201704;

/**
 * @author lanshan
 */
public class LeetCode14 {

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     * 示例 1:
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        char[] minStr = getMinStr(strs);

        StringBuilder sb = new StringBuilder();

        label1: for (int i = 0; i < minStr.length; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) == minStr[i]) {
                    if (j == strs.length - 1) {
                        sb.append(minStr[i]);
                    }
                } else {
                    break label1;
                }
            }
        }
        return sb.toString();
    }

    public char[] getMinStr(String[] strs) {
        int min = strs[0].length();
        String re = "";
        for (String str : strs) {
            int len = str.length();
            if (len <= min) {
                min = len;
                re = str;
            }
        }
        return re.toCharArray();
    }
}
