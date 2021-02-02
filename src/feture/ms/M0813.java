package feture.ms;

import java.util.Arrays;

/**
 * @author lanshan
 */
public class M0813 {
    /**
     * 堆箱子。给你一堆n个箱子，箱子宽 wi、深 di、高 hi。箱子不能翻转，将箱子堆起来时，下面箱子的宽度、高度和深度必须大于上面的箱子。
     * 实现一种方法，搭出最高的一堆箱子。箱堆的高度为每个箱子高度的总和。
     *
     * 输入使用数组[wi, di, hi]表示每个箱子。
     *
     * 示例1:
     *
     *  输入：box = [[1, 1, 1], [2, 2, 2], [3, 3, 3]]
     *  输出：6
     * 示例2:
     *
     *  输入：box = [[1, 1, 1], [2, 3, 4], [2, 6, 7], [3, 4, 5]]
     *  输出：10
     * 提示:
     *
     * 箱子的数目不大于3000个。
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/pile-box-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    Integer[][] temp;
    public int pileBox(int[][] box) {
        if (box==null || box.length==0)
            return 0;
        Arrays.sort(box, ((o1, o2) -> {
            if (o1[0] != o2[0])
                return o1[0] - o2[0];
            if (o1[1] != o2[1])
                return o1[1] - o2[1];
            return o1[2] - o2[2];
        }));
        temp = new Integer[box.length + 1][box.length + 1];
        return find(box, 0, 0);
    }

    /**
     * [[1, 1, 1], [2, 3, 4], [2, 6, 7], [3, 4, 5]]
     */
    private int find(int[][] box, int index, int preIndex) {
        if (index >= box.length)
            return 0;
        if (temp[index][preIndex] != null) {
            return temp[index][preIndex];
        }
        int max;
        if (preIndex == 0) {
            max = Math.max(find(box, index + 1, index + 1) + box[index][2], find(box, index + 1, 0));
        } else {
            if (box[index][0] > box[preIndex - 1][0] && box[index][1] > box[preIndex - 1][1]
                    && box[index][2] > box[preIndex - 1][2]) {
                max = Math.max(find(box, index + 1, index + 1) + box[index][2], find(box, index + 1, preIndex));
            } else {
                max = find(box, index + 1, preIndex);
            }
        }
        temp[index][preIndex] = max;
        return max;
    }

    public static void main(String[] args) {
        M0813 m = new M0813();
        System.out.println(m.pileBox(new int[][] {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}}));
        System.out.println(m.pileBox(new int[][] {{1, 1, 1}, {2, 3, 4}, {2, 6, 7},{3, 4, 5}}));
    }
}
