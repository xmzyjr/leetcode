
package feture.dp.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode279 {

    public int numSquares(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        List<Integer> num = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            num.add(i * i);
        }
        int row = num.size();
        int[] res = new int[n+1];
        for (int j = 1; j < n + 1; j++) {
            res[j] = j;
        }
        for (int i = 1; i < row; i++) {
            Integer nu = num.get(i);
            for (int j = nu; j < n + 1; j++) {
                res[j] = Math.min(j / nu + res[j % nu], res[j]);
            }
        }
        return res[n];
    }

    public static void main(String[] args) {
        LeetCode279 l = new LeetCode279();
        System.out.println(l.numSquares(12));
    }

}
