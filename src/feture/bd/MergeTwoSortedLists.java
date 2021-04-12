package feture.bd;

/**
 * @author lanshan
 */
public class MergeTwoSortedLists {
    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode pre = null;
        ListNode temp;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp = l1;
                l1 = l1.next;
            } else {
                temp = l2;
                l2 = l2.next;
            }
            if (head == null) {
                head = temp;
                pre = temp;
            } else {
                pre.next = temp;
                pre = pre.next;
            }
        }
        ListNode[] t = merge(l1, pre, head);
        head = t[0];
        pre = t[1];
        t = merge(l2, pre, head);
        head = t[0];
        return head;
    }

    private ListNode[] merge(ListNode l, ListNode pre, ListNode head) {
        while (l != null) {
            if (head == null) {
                head = l;
                pre = l;
            } else {
                pre.next = l;
                pre = pre.next;
            }
            l = l.next;
        }
        return new ListNode[] { head, pre };
    }
}
