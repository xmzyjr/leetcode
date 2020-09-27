package feture.greedy.easy;

/**
 * @author lanshan
 */
public class LeetCode1217 {

    public int minCostToMoveChips(int[] position) {
        if (position == null || position.length <= 1)
            return 0;
        int odd = 0, even = 0;
        for (int num : position) {
            if (num % 2 == 0)
                even++;
            else 
                odd++;
        }
        return Math.min(odd, even);
    }

    public static void main(String[] args) {
        LeetCode1217 l = new LeetCode1217();
        System.out.println(l.minCostToMoveChips(new int[] {2, 2, 2, 3, 3}));
    }
}
