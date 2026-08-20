Subtree of Another TreeA highly efficient Java solution for the classic "Subtree of Another Tree" problem (LeetCode #572). This repository contains an optimized $O(M \times N)$ Time Complexity approach utilizing a Recursive Depth-First Search (DFS) traversal.  📌 Problem DescriptionGiven the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.  A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.  ExamplesExample 1:  Input: root = [3,4,5,1,2], subRoot = [4,1,2]Output: true  Example 2:  Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]Output: false  Constraints  The number of nodes in the root tree is in the range [1, 2000].  The number of nodes in the subRoot tree is in the range [1, 1000].  -10^4 <= root.val <= 10^4  -10^4 <= subRoot.val <= 10^4  🚀 Solution ApproachThe problem can be solved by leveraging a modular Recursive Depth-First Search (DFS) strategy:  Tree Traversal (isSubtree): We traverse the main root tree. At each node, we check if the current subtree rooted at this node is identical to subRoot using a helper function. If it isn't, we recursively check the left and right children of root.  Structural Equality Check (isSameTree): The helper function simultaneously evaluates two trees to check if they are structurally and textually identical (identical to LeetCode #100).  By separating the traversal from the identity check, the code remains highly readable and clean.  Complexity AnalysisMetricComplexityDescriptionTime Complexity$O(M \times N)$In the worst case (e.g., matching node values but structural mismatches at the leaves), we may invoke isSameTree for every node in root. Here, $M$ is the number of nodes in root and $N$ is the number of nodes in subRoot.Space Complexity$O(H_{root})$The auxiliary space depends on the depth of the recursive call stack, bounded by the height of the main tree $H_{root}$.💻 Code StructureThe core implementation is written in Java:Java/**
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Base case: If the main tree is null, subRoot cannot be a subtree
        if (root == null) {
            return false;
        }
        
        // If the current structures match completely, we found the subtree
        if (isSameTree(root, subRoot)) {
            return true;
        }
        
        // Otherwise, look for the subRoot in the left or right subtrees of the main tree
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    // Helper function to check if two trees are completely identical (LeetCode #100)
    private boolean isSameTree(TreeNode p, TreeNode q) {
        // Both reach boundary safely
        if (p == null && q == null) {
            return true;
        }
        
        // One reaches boundary early -> structural mismatch
        if (p == null || q == null) {
            return false;
        }
        
        // Value mismatch
        if (p.val != q.val) {
            return false;
        }
        
        // Check structural identity for both left and right child branches
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}