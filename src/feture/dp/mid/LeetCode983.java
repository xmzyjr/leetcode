package feture.dp.mid;

/**
 * @author lanshan
 */
public class LeetCode983 {
    static class Solution {
        Integer[] mem;
        public int mincostTickets(int[] days, int[] costs) {
            if (days == null || days.length == 0)
                return 0;
            mem = new Integer[days.length];
            return find(days, costs, 0, 0);
        }

        public int find(int[] days, int[] costs, int index, int targetDay) {
            if (index == days.length) {
                return 0;
            }
            if (days[index] <= targetDay) {
                return find(days, costs, index+1, targetDay);
            }
            if (mem[index]!=null) {
                return mem[index];
            }
            int one = find(days, costs, index+1, days[index]) + costs[0];
            int two = find(days, costs, index+1, days[index] + 6) + costs[1];
            int three = find(days, costs, index+1, days[index]+29) + costs[2];
            int min = Math.min(one, Math.min(two, three));
            mem[index] = min;
            return min;
        }

        public static void main(String[] args) {
            Solution s = new Solution();
            System.out.println(s.mincostTickets(new int[] {1, 4, 6, 7, 8, 20}, new int[] {2, 7, 15}));
        }

    }
}
