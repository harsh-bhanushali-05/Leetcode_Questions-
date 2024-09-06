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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums )
            set.add(i);
        ListNode curr = new ListNode(-1);
        ListNode ret = curr;
        while(head!=null){
            if(set.contains(head.val)){
                head = head.next;
            }
            else{
                curr.next = new ListNode(head.val);
                head = head.next;
                curr = curr.next;
            }
        }
        return ret.next;
    }
}