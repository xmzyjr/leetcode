
package l201904;

/**
 * @author lanshan
 */
public class LeetCode25 {

    private static class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k==1) {
            return doRevertOne(head);
        }
        ListNode revertHead = head;
        ListNode revertTail = head;
        ListNode revertNextHead = null;
        boolean first = true;
        ListNode reHead = head;
        ListNode reNext = null;
        int count = 1;
        while (true) {
            while (revertTail != null && count != k) {
                count++;
                revertTail = revertTail.next;
            }
            if (count != k || revertTail == null) {
                return reHead;
            } else {
                revertNextHead = revertTail.next;
                ListNode node = doRevert(revertHead, revertTail);
                if (first) {
                    reHead = node;
                    first = false;
                } else {
                    reNext.next = node;
                }
                reNext = revertHead;
                revertHead = revertNextHead;
                revertTail = revertHead;
                count = 1;
            }
        }
    }

    public ListNode doRevert(ListNode head, ListNode tail) {
        ListNode temp = head.next;
        ListNode tempNext = null;
        ListNode tempBefore = head;
        head.next = tail.next;
        while (temp != tail && temp != null) {
            tempNext = temp.next;
            temp.next = tempBefore;
            tempBefore = temp;
            temp = tempNext;
        }
        tail.next = tempBefore;
        return tail;
    }

    public ListNode doRevertOne(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre= null;
        ListNode now = head;
        ListNode temp = null;
        while (now != null) {
            temp = now.next;
            now.next = pre;
            pre = now;
            now = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        LeetCode25 l = new LeetCode25();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        System.out.println(l.reverseKGroup(l1, 1));

    }
}
