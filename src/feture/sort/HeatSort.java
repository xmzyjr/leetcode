package feture.sort;

import java.util.Arrays;

/**
 * @author lanshan
 */
public class HeatSort {

    public int[] sort(int[] num) {
        // 先生存大顶堆
        for (int i = num.length / 2 - 1; i >= 0; i--) {
            adjust(num, i, num.length);
        }
        for (int i = num.length-1; i >= 0; i--) {
            swap(num, 0, i);
            adjust(num, 0, i);
        }
        return num;
    }

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    private void adjust(int[] num, int index, int length) {
        int temp = num[index];
        for (int k = 2 * index + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && num[k + 1] > num[k]) {
                k++;
            }
            if (num[k] > temp) {
                num[index] = num[k];
                index = k;
            } else {
                break;
            }
        }
        num[index] = temp;
    }

    /**
     * [0,1,1,1,4,5,3,7,7,8,10,2,7,8,0,5,2,16,12,1,19,15,5,18,2,2,22,15,8,22,17,6,22,6,22,26,32,8,10,11,2,26,9,12,9,7,28,33,20,7,2,17,44,3,52,27,2,23,19,56,56,58,36,31,1,19,19,6,65,49,27,63,29,1,69,47,56,61,40,43,10,71,60,66,42,44,10,12,83,69,73,2,65,93,92,47,35,39,13,75]
     */
    public static void main(String[] args) {
        HeatSort h = new HeatSort();
        System.out.println(Arrays.toString(h.sort(new int[] {5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(h.sort(new int[] { 0, 1, 1, 1, 4, 5, 3, 7, 7, 8, 10, 2, 7, 8, 0, 5, 2, 16,
                12, 1, 19, 15, 5, 18, 2, 2, 22, 15, 8, 22, 17, 6, 22, 6, 22, 26, 32, 8, 10, 11, 2, 26, 9, 12, 9, 7, 28,
                33, 20, 7, 2, 17, 44, 3, 52, 27, 2, 23, 19, 56, 56, 58, 36, 31, 1, 19, 19, 6, 65, 49, 27, 63, 29, 1, 69,
                47, 56, 61, 40, 43, 10, 71, 60, 66, 42, 44, 10, 12, 83, 69, 73, 2, 65, 93, 92, 47, 35, 39, 13, 75 })));
    }
}
