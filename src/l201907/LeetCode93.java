
package l201907;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode93 {

    /**
     * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
     * 示例:
     * 输入: "25525511135"
     * 输出: ["255.255.11.135", "255.255.111.35"]
     */
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4 || s.length() > 12) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        get(s, 1, 0, "", res);
        return res;
    }

    public void get(String s, int indexNow, int index, String now, List<String> res) {
        if (indexNow > 3) {
            return;
        }
        if ((index == 1 && (s.length() > 9 || s.length() < 3)) || (index == 2 && (s.length() > 6 || s.length() < 2))
                || (index == 3 && (s.length() > 3 || s.length() < 1))) {
            return;
        }
        if (index == 3) {
            Integer value = Integer.valueOf(s);
            if (value >= 0 && value <= 255 && !checkNotZeroStart(s)) {
                now += s;
                res.add(now);
            }
            return;
        }
        if (s.length() >= indexNow) {
            String substring = s.substring(0, indexNow);
            Integer value = Integer.valueOf(substring);
            if (value >= 0 && value <= 255 && !checkNotZeroStart(substring)) {
                get(s.substring(indexNow), 1, index + 1, now + substring + ".", res);
            }
        }
        get(s, indexNow + 1, index, now, res);
    }

    public boolean checkNotZeroStart(String s) {
        return s.length() > 1 && s.startsWith("0");
    }

    public static void main(String[] args) {
        LeetCode93 l = new LeetCode93();
        System.out.println(l.restoreIpAddresses("010010"));
    }
}
