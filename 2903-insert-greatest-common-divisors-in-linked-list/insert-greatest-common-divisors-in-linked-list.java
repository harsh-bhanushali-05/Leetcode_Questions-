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
    public int f(int a , int b ){
        if(b == 0 )return a;
        return f( b , a%b );
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode ret = head;
        while(head.next!=null){
            int add = f(head.val , head.next.val);
            ListNode next = head.next;
            head.next = new ListNode(add); 
            head.next.next = next;
            head = next;
        }
        return ret;
    }
}