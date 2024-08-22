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
    public ListNode middle(ListNode curr){
        ListNode slow = curr;
        ListNode fast = curr;
        while(fast !=null && fast.next !=null){
            fast = fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head ){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        if(head ==null)return head;
            next = head.next;
        while(curr !=null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null )
                next = next.next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode mid = reverse(middle(head));
        while(mid!=null && head!=null){
            if(mid.val != head.val)return false;
            mid = mid.next;
            head = head.next;
        }
        return true;
    }
}