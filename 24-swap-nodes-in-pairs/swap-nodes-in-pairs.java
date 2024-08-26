class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;  // If there's only one node or no node, return the list as it is.
        }

        ListNode prev = new ListNode(-1);  // Dummy node to simplify operations
        ListNode ret = prev;
        
        while (head != null && head.next != null) {
            ListNode curr = head;
            ListNode next = head.next;
            ListNode next_head = head.next.next;
            prev.next = next;
            next.next = curr;
            curr.next = next_head;
            prev = curr;
            
            // Move head to the next pair
            head = next_head;
        }
        
        return ret.next;  // Return the new head of the linked list
    }
}