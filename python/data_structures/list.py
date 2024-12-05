
print('\n#create a list fruits = [\'apple','banana','cherry\']')
fruits = ['apple','banana','cherry']

print('\n#empty list empty = []')
empty = []

print('\n#create a list from a iterable ')

list_from_s = list('string')

print('\n#access list elements print(list_from_s[0])')
print(list_from_s[0])

print('\n#slice list print(fruits[0:7])')
print(fruits[0:7])

print('\n#negative indexing print(fruits[-1])')
print(fruits[-1])

print('\n#append fruits.append(\'grape\')')
fruits.append('grape')
print(fruits)

print('\n#extend fruits.extend([\'kiwi','orange\'])')
fruits.extend(['kiwi','orange'])
print(fruits)


print('\n#extend fruits.extend([\'berry\'])')
fruits.extend(['berry'])
print(fruits)

print('\n#insert  O(n) fruits.insert(1,\'guava\')')
fruits.insert(1,'guava')
print(fruits)

print('\n#remove  O(n) fruits.remove(\'cherry\')')
fruits.remove('cherry')
print(fruits)

print(f'''\nfruits.pop()''')
fruits.pop()
print(fruits)

print(f'''\nfruits.index('guava')''')
print(fruits.index('guava'))

print(f'''\nthrows exception if not in the list \nfruits.index('cherries')''')
try:
    print(fruits.index('cherries'))
except :
    print('not found')



print(f'''\nfruits.count('guava') Returns the number of times the specified item appears in the list.''')

print(fruits.count('guava'))


print(f'''\nfruits.sort() doest return anything, sorts in place''')

print(fruits.sort())
print(fruits)

print(f'''\nfruits.reverse() doest return anything, reverses in place''')

print(fruits.reverse())
print(fruits)

print(f'''\nfruits.copy() → fruits_copy is a new list with the same items as fruits''')
print(fruits.copy())

print(f'''\njoin(separator): ''.join(fruits) Joins elements of a list into a single string (using a string method)''')

print(','.join(fruits))

print(f'''\nList comprehension [fruit + '_hi' for fruit in fruits]''')
print([fruit + '_hi' for fruit in fruits])

fruits.append('orange')
fruits.append('orange')
fruits.append('orange')

print(fruits)
print(f''' remove duplicates set(fruits)''')
print(list(set(fruits)))





print(f'''
for f in fruits:
    print(f)
    
for i,f in enumerate(fruits):
    print(f'')

iterate list
''')

for f in fruits:
    print(f)

for i,f in enumerate(fruits):
    print(f' {i} - {f}')






print(f'''\nfruits.clear()''')
fruits.clear()
print(fruits)




