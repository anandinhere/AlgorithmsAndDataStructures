
print(f'''
Set is a collection is unordered, not changeable and duplicates not allowed.

''')


print(f'''
1. Creating a Set: Create a set using curly braces
Example: my_set = {{1, 2, 3 }}


''')

my_set = {1, 2, 3 }
print(f'myset = {my_set}')

print(f'''
2. Creating an Empty Set: Create an empty set
Example: empty_set = set()


''')
empty_set = set()

print(f'''
Creating a set from a list
myset = set([1,2,3])

''')
l = [1,2,3]
my_set = set(l)
print(f'''{my_set}''')


print(f'''

5. Adding Elements: Add a single element to a set using add()
Example: my_set.add(4) → my_set becomes {1, 2, 3, 4}

6. Updating a Set: Add multiple elements using update()
Example: my_set.update([5, 6]) → my_set becomes {1, 2, 3, 4, 5, 6}

7. Removing Elements: Remove an element using remove()
Example: my_set.remove(2) → my_set becomes {1, 3, 4, 5, 6}
Note: Raises KeyError if the element is not found

8. Discarding Elements: Remove an element using discard()
Example: my_set.discard(3) → my_set becomes {1, 4, 5, 6}
Note: Does not raise an error if the element is not found


''')

my_set.add(5)
print(my_set)

my_set.update([6,7])
print(my_set)

my_set.update({8,9})
print(my_set)

my_set.update('89')
print(my_set)

my_set.remove('8')
print(my_set)

my_set.remove(1)
print(my_set)

my_set.discard(125)
print(my_set)

print(f'''
9. Popping an Element: Remove and return an arbitrary element using pop()
Example: popped_item = my_set.pop() → my_set is modified

10. Clearing a Set: Remove all elements using clear()
Example: my_set.clear() → my_set becomes set()

11. Membership Testing: Check if an item exists in the set
Example: exists = 1 in my_set → exists is True

12. Finding the Length: Get the number of items using len()
Example: length = len(my_set) → length is the count of elements
''')

my_set.pop()

print(my_set)

my_set.clear()
print(my_set)

my_set = {3, 5, 6, 7, 8, 9, '9'}

print(9 in my_set)
print(len(my_set))


print(f'''
13. Union: Combine two sets using union() or the | operator
Example 1: new_set = my_set.union({{7, 8}}) → new_set is {{1, 4, 5, 6, 7, 8}}
Example 2: new_set = my_set | {{7, 8}} → same result

14. Intersection: Find common elements using intersection() or the & operator
Example 1: common_set = my_set.intersection({{4, 5, 10}}) → common_set is {{4, 5}}
Example 2: common_set = my_set & {{4, 5, 10}} → same result

15. Difference: Find elements in one set but not in another using difference() or the — operator
Example 1: diff_set = my_set.difference({{5, 10}}) → diff_set is {{1, 4}}
Example 2: diff_set = my_set — {{5, 10}} → same result


''')

set1 = {1,2,3}
set2 = {2,3,4}

sets_union = set1.union(set2)
print(sets_union)
sets_union2 = set1 | set2
print(sets_union2)


sets_xn = set1.intersection(set2)
print(sets_xn)
sets_xn2 = set1 & set2
print(sets_xn2)


sets_diff = set1.difference(set2)
print(sets_diff)
sets_diff2 = set1 - set2
print(sets_diff2)


print(f'''
16. Symmetric Difference: Find elements in either set but not both using symmetric_difference() or the ^ operator
Example 1: sym_diff_set = my_set.symmetric_difference({1, 10}) → sym_diff_set is {4, 5, 10}
Example 2: sym_diff_set = my_set ^ {1, 10} → same result

17. Set Intersection Update: Modify a set to keep only elements found in another set using intersection_update()
Example: my_set.intersection_update({1, 2, 3}) → my_set becomes {1}

18. Set Difference Update: Modify a set to remove elements found in another set using difference_update()
Example: my_set.difference_update({1}) → my_set becomes set()

19. Set Symmetric Difference Update :Modify a set to keep only elements found in either set but not both using symmetric_difference_update(): Symmetric Difference but updates set1
Example: my_set.symmetric_difference_update({2, 3}) → my_set becomes {2, 3}
''')

set1 = {1,2,3}
set2 = {2,3,4}

print(set1.symmetric_difference(set2))

set1.intersection_update(set2)
print(set1)


set1 = {1,2,3}
set2 = {2,3,4}

set1.difference_update(set2)
print(set1)

set1 = {1,2,3}
set2 = {2,3,4}
set1.symmetric_difference_update(set2)
print(set1)


print(f'''
20. Subset Check: if a set is a subset of another using issubset()
Example: is_subset = my_set.issubset({{1, 2, 3, 4}}) → is_subset is True

21. Superset Check: if a set is a superset of another using issuperset()
Example: is_superset = my_set.issuperset({{1, 4}}) → is_superset is True

22. Disjoint Sets: Check if two sets have no elements in common using isdisjoint()
Example: are_disjoint = my_set.isdisjoint({{7, 8}}) → are_disjoint is True
''')


24. Converting to a Set: Convert a list or other iterable to a set
Example: my_set = set([1, 2, 2, 3]) → my_set becomes {1, 2, 3}

25. Set Comprehensions: Create a set using a comprehension
Example: squared_set = {x**2 for x in range(5)} → squared_set is {0, 1, 4, 9, 16}