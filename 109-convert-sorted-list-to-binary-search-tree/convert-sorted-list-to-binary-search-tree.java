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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode f(int arr[] , int i , int j ){
        if(j < i )return null;
        int mid = i+ ((j-i)/2);
        TreeNode root = new TreeNode(arr[mid]);
        root.left = f(arr , i , mid-1 );
        root.right = f(arr , mid+1 , j );
        return root;
    }
    public int len(ListNode head ){
        int ans = 0;
        ListNode curr = head;
        while(curr!=null){
            curr = curr.next;
            ans++;
        }
        return ans;
    }
    public TreeNode sortedListToBST(ListNode head) {
        int arr[] = new int[len(head)]; 
        int i = 0 ;
        while(head!=null){
            arr[i] = head.val;
            i++;
            head= head.next;
        }
        return f(arr , 0 , arr.length -1);
    }
}