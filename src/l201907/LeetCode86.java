
package l201907;

/**
 * @author lanshan
 */
public class LeetCode86 {

    private class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
     * 你应当保留两个分区中每个节点的初始相对位置。
     * 示例:
     * 输入: head = 1->4->3->2->5->2, x = 3
     * 输出: 1->2->2->4->3->5
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode targetBefore = null, target = head, nowBefore, now;
        ListNode resultHead = head;
        // 定位到 targetEnd
        while (target != null) {
            if (target.val < x) {
                target = target.next;
                targetBefore = targetBefore == null ? head : targetBefore.next;
            } else {
                break;
            }
        }
        if (target == null || target.next == null) {
            return head;
        }
        // now 从 target.next 开始
        now = target.next;
        nowBefore = target;
        while (now != null) {
            if (now.val < x) {
                nowBefore.next = now.next;
                now.next = target;
                if (targetBefore == null) {
                    targetBefore = now;
                    resultHead = now;
                } else {
                    targetBefore.next = now;
                    targetBefore = now;
                }
                now = nowBefore.next;
            } else {
                now = now.next;
                nowBefore = nowBefore.next;
            }
        }
        return resultHead;
    }
}
