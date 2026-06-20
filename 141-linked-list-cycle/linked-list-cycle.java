/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        if(head == null){
            return false; 
        }
        ListNode fast = head;
        boolean ans = false; 
        while(fast!=null && fast.next!=null){
            slow = slow.next; 
            fast = fast.next.next;
            if(slow == fast){
                ans = true; 
                break; 
            }
        }
        if(ans){
            ListNode curr = head; 
            while(curr!= slow ){
                slow = slow.next; 
                curr = curr.next; 
            }
            System.out.println(curr.val);
        }
        return ans ;
    }
}