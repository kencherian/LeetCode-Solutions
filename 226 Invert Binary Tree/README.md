Invert Binary TreeA highly efficient Java solution for the classic "Invert Binary Tree" problem (LeetCode #226). This repository contains an optimized $O(N)$ Time Complexity approach utilizing a Recursive Depth-First Search (DFS) algorithm.📌 Problem DescriptionGiven the root of a binary tree, invert the tree, and return its root. Inverting a binary tree means that for every node in the tree, its left and right children are swapped.ExamplesExample 1:Input: root = [4,2,7,1,3,6,9]Output: [4,7,2,9,6,3,1]Example 2:Input: root = [2,1,3]Output: [2,3,1]Example 3:Input: root = []Output: []ConstraintsThe number of nodes in the tree is in the range [0, 100].-100 <= Node.val <= 100🚀 Solution ApproachThe problem requires transforming a binary tree into its mirror image. The optimal approach is to traverse the tree using Depth-First Search (DFS) via recursion:Base Case: If the current node is null, we return null because there are no children to swap.Recursive Step: We recursively visit the left child and the right child of the current node.Swap Action: We swap the left and right pointers of the current node.Return: Finally, we return the current node up the call stack.This post-order traversal strategy ensures that all subtrees are inverted before or during the processing of their parent nodes, achieving full inversion efficiently without any overhead from external data structures.Complexity AnalysisMetricComplexityDescriptionTime ComplexityO(N)Every node in the binary tree is visited exactly once, where N is the total number of nodes.Space ComplexityO(H)Space is determined by the recursive call stack, where H is the height of the tree. In the worst-case scenario (a skewed tree), it takes O(N), and in the best-case scenario (a balanced tree), it takes O(log N).💻 Code StructureThe core implementation is written in Java:Java/**
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
    public TreeNode invertTree(TreeNode root) {
        // Base case: if the tree is empty, return null
        if (root == null) {
            return null;
        }
        
        // Recursively invert the left and right subtrees
        TreeNode leftInverted = invertTree(root.left);
        TreeNode rightInverted = invertTree(root.right);
        
        // Swap the left and right children
        root.left = rightInverted;
        root.right = leftInverted;
        
        // Return the root of the inverted tree
        return root;
    }
}