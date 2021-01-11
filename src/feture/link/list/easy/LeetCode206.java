package feture.link.list.easy;

/**
 * @author lanshan
 */
public class LeetCode206 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     */
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode current = head;
        ListNode res = head;
        ListNode nxt = current.next;
        ListNode pre = null;
        while (nxt != null) {
            current = nxt.next;
            nxt.next = res;
            res.next = pre;
            pre = res;
            res = nxt;
            nxt = current;
        }
        return res;
    }
}
