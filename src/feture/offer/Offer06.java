package feture.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lanshan
 */
public class Offer06 {
    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     *  
     *
     * 限制：
     *
     * 0 <= 链表长度 <= 10000
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        List<Integer> res = new ArrayList<>();
        ListNode t = head;
        while (t != null) {
            res.add(t.val);
            t = t.next;
        }
        Collections.reverse(res);
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
