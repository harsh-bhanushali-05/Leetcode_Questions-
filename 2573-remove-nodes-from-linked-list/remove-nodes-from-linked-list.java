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
    public ListNode rev(ListNode head ){
        ListNode prev = new ListNode(-1);
        ListNode curr = prev;
        while(head !=null){
            ListNode next = head.next;
            head.next= prev;
            prev = head; 
            head = next;
        }
        return prev;
    }
    public ListNode returnHelp(ListNode head ){
        ListNode curr = head;
        if(head.next == null) return null;
        while(head.next.next!=null){
            head = head.next;
        }
        head.next = null;
        return curr;
    }
    public ListNode removeNodes(ListNode head) {
        head = rev(head);
        ListNode curr = new ListNode();
        ListNode ret = curr ; 
        int max = Integer.MIN_VALUE;
        while(head!=null){
            // this element should be the biggest element we have seen till now 
            if(head.val >= max){
                curr.next= new ListNode(head.val);
                max = Math.max(max , head.val);
                curr = curr.next;
                head = head.next;
            }
            else{
                head = head.next;
            }
        }
        ret = rev(ret.next);
        ret = returnHelp(ret);
         // we are getting one extra node at the end of the Linked list 
        return ret;
    }
}