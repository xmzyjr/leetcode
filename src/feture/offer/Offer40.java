package feture.offer;

import java.util.Arrays;

/**
 * @author lanshan
 */
public class Offer40 {
    /**
     * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：arr = [3,2,1], k = 2
     * 输出：[1,2] 或者 [2,1]
     * 示例 2：
     *
     * 输入：arr = [0,1,2,1], k = 1
     * 输出：[0]
     *  
     *
     * 限制：
     *
     * 0 <= k <= arr.length <= 10000
     * 0 <= arr[i] <= 10000
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return new int[0];
        }
        if (k >= arr.length) {
            return arr;
        }
        int[] num = new int[k];
        System.arraycopy(arr, 0, num, 0, k);
        for (int i = num.length / 2 - 1; i >= 0; i--) {
            adjust(num, i, num.length);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < num[0]) {
                num[0] = arr[i];
                adjust(num, 0, num.length);
            }
        }
        return num;
    }

    private void adjust(int[] num, int index, int length) {
        int temp = num[index];
        for (int i = index * 2 + 1; i < length; i = i * 2 + 1) {
            if (i + 1 < length && num[i + 1] > num[i]) {
                i++;
            }
            if (num[i] > temp) {
                num[index] = num[i];
                index = i;
            } else {
                break;
            }
        }
        num[index] = temp;
    }

    public static void main(String[] args) {
        int[] num = new int[] { 10, 0, 2, 1, 28, 52, 1, 10, 1, 26, 4, 33, 5, 27, 3, 31, 7, 7, 12, 11, 36, 15, 10, 2, 7,
                44, 7, 8, 23, 56, 0, 5, 22, 2, 49, 63, 16, 8, 10, 1, 2, 19, 9, 12, 9, 7, 5, 18, 20, 2, 2, 17, 2, 3, 22,
                15, 2, 8, 19, 22, 56, 17, 8, 6, 1, 19, 19, 6, 6, 22, 27, 26, 29, 1, 32 };
        Arrays.sort(num);
        System.out.println(Arrays.toString(num));
    }
}
