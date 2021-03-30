package feture.offer;

/**
 * @author lanshan
 */
public class Offer51 {
    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
     * 输入一个数组，求出这个数组中的逆序对的总数。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: [7,5,6,4]
     * 输出: 5
     *  
     *
     * 限制：
     *
     * 0 <= 数组长度 <= 50000
     */
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] num, int left, int right) {
        int t = 0;
        int t1 = 0, t2 = 0;
        if (left < right) {
            int mid = left + (right-left)/2;
            t1 = mergeSort(num, left, mid);
            t2 = mergeSort(num, mid+1, right);

            t = merge(num, left, mid, right);
        }
        return t + t1 + t2;
    }

    private int merge(int[] num, int left, int mid, int right) {
        int t = 0;
        int low = left;
        int high = mid + 1;
        int[] temp = new int[right - left + 1];
        int tempIndex = 0;
        while (low <= mid && high <= right) {
            if (num[low] <= num[high]) {
                temp[tempIndex++] = num[low++];
            } else {
                t += (mid - low + 1);
                temp[tempIndex++] = num[high++];
            }
        }
        while (low <= mid) {
            temp[tempIndex++] = num[low++];
        }
        while (high <= right) {
            temp[tempIndex++] = num[high++];
        }
        System.arraycopy(temp, 0, num, left, temp.length);
        return t;
    }

    public static void main(String[] args) {
        Offer51 o = new Offer51();
        System.out.println(o.reversePairs(new int[] {7, 5, 6, 4}));
    }
}
