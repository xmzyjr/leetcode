package feture.ms;

/**
 * @author lanshan
 */
public class M0206 {
    /**
     * 编写一个函数，检查输入的链表是否是回文的。
     *
     *  
     *
     * 示例 1：
     *
     * 输入： 1->2
     * 输出： false
     * 示例 2：
     *
     * 输入： 1->2->2->1
     * 输出： true
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-linked-list-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        boolean flag = count % 2 != 0;
        int mid = flag ? count / 2 + 1 : count / 2;
        ListNode pre = null, cur = head;
        count = 0;
        ListNode second = null;
        while (cur != null) {
            count++;
            if (flag && count == mid) {
                second = cur.next;
                break;
            }
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            if (!flag && count == mid) {
                second = cur;
                break;
            }
        }
        return check(pre, second);
    }

    private boolean check(ListNode first, ListNode second) {
        while (first != null && second != null) {
            if (first.val != second.val)
                return false;
            first = first.next;
            second = second.next;
        }
        return true;
    }

    private ListNode createListNode(int[] nums) {
        ListNode head = null, cur = null;
        for (int num : nums) {
            ListNode node = new ListNode(num);
            if (head == null)
                head = node;
            if (cur == null)
                cur = node;
            else {
                cur.next = node;
                cur = cur.next;
            }
        }
        return head;
    }
}
