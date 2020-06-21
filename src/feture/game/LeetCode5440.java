package feture.game;

/**
 * @author lanshan
 */
public class LeetCode5440 {

    public int xorOperation(int n, int start) {
        if (n == 0) {
            return 0;
        }
        int result = start;
        for (int i = 1; i < n; i++) {
            result ^= (start + 2 * i);
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode5440 l = new LeetCode5440();
        System.out.println(l.xorOperation(5, 0));
    }
}
