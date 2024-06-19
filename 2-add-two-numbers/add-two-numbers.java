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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(-1);
        ListNode head = ret; 
        int carry = 0 ;
        while(l1!=null && l2!=null){
            int val = l1.val+l2.val+carry;
            carry = val/10;
            ListNode next = new ListNode(val%10);
            head.next= next;
            head = head.next;
            l1= l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            int val = l1.val + carry;
            carry = val/10;
            ListNode next = new ListNode(val%10);
            head.next= next;
            head = head.next;
            l1= l1.next;
        }
        while(l2!=null ){
            int val = l2.val + carry;
            carry = val/10;
            ListNode next = new ListNode(val%10);
            head.next= next;
            head = head.next;
            l2= l2.next;
        }
        if(carry != 0 ){
            ListNode next = new ListNode ( carry);
            head.next = next;
        }
        return ret.next;
    }
}