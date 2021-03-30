package feture.sort;

import java.util.Arrays;

/**
 * @author lanshan
 */
public class MergeSort {

    public int[] sort(int[] num) {
        mergeSort(num, 0, num.length - 1);
        return num;
    }
    
    private void mergeSort(int[] num, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(num, left, mid);
            mergeSort(num, mid + 1, right);
            merge(num, left, mid, right);
        }
    }

    private void merge(int[] num, int left, int mid, int right) {
        int low = left, high = mid + 1;
        int[] temp = new int[right - left + 1];
        int tempIndex = 0;
        while (low <= mid && high <= right) {
            temp[tempIndex++] = num[low] < num[high] ? num[low++] : num[high++]; 
        }
        while (low <= mid) {
            temp[tempIndex++] = num[low++];
        }
        while (high <= right) {
            temp[tempIndex++] = num[high++];
        }
        System.arraycopy(temp, 0, num, left, temp.length);
    }

    public static void main(String[] args) {
        MergeSort m = new MergeSort();
        System.out.println(Arrays.toString(m.sort(new int[] {6, 5, 4, 3, 2, 1})));
    }
}
