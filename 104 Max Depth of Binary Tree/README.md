Maximum Depth of Binary TreeA highly efficient Java solution for the classic "Maximum Depth of Binary Tree" problem (LeetCode #104). This repository contains an optimized $O(N)$ Time Complexity approach utilizing a Recursive Depth-First Search (DFS) traversal.📌 Problem DescriptionGiven the root of a binary tree, return its maximum depth.A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.ExamplesExample 1:Input: root = [3,9,20,null,null,15,7]Output: 3Example 2:Input: root = [1,null,2]Output: 2ConstraintsThe number of nodes in the tree is in the range [0, 10^4].-100 <= Node.val <= 100🚀 Solution ApproachThe optimal strategy to solve this problem is using a post-order Recursive Depth-First Search (DFS).Instead of an expensive level-order traversal (BFS) which requires extra queue memory proportional to the tree's width, the recursive DFS naturally leverages the call stack to explore down to the leaf nodes. For any given node, maximum depth is determined by calculating the maximum depth of its left and right subtrees and adding 1 to account for the current node itself.The base case occurs when the traversal hits a null node, representing an empty subtree, which returns a depth of 0.Complexity AnalysisMetricComplexityDescriptionTime Complexity$O(N)$We visit every node exactly once, where $N$ is the total number of nodes in the tree.Space Complexity$O(H)$The space complexity depends on the tree height $H$ due to the recursive call stack. In the worst case (skewed tree), it is $O(N)$; in the best case (perfectly balanced tree), it is $O(\log N)$.💻 Code StructureThe core implementation is written in Java:Java/\*\*

- Definition for a binary tree node.
- public class TreeNode {
-     int val;
-     TreeNode left;
-     TreeNode right;
-     TreeNode() {}
-     TreeNode(int val) { this.val = val; }
-     TreeNode(int val, TreeNode left, TreeNode right) {
-         this.val = val;
-         this.left = left;
-         this.right = right;
-     }
- }
  \*/
  class Solution {
  public int maxDepth(TreeNode root) {
  // Base case: If the current node is null, the depth is 0
  if (root == null) {
  return 0;
  }
          // Recursively find the maximum depth of the left subtree
          int leftDepth = maxDepth(root.left);

          // Recursively find the maximum depth of the right subtree
          int rightDepth = maxDepth(root.right);

          // The depth of the current node is the maximum of its subtrees + 1
          return Math.max(leftDepth, rightDepth) + 1;
      }
  }
