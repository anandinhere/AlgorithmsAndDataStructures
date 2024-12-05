from typing import List

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        # 2 pointers, ptr1 for index to copy first occuring element,
        # ptr2 keeps moving forward to find first occurrence of next higher elements

        arr_l = len(nums)

        if len(nums) == 0:
            return 0
        if len(nums) == 1:
            return 1

        ptr2 = 1
        k = 1
        for ptr1 in range(0, arr_l):
            while ptr2 < arr_l and nums[ptr1] == nums[ptr2] :
                ptr2 += 1
            if ptr2 < arr_l :
                k += 1
                nums[ptr1+1] = nums[ptr2]
            ptr2 += 1
        return k

    def removeDuplicates2(self, nums: List[int]) -> int:
        # 2 pointers, ptr1 for index to copy first occuring element,
        # ptr2 keeps moving forward to find first occurrence of next higher elements

        arr_l = len(nums)


        # if empty list return 0
        if len(nums) == 0:
            return 0
        # if list has 1 item return 1
        if len(nums) == 1:
            return 1

        # if list has 1 item return 1
        if len(nums) == 2:
            return 2

        ptr1 = 0
        ptr2 = 1
        k = 1
        while ptr1 < arr_l:
            cnt = 1
            while ptr2 < arr_l and nums[ptr1] == nums[ptr2] :
                ptr2 += 1
                cnt += 1
            if ptr2 < arr_l :
                if cnt > 1:
                    k += 2
                    nums[ptr1+2] = nums[ptr2]
                    nums[ptr1+1] = nums[ptr1]
                    ptr1 +=1
                else:
                    k += 1
                    nums[ptr1+1] = nums[ptr2]
            elif cnt > 1:
                k += 1
                nums[ptr1+1] = nums[ptr1]
            ptr2 += 1
            ptr1 += 1
        return k


input = \
    [0,0,0,1,1,1,2,3,3]
#[0,1,1,1,1,2,3,3]

#ptr1 0  2 7 8
#ptr2 2  6 8 10



s = Solution()
k =  s.removeDuplicates2(input)
print(k)
print(input)



        