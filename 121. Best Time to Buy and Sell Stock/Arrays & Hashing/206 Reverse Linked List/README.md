Reverse Linked List

A highly efficient Java solution for the classic "Reverse Linked List" problem (LeetCode #206). This repository contains an optimized $O(n)$ Time Complexity approach utilizing a Three-Pointer Iterative Strategy.

📌 Problem Description
Given the head of a singly linked list, reverse the list, and return the reversed list.

Examples

Example 1:

Input: head = [1,2,3,4,5]

Output: [5,4,3,2,1]

Example 2:

Input: head = [1,2]

Output: [2,1]

Example 3:

Input: head = []

Output: []

Constraints

The number of nodes in the list is the range [0, 5000].

$-5000 \le \text{Node.val} \le 5000$

🚀 Solution Approach
The optimal way to reverse a singly linked list in-place without using extra memory is by utilizing an iterative three-pointer approach (prev, curr, and nextTemp).

Initialization: We initialize prev to null (since the new tail will point to null) and curr to the head of the list.

Traversal & Reversal: We iterate through the list node by node. In each step:

Save the next node (nextTemp = curr.next) so we don't lose the rest of the list.

Reverse the current node's pointer to point backwards (curr.next = prev).

Shift prev and curr one step forward (prev = curr, curr = nextTemp).

Termination: When curr becomes null, prev will be standing at the new head of the reversed list.

This approach beats the brute-force method of copying values to an array, as it requires no extra space and modifies the structure in a single pass.

Complexity Analysis

Metric

Complexity

Description

Time Complexity

$O(n)$

We traverse the list exactly once, where $n$ is the number of nodes.

Space Complexity

$O(1)$

The reversal is done in-place using only pointers, requiring no auxiliary storage.

💻 Code Structure
The core implementation is written in Java:

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


🔍 Step-by-Step Execution Trace
Here is a step-by-step structural trace of how the pointers shift during each pass of the iterative algorithm, using the example list [1, 2, 3, 4, 5].

Initially, the list is: 1 → 2 → 3 → 4 → 5 → null.

prev is initialized to null.

curr starts at 1.

Before Loop Starts

prev = null

curr = 1

Pass 1 (Processing Node 1)

Save next: nextTemp = curr.next $\rightarrow$ nextTemp points to 2.

Reverse link: curr.next = prev $\rightarrow$ Node 1 now points to null.

Shift pointers: * prev = curr $\rightarrow$ prev points to 1.

curr = nextTemp $\rightarrow$ curr points to 2.

State of list: null ← 1 and 2 → 3 → 4 → 5 → null

Pass 2 (Processing Node 2)

Save next: nextTemp = curr.next $\rightarrow$ nextTemp points to 3.

Reverse link: curr.next = prev $\rightarrow$ Node 2 now points to 1.

Shift pointers: * prev = curr $\rightarrow$ prev points to 2.

curr = nextTemp $\rightarrow$ curr points to 3.

State of list: null ← 1 ← 2 and 3 → 4 → 5 → null

Pass 3 (Processing Node 3)

Save next: nextTemp = curr.next $\rightarrow$ nextTemp points to 4.

Reverse link: curr.next = prev $\rightarrow$ Node 3 now points to 2.

Shift pointers: * prev = curr $\rightarrow$ prev points to 3.

curr = nextTemp $\rightarrow$ curr points to 4.

State of list: null ← 1 ← 2 ← 3 and 4 → 5 → null

Pass 4 (Processing Node 4)

Save next: nextTemp = curr.next $\rightarrow$ nextTemp points to 5.

Reverse link: curr.next = prev $\rightarrow$ Node 4 now points to 3.

Shift pointers: * prev = curr $\rightarrow$ prev points to 4.

curr = nextTemp $\rightarrow$ curr points to 5.

State of list: null ← 1 ← 2 ← 3 ← 4 and 5 → null

Pass 5 (Processing Node 5)

Save next: nextTemp = curr.next $\rightarrow$ nextTemp points to null.

Reverse link: curr.next = prev $\rightarrow$ Node 5 now points to 4.

Shift pointers: * prev = curr $\rightarrow$ prev points to 5.

curr = nextTemp $\rightarrow$ curr points to null.

State of list: null ← 1 ← 2 ← 3 ← 4 ← 5

Termination

The loop terminates because curr == null.

The function returns prev, which is pointing to node 5. Looking at the pointers from 5, the list reads natively as:
5 → 4 → 3 → 2 → 1 → null.