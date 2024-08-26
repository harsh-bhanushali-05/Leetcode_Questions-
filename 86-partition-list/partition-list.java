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
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(-1);
        ListNode head_small = small;
        ListNode big = new ListNode(-1);
        ListNode head_big = big;
        while(head!=null){
            if(head.val < x ){
                small.next = new ListNode(head.val);
                small = small.next;
                head = head.next;
            }
            else{
                big.next = new ListNode(head.val);
                big = big.next;
                head = head.next;
            }
        }
        small.next = head_big.next;
        return head_small.next;   
    }
}