Remove Nth Node From End of List
A highly efficient Java solution for the classic "Remove Nth Node From End of List" problem (LeetCode #19). This repository contains an optimized O(N) Time Complexity approach utilizing a Two-Pointer (Fast & Slow) technique with a Dummy Node in a single pass.

📌 Problem Description
Given the head of a linked list, remove the n 
th
  node from the end of the list and return its head.

Examples
Example 1:

Input: head = [1,2,3,4,5], n = 2

Output: [1,2,3,5]

Example 2:

Input: head = [1], n = 1

Output: []

Example 3:

Input: head = [1,2], n = 1

Output: [1]

Constraints

The number of nodes in the list is sz.

1 <= sz <= 30

0 <= Node.val <= 100

1 <= n <= sz

Follow up: Could you do this in one pass?

🚀 Solution Approach
The naive approach requires two passes: the first pass determines the total length L of the linked list, and the second pass traverses to the (L−n) 
th
  node to remove the target.

To solve the problem in a single pass:

Dummy Node: Create a sentinel dummy node pointing to head (dummy.next = head). This elegantly handles edge cases, such as removing the first node of the list.

Two-Pointer Gap: Initialize two pointers, fast and slow, both starting at the dummy node. Advance the fast pointer n+1 steps ahead so that a constant gap of n nodes is established between slow and fast.

Simultaneous Traversal: Move both fast and slow forward one node at a time until fast reaches null. Because of the fixed gap, slow will stop directly before the node that needs to be removed.

Relink: Skip the target node by updating slow.next = slow.next.next.

Complexity Analysis

Metric	Complexity	Description
Time Complexity	O(N)	The list is traversed in a single pass of N nodes, where N is the number of nodes in the list.
Space Complexity	O(1)	Auxiliary space is constant as only pointer references (dummy, fast, slow) are utilized.
💻 Code Structure
The core implementation is written in Java:

Java
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Sentinel dummy node to handle edge cases like removing the head node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // Advance fast pointer so that there is a gap of (n + 1) between fast and slow
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // Move both pointers simultaneously until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // slow is now pointing to the node immediately before the target node
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}