/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverse(ListNode head, ListNode end) {
        ListNode prev = null;
        while (head != end) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        dummy.next = head;
        ListNode start = head;
        while (true) {
            ListNode end = start;
            int count = 0;
            while (count < k && end != null) {
                end = end.next;
                count++;
            }
            if (count == k) {
                curr.next = reverse(start, end);
                curr = start;
                start = end;
            } else {
                curr.next = start;
                break;
            }
        }

        return dummy.next;
    }
}