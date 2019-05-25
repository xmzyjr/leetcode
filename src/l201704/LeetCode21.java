package l201704;

/**
 * @author lanshan
 */
public class LeetCode21 {

    private static class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode re = null;
        ListNode temp = null;
        ListNode l11, l22;
        l11 = l1;
        l22 = l2;
        while (l11 != null && l22 != null) {
            if (l11.val < l22.val) {
                if (temp == null) {
                    temp = l11;
                    re = temp;
                } else {
                    temp.next = l11;
                    temp = temp.next;
                }
                l11 = l11.next;

            } else {
                if (temp == null) {
                    temp = l22;
                    re = temp;
                } else {
                    temp.next = l22;
                    temp = temp.next;
                }
                l22 = l22.next;

            }
        }

        while (l11 != null) {
            if (temp == null) {
                temp = l11;
                re = temp;
            } else {
                temp.next = l11;
                temp = temp.next;
            }
            l11 = l11.next;

        }

        while (l22 != null) {
            if (temp == null) {
                temp = l22;
                re = temp;
            } else {
                temp.next = l22;
                temp = temp.next;
            }
            l22 = l22.next;
        }

        return re;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l3.next = l4;

        System.out.println(mergeTwoLists(l1, l3));
    }
}
