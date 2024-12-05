from typing import List


class Solution:
    def findMissingRanges(self, nums: List[int], lower: int, upper: int) -> List[List[int]]:

        i = lower
        j = 0
        res = []

        while i <= upper and j<len(nums) :

            new_list = []
            while i <= upper and j<len(nums) and i == nums[j] :
                i += 1
                j += 1
            new_list.append(i)
            while i <= upper and j<len(nums) and i != nums[j]:
                i += 1

            if j>=len(nums):
                new_list.append(upper)
            else:
                new_list.append(i-1)

            if new_list[0]<=new_list[1]:
                res.append(new_list)

        return res



s = Solution()
nums = [1000000000]
lower = 0
upper = 1000000000

print(s.findMissingRanges(nums, lower, upper))