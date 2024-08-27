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
    public ListNode reverse(ListNode head ){
        ListNode prev = null ; 
        while(head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev  = head;
            head = next;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // solve 
        ListNode curr = new ListNode(-1);
        ListNode ret = curr;
        ListNode a = reverse(l1);
        ListNode b = reverse(l2);
        int carry = 0;
        while(a!=null || b!=null || carry !=0 ){
            int digit = carry;
            if(a!=null){
                digit+= a.val;
                a=a.next;
            }
            if(b!=null){
                digit+=b.val;
                b = b.next;
            }
            curr.next = new ListNode(digit%10);
            curr = curr.next;
            carry = digit/10;

        }
        return reverse(ret.next);
    }
}