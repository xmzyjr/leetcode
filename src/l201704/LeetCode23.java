
package l201704;

/**
 * @author lanshan
 */
public class LeetCode23 {

    private static class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] list, int left, int right) {
        if (left == right) {
            return list[left];
        }
        ListNode leftNode;
        ListNode rightNode;
        int mid = left + (right - left) / 2;
        leftNode = merge(list, left, mid);
        rightNode = merge(list, mid + 1, right);
        return mergeTwoLists(leftNode, rightNode);

    }

    /**
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode re = null;
        ListNode temp = null;
        ListNode l11, l22;
        l11 = l1;
        l22 = l2;
        while (l11 != null && l22 != null) {
            if (l11.val < l22.val) {
                if (temp == null) {
                    temp = l11;
                    re = temp;
                } else {
                    temp.next = l11;
                    temp = temp.next;
                }
                l11 = l11.next;

            } else {
                if (temp == null) {
                    temp = l22;
                    re = temp;
                } else {
                    temp.next = l22;
                    temp = temp.next;
                }
                l22 = l22.next;

            }
        }

        while (l11 != null) {
            if (temp == null) {
                temp = l11;
                re = temp;
            } else {
                temp.next = l11;
                temp = temp.next;
            }
            l11 = l11.next;

        }

        while (l22 != null) {
            if (temp == null) {
                temp = l22;
                re = temp;
            } else {
                temp.next = l22;
                temp = temp.next;
            }
            l22 = l22.next;
        }

        return re;
    }
}
