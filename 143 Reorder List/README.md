Reorder ListA highly efficient Java solution for the classic "Reorder List" problem (LeetCode #143). This repository contains an optimized $O(N)$ Time Complexity approach utilizing a Two-Pointer & In-Place Reversal algorithm.📌 Problem DescriptionYou are given the head of a singly linked-list. The list can be represented as:$L_0 \rightarrow L_1 \rightarrow \dots \rightarrow L_{n-1} \rightarrow L_n$Reorder the list to be on the following form:$L_0 \rightarrow L_n \rightarrow L_1 \rightarrow L_{n-1} \rightarrow L_2 \rightarrow L_{n-2} \rightarrow \dots$You may not modify the values in the list's nodes. Only nodes themselves may be changed.ExamplesExample 1:Input: head = [1,2,3,4]Output: [1,4,2,3]Example 2:Input: head = [1,2,3,4,5]Output: [1,5,2,4,3]ConstraintsThe number of nodes in the list is in the range $[1, 5 \times 10^4]$.$1 \le \text{Node.val} \le 1000$🚀 Solution ApproachA naive approach would store all nodes in an array or stack to access them by index, costing $O(N)$ auxiliary space.To achieve an optimal in-place $O(1)$ space solution, the problem can be broken down into three distinct linear phases:Find the Middle: Utilize the Fast and Slow pointer technique (Tortoise and Hare). The slow pointer advances by one step while the fast pointer advances by two. When fast reaches the end, slow will rest exactly at the midpoint.Reverse the Second Half: Disconnect the first half from the second half (slow.next = null). Then, iterate through the second half, reversing the next pointers in-place just like the classic "Reverse Linked List" algorithm.Merge the Two Halves: Maintain two pointers, one at the start of the first half and one at the start of the reversed second half. Alternately stitch their nodes together by updating their next pointers step-by-step.Complexity AnalysisMetricComplexityDescriptionTime Complexity$O(N)$Finding the middle takes $O(N/2)$, reversing takes $O(N/2)$, and merging takes $O(N/2)$. The overall runtime simplifies to $O(N)$.Space Complexity$O(1)$Execution manipulates existing node pointers entirely in-place without allocating any additional data structures.💻 Code StructureThe core implementation is written in Java:Java/**
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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        
        // Step 1: Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Step 2: Reverse the second half of the list
        // 'slow' is currently the tail of the first half
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null; // Sever the list into two distinct halves
        
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        
        // Step 3: Merge the two halves
        // 'head' is the start of the first half, 'prev' is the start of the reversed second half
        ListNode first = head;
        ListNode second = prev;
        
        while (second != null) {
            // Store the next nodes before overwriting pointers
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            
            // Link first half node to second half node
            first.next = second;
            // Link second half node to the next first half node
            second.next = tmp1;
            
            // Advance both pointers
            first = tmp1;
            second = tmp2;
        }
    }
}