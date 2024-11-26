def make_bricks(small, big, goal):

    for x in range(0,small+1):
        for y in range(0,big+1):
            if (1 * x) + (5*y) == goal:
                return True

    return False

def make_bricks2(small, big, goal):
    # 8 , 2*5
    reminder = goal%5
    multiple = goal//5

    can_use_big = min(multiple,big)
    remaining = goal - (5*can_use_big)
    if remaining<=small:
        return True
    else:
        return False

'''
We want make a package of goal kilos of chocolate. We have small bars (1 kilo each) 
and big bars (5 kilos each). Return the number of small bars to use, 
assuming we always use big bars before small bars. Return -1 if it can't be done.


'''

def make_chocolate(small, big, goal):
    multiple = goal//5

    can_use_big = min(multiple,big)
    remaining = goal - (5*can_use_big)
    if remaining<=small:
        return remaining
    else:
        return -1


print(make_bricks2(3, 2, 18))
