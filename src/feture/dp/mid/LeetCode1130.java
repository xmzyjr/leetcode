
package feture.dp.mid;

/**
 * @author lanshan
 */
public class LeetCode1130 {

    public int mctFromLeafValues2(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, find2(arr, i, i, arr[i]));
        }
        return min;
    }

    private int find2(int[] arr, int i, int j, int tempMax) {
        if (i == 0 && j == arr.length - 1) {
            return 0;
        }
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if (i - 1 >= 0) {
            left = find2(arr, i - 1, j, Math.max(tempMax, arr[i - 1])) + tempMax * arr[i - 1];
        }
        if (j + 1 < arr.length) {
            right = find2(arr, i, j + 1, Math.max(tempMax, arr[j + 1])) + tempMax * arr[j + 1];
        }
        return Math.min(left, right);
    }

    /**
     * 从理解上，[1, length-1] 中间，
     *  1-1,1-2,1-3,1-4....,1-length-1
     *  2-2,2-3,2-4,...,2-length-1
     *  ....
     *  k-k,...k-length-1
     *  ...
     *  length-2-length-2, length-2,length-1
     *  这些子数组中，需要分成两块。
     *  因为题意在于，左块和右块，最大值的乘积，并且在[i,j] 这个区间中需要找到一个k值，使得[i,k],[k+1,j] 两块最大值的乘积最小
     * @return {在[i,j]区间上最小的乘积，在[i,j]区间上最大的数}
     */
    private int[] find3(int[] arr, int i, int j) {
        if (res[i][j][1]>0) {
            return res[i][j];
        }
        if (i == j) {
            return new int[] { 0, arr[i] };
        }
        int minAns = Integer.MAX_VALUE;
        int max = 0;
        for (int k = i; k < j; k++) {
            int[] left = find3(arr, i, k);
            int[] right = find3(arr, k+1, j);
            minAns = Math.min(minAns, left[0] + right[0] + left[1] * right[1]);
            max = Math.max(left[1], right[1]);
        }
        res[i][j] = new int[]{ minAns, max };
        return res[i][j];
    }

    int[][][] res;
    public int mctFromLeafValues(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        res = new int[arr.length][arr.length][2];
        find3(arr, 0, arr.length - 1);
        return res[0][arr.length-1][0];
    }

    private int find(int[] arr, int index, int leftMax) {
        if (index >= arr.length || index < 0)
            return 0;
        int i = find(arr, index + 1, Math.max(leftMax, arr[index])) + arr[index] * leftMax;
        int j = Integer.MAX_VALUE;
        if (index + 1 < arr.length) {
            int tempMax = Math.max(arr[index], arr[index + 1]);
            j = find(arr, index + 2, Math.max(leftMax, tempMax)) + arr[index] * arr[index + 1] + leftMax * tempMax;
        }
        return Math.min(i, j);
    }

    public int mctFromLeafValues1(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int[] leftMax = new int[arr.length];
        // leftMax, 便于计算后续的leftMax值
        leftMax[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            leftMax[i] = Math.max(arr[i - 1], leftMax[i - 1]);
        }
        // 0位置左边最小等于0
        leftMax[0] = 0;
        print(leftMax);
        int[] res = new int[arr.length + 1];
        for (int i = arr.length - 1; i >= 0; i--) {
            int iNum = res[i + 1] + arr[i] * leftMax[i];
            int jNum = Integer.MAX_VALUE;
            if (i + 1 < arr.length) {
                int tempMax = Math.max(arr[i], arr[i + 1]);
                jNum = res[i + 2] + arr[i] * arr[i + 1] + leftMax[i] * tempMax;
            }
            res[i] = Math.min(iNum, jNum);
        }
        print(res);
        return res[0];
    }

    private void print(int[] arr) {
        return;
        //        for (int i = 0; i < arr.length; i++) {
        //            System.out.print(arr[i]+" ");
        //        }
        //        System.out.println();
    }

    public static void main(String[] args) {
        LeetCode1130 l = new LeetCode1130();
        System.out.println(l.mctFromLeafValues2(new int[] { 6, 2, 4 }));
        System.out.println(l.mctFromLeafValues2(new int[] { 6, 2, 4 }));
        //        System.out.println(l.mctFromLeafValues(new int[] { 4, 2, 6 }));
        //        System.out.println(l.mctFromLeafValues(new int[] { 1, 2, 3, 4 }));
        //        System.out.println(l.mctFromLeafValues(new int[] { 4, 3, 2, 1 }));
        System.out.println(l.mctFromLeafValues2(new int[] { 15, 13, 5, 3, 15 }));
        //        System.out.println(l.mctFromLeafValues(new int[] { 15, 3, 5, 13, 15 }));
                System.out.println(l.mctFromLeafValues2(new int[] { 15, 1, 1, 1, 1 }));
                System.out.println(l.mctFromLeafValues2(new int[] { 3,7,2,12,15,10,3,9 }));

    }
}
