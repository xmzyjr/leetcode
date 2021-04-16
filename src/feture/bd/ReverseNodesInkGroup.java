package feture.bd;

/**
 * @author lanshan
 */
public class ReverseNodesInkGroup {

    /**
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     *
     * k 是一个正整数，它的值小于或等于链表的长度。
     *
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     *
     * 进阶：
     *
     * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     *
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[2,1,4,3,5]
     *
     * 输入：head = [1,2,3,4,5], k = 3
     * 输出：[3,2,1,4,5]
     * 示例 3：
     *
     * 输入：head = [1,2,3,4,5], k = 1
     * 输出：[1,2,3,4,5]
     * 示例 4：
     *
     * 输入：head = [1], k = 1
     * 输出：[1]
     * 提示：
     *
     * 列表中节点的数量在范围 sz 内
     * 1 <= sz <= 5000
     * 0 <= Node.val <= 1000
     * 1 <= k <= sz
     */

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }

    /**
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[2,1,4,3,5]
     * 输入：head = [1,2,3,4,5], k = 3
     * 输出：[3,2,1,4,5]
     * 示例 3：
     * 输入：head = [1,2,3,4,5], k = 1
     * 输出：[1,2,3,4,5]
     * 示例 4：
     * 输入：head = [1], k = 1
     * 输出：[1]
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        int count = 0;
        ListNode res = null, temp = head;
        ListNode start = head, end, pre = null;
        while (temp != null) {
            count++;
            if (count == k) {
                end = temp;
                ListNode t1 = start, preS = start;
                ListNode p1 = end.next;
                start = p1;
                while (t1 != end) {
                    ListNode t2 = t1.next;
                    t1.next = p1;
                    p1 = t1;
                    t1 = t2;
                }
                t1.next = p1;
                if (res == null) {
                    res = t1;
                } else {
                    pre.next = end;
                }
                pre = preS;
                count = 0;
                temp = start;
                continue;
            }
            temp = temp.next;
        }
        return res;
    }

    private static ListNode build(int[] num) {
        ListNode head = null, temp = null;
        for (int i : num) {
            ListNode l = new ListNode(i);
            if (head == null)
                head = l;
            if (temp == null) {
                temp = l;
            } else {
                temp.next = l;
                temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ReverseNodesInkGroup r = new ReverseNodesInkGroup();
        r.reverseKGroup(build(new int[] { 1, 2, 3, 4, 5 }), 2);
    }

}
