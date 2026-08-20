class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        num_map = {}  # Hash table to store number and its index
        for i, num in enumerate(nums):
            complement = target - num  # Find the complement
            if complement in num_map:
                return [num_map[complement], i]  # Return indices of complement and current number
            num_map[num] = i  # Store the number with its index