class Solution:
    def validPalindrome(self, s: str) -> bool:
        i = 0
        j = len(s)-1

        skip_count = 0

        while i <= j:
            if s[i] == s[j]:
                i += 1
                j -= 1
            else:
                return self.checkPalindrome(s,i+1,j) or self.checkPalindrome(s,i,j-1)

        return True

    def checkPalindrome(self, s: str,i:int,j:int) -> bool:
        while i<len(s) and j>=0 and i <= j:
            if s[i] == s[j]:
                i += 1
                j -= 1
            else:
                return False

        return True



s = Solution()
res = s.validPalindrome('abc')
print(res)