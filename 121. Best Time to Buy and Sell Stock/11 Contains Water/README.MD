Container With Most WaterA highly efficient Java solution for the classic "Container With Most Water" problem (LeetCode #11). This repository contains an optimized $O(N)$ Time Complexity approach utilizing a Two-Pointer technique.📌 Problem DescriptionYou are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the $i^{\text{th}}$ line are (i, 0) and (i, height[i]).Find two lines that together with the x-axis form a container, such that the container contains the most water.Return the maximum amount of water a container can store.Notice that you may not slant the container.ExamplesExample 1:Input: height = [1,8,6,2,5,4,8,3,7]Output: 49Explanation: The vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water the container can contain is between index 1 (height 8) and index 8 (height 7), which equals min(8, 7) * (8 - 1) = 7 * 7 = 49.Example 2:Input: height = [1,1]Output: 1Constraintsn == height.length2 <= n <= 10^50 <= height[i] <= 10^4🚀 Solution ApproachThe brute-force approach evaluates all possible pairs of lines to calculate the area, resulting in $O(N^2)$ time complexity, which leads to a Time Limit Exceeded (TLE) on large inputs.To solve this problem in optimal linear time $O(N)$:Two-Pointer Initialization: Place one pointer left at the beginning of the array (0) and another pointer right at the end (n - 1). This maximizes the width of the container initially.Area Calculation: At each step, calculate the area formed by the two lines using the formula:$$\text{Area} = \min(\text{height}[left], \text{height}[right]) \times (right - left)$$Greedy Pointer Movement: The volume of water is always constrained by the shorter line. Moving the taller line's pointer would only decrease the width without any chance of increasing the height limit. Therefore, we greedily move the pointer corresponding to the shorter height inward (left++ if height[left] < height[right], otherwise right--) in search of a taller boundary.Track Maximum: Update the global maximum area at each iteration until the two pointers meet.Complexity AnalysisMetricComplexityDescriptionTime Complexity$O(N)$The two pointers start at opposite ends and move toward each other, inspecting each element at most once in a single linear pass.Space Complexity$O(1)$Execution operates in constant auxiliary space using only primitive scalar variables for state tracking.💻 Code StructureThe core implementation is written in Java:Javaclass Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            // The height of the container is limited by the shorter line
            int currentHeight = Math.min(height[left], height[right]);
            int currentWidth = right - left;
            int currentArea = currentHeight * currentWidth;
            
            // Update maxArea if the current container holds more water
            maxArea = Math.max(maxArea, currentArea);
            
            // Greedily move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
}