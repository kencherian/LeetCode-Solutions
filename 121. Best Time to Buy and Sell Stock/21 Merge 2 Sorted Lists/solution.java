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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy head to simplify edge cases (like appending to an empty list)
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        
        // Traverse both lists until one runs out
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next; // Advance list1
            } else {
                current.next = list2;
                list2 = list2.next; // Advance list2
            }
            current = current.next; // Move the tail tracker forward
        }
        
        // Attach the remaining elements of whichever list is not empty
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }
        
        // Return the actual head of the merged list, which skips the dummy node
        return dummy.next;
    }
}