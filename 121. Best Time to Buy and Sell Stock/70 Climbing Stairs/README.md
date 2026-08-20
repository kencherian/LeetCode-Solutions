Climbing StairsA highly efficient Java solution for the classic "Climbing Stairs" problem (LeetCode #70). This repository contains an optimized $O(N)$ Time Complexity approach utilizing a Dynamic Programming (Space-Optimized) algorithm.📌 Problem DescriptionYou are climbing a staircase. It takes n steps to reach the top.  Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?  ExamplesExample 1:  Input: n = 2Output: 2Explanation: There are two ways to climb to the top:  1 step + 1 step  2 steps  Example 2:  Input: n = 3Output: 3Explanation: There are three ways to climb to the top:1 step + 1 step + 1 step1 step + 2 steps2 steps + 1 stepConstraints1 <= n <= 45🚀 Solution ApproachThe problem can be modeled as a fundamental Dynamic Programming problem. To reach the $n$-th step, you must come from either the $(n-1)$-th step (by taking a 1-step leap) or the $(n-2)$-th step (by taking a 2-step leap). Thus, the total distinct ways to reach step $n$ is given by the recurrence relation:$$\text{dp}[n] = \text{dp}[n-1] + \text{dp}[n-2]$$This logic directly mimics the Fibonacci sequence.Instead of keeping an array of size $N$ to store all intermediate states (which takes $O(N)$ auxiliary space), we only need to maintain the previous two state values (prev2 and prev1). By updating these two state variables iteratively in a bottom-up approach, we reduce the space requirement to $O(1)$.Complexity AnalysisMetricComplexityDescriptionTime Complexity$O(N)$A single loop executes $N$ times to calculate the total distinct ways step by step.Space Complexity$O(1)$Only two integer variables (prev1 and prev2) are used to track state transitions.💻 Code StructureThe core implementation is written in Java:Javaclass Solution {
    public int climbStairs(int n) {
        // Base case: 1 way to reach step 1
        if (n == 1) {
            return 1;
        }
        
        // Base cases tracking ways to reach the previous two steps
        int prev2 = 1; // dp[1] -> 1 way to reach step 1
        int prev1 = 2; // dp[2] -> 2 ways to reach step 2
        
        // Iteratively compute ways for step 3 up to step n
        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
}