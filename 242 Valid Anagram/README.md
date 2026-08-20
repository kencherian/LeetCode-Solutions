# Valid Anagram

A highly efficient Java solution for the classic "Valid Anagram" problem (LeetCode #242). This repository contains an optimized O(N) time complexity approach utilizing a frequency-array-based hash map technique.

📌 Problem Description
Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`, and `false` otherwise.

An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Examples
**Example 1:**
* **Input:** `s = "anagram"`, `t = "nagaram"`
* **Output:** `true`

**Example 2:**
* **Input:** `s = "rat"`, `t = "car"`
* **Output:** `false`

Constraints
* `1 <= s.length, t.length <= 5 * 10^4`
* `s` and `t` consist of lowercase English letters.

🚀 Solution Approach
The optimal approach avoids sorting (which takes O(N log N) time) and instead leverages a fixed-size frequency array to count character occurrences in O(N) time.

1. **Length Check:** If the lengths of `s` and `t` are not equal, they cannot be anagrams. We immediately return `false`.
2. **Frequency Array:** Since the constraints specify that the inputs consist only of lowercase English letters, we allocate an integer array of size 26.
3. **Single Pass Counter:** We iterate through both strings simultaneously. For every character in `s`, we increment its corresponding index in the tracking array, and for every character in `t`, we decrement it.
4. **Verification:** Finally, we check if all buckets in the array are `0`. If any element is non-zero, it means there is a mismatch in character distribution, rendering `false`.

> 💡 **Follow-up Note (Unicode Characters):** If the input contains Unicode characters, a fixed-size array of 26 is insufficient. We would adapt the solution by swapping the primitive array for a `HashMap<Character, Integer>` to dynamically store character counts.

Complexity Analysis
| Metric | Complexity | Description |
| :--- | :--- | :--- |
| Time Complexity | O(N) | Where N is the length of the strings. We traverse the strings exactly once. |
| Space Complexity | O(1) | The frequency array size is strictly bounded by the alphabet size (26), requiring constant auxiliary space. |

💻 Code Structure
The core implementation is written in Java:
```java
class Solution {
    public boolean isAnagram(String s, String t) {
        // If lengths don't match, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }
        
        // Frequency tracker for 26 lowercase English letters
        int[] charCounts = new int[26];
        
        // Count frequencies: increment for s, decrement for t
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }
        
        // If all counts are zero, the strings are valid anagrams
        for (int count : charCounts) {
            if (count != 0) {
                return false;
            }
        }
        
        return true;
    }
}