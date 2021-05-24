package feture.testt;

/**
 * @author lanshan
 */
public class Test1 {
    public class ListNode {
        int val;
        ListNode next;
    }

    public ListNode find(ListNode l1, ListNode l2) {
        ListNode t1 = l1, t2 = l2;

        while (t1 != t2) {
            t1 = t1 == null ? t2 : t1.next;
            t2 = t2 == null ? t1 : t2.next;
        }
        return t1;
    }
}
