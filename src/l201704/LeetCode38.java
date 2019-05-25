
package l201704;

/**
 * @author lanshan
 */
public class LeetCode38 {

    public String countAndSay(int n) {
        String str = "1";
        StringBuilder sb;
        if (n == 1) {
            return str;
        } else if (n == 2) {
            str = "11";
            return str;
        } else {
            str = "11";
            for (int i = 2; i < n; i++) {
                int count = 1;
                sb = new StringBuilder();
                int j;
                for (j = 1; j < str.length(); j++) {
                    if (str.charAt(j) == str.charAt(j - 1)) {
                        count++;
                    } else {
                        sb.append(count);
                        sb.append(str.charAt(j - 1));
                        count = 1;
                    }
                }
                if (count > 0) {
                    sb.append(count);
                    sb.append(str.charAt(j - 1));
                }
                str = sb.toString();
            }
        }
        return str;
    }

    public static void main(String[] args) {
        LeetCode38 l = new LeetCode38();
        System.out.println(l.countAndSay(5));
    }

}
