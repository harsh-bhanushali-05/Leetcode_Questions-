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
    public ListNode middle(ListNode head ){
        ListNode fast = head; 
        ListNode slow = head; 
        while(fast!=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head ){
        ListNode prev = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode a = head;
        ListNode b = reverse(middle(head));
        while(b!=null){
            if(a.val!=b.val){
                return false;
            }
            a=a.next;
            b=b.next;
        }
        return true;
    }
}