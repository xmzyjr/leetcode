
package l201907;

/**
 * @author lanshan
 */
public class LeetCode92 {

    /**
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     * 说明:
     * 1 ≤ m ≤ n ≤ 链表长度。
     * 示例:
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     */
    private class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) {
            return head;
        }
        ListNode temp = head, temp1 = head.next, head1 = null, tail = null;
        int count = 1, len = 0;
        ListNode res = null;
        while (temp != null && len < (n - m + 1)) {
            if (count != m) {
                if (res == null) {
                    res = temp;
                } else {
                    res = res.next;
                }
                temp = temp1;

                temp1 = temp1.next;
                count++;
            } else {
                temp.next = head1;
                if (tail == null)
                    tail = temp;
                head1 = temp;
                temp = temp1;
                if (temp1 != null)
                    temp1 = temp1.next;
                len++;
            }
        }
        if (res == null) {
            res = head1;
        } else {
            res.next = head1;
            res = head;
        }
        tail.next = temp;

        return res;

    }

}
