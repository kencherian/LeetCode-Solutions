Longest Repeating Character ReplacementA highly efficient Java solution for the classic "Longest Repeating Character Replacement" problem (LeetCode #424). This repository contains an optimized $O(N)$ Time Complexity approach utilizing a Sliding Window technique with Frequency Tracking.📌 Problem DescriptionYou are given a string s consisting of only uppercase English letters and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.Return the length of the longest substring containing the same letter you can get after performing the above operations.ExamplesExample 1:Input: s = "ABAB", k = 2Output: 4Explanation: Replace the two 'A's with 'B's or vice versa to obtain "BBBB" or "AAAA".Example 2:Input: s = "AABABBA", k = 1Output: 4Explanation: Replace the 'B' at index 2 to form "AAAAA", or replace 'A' at index 3 to form "AABBB". The substring "AABB" or "BBBA" (and others) can also be formed, giving maximum length 4.Constraints1 <= s.length <= 10^5s consists of only uppercase English letters.0 <= k <= s.length🚀 Solution ApproachThe optimal approach utilizes a variable-size Sliding Window:Validity Condition: A window defined by indices [left, right] is valid if the number of character replacements needed is at most k. The minimum number of replacements needed in any window is given by:$$\text{Replacements} = (\text{Window Size}) - (\text{Max Frequency of a Single Character in Window})$$Frequency Array: We maintain a frequency array of size 26 to track occurrences of each character within the active window, alongside a variable maxCount tracking the highest frequency of any single character seen in the current window.Window Expansion & Contraction:Expand the window by moving the right pointer and updating character counts and maxCount.If (right - left + 1) - maxCount > k, the current window requires more than k replacements. We increment left to shrink the window from the left.Optimization: We do not need to decrement maxCount when shrinking the window because our goal is to find a window size strictly larger than the maximum valid window found so far.Complexity AnalysisMetricComplexityDescriptionTime Complexity$O(N)$Each character is processed at most twice (once by the right pointer and once by the left pointer) across the string of length $N$.Space Complexity$O(1)$Uses a fixed-size integer array of length 26 to track uppercase character frequencies, requiring $O(1)$ auxiliary space.💻 Code StructureThe core implementation is written in Java:Javaclass Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int maxCount = 0; // Tracks the max frequency of a single character in the window
        int maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            // Increment frequency of current character
            char currentChar = s.charAt(right);
            count[currentChar - 'A']++;
            
            // Update the maximum character frequency in the current window
            maxCount = Math.max(maxCount, count[currentChar - 'A']);
            
            // Current window size is (right - left + 1)
            // If replacements needed > k, shrink window from left
            while ((right - left + 1) - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            
            // Update global maximum window length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}