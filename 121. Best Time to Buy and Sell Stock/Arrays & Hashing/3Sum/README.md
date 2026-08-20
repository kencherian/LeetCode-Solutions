3Sum

**Difficulty:** `Medium`

This repository contains an optimized Python 3 solution for the [LeetCode 15. 3Sum](https://leetcode.com/problems/3sum/) problem.

## 📝 Problem Statement

Given an integer array `nums`, return all the triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `i != k`, and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.

**Note:** The solution set must not contain duplicate triplets.

### Example

```text
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
The distinct triplets are [-1,0,1] and [-1,-1,2].
🚀 Approach: Sorting & Two Pointers
The most efficient way to solve this problem is by combining sorting with the two-pointer technique to bring the time complexity down from O(n^3) (brute force) to O(n^2).

Sort the array: This allows us to sequentially pick the first element of our triplet and easily skip duplicate values.

Iterate with a fixed pointer (i): For every number nums[i], we treat it as a target of -nums[i].

Use Two Pointers (left and right):

Initialize left just after i (i + 1) and right at the end of the array.

If the sum of the three numbers is < 0, increment left to increase the sum.

If the sum is > 0, decrement right to decrease the sum.

If the sum is == 0, we've found a triplet. Append it to our results and adjust both pointers.

Skip duplicates: To ensure we don't record identical triplets, we skip over adjacent duplicate values for both i and left.

Early Exit Optimization: Because the array is sorted, if nums[i] is ever strictly greater than 0, it's impossible for the remaining numbers to sum to 0. We can instantly break the loop.

📊 Complexity Analysis
Time Complexity: O(n^2)

Sorting the array takes O(n log n).

The outer loop runs n times, and the inner two-pointer loop runs up to n times, resulting in O(n^2).

Overall time complexity is dominated by the nested loops: O(n^2).

Space Complexity: O(1) or O(n)

The auxiliary space is O(1) (excluding the output array). However, depending on the sorting algorithm used by the language (Python uses Timsort), it can take up to O(n) space.

💻 How to Run
Make sure you have Python 3 installed.

Clone this repository or download the source code file.

Import the Solution class or run it directly with your own test cases:

Python
solution = Solution()
result = solution.threeSum([-1,0,1,2,-1,-4])
print(result) # Output: [[-1, -1, 2], [-1, 0, 1]]