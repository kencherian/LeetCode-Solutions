Number of 1 BitsA highly efficient Java solution for the classic "Number of 1 Bits" problem (LeetCode #191). This repository contains an optimized $O(K)$ Time Complexity approach utilizing Brian Kernighan's Bit Manipulation Algorithm.📌 Problem DescriptionGiven a positive integer n, write a function that returns the number of set bits it has (also known as the Hamming weight).ExamplesExample 1:  Input: n = 11Output: 3Explanation: The input binary string 1011 has a total of three set bits.  Example 2:  Input: n = 128Output: 1Explanation: The input binary string 10000000 has a total of one set bit.  Example 3:  Input: n = 2147483645Output:   30Explanation: The input binary string 1111111111111111111111111111101 has a total of thirty set bits.  Constraints1 <= n <= 2^31 - 1🚀 Solution ApproachWhile a simple approach involves checking all 32 bits by shifting n right continuously ($O(32)$ operations), we can optimize this using Brian Kernighan's Algorithm.The expression n & (n - 1) drops the lowest set bit (the rightmost 1) of n. By performing this bitwise operation in a loop and counting how many times it executes before n becomes 0, the algorithm runs only as many times as there are set bits ($K$). This beats inspecting zero-bits entirely.Complexity AnalysisMetricComplexityDescriptionTime Complexity$O(K)$Where $K$ is the number of set bits (1s) in n. In the worst case, $K \le 32$, making execution extremely fast.Space Complexity$O(1)$No additional memory is allocated; execution operates strictly using bitwise register operations.💻 Code StructureThe core implementation is written in Java:Javaclass Solution {
    public int hammingWeight(int n) {
        int count = 0;
        
        // Loop runs only for the number of set bits
        while (n != 0) {
            // Clears the lowest set bit in n
            n = n & (n - 1);
            count++;
        }
        
        return count;
    }
}