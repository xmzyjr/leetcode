
package feture.ms;

import java.util.Arrays;

/**
 * @author lanshan
 */
public class M1708 {

    /**
     * 有个马戏团正在设计叠罗汉的表演节目，一个人要站在另一人的肩膀上。
     * 出于实际和美观的考虑，在上面的人要比下面的人矮一点且轻一点。已知马戏团每个人的身高和体重，请编写代码计算叠罗汉最多能叠几个人。
     * 示例：
     * 输入：height = [65,70,56,75,60,68] weight = [100,150,90,190,95,110]
     * 输出：6
     * 解释：从上往下数，叠罗汉最多能叠 6 层：(56,90), (60,95), (65,100), (68,110), (70,150), (75,190)
     * height.length == weight.length <= 10000
     */
    Integer[][] temp;

    public int bestSeqAtIndex(int[] height, int[] weight) {
        if (height == null || height.length == 0 || weight == null || weight.length == 0)
            return 0;
        int[][] t = new int[height.length][2];
        for (int i = 0; i < t.length; i++) {
            t[i][0] = height[i];
            t[i][1] = weight[i];
        }
        Arrays.sort(t, ((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[1] - o2[1];
        }));
        temp = new Integer[t.length + 1][t.length + 1];
        return find(t, -1, 0);
    }

    private int find(int[][] t, int pre, int index) {
        if (index >= t.length)
            return 0;
        if (temp[index][pre] != null) {
            return temp[index][pre];
        }
        int max;
        if (pre == 0) {
            max = Math.max(find(t, 0, index + 1), find(t, index + 1, index + 1) + 1);
        } else {
            if (t[index][0] > t[pre - 1][0] && t[index][1] > t[pre - 1][1]) {
                max = Math.max(find(t, pre, index + 1), find(t, index + 1, index + 1) + 1);
            } else {
                max = find(t, pre, index + 1);
            }
        }
        temp[index][pre] = max;
        return max;
    }

    public int bestSeqAtIndex2(int[] height, int[] weight) {
        if (height == null || height.length == 0 || weight == null || weight.length == 0)
            return 0;
        int[][] t = new int[height.length][2];
        for (int i = 0; i < t.length; i++) {
            t[i][0] = height[i];
            t[i][1] = weight[i];
        }
        Arrays.sort(t, ((o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]));
        int len = 1;
        int[] num = new int[t.length + 1];
        num[0] = t[0][1];
        for (int[] ints : t) {
            int i = Arrays.binarySearch(num, 0, len, ints[1]);
            if (i < 0) {
                i = -(i+1);
            }
            num[i] = ints[1];
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] num = new int[] { 1 };
        System.out.println(Arrays.binarySearch(num, 0, num.length, 2));
    }
}
