package feture.ms;

/**
 * @author lanshan
 */
public class M1610 {
    /**
     * 给定 N 个人的出生年份和死亡年份，第 i 个人的出生年份为 birth[i]，死亡年份为 death[i]，实现一个方法以计算生存人数最多的年份。
     *
     * 你可以假设所有人都出生于 1900 年至 2000 年（含 1900 和 2000 ）之间。如果一个人在某一年的任意时期处于生存状态，那么他应该被纳入那一年的统计中。
     * 例如，生于 1908 年、死于 1909 年的人应当被列入 1908 年和 1909 年的计数。
     *
     * 如果有多个年份生存人数相同且均为最大值，输出其中最小的年份。
     *
     *  
     *
     * 示例：
     *
     * 输入：
     * birth = {1900, 1901, 1950}
     * death = {1948, 1951, 2000}
     * 输出： 1901
     *  
     *
     * 提示：
     *
     * 0 < birth.length == death.length <= 10000
     * birth[i] <= death[i]
     */
    public int maxAliveYear(int[] birth, int[] death) {
        int[] num = new int[101];
        for (int i = 0; i < birth.length; i++) {
            for (int j = birth[i] - 1900; j <= death[i]-1900 ; j++) {
                num[j]++;
            }
        }
        int max = num[0];
        int res = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] > max) {
                max = num[i];
                res = i;
            }
        }
        return 1900 + res;
    }
}
