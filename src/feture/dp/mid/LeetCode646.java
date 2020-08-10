package feture.dp.mid;

import java.util.Arrays;

/**
 * @author lanshan
 */
public class LeetCode646 {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0)
            return 0;
        if (pairs.length == 1)
            return 1;
        Arrays.sort(pairs, (o1, o2) -> {
            if (o1[0] != o2[0])
                return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        int[] res = new int[pairs.length];
        for (int i = pairs.length - 1; i >= 0; i--) {
            for (int j = pairs.length - 1; j >= i; j--) {
                if (i == j){
                    res[i] = Math.max(1, res[i]);
                } else {
                    if (pairs[i][1]< pairs[j][0])
                        res[i] = Math.max(res[i], res[j]+1);
                }
            }
        }
        int max = 0;
        for (int re : res) {
            max = Math.max(max, re);
        }
        return max;
    }
    
    
}
