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
            curr=curr.next;
            ans++;
        }
        return ans;
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        int l = len(head);
        int index = 0;
        while(head!=null){
            int size = l/k;
            if(((float)l / (float)k)%1!=0){
                size++;
            }
            ListNode curr = new ListNode(-1);
            for(int i = 0 ; i < size ; i++){
                if(head == null)break;
                if(i == 0 ){
                    ans[index] = new ListNode(head.val);
                    head = head.next;
                    curr = ans[index];
                }
                else{
                    curr.next = new ListNode(head.val);
                    curr = curr.next;
                    head = head.next;
                }
            }
            index++;
            l-=size;
            k--;
        }
        return ans;
    }
}