package l201906;

/**
 * @author lanshan
 */
public class LeetCode69 {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        double r = x;
        while ((int) r > x / r) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }

    public static void main(String[] args) {
        LeetCode69 l = new LeetCode69();
        System.out.println(l.mySqrt(4));
    }
}
