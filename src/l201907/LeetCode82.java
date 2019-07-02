
package l201907;

/**
 * @author lanshan
 */
public class LeetCode82 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    private static class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     * 示例 1:
     * 输入: 1->2->3->3->4->4->5
     * 输出: 1->2->5
     * 示例 2:
     * 输入: 1->1->1->2->3
     * 输出: 2->3
     * 1-1-2-2
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode pre = head, now = head, after = head.next;
        ListNode head1 = null;
        if (head.next.val != head.val) {
            head1 = head;
        }
        boolean check = false;
        boolean dup = false;
        while (after != null) {
            if (after.val != now.val) {
                if (dup) {
                    pre.next = after;
                    now = after;
                    dup = false;
                    after = after.next;
                } else {
                    now = after;
                    after = after.next;
                    if (pre.next != now) {
                        if (head1 == null) {
                            check = true;
                            head1 = pre.next;
                        }
                        pre = pre.next;
                    }
                }
            } else {
                if (!dup) {
                    dup = true;
                }
                after = after.next;
                if (after == null) {
                    pre.next = null;
                    break;
                }
            }
        }
        if (!check && now.next == null && head1 == null && pre.val != now.val) {
            head1 = now;
        }
        return head1;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(1);
        ListNode l6 = new ListNode(1);
        ListNode l7 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        LeetCode82 l = new LeetCode82();
        print(l.deleteDuplicates(l1));
    }

    public static void print(ListNode l) {
        while (l != null) {
            System.out.print(l.val + " ");
            l = l.next;
        }
    }
}
