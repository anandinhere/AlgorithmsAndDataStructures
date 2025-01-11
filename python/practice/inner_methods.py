

def outer_function():
    x = 10
    def inner_function():

        x = 1
        print(x)
    inner_function()
    print(x)


class Solution:


    def outer_function2(self):
        x = [10]
        def inner_function():

            x[0] = 11
            print(x)
        inner_function()
        print(x)

print(Solution().outer_function2())