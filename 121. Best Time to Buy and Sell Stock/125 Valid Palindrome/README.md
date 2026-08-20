# Valid Palindrome

A highly efficient Java solution for the classic "Valid Palindrome" problem (LeetCode #125). This repository contains an optimized O(N) Time Complexity approach utilizing a Two Pointers technique.

📌 Problem Description
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string `s`, return `true` if it is a palindrome, or `false` otherwise.

Examples
**Example 1:**

- **Input:** s = "A man, a plan, a canal: Panama"
- **Output:** true
- **Explanation:** "amanaplanacanalpanama" is a palindrome.

**Example 2:**

- **Input:** s = "race a car"
- **Output:** false
- **Explanation:** "raceacar" is not a palindrome.

**Example 3:**

- **Input:** s = " "
- **Output:** true
- **Explanation:** s is an empty string "" after removing non-alphanumeric characters. Since an empty string reads the same forward and backward, it is a palindrome.

Constraints

- `1 <= s.length <= 2 * 10^5`
- `s` consists only of printable ASCII characters.

🚀 Solution Approach
Instead of allocating extra memory to filter and reverse the string, we can optimize this using the **Two Pointers** technique to check the string in place:

1.  Initialize two pointers: `left` at the beginning (`0`) and `right` at the end (`s.length() - 1`).
2.  Iterate while `left < right`.
3.  Increment the `left` pointer if it encounters a non-alphanumeric character.
4.  Decrement the `right` pointer if it encounters a non-alphanumeric character.
5.  If both pointers point to valid alphanumeric characters, convert them to lowercase and compare them. If they don't match, return `false`.
6.  If the pointers cross without any mismatch, the string is a valid palindrome, so return `true`.

This approach avoids string duplication or regex overhead, making it exceptionally fast and memory-efficient.

Complexity Analysis
| Metric | Complexity | Description |
| :--- | :--- | :--- |
| Time Complexity | O(N) | We traverse the string at most once, where N is the length of the string. |
| Space Complexity | O(1) | No extra memory is allocated; modifications and comparisons are done in place. |

💻 Code Structure
The core implementation is written in Java:

```java
class Solution {
    public boolean isPalindrome(String s) {
        // Handle empty or single character strings early
        if (s == null || s.length() == 0) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Move left pointer forward if current character is not alphanumeric
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Move right pointer backward if current character is not alphanumeric
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters after converting them to lowercase
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            // Move both pointers towards the center
            left++;
            right--;
        }

        return true;
    }
}
```
