Product of Array Except SelfA highly efficient Java solution for the classic "Product of Array Except Self" problem (LeetCode #238). This repository contains an optimized $O(N)$ Time Complexity approach utilizing a Prefix and Suffix Product algorithm with $O(1)$ auxiliary space.📌 Problem DescriptionGiven an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.  You must write an algorithm that runs in $O(n)$ time and without using the division operation.  ExamplesExample 1:  Input: nums = [1,2,3,4]Output: [24,12,8,6]Example 2:  Input: nums = [-1,1,0,-3,3]Output: [0,0,9,0,0]Constraints2 <= nums.length <= 10^5-30 <= nums[i] <= 30  The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.  Follow-up: Can you solve the problem in $O(1)$ extra space complexity? (The output array does not count as extra space for space complexity analysis.)  🚀 Solution ApproachThe naive approach relies on calculating the total product of all elements and dividing by nums[i] for each index, but the problem explicitly forbids the division operator and must handle zeroes gracefully.To achieve an optimal solution without division:Prefix Pass: We initialize the output array answer where answer[i] stores the product of all elements to the left of index i. We iterate through the array from left to right, maintaining a running prefix product.Suffix Pass: We iterate through the array backwards (from right to left) using a running variable suffix to calculate the product of all elements to the right of index i. We multiply the existing value in answer[i] by suffix on the fly.By reusing the result array answer to store prefix products and accumulating suffix products in a single scalar variable, we achieve $O(1)$ auxiliary space while remaining strictly linear in time.Complexity AnalysisMetricComplexityDescriptionTime Complexity$O(N)$The array is traversed twice in two linear passes (left-to-right and right-to-left), where $N$ is the length of nums.Space Complexity$O(1)$No extra data structures are used beyond the output array, which is excluded from space complexity analysis per the problem prompt.💻 Code StructureThe core implementation is written in Java:Javaclass Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        
        // Step 1: Compute prefix products for each index
        // answer[i] contains the product of all elements to the left of i
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        
        // Step 2: Compute suffix products on the fly and multiply with prefix values
        // suffix stores the running product of all elements to the right of i
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * suffix;
            suffix *= nums[i];
        }
        
        return answer;
    }
}