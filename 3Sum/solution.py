from typing import List

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        # Sort the array to easily manage duplicates and use the two-pointer technique
        nums.sort()
        res = []
        
        for i in range(len(nums)):
            # If the current number is greater than zero, remaining numbers cannot sum to zero
            if nums[i] > 0:
                break
                
            # Skip duplicate elements for the first number of our triplet
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            
            # Two-pointer setup
            left, right = i + 1, len(nums) - 1
            
            while left < right:
                total = nums[i] + nums[left] + nums[right]
                
                if total < 0:
                    left += 1
                elif total > 0:
                    right -= 1
                else:
                    # Triplet found
                    res.append([nums[i], nums[left], nums[right]])
                    left += 1
                    right -= 1
                    
                    # Skip duplicate elements for the left pointer to avoid duplicate triplets
                    while left < right and nums[left] == nums[left - 1]:
                        left += 1
                        
        return res