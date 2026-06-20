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
    public ListNode  reverse(ListNode head , ListNode limit){
        ListNode h = head; 
        ListNode l = limit; 
        ListNode prev = null; 
        while(h!=null && h!= limit ){
            ListNode nxt = h.next; 
            h.next = prev; 
            prev = h; 
            h = nxt; 
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode kth = head;
        int temp = k ; 
        while(kth != null && temp > 0){
            kth = kth.next; 
            temp--;
        }
        if(temp != 0 ){
            System.out.println("WHY?");
            return head; 
        }
        ListNode ret = reverse(head , kth ); 
        head.next = reverseKGroup(kth , k );
        return ret; 
    }
}