Lowest Common Ancestor of a Binary Search TreeA highly efficient Java solution for the classic "Lowest Common Ancestor of a Binary Search Tree" problem (LeetCode #235). This repository contains an optimized $O(H)$ Time Complexity approach utilizing an Iterative BST Traversal algorithm.📌 Problem DescriptionGiven a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.According to the definition of LCA on Wikipedia: "The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself)."  ExamplesExample 1:  Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8Output: 6Explanation: The LCA of nodes 2 and 8 is 6.  Example 2:  Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4Output: 2Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.  Example 3:  Input: root = [2,1], p = 2, q = 1Output: 2Constraints  The number of nodes in the tree is in the range [2, 10^5].  -10^9 <= Node.val <= 10^9All Node.val are unique.p != qp and q will exist in the BST.🚀 Solution ApproachIn a standard binary tree, finding the LCA typically requires exploring both subtrees and propagating results upward ($O(N)$ time). However, we can take advantage of the Binary Search Tree (BST) property: for every node, all values in its left subtree are strictly smaller, and all values in its right subtree are strictly larger.Using an Iterative BST Traversal:Start at the root node.If both p.val and q.val are strictly greater than root.val, the LCA must reside entirely in the right subtree. We update root = root.right.If both p.val and q.val are strictly smaller than root.val, the LCA must reside entirely in the left subtree. We update root = root.left.If one value is on the left and the other is on the right (or if one matches root.val), we have reached the split point. This current node is guaranteed to be the lowest common ancestor.Iterating instead of recursing keeps auxiliary memory strictly at $O(1)$ by avoiding call-stack overhead.Complexity AnalysisMetricComplexityDescriptionTime Complexity$O(H)$At each step, we traverse down one level of the tree, where $H$ is the height of the tree. This is $O(\log N)$ on average for a balanced BST and $O(N)$ in the worst case (skewed tree).Space Complexity$O(1)$Traversal is handled iteratively using pointer updates without recursion or extra memory allocation.💻 Code StructureThe core implementation is written in Java:Java/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        
        while (curr != null) {
            // If both p and q are greater than current node, LCA is in the right subtree
            if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            } 
            // If both p and q are smaller than current node, LCA is in the left subtree
            else if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
            } 
            // We have found the split point (or matched one of the targets), which is the LCA
            else {
                return curr;
            }
        }
        
        return null;
    }
}