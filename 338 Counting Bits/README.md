Counting BitsA highly efficient Java solution for the classic "Counting Bits" problem (LeetCode #338). This repository contains an optimized $O(N)$ Time Complexity approach utilizing Bitwise Dynamic Programming.📌 Problem DescriptionGiven an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.ExamplesExample 1:Input: n = 2Output: [0,1,1]Explanation:0 --> 0 (0 set bits)1 --> 1 (1 set bit)2 --> 10 (1 set bit)Example 2:Input: n = 5Output: [0,1,1,2,1,2]Explanation:0 --> 0 (0 set bits)1 --> 1 (1 set bit)2 --> 10 (1 set bit)3 --> 11 (2 set bits)4 --> 100 (1 set bit)5 --> 101 (2 set bits)Constraints0 <= n <= 10^5🚀 Solution ApproachRather than calculating the number of set bits independently for each number from 0 to n (which takes $O(N \log N)$ time), we can solve this problem in linear time using Bitwise Dynamic Programming.By observing binary patterns:Right-shifting a number by 1 bit (i >> 1) divides it by 2 and drops its least significant bit.The number of set bits in i is equal to the number of set bits in i >> 1 plus the value of the least significant bit itself (i & 1).This leads to a single-line recurrence relation:$$\text{dp}[i] = \text{dp}[i \gg 1] + (i \text{ \& } 1)$$By iteratively populating our results array from $1$ up to $N$, we reuse previously computed bit counts in $O(1)$ constant time per integer.Complexity AnalysisMetricComplexityDescriptionTime Complexity$O(N)$Each state from 1 to n is computed in $O(1)$ time using previously memoized results.Space Complexity$O(1)$Auxiliary space is $O(1)$ excluding the $O(N)$ space allocated for the output array ans.💻 Code StructureThe core implementation is written in Java:Javaclass Solution {
public int[] countBits(int n) {
// ans[i] will store the number of 1's in the binary representation of i
int[] ans = new int[n + 1];

        // Base case: ans[0] = 0 (already 0 by default array initialization)

        // Compute set bits for all numbers from 1 to n using dynamic programming
        for (int i = 1; i <= n; i++) {
            // dp[i] = dp[i / 2] + (1 if i is odd, else 0)
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
    }

}
