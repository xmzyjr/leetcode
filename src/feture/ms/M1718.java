package feture.ms;

import java.util.*;

/**
 * @author lanshan
 */
public class M1718 {
    /**
     * 假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。
     *
     * 返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。
     *
     * 示例 1:
     *
     * 输入:
     * big = [7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7]
     * small = [1,5,9]
     * 输出: [7,10]
     * 示例 2:
     *
     * 输入:
     * big = [1,2,3]
     * small = [4]
     * 输出: []
     * 提示：
     *
     * big.length <= 100000
     * 1 <= small.length <= 100000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shortest-supersequence-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] shortestSeq(int[] big, int[] small) {
        if (big == null || big.length == 0 || small == null || small.length == 0)
            return new int[0];
        int[] res = new int[]{0, big.length-1};
        int count = small.length;
        Map<Integer, Integer> map = new HashMap<>(small.length);
        for (int i : small) {
            map.put(i, -1);
        }
        for (int i = 0; i < big.length; i++) {
            if (map.containsKey(big[i])) {
                if (map.get(big[i]) == -1)
                    count--;
                map.put(big[i], i);
                if (count <= 0) {
                    int min = big.length;
                    for (Integer value :  map.values()) {
                        min = Math.min(min, value);
                    }
                    if (i - min < res[1] - res[0]) {
                        res[0] = min;
                        res[1] = i;
                    }
                }
            }
        }
        if (count > 0) {
            return new int[0];
        }
        return res;
    }


    /**
     * [842, 336, 777, 112, 789, 801, 922, 874, 634, 121, 390, 614, 179, 565, 740, 672, 624, 130, 555, 714, 9, 950, 887, 375, 312, 862, 304, 121, 360, 579, 937, 148, 614, 885, 836, 842, 505, 187, 210, 536, 763, 880, 652, 64, 272, 675, 33, 341, 101, 673, 995, 485, 16, 434, 540, 284, 567, 821, 994, 174, 634, 597, 919, 547, 340, 2, 512, 433, 323, 895, 965, 225, 702, 387, 632, 898, 297, 351, 936, 431, 468, 694, 287, 671, 190, 496, 80, 110, 491, 365, 504, 681, 672, 825, 277, 138, 778, 851, 732, 176]
     * [950, 885, 702, 101, 312, 652, 555, 936, 842, 33, 634, 851, 174, 210, 287, 672, 994, 614, 732, 919, 504, 778, 340, 694, 880, 110, 777, 836, 365, 375, 536, 547, 887, 272, 995, 121, 225, 112, 740, 567, 898, 390, 579, 505, 351, 937, 825, 323, 874, 138, 512, 671, 297, 179, 277, 304]
     */
    public static void main(String[] args) {
        M1718 m = new M1718();
        System.out.println(Arrays.toString(
                m.shortestSeq(new int[] { 7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7 }, new int[] { 1, 5, 9 })));
        System.out.println(
                Arrays.toString(m.shortestSeq(new int[] { 1, 2, 1, 2, 9 }, new int[] { 1, 2, 9 })));
        System.out.println(Arrays.toString(m.shortestSeq(
                new int[] { 842, 336, 777, 112, 789, 801, 922, 874, 634, 121, 390, 614, 179, 565, 740, 672, 624, 130,
                        555, 714, 9, 950, 887, 375, 312, 862, 304, 121, 360, 579, 937, 148, 614, 885, 836, 842, 505,
                        187, 210, 536, 763, 880, 652, 64, 272, 675, 33, 341, 101, 673, 995, 485, 16, 434, 540, 284, 567,
                        821, 994, 174, 634, 597, 919, 547, 340, 2, 512, 433, 323, 895, 965, 225, 702, 387, 632, 898,
                        297, 351, 936, 431, 468, 694, 287, 671, 190, 496, 80, 110, 491, 365, 504, 681, 672, 825, 277,
                        138, 778, 851, 732, 176 },
                new int[] { 950, 885, 702, 101, 312, 652, 555, 936, 842, 33, 634, 851, 174, 210, 287, 672, 994, 614,
                        732, 919, 504, 778, 340, 694, 880, 110, 777, 836, 365, 375, 536, 547, 887, 272, 995, 121, 225,
                        112, 740, 567, 898, 390, 579, 505, 351, 937, 825, 323, 874, 138, 512, 671, 297, 179, 277,
                        304 })));
    }
}