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
    public ListNode removeElements(ListNode head, int val) {
        ListNode ret = new ListNode(-1);
        ListNode curr = ret;
        while(head !=null){
            if(head.val == val ){
                head = head.next;
                continue;
            }
            curr.next = new ListNode(head.val);
            head = head.next;
            curr = curr.next;
        }
        return ret.next;
    }
}