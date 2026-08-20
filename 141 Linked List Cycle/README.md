Linked List Cycle
=================

A highly efficient Java solution for the classic "Linked List Cycle" problem (LeetCode #141). This repository contains an optimized $O(n)$ time complexity approach utilizing Floyd's Cycle-Finding Algorithm (also known as the Tortoise and the Hare algorithm).

📌 Problem Description
----------------------

Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

### Examples

**Example 1:**

*   **Input:** head = \[3,2,0,-4\], pos = 1
    
*   **Output:** true
    
*   **Explanation:** There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
    

**Example 2:**

*   **Input:** head = \[1,2\], pos = 0
    
*   **Output:** true
    
*   **Explanation:** There is a cycle in the linked list, where the tail connects to the 0th node.
    

**Example 3:**

*   **Input:** head = \[1\], pos = -1
    
*   **Output:** false
    
*   **Explanation:** There is no cycle in the linked list.
    

### Constraints

*   The number of nodes in the list is in the range $\[0, 10^4\]$.
    
*   $-10^5 \\le \\text{Node.val} \\le 10^5$
    
*   pos is -1 or a valid index in the linked-list.
    

🚀 Solution Approach
--------------------

Instead of using a hash set to store visited nodes—which demands extra memory allocation—this solution applies **Floyd's Cycle-Finding Algorithm**.

We maintain two pointers traversing the list at different speeds:

1.  **slow (Tortoise):** Advances by exactly one node per step.
    
2.  **fast (Hare):** Advances by exactly two nodes per step.
    

If the linked list does not contain a cycle, the fast pointer will eventually hit the end (null), allowing us to quickly return false. If a cycle exists, the fast pointer will continuously loop within the cycle, closing the distance gap by $1$ node per iteration until it inevitably meets the slow pointer from behind.

### Complexity Analysis

Metric

Complexity

Description

**Time Complexity**

$O(n)$

In the worst-case scenario where a cycle exists, the fast pointer catches up to the slow pointer within $n$ iterations.

**Space Complexity**

$O(1)$

No extra memory structure is allocated. The tracking relies entirely on two pointer references.

💻 Code Structure
-----------------

The core implementation is written in **Java**:

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   /**   * Definition for singly-linked list.   * class ListNode {   *     int val;   *     ListNode next;   *     ListNode(int x) {   *         val = x;   *         next = null;   *     }   * }   */  public class Solution {      public boolean hasCycle(ListNode head) {          // Guard clause: an empty list or a single node without a link cannot have a cycle          if (head == null || head.next == null) {              return false;          }          // Initialize two pointers traveling at different speeds          ListNode slow = head;          ListNode fast = head;          // Traverse the list; fast moves twice as fast as slow          while (fast != null && fast.next != null) {              slow = slow.next;         // Move 1 step              fast = fast.next.next;    // Move 2 steps              // If the pointers meet, a cycle exists              if (slow == fast) {                  return true;              }          }          // The fast pointer reached the end of the list, meaning no cycle exists          return false;      }  }   `
