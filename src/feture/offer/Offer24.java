package feture.offer;

/**
 * @author lanshan
 */
public class Offer24 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode pre = null;
        ListNode temp = head;
        while (temp != null) {
            ListNode t = temp.next;
            temp.next = pre;
            pre = temp;
            temp = t;
        }
        return pre;
    }
}
