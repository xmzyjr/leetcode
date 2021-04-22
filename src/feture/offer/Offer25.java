package feture.offer;

/**
 * @author lanshan
 */
public class Offer25 {

    public class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = null;
        ListNode temp, pre = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp = l1;
                l1 = l1.next;
            } else {
                temp = l2;
                l2 = l2.next;
            }
            if (res == null) {
                res = temp;
                pre = temp;
            } else {
                pre.next = temp;
                pre = pre.next;
            }
        }

        while (l1 != null) {
            if (res == null) {
                res = l1;
                pre = l1;
            } else {
                pre.next = l1;
                pre = pre.next;
            }
            l1 = l1.next;
        }

        while (l2 != null) {
            if (res == null) {
                res = l2;
                pre = l2;
            } else {
                pre.next = l2;
                pre = pre.next;
            }
            l2 = l2.next;
        }
        return res;
    }
}
