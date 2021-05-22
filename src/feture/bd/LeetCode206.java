package feture.bd;

/**
 * @author lanshan
 */
public class LeetCode206 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode t = head;
        while (t != null) {
            ListNode next = t.next;
            t.next = pre;
            pre = t;
            t = next;
        }
        return pre;
    }
}
