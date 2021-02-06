
package feture.ms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author lanshan
 */
public class M1618 {

    /**
     * 你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。
     * 例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），
     * 该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。
     * 示例 1：
     * 输入： pattern = "abba", value = "dogcatcatdog"
     * 输出： true
     * 示例 2：
     * 输入： pattern = "abba", value = "dogcatcatfish"
     * 输出： false
     * 示例 3：
     * 输入： pattern = "aaaa", value = "dogcatcatdog"
     * 输出： false
     * 示例 4：
     * 输入： pattern = "abba", value = "dogdogdogdog"
     * 输出： true
     * 解释： "a"="dogdog",b=""，反之也符合规则
     * 提示：
     * 1 <= len(pattern) <= 1000
     * 0 <= len(value) <= 1000
     * 你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/pattern-matching-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    int aCount, bCount, valueLength;

    Map<Character, String> key;
    Set<String> word;
    public boolean patternMatching(String pattern, String value) {
        char[] pa = pattern.toCharArray();
        key = new HashMap<>(2);
        word = new HashSet<>(4);
        return find(pa, 0, value);
    }

    private boolean find(char[] pa, int index, String value) {
        if (index == pa.length) {
            return "".equals(value);
        }
        if (key.containsKey(pa[index])) {
            String s = key.get(pa[index]);
            if (!value.startsWith(s))
                return false;
            return find(pa, index + 1, value.substring(s.length()));
        }
        for (int i = -1; i < value.length(); i++) {
            String newKey = value.substring(0, i + 1);
            if (word.contains(newKey))
                continue;
            key.put(pa[index], newKey);
            word.add(newKey);
            boolean check = find(pa, index + 1, value.substring(newKey.length()));
            if (check)
                return true;
            key.remove(pa[index]);
            word.remove(newKey);
        }
        return false;
    }
    
//    private boolean checkLength() {
//        String a = key.get('a');
//        String b = key.get('b');
//        int aLength = a != null ? a.length() : 0;
//        int bLength = b != null ? b.length() : 0;
//        return aLength * aCount + bLength * bCount == valueLength;
//    }

    public static void main(String[] args) {
        M1618 m = new M1618();
        System.out.println(m.patternMatching("abba", "dogcatcatdog"));
        System.out.println(m.patternMatching("abba", "dogcatcatfish"));
        System.out.println(m.patternMatching("aaaa", "dogcatcatdog"));
        System.out.println(m.patternMatching("abba", "dogdogdogdog"));

    }
}
