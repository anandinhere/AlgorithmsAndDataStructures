

### min heap
import heapq

print("\n\nmin heap")
heap_l = [2,7,1,5,3]
heapq.heapify(heap_l)
while heap_l:
    print(heapq.heappop(heap_l))



print("\nmax heap")
heap_l = [2,7,1,5,3]
for x in range(len(heap_l)):
    heap_l[x]  = heap_l[x] * -1

heapq.heapify(heap_l)
while heap_l:
    print(heapq.heappop(heap_l) * -1)


print("1D Array")
arr = [0] * 100
print(arr)

print("2D Array")
arr = [[0] * 4]*5 # outer is the 1D
print(arr)

print(f''' length {len(arr)}''')
print(f''' length of arr[0] {len(arr[0])}''')

print(f''' value at arr[0][0] {arr[0][0]}''')



for i, j in zip(range(1,10),range(1,10)):
    print(i)
    print(j)
    i = i+2
