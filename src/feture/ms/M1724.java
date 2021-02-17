package feture.ms;

import java.util.Arrays;

/**
 * @author lanshan
 */
public class M1724 {
    /**
     * 给定一个正整数、负整数和 0 组成的 N × M 矩阵，编写代码找出元素总和最大的子矩阵。
     *
     * 返回一个数组 [r1, c1, r2, c2]，其中 r1, c1 分别代表子矩阵左上角的行号和列号，
     * r2, c2 分别代表右下角的行号和列号。若有多个满足条件的子矩阵，返回任意一个均可。
     *
     * 注意：本题相对书上原题稍作改动
     *
     * 示例：
     *
     * 输入：
     * [
     *    [-1,0],
     *    [0,-1]
     * ]
     * 输出：[0,1,0,1]
     * 解释：输入中标粗的元素即为输出所表示的矩阵
     *  
     *
     * 说明：
     *
     * 1 <= matrix.length, matrix[0].length <= 200
     */

    public int[] getMaxMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[0];
        int[][] sum = buildSum(matrix);
        int[][] area = buildArea(sum);
        int r1 = 0, c1 = 0, r2 = 0, c2 = 0, size = area[0][0];
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[i].length; j++) {
                for (int i1 = i; i1 < area.length; i1++) {
                    for (int j2 = j; j2 < area[i].length; j2++) {
                        int sa = i - 1 < 0 || j - 1 < 0 ? 0 : area[i - 1][j - 1];
                        int sc = area[i1][j2];
                        int sb = i - 1 < 0 ? 0 : area[i - 1][j2];
                        int sd = j - 1 < 0 ? 0 : area[i1][j - 1];
                        int tSize = sc - sb - sd + sa;
                        if (tSize > size) {
                            size = tSize;
                            r1 = i;
                            c1 = j;
                            r2 = i1;
                            c2 = j2;
                        }
                    }
                }
            }
        }
        return new int[] { r1, c1, r2, c2 };
    }

    public int[] getMaxMatrix2(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[0];
        int r1 = 0, c1 = 0, r2 = 0, c2 = 0, max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            int[] num = new int[matrix[i].length];
            for (int j = i; j < matrix.length; j++) {
                int pre = 0, start = 0;
                for (int k = 0; k < matrix[i].length; k++) {
                    num[k] += matrix[j][k];
                    if (num[k] > pre + num[k]) {
                        start = k;
                        pre = num[k];
                    } else {
                        pre = pre + num[k];
                    }
                    if (pre > max) {
                        r1 = i;
                        c1 = start;
                        r2 = j;
                        c2 = k;
                        max = pre;
                    }
                }
            }
        }
        return new int[] { r1, c1, r2, c2 };
    }

    private int[][] buildSum(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                res[i][j] = (j - 1 < 0 ? 0 : res[i][j - 1]) + matrix[i][j];
            }
        }
        return res;
    }

    private int[][] buildArea(int[][] sum) {
        int[][] res = new int[sum.length][sum[0].length];
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum[i].length; j++) {
                res[i][j] = (i == 0 ? 0 : res[i - 1][j]) + sum[i][j];
            }
        }
        return res;
    }

    public int maxSubArray(int[] nums) {
        findMax = nums[0];
        int i = find(nums, 0);
        System.out.println("end: "+i);
        return findMax;
    }

    int findMax;
    private int find(int[] nums, int index) {
        if (index == nums.length)
            return 0;
        int max = Math.max(find(nums, index + 1) + nums[index], nums[index]);
        System.out.println("process: max="+max);
        findMax = Math.max(findMax, max);
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int pre = 0, max = nums[0];
        for (int num : nums) {
            pre = Math.max(num, num + pre);
            max = Math.max(max, pre);
        }
        return max;
    }

    public static void main(String[] args) {
        M1724 m = new M1724();
        System.out.println(m.maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
//        System.out.println(m.maxSubArray(new int[] {1}));
//        System.out.println(m.maxSubArray(new int[] {-100}));
        System.out.println(Arrays.toString(m.getMaxMatrix2(new int[][] {{-1, 0}, {0, -1}})));
    }
}
