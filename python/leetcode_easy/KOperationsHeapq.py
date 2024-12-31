from typing import List
import heapq
class Solution:
    def getFinalState(self, nums: List[int], k: int, multiplier: int) -> List[int]:

        numsHeap = []
        heapq.heapify(numsHeap)
        for index,i in enumerate(nums):
            heapq.heappush(numsHeap, (i,index))

        for _ in range(k):
            min_,index = heapq.heappop(numsHeap)
            nums[index] = min_ * multiplier
            heapq.heappush(numsHeap, (nums[index],index))
        return nums


s = Solution()
nums = [2,1,3,5,6]

sol = s.getFinalState(nums,5,2)
print(sol)
