package feture.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author lanshan
 */
public class Offer41 {

    static class MedianFinder {

        /** initialize your data structure here. */
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;
        public MedianFinder() {
            left = new PriorityQueue<>(((o1, o2) -> o2 - o1));
            right = new PriorityQueue<>((Comparator.comparingInt(o -> o)));
        }

        public void addNum(int num) {
            if (left.isEmpty()) {
                left.add(num);
            } else {
                if (num > left.peek()) {
                    if (left.size() <= right.size()) {
                        if (right.peek() >= num) {
                            left.add(num);
                        } else {
                            left.add(right.poll());
                            right.add(num);
                        }
                    } else {
                        right.add(num);
                    }
                } else {
                    if (left.size() > right.size()) {
                        right.add(left.poll());
                    }
                    left.add(num);
                }
            }
        }

        public double findMedian() {
            if (left.isEmpty()) {
                return -1;
            } else {
                if (left.size() == right.size()) {
                    return (left.peek() + right.peek()) * 1.0 / 2;
                } else {
                    if (left.size() > right.size()) {
                        return left.peek();
                    } else {
                        return right.peek();
                    }
                }
            }
        }

        public static void main(String[] args) {
            MedianFinder m = new MedianFinder();
            m.addNum(12);
            System.out.println(m.findMedian());
            m.addNum(10);
            System.out.println(m.findMedian());
            m.addNum(13);
            System.out.println(m.findMedian());
            m.addNum(11);
            System.out.println(m.findMedian());
            m.addNum(5);
            System.out.println(m.findMedian());
            m.addNum(15);
            System.out.println(m.findMedian());
            m.addNum(1);
            System.out.println(m.findMedian());
            m.addNum(11);
            System.out.println(m.findMedian());
        }
    }

}
