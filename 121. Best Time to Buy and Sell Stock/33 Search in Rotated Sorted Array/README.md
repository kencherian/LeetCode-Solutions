Search in Rotated Sorted ArrayA highly efficient Java solution for the classic "Search in Rotated Sorted Array" problem (LeetCode #33). This repository contains an optimized $O(\log N)$ Time Complexity approach utilizing a Modified Binary Search algorithm.📌 Problem DescriptionThere is an integer array nums sorted in ascending order (with distinct values).Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.  You must write an algorithm with $O(\log n)$ runtime complexity.  ExamplesExample 1:  Input: nums = [4,5,6,7,0,1,2], target = 0Output: 4Example 2:  Input: nums = [4,5,6,7,0,1,2], target = 3Output: -1Example 3:  Input: nums = [1], target = 0Output: -1Constraints1 <= nums.length <= 5000-10^4 <= nums[i] <= 10^4All values of nums are unique.nums is an ascending array that was possibly rotated.-10^4 <= target <= 10^4🚀 Solution ApproachA linear scan takes $O(N)$ time, which violates the strict $O(\log N)$ requirement.To maintain $O(\log N)$ execution time on a rotated array, we adapt Binary Search:Key Observation: If you divide a rotated sorted array in half at any midpoint mid, at least one half (either left or right) is guaranteed to be strictly sorted.Identify the Sorted Half: Compare nums[left] with nums[mid].If nums[left] <= nums[mid], the left half [left...mid] is sorted.Otherwise, the right half [mid...right] is sorted.Determine Target Boundary: Check if target falls within the range of the sorted half:If target lies within the sorted half's range, narrow the binary search scope to that half.Otherwise, search the unsorted half.This halving property guarantees convergence in logarithmic time.Complexity AnalysisMetricComplexityDescriptionTime Complexity$O(\log N)$In each step, the search space is halved, yielding logarithmic time complexity where $N$ is the length of nums.Space Complexity$O(1)$Execution operates in constant space using iterative pointers (left, right, mid).💻 Code StructureThe core implementation is written in Java:Javaclass Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Target found
            if (nums[mid] == target) {
                return mid;
            }
            
            // Check if the left half is sorted
            if (nums[left] <= nums[mid]) {
                // Target lies within the sorted left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } 
            // Otherwise, the right half must be sorted
            else {
                // Target lies within the sorted right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        // Target not present in array
        return -1;
    }
}