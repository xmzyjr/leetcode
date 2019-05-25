
package l201704;

/**
 * @author lanshan
 */
public class LeetCode24 {

    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * 示例:
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     */
    private class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return head;
        }
        return reverseKGroup(head,2);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode revertHead = head;
        ListNode revertTail = head;
        ListNode revertNextHead = null;
        boolean first = true;
        ListNode reHead = null;
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
}
