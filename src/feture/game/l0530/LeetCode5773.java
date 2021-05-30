package feture.game.l0530;

/**
 * @author lanshan
 */
public class LeetCode5773 {

    public String maxValue(String n, int x) {
        boolean flag = false;
        if (n.charAt(0) == '-')
            flag = true;
        return find(n, flag, x);
    }

    private String find(String n, boolean flag, int x) {
        char[] chars = n.toCharArray();
        StringBuilder sb = new StringBuilder(n);
        int i;
        if (flag) {
            for (i = 0; i < chars.length; i++) {
                if ((chars[i] - '0') > x) {
                    break;
                }
            }
        } else {
            // 正数，找到第一个比x小的，进行插入
            for (i = 0; i < chars.length; i++) {
                if ((chars[i] - '0') < x) {
                    break;
                }
            }
        }
        if (i == chars.length) {
            sb.append(x);
        } else {
            sb.insert(i, x);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode5773 l = new LeetCode5773();
        System.out.println(l.maxValue("99", 9));
        System.out.println(l.maxValue("-13", 2));
    }
}
