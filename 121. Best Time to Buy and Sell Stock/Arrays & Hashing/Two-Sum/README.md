# LeetCode 1: Two Sum

## 📝 Problem Description

Given an array of integers `nums` and an integer `target`, return _indices of the two numbers such that they add up to `target`_.

You may assume that each input would have **_exactly_ one solution**, and you may not use the _same_ element twice. You can return the answer in any order.

### Example

**Input:** `nums = [2, 7, 11, 15]`, `target = 9`  
**Output:** `[0, 1]`  
**Explanation:** Because `nums[0] + nums[1] == 9`, we return `[0, 1]`.

---

## 💡 Approach: One-Pass Hash Table

Instead of checking every possible pair using a brute-force approach ($O(n^2)$), we can optimize the lookup time by using a Hash Map (dictionary in Python).

1. We iterate through the array while keeping track of the elements we have seen so far and their respective indices.
2. For each element `num`, we calculate its `complement` ($target - num$).
3. If the `complement` already exists in our hash map, it means we have found the two numbers that add up to the target. We immediately return their indices.
4. If it doesn't exist, we add the current `num` and its index `i` to the hash map and move to the next iteration.

### Complexity Analysis

- **Time Complexity:** $O(n)$ — We traverse the list containing $n$ elements only once. Each lookup in the table costs only $O(1)$ time.
- **Space Complexity:** $O(n)$ — The extra space required depends on the number of items stored in the hash table, which stores at most $n$ elements.

---

## 🐍 Python3 Implementation

```python
from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        num_map = {}  # Hash table to store number and its index

        for i, num in enumerate(nums):
            complement = target - num  # Find the complement

            # If complement is found, return the indices
            if complement in num_map:
                return [num_map[complement], i]

            # Store the current number with its index
            num_map[num] = i
```
