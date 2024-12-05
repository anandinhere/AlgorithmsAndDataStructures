from collections import deque

ss = deque()

ss.append(0)
ss.append(1)
ss.append(2)

print(f'len: {len(ss)}')

print(ss.popleft())
print(ss.popleft())
print(ss.popleft())

print(f'len: {len(ss)}')

ss.append(0)
ss.append(1)
ss.append(2)
print(f'len: {len(ss)}')

print(ss.pop())
print(ss.pop())
print(ss.pop())







