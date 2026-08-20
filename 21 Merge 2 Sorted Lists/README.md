Merge Two Sorted Lists
A highly efficient Java solution for the classic "Merge Two Sorted Lists" problem (LeetCode #21). This repository contains an optimized O(n+m) approach utilizing an iterative two-pointer technique with a dummy head node.

📌 Problem Description
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Examples
Example 1:

Input: list1 = [1,2,4], list2 = [1,3,4]

Output: [1,1,2,3,4,4]

Example 2:

Input: list1 = [], list2 = []

Output: []

Example 3:

Input: list1 = [], list2 = [0]

Output: [0]

Constraints
The number of nodes in both lists is in the range [0, 50].

-100 <= Node.val <= 100

Both list1 and list2 are sorted in non-decreasing order.

🚀 Solution Approach
Instead of allocating new nodes and copying values—which wastes memory—this solution uses an Iterative Two-Pointer Splicing approach to merge the lists in-place.

We track the structure using two reference points:

dummy: A sentinel node that acts as the fixed anchor before the head of our new merged list, eliminating tricky edge cases for empty inputs.

current: A tail pointer that tracks the last node of the building merged list.

We iterate through both lists simultaneously, comparing the values at the front of list1 and list2. The smaller node is linked directly to current.next. Once one of the lists is completely exhausted, we can wire the remainder of the non-empty list to the tail in O(1) structural time.

Complexity Analysis
Metric	Complexity	Description
Time Complexity	O(n+m)	The algorithm traverses each node in both lists at most once, where n and m are the lengths of list1 and list2.
Space Complexity	O(1)	Splicing is performed entirely in place by adjusting next pointers. No additional nodes are created.
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