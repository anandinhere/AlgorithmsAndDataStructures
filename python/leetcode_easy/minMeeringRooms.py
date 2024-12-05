import heapq
from typing import List
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        '''
        all_times_arr = [0] * 10000000

        max_rooms = 0
        for meeting in intervals:
            for x in range(meeting[0],meeting[1]):
                all_times_arr[x] += 1
                max_rooms = max(all_times_arr[x],max_rooms)

        return max_rooms
        '''
        if not intervals or len(intervals)==0:
            return 0

        total_ints = len(intervals)
        if total_ints == 1:
            return 0

        intervals.sort(key=lambda x : (x[0],x[1]))

        room_heap = []
        heapq.heappush(room_heap,intervals[0][1])
        for i in range(1,total_ints):
            h_top = room_heap[0]
            if h_top <= intervals[i][1]:
                heapq.heappop(room_heap)

            heapq.heappush(room_heap,intervals[i][1])

        return len(room_heap)

s = Solution()
ints = [[6,15],[13,20],[6,17]]

sol = s.minMeetingRooms(ints)
print(sol)





"""

check if min or max of a meeting within current rooms, if yes then diff room

0 30
5 10
15 20
 
                    min max 
1 [0 30]            0   30 
2 [5 10] [15 20]    5-10. 5-20
3 
---------------------------

0 30
5 10
15 20
11 14 

                    min max 
1 [0 30]            0   30 
2 [5 10] [15 20]    5   20
3 [11 14] 

---------------------------

sort to check if it helps

0 30
5 10
11 14 
15 20


if new meeting's min < a room's max -> diff room , set min and max if not already set 
if new meeting's min >= a room's max -> same room, update min and max
                    min max 
1 [0 30]            0-30 
2 [5 10] [11 14] [15 20]   5-10   5-14   15-20
3 
"""




