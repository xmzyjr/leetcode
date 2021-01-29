
package feture.ms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanshan
 */
public class M1010 {
    /**
     * 假设你正在读取一串整数。每隔一段时间，你希望能找出数字 x 的秩(小于或等于 x 的值的个数)。请实现数据结构和算法来支持这些操作，也就是说：
     *
     * 实现 track(int x) 方法，每读入一个数字都会调用该方法；
     *
     * 实现 getRankOfNumber(int x) 方法，返回小于或等于 x 的值的个数。
     *
     * 注意：本题相对原题稍作改动
     *
     * 示例:
     *
     * 输入:
     * ["StreamRank", "getRankOfNumber", "track", "getRankOfNumber"]
     * [[], [1], [0], [0]]
     * 输出:
     * [null,0,null,1]
     * 提示：
     *
     * x <= 50000
     * track 和 getRankOfNumber 方法的调用次数均不超过 2000 次
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rank-from-stream-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class StreamRank {

        List<Integer> list;
        public StreamRank() {
            list = new ArrayList<>();
        }

        public void track(int x) {
            if (list.isEmpty()) {
                list.add(x);
            } else {
                int left = 0, right = list.size() - 1;
                while (left <= right) {
                    if (x <= list.get(left)) {
                        list.add(left, x);
                        return;
                    }
                    if (x >= list.get(right)) {
                        list.add(right+1, x);
                        return;
                    }
                    int mid = left + (right - left) / 2;
                    Integer midValue = list.get(mid);
                    if (midValue == x) {
                        list.add(mid, x);
                        return;
                    }
                    if (midValue > x) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                if (x <= list.get(left)) {
                    list.add(left, x);
                }
                if (x >= list.get(right)) {
                    list.add(right + 1, x);
                }
            }
        }

        public int getRankOfNumber(int x) {
            if (list.isEmpty())
                return 0;
            else {
                int left = 0, right = list.size() - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    Integer midValue = list.get(mid);
                    if (midValue == x) {
                        if (left == right)
                            return left + 1;
                        left = mid+1;
                    } else if (midValue < x) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                return right + 1;
            }
        }
    }
}
