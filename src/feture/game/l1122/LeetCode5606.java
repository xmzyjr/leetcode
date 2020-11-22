package feture.game.l1122;

/**
 * @author lanshan
 */
public class LeetCode5606 {
    public String getSmallestString(int n, int k) {
        char[] res = new char[n];
        int leave = k - n;
        int right = leave / 25;
        int right1 = leave % 25;
        boolean right1Flag = false;
//        StringBuilder sb = new StringBuilder();
        for (int i = n-1, count = 1; i >= 0; i--, count++) {
            if (count <= right) {
//                sb.insert(0, 'z');
                res[i] = 'z';
                continue;
            }
            if (!right1Flag) {
//                sb.insert(0, (char) ('a' + right1));
                res[i] = (char) ('a' + right1);
                right1Flag = true;
                continue;
            }
            res[i] = 'a';
//            sb.insert(0, 'a');
        }
        return String.valueOf(res);
//        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode5606 l = new LeetCode5606();
        System.out.println(l.getSmallestString(3, 27));
        System.out.println(l.getSmallestString(5, 73));
    }
}
