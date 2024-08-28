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
    public ListNode reverse(ListNode head ){
        ListNode prev = new ListNode(-1);
        while(head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    public void arr_reverse(int arr[]){
        for(int i = 0 ; i < arr.length/2 ; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length -1 - i ];
            arr[arr.length -1 - i ] = temp;
        }
    }
    public int len(ListNode head ){
        ListNode curr = head;
        int ans = 0;
        while(curr!=null){
            curr = curr.next;
            ans++;
        }
        return ans;
    }
    public int[] nextLargerNodes(ListNode head) {
        int ans[] = new int[len(head)+1];
        head = reverse(head);
        Stack<Integer> st = new Stack<>();
        int i = 0 ;
        while(head!=null){
            while(st.isEmpty() == false && st.peek() <= head.val){
                st.pop();
            }
            ans[i] = st.isEmpty()? 0 : st.peek();
            i++;
            st.push(head.val) ;
            head = head.next;
        }
        arr_reverse(ans);
        int arr[] = new int[ans.length-1];
        for(int q = 0 ; q < arr.length ; q++){
            arr[q] = ans[q+1];
        }
        return arr;
    }
}