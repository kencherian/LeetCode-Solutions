Same TreeA highly efficient Java solution for the classic "Same Tree" problem (LeetCode #100). This repository contains an optimized $O(N)$ Time Complexity approach utilizing a Recursive Depth-First Search (DFS) traversal.📌 Problem DescriptionGiven the roots of two binary trees p and q, write a function to check if they are the same or not.Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.  ExamplesExample 1:  Input: p = [1,2,3], q = [1,2,3]Output: trueExample 2:  Input: p = [1,2], q = [1,null,2]Output: falseExample 3:  Input:   p = [1,2,1], q = [1,1,2]Output: falseConstraintsThe number of nodes in both trees is in the range [0, 100].-10^4 <= Node.val <= 10^4🚀 Solution ApproachThe optimal strategy to solve this problem is using a structural Recursive Depth-First Search (DFS) to evaluate both trees simultaneously.Instead of serialization or structural flattening which requires extra heap allocation, a simultaneous pre-order traversal compares nodes on the fly. For any pair of nodes being evaluated, three conditions must hold true:Both nodes are null (Base case: reached structural boundary safely, return true).One node is null while the other is not (Structural mismatch, return false).Both nodes contain identical data values (p.val == q.val).If the values match, the algorithm recursively validates their left subtrees and right subtrees. The operation returns true only if every structural branch evaluates successfully.Complexity AnalysisMetricComplexityDescriptionTime Complexity$O(N)$We visit every node at most once, where $N$ is the total number of nodes in the smaller tree.Space Complexity$O(H)$The space complexity depends on the tree height $H$ due to the recursive call stack. In the worst case (skewed tree), it is $O(N)$; in the best case (balanced tree), it is $O(\log N)$.💻 Code StructureThe core implementation is written in Java:Java/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base case 1: Both nodes are null, meaning structurally identical so far
        if (p == null && q == null) {
            return true;
        }
        
        // Base case 2: One node is null and the other isn't, structural mismatch
        if (p == null || q == null) {
            return false;
        }
        
        // Base case 3: Values don't match
        if (p.val != q.val) {
            return false;
        }
        
        // Recursively check if the left subtrees and right subtrees match completely
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}