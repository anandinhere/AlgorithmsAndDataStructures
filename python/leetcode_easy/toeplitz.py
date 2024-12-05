from typing import List

class Solution:
    def isToeplitzMatrix(self, matrix: List[List[int]]) -> bool:

        '''
        [
        [1,2,3,4],
        [5,1,2,3],
        [9,5,1,2]]



        0,0|1,1|2,2
        0,1|1,2|2,3
        0,2|1,3
        0,3
        1,0|2,1
        2,0

        '''

        # i row index, no of lists inside
        # j column index, no of elements in each list


        i_max = len(matrix)-1
        j_max = len(matrix[0])-1

        i =0
        j =0
        inner_i = i+1
        inner_j = j+1

        while j <= j_max:


            start = matrix[i][j]
            while inner_i<=i_max and inner_j<=j_max:
                if matrix[inner_i][inner_j]!=start:
                    return False
                inner_i += 1
                inner_j += 1
            j += 1
            inner_i = i+1
            inner_j = j+1

        i =1
        j =0
        inner_i = i+1
        inner_j = j+1

        while i <= i_max:


            start = matrix[i][j]
            while inner_i<=i_max and inner_j<=j_max:
                if matrix[inner_i][inner_j]!=start:
                    return False
                inner_i += 1
                inner_j += 1
            i += 1
            inner_i = i+1
            inner_j = j+1

        return True


matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]

s = Solution()
res = s.isToeplitzMatrix(matrix)
print(res)

