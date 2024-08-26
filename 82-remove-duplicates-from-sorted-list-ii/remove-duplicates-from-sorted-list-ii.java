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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = new ListNode(-1);
        HashSet<Integer> set = new HashSet<>();
        ListNode ret = curr;
        while(head!=null){
            if(set.contains(head.val) || (head.next!=null && head.next.val == head.val) ){
                set.add(head.val);
                head = head.next;
                continue;
            }
            set.add(head.val);
            curr.next = new ListNode(head.val);
            curr = curr.next;
            head = head.next;
        }
        return ret.next;
    }
}