Missing NumberA highly efficient Java solution for the classic "Missing Number" problem (LeetCode #268). This repository contains an optimized $O(N)$ Time Complexity approach utilizing Bitwise XOR manipulation.📌 Problem DescriptionGiven an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.  ExamplesExample 1:  Input: nums = [3,0,1]Output: 2Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number since it does not appear in nums.Example 2:Input: nums = [0,1]  Output: 2Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number since it does not appear in nums.  Example 3:  Input: nums = [9,6,4,2,3,5,7,0,1]Output: 8Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number since it does not appear in nums.  Constraintsn == nums.length1 <= n <= 10^40 <= nums[i] <= nAll the numbers of nums are unique.🚀 Solution ApproachWhile this can be solved using Gauss's summation formula ($\text{Sum} = \frac{n(n+1)}{2}$), that approach carries a minor risk of integer overflow for massive array sizes.To achieve maximum efficiency without overflow risks, we use Bitwise XOR Manipulation:XOR possesses key properties: $x \oplus x = 0$ and $x \oplus 0 = x$.If we XOR all indices from 0 to n together with every element present in the nums array, every number that exists in both the index range and the array will cancel itself out ($x \oplus x = 0$).The only value that remains will be the single missing number.Complexity AnalysisMetricComplexityDescriptionTime Complexity$O(N)$A single linear pass processes all $N$ elements in the array.Space Complexity$O(1)$Memory usage is strictly $O(1)$ as operations are performed in-place using a single accumulator variable.💻 Code StructureThe core implementation is written in Java:Javaclass Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int missing = n;
        
        // XOR both index and value at each step
        for (int i = 0; i < n; i++) {
            missing ^= i ^ nums[i];
        }
        
        return missing;
    }
}