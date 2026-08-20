Reverse BitsA highly efficient Java solution for the classic "Reverse Bits" problem (LeetCode #190). This repository contains an optimized $O(1)$ Time Complexity approach utilizing Bit Manipulation.📌 Problem DescriptionReverse bits of a given 32-bit unsigned integer.ExamplesExample 1:Input: n = 00000010100101000001111010011100Output: 964176192 (00111001011110000010100101000000)Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which has binary representation 00111001011110000010100101000000.Example 2:Input: n = 11111111111111111111111111111101Output: 3221225471 (10111111111111111111111111111111)Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which has binary representation 10111111111111111111111111111111.ConstraintsThe input must be a binary string of length 32.🚀 Solution ApproachTo reverse the bits of a 32-bit integer, we process the integer bit-by-bit using Bit Manipulation:Initialize result to 0.Run a loop exactly 32 times (once for each bit in a standard 32-bit integer).Shift result to the left by 1 position (result <<= 1) to make space for the incoming bit.Extract the least significant bit (LSB) of n using bitwise AND (n & 1), and combine it into result using bitwise OR (|).Perform a logical right shift on n (n >>>= 1). Using >>> ensures zero-filling from the left, safely handling signed integer representations in Java.Because the loop executes a fixed 32 times regardless of input value, execution completes in guaranteed constant $O(1)$ time and memory.Complexity AnalysisMetricComplexityDescriptionTime Complexity$O(1)$The algorithm performs a fixed 32 iterations for any 32-bit integer input.Space Complexity$O(1)$Memory allocation is strictly $O(1)$ with zero additional data structures.💻 Code StructureThe core implementation is written in Java:Javapublic class Solution {
    // Treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        
        for (int i = 0; i < 32; i++) {
            // Shift result left to make room for the incoming bit
            result <<= 1;
            
            // Extract the rightmost bit of n and add it to result
            result |= (n & 1);
            
            // Unsigned right shift n by 1 bit to process the next bit
            n >>>= 1;
        }
        
        return result;
    }
}