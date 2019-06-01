package l201904;

/**
 * @author lanshan
 */
public class LeetCode6 {

    public int reverse(int x) {
        long sum = 0;
        boolean flag = true;
        if (x < 0) {
            x = -x;
            flag = false;
        }
        while (x > 0) {
            sum *= 10;
            sum += (x % 10);
            x = x / 10;
        }
        if (sum < Integer.MIN_VALUE || sum > Integer.MAX_VALUE) {
            return 0;
        } else {
            return flag ? (int) sum : (int) -sum;
        }
    }
}
