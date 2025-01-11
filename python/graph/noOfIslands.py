from typing import List
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:

        rows = len(grid)
        cols = len(grid[0])
        visited = [[0 for _ in range(cols)] for _ in range(rows)]
        islands = 0



        def visit(i,j,rows,cols,grid,visited):

            if i >= rows or i<0 or j>=cols or j<0:
                return
            if grid[i][j]=='0':
                return
            if visited[i][j]:
                return

            visited[i][j] = 1
            visit(i,j+1,rows,cols,grid,visited)
            visit(i+1,j,rows,cols,grid,visited)
            visit(i,j-1,rows,cols,grid,visited)
            visit(i-1,j,rows,cols,grid,visited)


        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == '1' and not visited[i][j]:
                    visit(i,j,rows,cols,grid,visited)
                    islands += 1


        return islands







grid = [["0","1","0"],["1","0","1"],["0","1","0"]]

print(Solution().numIslands(grid))