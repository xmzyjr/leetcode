
package l201907;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author lanshan
 */
public class LeetCode91 {

    Map<Integer, String> map = new HashMap<>();

    public int numDecodings(String s) {
        //        if (s == null || s.length() == 0) {
        //            return 0;
        //        }
        //        for (int i = 1; i <= 26; i++) {
        //            map.put(i, String.valueOf((char) ('A' + i - 1)));
        //        }
        //        Set<String> num = new HashSet<>();
        //        get(s, num, new ArrayList<>());
        //        return num.size();
        if (s.charAt(0) == '0')
            return 0;

        int[] dp = new int[s.length() + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= s.length(); i++) {
            //如果该位不为'0'，说明该位单独成字母合法
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            //如果后两位能组成"1x"（x为任意数字）或者"2x"（x小于7），说明最后两位组成字母合法
            if ((s.charAt(i - 2) == '1') || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }

    public void get(String s, Set<String> num, List<Integer> list) {
        if (s.length() == 0) {
            StringBuilder sb = new StringBuilder();
            list.forEach(i -> sb.append(map.get(i)));
            num.add(sb.toString());
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            if (i > 2) {
                break;
            }
            String substring1 = s.substring(0, i);
            if (substring1.startsWith("0")) {
                continue;
            }
            Integer substring = Integer.valueOf(substring1);
            if (substring <= 0 || substring > 26) {
                continue;
            }
            list.add(substring);
            int removeIndex = list.size() - 1;
            get(s.substring(i), num, list);
            list.remove(removeIndex);
        }
    }

    public static void main(String[] args) {
        LeetCode91 l = new LeetCode91();
        System.out.println(l.numDecodings("01"));
    }
}
