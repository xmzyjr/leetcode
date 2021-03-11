package feture.ms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author lanshan
 */
public class M1720 {
    /**
     * 随机产生数字并传递给一个方法。你能否完成这个方法，在每次产生新值时，寻找当前所有值的中间值（中位数）并保存。
     *
     * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
     *
     * 例如，
     *
     * [2,3,4] 的中位数是 3
     *
     * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
     *
     * 设计一个支持以下两种操作的数据结构：
     *
     * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
     * double findMedian() - 返回目前所有元素的中位数。
     * 示例：
     *
     * addNum(1)
     * addNum(2)
     * findMedian() -> 1.5
     * addNum(3)
     * findMedian() -> 2
     *
     */
    static class MedianFinder {

        List<Integer> res;

        /** initialize your data structure here. */
        public MedianFinder() {
            res = new ArrayList<>();
        }

        public void addNum(int num) {
            if (res.isEmpty()) {
                res.add(num);
            } else {
                if (num <= res.get(0)) {
                    res.add(0, num);
                } else if (num >= res.get(res.size() - 1)) {
                    res.add(num);
                } else {
                    res.add(num);
                    res.sort(Comparator.comparingInt(o -> o));
                }
            }
        }

        public double findMedian() {
            if (res.isEmpty()) {
                return 0;
            } else {
                int size = res.size();
                if (size % 2 == 1) {
                    return res.get(size / 2);
                } else {
                    return (res.get(size / 2 - 1) + res.get(size / 2)) * 1.0 / 2;
                }
            }
        }

        /**
         * ["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
         * [[],[6],[],[10],[],[2],[],[6],[],[5],[],[0],[],[6],[],[3],[],[1],[],[0],[],[0],[]]
         *
         *
         * [null,null,6.0,null,8.0,null,6.0,null,6.0,null,6.0,null,5.5,null,6.0,null,5.5,null,5.0,null,4.0,null,3.0]
         */
        public static void main(String[] args) {
            MedianFinder mf = new MedianFinder();
            mf.addNum(6);
            System.out.println(mf.findMedian());
            mf.addNum(10);
            System.out.println(mf.findMedian());
            mf.addNum(2);
            System.out.println(mf.findMedian());
            mf.addNum(6);
            System.out.println(mf.findMedian());
            mf.addNum(5);
            System.out.println(mf.findMedian());
            mf.addNum(0);
            System.out.println(mf.findMedian());
            mf.addNum(6);
            System.out.println(mf.findMedian());
            mf.addNum(3);
            System.out.println(mf.findMedian());
            mf.addNum(1);
            System.out.println(mf.findMedian());
            mf.addNum(0);
            System.out.println(mf.findMedian());
            mf.addNum(0);
            System.out.println(mf.findMedian());
            System.out.println(mf.res);
        }
    }
}
