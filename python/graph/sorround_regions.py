from typing import List
class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rows = len(board)
        cols = len(board[0])
        visited = [[0 for _ in range(cols)] for _ in range(rows) ]

        if rows <=1 or cols <=1:
            return


        def dfs(r,c):

            if r >= rows or r < 0 or c >= cols or c < 0 or board[r][c]!='O':
                return

            if visited[r][c]:
                return

            visited[r][c] = 1
            dfs(r+1,c)
            dfs(r,c+1)
            dfs(r-1,c)
            dfs(r,c-1)


        for r in range(rows):
            for c in range(cols):
                if (r == rows-1 or r == 0 or c == cols-1 or c == 0) and board[r][c]=='O':
                    dfs(r,c)


        for r in range(rows):
            for c in range(cols):
                if not visited[r][c]:
                    board[r][c]='X'
                elif visited[r][c]:
                    board[r][c]='O'





board = [["O","X","X","O","X"],
         ["X","O","O","X","O"],
         ["X","O","X","O","X"],
         ["O","X","O","O","O"],
         ["X","X","O","X","O"]]




Solution().solve(board)
print(board)