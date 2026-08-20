Find Minimum in Rotated Sorted ArrayA highly efficient Java solution for the classic "Find Minimum in Rotated Sorted Array" problem (LeetCode #153). This repository contains an optimized $O(\log N)$ Time Complexity approach utilizing a Modified Binary Search algorithm.📌 Problem DescriptionSuppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:[4,5,6,7,0,1,2] if it was rotated 4 times.[0,1,2,4,5,6,7] if it was rotated 7 times.Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].Given the sorted rotated array nums of unique elements, return the minimum element of this array.You must write an algorithm that runs in $O(\log n)$ time.ExamplesExample 1:  Input: nums = [3,4,5,1,2]Output: 1Explanation: The original array was [1,2,3,4,5] rotated 3 times.  Example 2:Input: nums = [4,5,6,7,0,1,2]Output: 0Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.Example 3:Input: nums = [11,13,15,17]Output: 11Explanation: The original array was [11,13,15,17] and it was rotated 4 times.Constraintsn == nums.length1 <= n <= 5000-5000 <= nums[i] <= 5000All the integers of nums are unique.nums is sorted and rotated between 1 and n times.🚀 Solution ApproachA linear scan takes $O(N)$ time, which violates the strict $O(\log N)$ constraint.To achieve $O(\log N)$ runtime complexity:Binary Search Framework: Initialize two pointers, left = 0 and right = nums.length - 1.Identify Pivot Location: Compare the middle element nums[mid] with the rightmost element nums[right]:If nums[mid] > nums[right], the inflection point (minimum element) must lie strictly to the right of mid. Thus, shift the left bound: left = mid + 1.If nums[mid] <= nums[right], nums[mid] could either be the minimum element itself or the minimum lies to its left. Thus, shrink the right bound: right = mid.Termination: The search loop terminates when left == right, pointing directly to the smallest element in the array.Complexity AnalysisMetricComplexityDescriptionTime Complexity$O(\log N)$In each iteration, the search space is halved, executing in logarithmic time where $N$ is the length of nums.Space Complexity$O(1)$Execution operates in constant space using iterative pointers (left, right, mid).💻 Code StructureThe core implementation is written in Java:Javaclass Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // If mid element is greater than the rightmost element,
            // the minimum element must lie in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } 
            // Otherwise, the minimum element is in the left half (including mid)
            else {
                right = mid;
            }
        }
        
        // When left == right, we have found the minimum element
        return nums[left];
    }
}
/