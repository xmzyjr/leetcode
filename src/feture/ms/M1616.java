package feture.ms;

import java.util.Arrays;

/**
 * @author lanshan
 */
public class M1616 {

    /**
     * 给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。
     * 注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
     *
     * 示例：
     *
     * 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
     * 输出： [3,9]
     * 提示：
     *
     * 0 <= len(array) <= 1000000
     *
     * [5,3]
     *
     * [1,2,3,1,4,5]
     */
    public int[] subSort2(int[] array) {
        int N = array.length, start = -1, end = -1;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        // 从前往后找目标末位，使得从该位到最后，数组保持递增
        for (int i = 0; i < N; i++) {
            if (array[i] >= max) max = array[i];
            else end = i;
        }

        // 数组恒递增，说明数组是有序的，直接返回
        if (end == -1) return new int[] {-1, -1};

        // 从后往前找目标首位，使得从该位到最前，数组保持递减
        for (int i = end; i >= 0; i--) {
            if (array[i] <= min) min = array[i];
            else start = i;
        }
        return new int[] {start, end};
    }

    public int[] subSort(int[] array) {
        if (array == null || array.length < 2)
            return new int[] { -1, -1 };
        int left = -1, right = -1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                left = i;
                break;
            }
        }
        if (left == -1) {
            return new int[] { -1, -1 };
        }
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] > array[i + 1] || array[i] < array[left - 1]) {
                right = i;
                break;
            }
        }
        if (left > right) {
            return new int[] { 0, array.length - 1 };
        }
        int min = array[left], max = array[left];
        for (int i = left; i <= right; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        int leftIndex = -1, rightIndex = -1;
        leftLab: for (int i = 0; i < array.length; i++) {
            if (array[i] > min) {
                leftIndex = i;
                break;
            } else if (array[i] == min) {
                while (++i < array.length) {
                    if (array[i] != min) {
                        leftIndex = i;
                        break leftLab;
                    }

                }
            }
        }
        rightLab: for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] < max) {
                rightIndex = i;
                break;
            } else if (array[i] == max) {
                while (--i >= 0) {
                    if (array[i] != max) {
                        rightIndex = i;
                        break rightLab;
                    }
                }
            }
        }
        return new int[] { leftIndex, rightIndex };
    }

    public static void main(String[] args) {
        M1616 m = new M1616();
        System.out.println(Arrays.toString(m.subSort(new int[] {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19})));
        System.out.println(Arrays.toString(m.subSort(new int[]{5,4,3,2,1})));
        System.out.println(Arrays.toString(m.subSort(new int[]{4,6})));
        System.out.println(Arrays.toString(m.subSort(new int[]{6,4})));
        System.out.println(Arrays.toString(m.subSort(new int[]{1,2,3})));
        System.out.println(Arrays.toString(m.subSort(new int[]{3,2,1})));
        System.out.println(Arrays.toString(m.subSort(new int[]{1,2,3,1,4,5})));
    }
}
