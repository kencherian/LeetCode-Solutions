Group AnagramsA highly efficient Java solution for the classic "Group Anagrams" problem (LeetCode #49). This repository contains an optimized $O(N \times K)$ Time Complexity approach utilizing a Hash Map with Character Frequency Encoding.📌 Problem DescriptionGiven an array of strings strs, group the anagrams together. You can return the answer in any order.An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.ExamplesExample 1:Input: strs = ["eat","tea","tan","ate","nat","bat"]Output: [["bat"],["nat","tan"],["ate","eat","tea"]]Example 2:Input: strs = [""]Output: [[""]]Example 3:Input: strs = ["a"]Output: [["a"]]Constraints1 <= strs.length <= 10^40 <= strs[i].length <= 100strs[i] consists of lowercase English letters.🚀 Solution ApproachThe standard approach to group anagrams involves sorting each string alphabetically to create a canonical key. However, sorting takes $O(K \log K)$ time per string, where $K$ is the maximum string length.To achieve optimal performance, we use Character Frequency Encoding:Since input strings consist solely of lowercase English letters (a-z), we construct a frequency array of size 26 for each string.We serialize this frequency array into a unique string key (e.g., #1#0#0... representing occurrences of each letter).We store the grouped anagrams in a HashMap<String, List<String>>, where the key is the frequency representation and the value is the list of matching anagrams.This avoids string sorting entirely and operates in linear time relative to the total number of characters across all strings.Complexity AnalysisMetricComplexityDescriptionTime Complexity$O(N \times K)$Where $N$ is the number of strings and $K$ is the maximum length of a string. Counting character frequencies takes $O(K)$ time for each string.Space Complexity$O(N \times K)$The hash map stores all characters across all strings, requiring memory proportional to the total size of the input.💻 Code StructureThe core implementation is written in Java:Javaimport java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map to store character frequency pattern as key and list of anagrams as value
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            // Count frequencies of each character ('a' to 'z')
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            
            // Build a unique key representation from the frequency array
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('#'); // Delimiter to avoid count concatenation ambiguity
                sb.append(count[i]);
            }
            String key = sb.toString();
            
            // Group anagrams by the generated key
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        
        return new ArrayList<>(map.values());
    }
}