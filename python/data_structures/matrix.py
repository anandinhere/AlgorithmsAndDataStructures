

m = [[1,2,3,4],
     [5,6,7,8],
     [9,10,11,12]]

for i in range(5,-1,-1):
    print(i)

rows_l = len(m)
cols_l = len(m[0])

for r in range(rows_l-1,-1,-1):
    for c in range(cols_l-1,-1,-1):
        print(f'''  {r},{c} : {m[r][c]} ''')


print('cols and rows')
flag = True
for c in range(cols_l-1,-1,-1):
    if flag:
        for r in range(rows_l-1,-1,-1):
            print(f'''  {r},{c} : {m[r][c]} ''')
        flag = False
    elif not flag:
        for r in range(0,rows_l,1):
            print(f'''  {r},{c} : {m[r][c]} ''')
        flag = True




'''
2 1 0
0 1 2 
2 1 0
'''

'''
-1 -2 -3
0 1 2
2 1 0

'''

chart = [
    [101, 102, 103, 104],
    [201, 202, 203, 204],
    [301, 302, 303, 304]
]


transpose_matrix = [[str(j) + ',' + str(i) for i in range(len(chart))] for j in range(len(chart[0]))]
print(transpose_matrix)

transpose_matrix = [[str(j) + ',' + str(i) for i in range(len(chart))] for j in range(len(chart[0])-1,-1,-1)]
print(transpose_matrix)

transpose_matrix = [[chart[i][j] for i in range(len(chart))] for j in range(len(chart[0])-1,-1,-1)]
print(transpose_matrix)

