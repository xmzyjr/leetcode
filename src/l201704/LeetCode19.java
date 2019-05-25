package l201704;

/**
 * @author lanshan
 */
public class LeetCode19 {

    private class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode h = head;
        ListNode before = head;

        ListNode now = head;
        //        ListNode after = now.next;
        ListNode first = head;

        int count = 1;
        while (count != n) {
            first = first.next;
            count++;
        }
        while (first.next != null) {
            before = now;
            now = now.next;
            first = first.next;
        }
        if (now == head) {
            return head.next;
        }
        before.next = now.next;
        return h;
    }
}
