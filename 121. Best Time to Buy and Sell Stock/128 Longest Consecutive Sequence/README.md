Longest Consecutive SequenceA highly efficient Java solution for the classic "Longest Consecutive Sequence" problem (LeetCode #128). This repository contains an optimized $O(N)$ Time Complexity approach utilizing a Hash Set sequence building algorithm.📌 Problem DescriptionGiven an unsorted array of integers nums, return the length of the longest consecutive elements sequence.You must write an algorithm that runs in $O(n)$ time.ExamplesExample 1:Input: nums = [100,4,200,1,3,2]Output: 4Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.Example 2:Input: nums = [0,3,7,2,5,8,4,6,0,1]Output: 9Constraints0 <= nums.length <= 10^5-10^9 <= nums[i] <= 10^9🚀 Solution ApproachSorting the array first would take $O(N \log N)$ time, which violates the strict $O(N)$ time constraint.To achieve linear time complexity:Hash Set Insertion: We populate a HashSet with all numbers from nums. This grants us $O(1)$ average time complexity for value lookups and automatically eliminates duplicates.Sequence Boundary Detection: Instead of building sequences starting from every number, we only initiate a count if the current number is the start of a sequence. A number num is a sequence start if set.contains(num - 1) returns false.Linear Counting: For each sequence start, we incrementally check for num + 1, num + 2, and so on, keeping track of the current sequence length and updating the global maximum.Because each number is visited at most twice (once when checking if it's a sequence start and once when included in a sequence walk), the total execution time remains strictly $O(N)$.Complexity AnalysisMetricComplexityDescriptionTime Complexity$O(N)$Inserting elements into the hash set takes $O(N)$. The sequence lookup loop processes each element at most twice across all iterations.Space Complexity$O(N)$The hash set stores up to $N$ unique elements from the array.💻 Code StructureThe core implementation is written in Java:Javaimport java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Store all unique numbers in a HashSet for O(1) lookups
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;

        for (int num : set) {
            // Check if 'num' is the start of a consecutive sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                // Expand the sequence forward
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                // Update the maximum sequence length found
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }
}