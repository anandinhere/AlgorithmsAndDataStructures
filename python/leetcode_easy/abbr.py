class Solution:
    def validWordAbbreviation(self, word: str, abbr: str) -> bool:
        i = 0
        j = 0
        while i<len(abbr) and j <len(word):

            abbr_count = ''
            while i<len(abbr) and abbr[i].isdigit():
                abbr_count = abbr_count + abbr[i]
                i +=1
            if abbr_count.startswith('0'):
                return False
            if len(abbr_count) > 0:
                j = j + int(abbr_count)
            else:
                if abbr[i] != word[j]:
                    return False
                i +=1
                j +=1

        if i==len(abbr) and j==len(word):
            return True

        return False


s = Solution()
print(s.validWordAbbreviation('abbde','a1b01e'))