package feture.sort;

import java.util.Arrays;

/**
 * @author lanshan
 */
public class QuickSort {
    public int[] sort(int[] num) {
        quickSort(num, 0, num.length - 1);
        return num;
    }

    private void quickSort(int[] num, int left, int right) {
        if (left >= right)
            return;
        int t = partition(num, left, right);
        quickSort(num, left, t - 1);
        quickSort(num, t + 1, right);
    }

    private int partition(int[] num, int left, int right) {
        int temp = num[left];
        while (left < right) {
            while (left < right && num[right]>=temp)
                right--;
            num[left] = num[right];
            while (left < right && num[left] <= temp) {
                left++;
            }
            num[right] = num[left];
        }
        num[left]= temp;
        return left;
    }

    public static void main(String[] args) {
        QuickSort s = new QuickSort();
        s.sort(new int[] {3, 5, 4, 6, 1, 2});

        System.out.println(Arrays.toString(s.sort(new int[] {0, 0, 1, 0, 0, 1, 2})));
    }
}
