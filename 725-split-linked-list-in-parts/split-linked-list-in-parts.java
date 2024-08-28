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
    public int len(ListNode head ){
        ListNode curr = head;
        int ans = 0 ;
        while(curr!=null){
            ans++;
            curr= curr.next;
        }
        return ans ;
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        // we need to split the Linked list into k. 
        // we have length of 6 assume -> k = 3 then 2 each if len < k give 1 to each of the node 
        ListNode [] arr = new ListNode[k];
        for(int i = 0; i < k ; i++){
            arr[i] = new ListNode(-1);
        }
        int length = len(head);
        if(length <= k){
            // we are giving each value in the num 1 element 
            for(int i = 0 ; i < k ; i++){
                if(head!=null){
                    arr[i].next = new ListNode(head.val);
                    head = head.next;
                }
                arr[i] = arr[i].next;
            }
            return arr;
        }
        else{
            int index = 0;
            int each =(length / k ); 
            for(int i = 0; i < k ; i++){
                int s = each;
                ListNode curr = arr[i];
                if(length %k != 0 ){
                    s++;
                    length--;
                }
                while(s-->0 && head!=null){
                    curr.next = new ListNode(head.val);
                    head = head.next;
                    curr = curr.next;
                    index++;
                }
            }
            for(int i = 0 ; i < k ; i++){
                arr[i] = arr[i].next;
            }
        }
        return arr; 
    }
}