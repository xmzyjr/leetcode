
package feture.game.l0816;

import java.util.Arrays;

/**
 * @author lanshan
 */
public class L5490 {

    public int minDays(int n) {
        if (n < 1)
            return 0;
        if (n==1) {
            return 1;
        }
        if (n==2) {
            return 2;
        }
        if (n==3) {
            return 2;
        }
        int[] num = new int[n + 1];
        num[1] = 1;
        num[2] = 2;
        num[3] = 2;
        for (int i = 4; i <= n; i++) {
            System.out.println("i="+ i);
            if ((i % 2 == 0) && (i % 3 == 0)) {
                System.out.println(" " + (i - i / 2) + " " + (i - 2 * (i / 3)));
                int temp = Math.min(num[i - i / 2], num[i - 2 * (i / 3)]);
                num[i] = Math.min(temp, num[i - 1]) + 1;
            } else if (i % 2 == 0) {
                System.out.println(" " + (i - i / 2));
                num[i] = Math.min(num[i - i / 2], num[i - 1]) + 1;
            } else if (i % 3 == 0) {
                System.out.println(" " + (i - 2 * (i / 3)));
                num[i] = Math.min(num[i - 2 * (i / 3)], num[i - 1]) + 1;
            } else {
                System.out.println(" " + (i-1));
                num[i] = num[i - 1] + 1;
            }
        }
        System.out.println(Arrays.toString(num));
        return num[n];
    }

    public static void main(String[] args) {
        L5490 l = new L5490();
        System.out.println(l.minDays(182));
    }
}
