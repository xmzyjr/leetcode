package feture.bd;

/**
 * @author lanshan
 */
public class AddTwoNumbers {
    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     * 示例 2：
     *
     * 输入：l1 = [0], l2 = [0]
     * 输出：[0]
     * 示例 3：
     *
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * 输出：[8,9,9,9,0,0,0,1]
     *  
     *
     * 提示：
     *
     * 每个链表中的节点数在范围 [1, 100] 内
     * 0 <= Node.val <= 9
     * 题目数据保证列表表示的数字不含前导零
     */

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode t1 = l1, t2 = l2;
        int out = 0;
        ListNode pre = null;
        ListNode res = null;
        while (t1 != null && t2 != null) {
            ListNode t = new ListNode();
            int val = t1.val + t2.val + out;
            if (val >= 10) {
                out = 1;
                val %= 10;
            } else {
                out = 0;
            }
            t.val = val;
            if (res == null)
                res = t;
            if (pre != null) {
                pre.next = t;
            }
            pre = t;
            t1 = t1.next;
            t2 = t2.next;
        }
        while (t1 != null) {
            ListNode t = new ListNode();
            int val = t1.val + out;
            if (val >= 10) {
                out = 1;
                val %= 10;
            } else {
                out = 0;
            }
            t.val = val;
            pre.next = t;
            pre = t;
            t1 = t1.next;
        }
        while (t2 != null) {
            ListNode t = new ListNode();
            int val = t2.val + out;
            if (val >= 10) {
                out = 1;
                val %= 10;
            } else {
                out = 0;
            }
            t.val = val;
            pre.next = t;
            pre = t;
            t2 = t2.next;
        }
        if (out == 1) {
            pre.next = new ListNode(1);
        }
        return res;
    }
}
