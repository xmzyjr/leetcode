package feture.ms;

/**
 * @author lanshan
 */
public class M0204 {
    /**
     *编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。
     * 如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
     *
     * 示例:
     *
     * 输入: head = 3->5->8->5->10->2->1, x = 5
     * 输出: 3->1->2->10->5->5->8
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/partition-list-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;
        ListNode b = find(head, x);
        if (b == null)
            return head;
        ListNode tempF = new ListNode(0);
        tempF.next = b;
        ListNode tempE = new ListNode(0);
        ListNode t = head;
        while (t != null) {
            if (t == b) {
                t = t.next;
                continue;
            }
            ListNode nx = t.next;
            if (nx == b)
                nx = nx.next;
            if (t.val < x) {
                t.next = tempF.next;
                tempF.next = t;
            } else {
                t.next = tempE.next;
                tempE.next = t;
            }
            t = nx;
        }
        b.next = tempE.next;
        return tempF.next;
    }

    private ListNode find(ListNode head, int x) {
        while (head != null) {
            if (head.val >= x)
                return head;
            head = head.next;
        }
        return null;
    }
}
