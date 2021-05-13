package feture.offer;

import java.util.LinkedList;

/**
 * @author lanshan
 */
public class Offer59_2 {
    /**
     * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
     *
     * 若队列为空，pop_front 和 max_value 需要返回 -1
     *
     * 示例 1：
     *
     * 输入:
     * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
     * [[],[1],[2],[],[],[]]
     * 输出: [null,null,null,2,1,2]
     * 示例 2：
     *
     * 输入:
     * ["MaxQueue","pop_front","max_value"]
     * [[],[],[]]
     * 输出: [null,-1,-1]
     *  
     *
     * 限制：
     *
     * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
     * 1 <= value <= 10^5
     */
    class MaxQueue {

        LinkedList<Integer> list;
        LinkedList<Integer> num;
        public MaxQueue() {
            list = new LinkedList<>();
            num = new LinkedList<>();
        }

        public int max_value() {
            if (list.isEmpty())
                return -1;
            return num.peekFirst();
        }

        public void push_back(int value) {
            list.add(value);
            while (!num.isEmpty() && num.peekLast() < value) {
                num.pollLast();
            }
            num.add(value);
        }

        public int pop_front() {
            if (list.isEmpty())
                return -1;
            Integer num1 = list.pollFirst();
            if (num1.equals(num.peekFirst())) {
                num.pollFirst();
            }
            return num1;
        }
    }
}
