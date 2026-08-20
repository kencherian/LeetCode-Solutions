Find All Numbers Disappeared in an ArrayA highly efficient Java solution for the classic "Find All Numbers Disappeared in an Array" problem (LeetCode #448). This repository contains an optimized $O(n)$ Time Complexity approach utilizing a Cyclic Sort / In-place Marking pattern.📌 Problem DescriptionGiven an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.  Examples  Example 1:  Input: nums = [4,3,2,7,8,2,3,1]Output: [5,6]Example 2:  Input: nums = [1,1]Output: [2]Constraints  n == nums.length$1 \le n \le 10^5$$1 \le nums[i] \le n$🚀 Solution ApproachTo solve this problem without using extra space (meeting the follow-up constraint), we leverage the fact that all numbers in the array fall perfectly within the range [1, n]. This means each number can be directly mapped to a valid index in the array (index = value - 1).In-place Marking: We iterate through the array. For every value we encounter, we treat its absolute value minus one as an index. We then look at the element at that index and flip it to negative if it isn't already. This acts as a "visited" flag.Missing Number Identification: We walk through the array a second time. If the number at index i is positive, it means the value i + 1 was never encountered during our first pass.Result Collection: We append all such i + 1 values to our dynamic ArrayList result list.This strategy completely bypasses the brute-force approach (which would require $O(n^2)$ time searching or an $O(n)$ auxiliary HashSet) by turning the input array itself into a state-tracking mechanism.Complexity AnalysisMetricComplexityDescriptionTime Complexity$O(n)$We pass through the array exactly two times, leading to a linear runtime.Space Complexity$O(1)$No extra space is used except for the output list, which is excluded per the problem's follow-up prompt.💻 Code StructureThe core implementation is written in Java:Javaimport java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // Utilizing ArrayList to dynamically collect missing elements
        List<Integer> result = new ArrayList<>(); 
        
        // Step 1: Iterate through the array and mark visited indices negative
        for (int i = 0; i < nums.length; i++) {
            int targetIndex = Math.abs(nums[i]) - 1;

            if (nums[targetIndex] > 0) {
                nums[targetIndex] = -nums[targetIndex];
            }
        }

        // Step 2: Iterate again to find indices that remain positive
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1); 
            }
        }

        return result; 
    }
}