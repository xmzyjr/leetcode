package feture.dp.mid;

/**
 * @author lanshan
 */
public class LeetCode1039 {

    Integer[][] map;
    public int minScoreTriangulation(int[] A) {
        if (A == null || A.length<3)
            return 0;
        map = new Integer[A.length][A.length];
        return find(A, 0, A.length - 1);
    }

    private int find(int[]a, int start, int end) {
        if (map[start][end]!=null){
            return map[start][end];
        }
        if (start == end || end - start == 1) {
            map[start][end] = 0;
            return 0;
        }
            
        int min = Integer.MAX_VALUE;
        for (int i = start + 1; i < end; i++) {
            min = Math.min(find(a, start, i) + a[start] * a[i] * a[end] + find(a, i, end), min);
        }
        map[start][end] = min;
        return min;
    }


    public static void main(String[] args) {
        LeetCode1039 l = new LeetCode1039();
        System.out.println(l.minScoreTriangulation(new int[] {1, 3, 1, 4, 1, 5}));
    }

}
