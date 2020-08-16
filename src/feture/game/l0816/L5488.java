
package feture.game.l0816;

/**
 * @author lanshan
 */
public class L5488 {

    public int minOperations(int n) {
        if (n <= 1) {
            return 0;
        }
        int num = n / 2;
        int count = 0;
        if (n % 2 == 0) {
            for (int i = 0; i < num; i++) {
                count += (n - 2 * i - 1);
            }
        } else {
            for (int i = 0; i <= num; i++) {
                count += (n - 2 * i - 1);
            }
        }
        return count;
    }
}
