package feture.bd;

import java.util.PriorityQueue;

/**
 * @author lanshan
 */
public class MedianOfTwoSortedArrays {
    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     * 示例 2：
     *
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     * 示例 3：
     *
     * 输入：nums1 = [0,0], nums2 = [0,0]
     * 输出：0.00000
     * 示例 4：
     *
     * 输入：nums1 = [], nums2 = [1]
     * 输出：1.00000
     * 示例 5：
     *
     * 输入：nums1 = [2], nums2 = []
     * 输出：2.00000
     *  
     *
     * 提示：
     *
     * nums1.length == m
     * nums2.length == n
     * 0 <= m <= 1000
     * 0 <= n <= 1000
     * 1 <= m + n <= 2000
     * -106 <= nums1[i], nums2[i] <= 106
     *
     *
     * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0)) {
            return 0;
        }
        if (nums1 == null || nums1.length == 0) {
            return getNum(nums2);
        }
        if (nums2 == null || nums2.length == 0) {
            return getNum(nums1);
        }
        int[] num = new int[nums1.length + nums2.length];
        int index1 = 0, index2 = 0;
        int i = 0;
        while (index1 != nums1.length || index2 != nums2.length) {
            if (index1 == nums1.length) {
                num[i++] = nums2[index2++];
            } else if (index2 == nums2.length) {
                num[i++] = nums1[index1++];
            } else if (nums1[index1] < nums2[index2]) {
                num[i++] = nums1[index1++];
            } else {
                num[i++] = nums2[index2++];
            }
        }
        return getNum(num);
    }

    private double getNum(int[] num) {
        int index = num.length / 2;
        if (num.length % 2 == 0) {
            return (num[index] + num[index - 1]) * 1.0 / 2;
        } else {
            return num[index];
        } 
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays m = new MedianOfTwoSortedArrays();
        System.out.println(m.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(m.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
        System.out.println(m.findMedianSortedArrays(new int[]{0,0}, new int[]{0,0}));
        System.out.println(m.findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println(m.findMedianSortedArrays(new int[]{2}, new int[]{}));
    }
//
//    private int getNum(Integer num1, Integer num2, boolean isMin) {
//        if (num1 == null)
//            return num2;
//        if (num2 == null)
//            return num1;
//        return isMin ? Math.min(num1, num2) : Math.max(num1, num2);
//    }
}
