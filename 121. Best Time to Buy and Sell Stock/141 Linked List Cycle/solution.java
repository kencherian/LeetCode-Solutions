
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public boolean hasCycle(ListNode head) {
        // Guard clause: an empty list or a single node without a link cannot have a cycle
        if (head == null || head.next == null) {
            return false;
        }

        // Initialize two pointers traveling at different speeds
        ListNode slow = head;
        ListNode fast = head;

        // Traverse the list; fast moves twice as fast as slow
        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move 1 step
            fast = fast.next.next;    // Move 2 steps

            // If the pointers meet, a cycle exists
            if (slow == fast) {
                return true;
            }
        }

        // The fast pointer reached the end of the list, meaning no cycle exists
        return false;
    }
}
