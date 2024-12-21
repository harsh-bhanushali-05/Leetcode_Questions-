class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            // If the list is empty or has only one node, no rearrangement is needed
            return head;
        }
        ListNode odd = head; // Pointer to odd-indexed nodes
        ListNode even = head.next; // Pointer to even-indexed nodes
        ListNode evenHead = even; // Store the start of the even list

        while (even != null && even.next != null) {
            odd.next = even.next; // Connect the next odd node
            odd = odd.next; // Move the odd pointer forward

            even.next = odd.next; // Connect the next even node
            even = even.next; // Move the even pointer forward
        }

        odd.next = evenHead; // Connect the odd list to the even list
        return head;
    }
}