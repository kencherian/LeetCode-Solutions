/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // Track the node preceding the current node
        ListNode prev = null;
        // Track the current node being processed
        ListNode curr = head;
        
        while (curr != null) {
            // Temporarily store the next node before breaking the link
            ListNode nextTemp = curr.next;
            
            // Reverse the link to point to the previous node
            curr.next = prev;
            
            // Move the pointers forward for the next iteration
            prev = curr;
            curr = nextTemp;
        }
        
        // At the end, prev will point to the new head of the reversed list
        return prev;
    }
}