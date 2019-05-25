package l201704;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lanshan
 */
public class LeetCode2 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list = null;
        ListNode head = null;
        int out = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + out;
            if (list == null) {
                list = new ListNode(sum % 10);
                head = list;
            } else {
                list.next = new ListNode(sum % 10);
                list = list.next;
            }
            out = sum >= 10 ? 1 : 0;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + out;
            if (list == null) {
                list = new ListNode(sum % 10);
                head = list;
            } else {
                list.next = new ListNode(sum % 10);
                list = list.next;
            }
            out = sum >= 10 ? 1 : 0;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + out;
            if (list == null) {
                list = new ListNode(sum % 10);
                head = list;
            } else {
                list.next = new ListNode(sum % 10);
                list = list.next;
            }
            out = sum >= 10 ? 1 : 0;
            l2 = l2.next;
        }
        if (out != 0) {
            list.next = new ListNode(1);
        }
        return head;
    }

    Stack<Integer> addIntoStack(ListNode l) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = l;
        if (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        return stack;
    }


}
