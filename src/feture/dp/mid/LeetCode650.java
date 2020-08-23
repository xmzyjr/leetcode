package feture.dp.mid;

import feture.util.LeetCodeUtil;

/**
 * @author lanshan
 */
public class LeetCode650 {
    public int minSteps2(int n) {
        if (n == 1)
            return 0;
        if (n == 2 || n == 3) {
            return n;
        }
        int[] res = new int[n+1];
        res[2] = 2;
        res[3] = 3;
        for (int i = 4; i <= n; i++) {

        }
        LeetCodeUtil.printList(res);
        return res[n];
    }

    int[][] res;
    public int minSteps3(int n) {
        if (n == 1)
            return 0;
        if (n == 2 || n == 3) {
            return n;
        }
        res = new int[n+1][n+1];
        return find(n, 1, 1);
    }

    private int find(int n, int now, int k) {
        if (now > n) {
            return Integer.MAX_VALUE;
        }
        if (now == n)
            return 1;
        if (res[now][k]!=0)
            return res[now][k];
        int step1 = find(n, now + k, k);
        if (step1 != Integer.MAX_VALUE)
            step1 += 1;
        int step2 = find(n, now * 2, now);
        if (step2 != Integer.MAX_VALUE)
            step2 += 2;
        int min = Math.min(step1, step2);
        res[now][k] = min;
        return min;
    }


//    public int minSteps(int n) {
//        if (n == 1)
//            return 0;
//        if (n == 2 || n == 3) {
//            return n;
//        }
//
//    }


    public static void main(String[] args) {
        LeetCode650 l = new LeetCode650();
        System.out.println(l.minSteps3(4));
    }
}
