package feture.offer;

/**
 * @author lanshan
 */
public class Offer18 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null)
            return null;
        ListNode tt = new ListNode(0);
        tt.next = head;
        ListNode pre = tt;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
                break;
            }
            pre = pre.next;
            head = head.next;
        }
        return tt.next;
    }
}
