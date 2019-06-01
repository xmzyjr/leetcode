package l201904;

import java.util.Arrays;

/**
 * @author lanshan
 * <p>
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 */
public class LeetCode4 {

    /**
     * 示例 1:
     * <p>
     * nums1 = [1, 3]
     * nums2 = [2]
     * <p>
     * 则中位数是 2.0
     * 示例 2:
     * <p>
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * <p>
     * 则中位数是 (2 + 3)/2 = 2.5
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] num = new int[nums1.length + nums2.length];
        if (nums1.length != 0) {
            System.arraycopy(nums1, 0, num, 0, nums1.length);
        }
        if (nums2.length != 0) {
            System.arraycopy(nums2, 0, num, nums1.length, nums2.length);
        }
        Arrays.sort(num);
        if (num.length == 0) {
            return 0.0;
        }
        if (num.length % 2 == 0) {
            return (num[num.length / 2] + num[num.length / 2 - 1]) * 1.0 / 2;
        }else {
            return num[num.length/2];
        }
    }


}
