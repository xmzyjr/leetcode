package l202004;

import java.util.Stack;

/**
 * @author lanshan
 */
public class LeetCode446 {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        Stack<ListNode> stackL1 = new Stack<>();
        Stack<ListNode> stackL2 = new Stack<>();
        ListNode temp1 = l1, temp2 = l2;
        while (temp1!=null) {
            stackL1.push(temp1);
            temp1 = temp1.next;
        }
        while (temp2!=null) {
            stackL2.push(temp2);
            temp2 = temp2.next;
        }
        int out = 0;
        ListNode head = null;
        while (!stackL1.isEmpty() && !stackL2.isEmpty()) {
            ListNode l1Node = stackL1.pop();
            ListNode l2Node = stackL2.pop();
            int sum = l1Node.val + l2Node.val + out;
            if (head == null) {
                head = new ListNode(sum % 10);
            } else {
                ListNode temp = new ListNode(sum % 10);
                temp.next = head;
                head = temp;
            }
            out = sum >= 10 ? 1 : 0;
        }
        while (!stackL1.isEmpty()) {
            ListNode l1Node = stackL1.pop();
            int sum = l1Node.val + out;
            ListNode temp = new ListNode(sum % 10);
            temp.next = head;
            head = temp;
            out = sum >= 10 ? 1 : 0;
        }
        while (!stackL2.isEmpty()) {
            ListNode l1Node = stackL2.pop();
            int sum = l1Node.val + out;
            ListNode temp = new ListNode(sum % 10);
            temp.next = head;
            head = temp;
            out = sum >= 10 ? 1 : 0;
        }
        if (out == 1) {
            ListNode temp = new ListNode(1);
            temp.next = head;
            head = temp;
        }
        return head;
    }
}
