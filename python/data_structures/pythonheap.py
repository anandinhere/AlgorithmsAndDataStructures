import heapq


heape = []

heapq.heappush(heape,3)

heapq.heappush(heape,2)

heapq.heappush(heape,1)


print(len(heape))

print(heapq.heappop(heape))
print(heapq.heappop(heape))
print(heapq.heappop(heape))

print(len(heape))

if len(heape)>0:
    print(heapq.heappop(heape))
