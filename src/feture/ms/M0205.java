package feture.ms;

/**
 * @author lanshan
 */
public class M0205 {
    /**
     * 给定两个用链表表示的整数，每个节点包含一个数位。
     *
     * 这些数位是反向存放的，也就是个位排在链表首部。
     *
     * 编写函数对这两个整数求和，并用链表形式返回结果。
     *
     * 示例：
     *
     * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
     * 输出：2 -> 1 -> 9，即912
     * 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
     *
     * 示例：
     *
     * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
     * 输出：9 -> 1 -> 2，即912
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        ListNode t1 = l1;
        ListNode t2 = l2;
        int addMore = 0;
        ListNode res = null;
        ListNode temp = null;
        while (t1 != null && t2 != null) {
            int i = t1.val + t2.val + addMore;
            addMore = 0;
            if (i >= 10) {
                addMore = 1;
                i -= 10;
            }
            ListNode now = new ListNode(i);
            if (res == null) {
                res = now;
                temp = res;
            } else {
                temp.next = now;
                temp = now;
            }
            t1 = t1.next;
            t2 = t2.next;
        }
        if (t1 != null) {
            add(t1, res, temp, addMore);
            addMore = 0;
        }
        if (t2 != null) {
            add(t2, res, temp, addMore);
            addMore = 0;
        }
        if (addMore == 1) {
            temp.next = new ListNode(1);
        }
        return res;
    }

    private void add(ListNode l, ListNode resHead, ListNode temp, int addMore) {
        while (l != null) {
            int i = l.val + addMore;
            addMore = 0;
            if (i >= 10) {
                addMore = 1;
                i -= 10;
            }
            ListNode now = new ListNode(i);
            if (resHead == null) {
                resHead = now;
                temp = resHead;
            } else {
                temp.next = now;
                temp = now;
            }
            l = l.next;
        }
        if (addMore == 1) {
            temp.next = new ListNode(1);
        }
    }

}
