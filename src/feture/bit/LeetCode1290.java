
package feture.bit;

/**
 * @author lanshan
 */
public class LeetCode1290 {

    public class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {

        public int getDecimalValue(ListNode head) {
            if (head == null)
                return 0;
            if (head.next == null) {
                return head.val;
            }
            ListNode temp = head.next;
            int sum = head.val;
            while (temp != null) {
                sum = (sum << 1);
                sum += temp.val;
                temp = temp.next;
            }
            return sum;
        }
    }
}
