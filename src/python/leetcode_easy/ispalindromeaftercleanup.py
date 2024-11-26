class Solution:
    def isPalindrome(self, s: str) -> bool:

        cleanstr = ''
        for c in s:
            if c.isalpha():
                cleanstr += c.lower()

        c_len = len(cleanstr)

        if c_len == 0 or c_len==1:
            return True

        p_stack = []

        for i in range(0,c_len//2):
            p_stack.append(cleanstr[i])


        if c_len%2 == 0:
            start = c_len//2
        else:
            start = (c_len//2) + 1

        for i in range(start,c_len):
            c_pop = p_stack.pop()
            if c_pop!=cleanstr[i]:
                return False

        if len(p_stack)==0:
            return True
        else:
            return False





s = "0P"
sol = Solution()
val = sol.isPalindrome(s)
print(val)