package feture.ms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lanshan
 */
public class M0201 {

    /**
     * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
     * 示例1:
     * 输入：[1, 2, 3, 3, 2, 1]
     * 输出：[1, 2, 3]
     * 示例2:
     * 输入：[1, 1, 1, 1, 2]
     * 输出：[1, 2]
     * 提示：
     * 链表长度在[0, 20000]范围内。
     * 链表元素在[0, 20000]范围内。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null)
            return head;
        Set<Integer> num = new HashSet<>();
        ListNode temp = head;
        num.add(head.val);
        while (temp.next != null) {
            if (num.contains(temp.next.val)) {
                temp.next = temp.next.next;
            } else {
                num.add(temp.next.val);
                temp = temp.next;
            }
        }
        return head;
    }
}
