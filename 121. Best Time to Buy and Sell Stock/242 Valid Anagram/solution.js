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