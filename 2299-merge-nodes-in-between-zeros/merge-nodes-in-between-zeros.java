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
    public ListNode mergeNodes(ListNode head) {
        ListNode temp = new ListNode(-1);
        ListNode ret = temp;
        int sum = 0; 
        if(head == null)return ret;
        head = head.next;
        while(head!=null){
            if(head.val == 0 ){
                temp.next = new ListNode (sum);
                temp = temp.next;
                head = head.next;
                sum = 0; 
            }
            else{
                sum+=head.val;
                head = head.next;
            }
        }
        return ret.next;
    }
}