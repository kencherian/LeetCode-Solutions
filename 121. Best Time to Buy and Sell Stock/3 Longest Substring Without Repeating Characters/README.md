Longest Substring Without Repeating CharactersA highly efficient Java solution for the classic "Longest Substring Without Repeating Characters" problem (LeetCode #3). This repository contains an optimized $O(N)$ Time Complexity approach utilizing a Sliding Window technique with a Hash Map / Index Array.📌 Problem DescriptionGiven a string s, find the length of the longest substring without repeating characters.  ExamplesExample 1:  Input: s = "abcabcbb"Output: 3Explanation: The answer is "abc", with the length of 3.  Example 2:  Input:   s = "bbbbb"Output: 1Explanation: The answer is "b", with the length of 1.Example 3:Input: s = "pwwkew"Output: 3Explanation: The answer is "wke", with the length of 3. Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.Constraints0 <= s.length <= 5 * 10^4s consists of English letters, digits, symbols and spaces.🚀 Solution ApproachThe brute-force approach checks every possible substring for duplicates, resulting in $O(N^3)$ time complexity.To achieve an optimal linear solution $O(N)$:Sliding Window: Maintain a dynamic window defined by two pointers, left and right, representing the boundaries of the current substring without duplicate characters.Direct Index Lookup: Instead of using a heavy Hash Set, we use an integer array of size 128 (covering standard ASCII characters) to store the most recent index + 1 where each character was seen.Optimized Window Jump: As right iterates through the string, if the current character has been seen inside the active window (lastSeen[s.charAt(right)] > left), we instantly jump left directly to lastSeen[s.charAt(right)], skipping unnecessary intermediate checks.Track Maximum Length: At each step, calculate the current window size (right - left + 1) and update the global maximum length.Complexity AnalysisMetricComplexityDescriptionTime Complexity$O(N)$The right pointer traverses the string of length $N$ exactly once. Index jumps allow $O(1)$ window adjustments.Space Complexity$O(1)$Uses a fixed-size integer array of length 128 to store character positions, requiring constant memory regardless of input size.💻 Code StructureThe core implementation is written in Java:Javaclass Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        
        // Array to store the last seen position (+1) of ASCII characters
        int[] lastSeen = new int[128];
        
        // Left pointer of the sliding window
        int left = 0;
        
        // Right pointer expands the sliding window
        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            
            // If the character was seen inside the current window, move 'left' past its previous position
            left = Math.max(left, lastSeen[currentChar]);
            
            // Calculate current window size and update max length
            maxLength = Math.max(maxLength, right - left + 1);
            
            // Store the next valid starting position for this character (right + 1)
            lastSeen[currentChar] = right + 1;
        }
        
        return maxLength;
    }
}