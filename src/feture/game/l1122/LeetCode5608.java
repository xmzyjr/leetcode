
package feture.game.l1122;

import java.util.Arrays;

/**
 * @author lanshan
 */
public class LeetCode5608 {

    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (o1, o2) -> {
            int i = o1[1] - o1[0];
            int j = o2[1] - o2[0];
            if (i == j) {
                return o1[0] - o2[0];
            }
            return j - i;
        });
        int now = 0;
        int result = 0;
        for (int[] task : tasks) {
            result += task[1] > now ? (task[1] - now) : 0;
            now = now > task[1] ? now - task[0] : (task[1] - task[0]);
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode5608 l = new LeetCode5608();
        System.out.println(l.minimumEffort(new int[][] {{1,2},{2,4},{4,8}}));
        System.out.println(l.minimumEffort(new int[][] { { 1, 1 }, { 1, 3 } }));
    }
}
