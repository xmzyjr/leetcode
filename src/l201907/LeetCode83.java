
package l201907;

/**
 * @author lanshan
 */
public class LeetCode83 {

    private static class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     * 示例 1:
     * 输入: 1->1->2
     * 输出: 1->2
     * 示例 2:
     * 输入: 1->1->2->3->3
     * 输出: 1->2->3
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next, pre = head;

        while (next != null) {
            if (next.val == pre.val) {
                next = next.next;
            } else {
                pre.next = next;
                pre = next;
                next = next.next;
            }
        }
        pre.next = null;

        return head;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        LeetCode83 l = new LeetCode83();
        print(l.deleteDuplicates(l1));
    }

    public static void print(ListNode l) {
        while (l != null) {
            System.out.print(l.val + " ");
            l = l.next;
        }
    }
}
