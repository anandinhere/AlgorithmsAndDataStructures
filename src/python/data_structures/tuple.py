
print(f'''

Tuple is a collection which is ordered, unchangeable and allow duplicates.


''')


print(f'''

1. Creating a Tuple: Create a tuple using parentheses
Example: my_tuple = (1, 2, 3)''')

my_tuple = (1,2,3)
print(my_tuple)

num1 = (1,)
print(type(num1))

print(
f'''
13. Tuple Unpacking: Assign values to variables in one line
Example: a, b, c = my_tuple → a is 1, b is 2, c is 3
'''
)

a, b, c = my_tuple
print(f'''{a}  ValueError if tried to unpack more''')


print(f'''\n
15. Tuples are Immutable: You cannot modify, add, or remove elements once created
Example: my_tuple[1] = 10 # This will raise a TypeError
''')

print(f'''
16. Deleting a Tuple: Use the del statement to delete a tuple
Example: del my_tuple → my_tuple is now deleted

''')

del  my_tuple
try:
    print(my_tuple)
except NameError:
    print(f'''NameError: name 'my_tuple' is not defined''')


print(f'''\n
19. Convert to String: Join elements of a tuple into a single string
Example: joined = “, “.join(map(str, my_tuple)) → joined is “1, 2, 3”

''')

my_tuple = (1,2,3)

str_tuple = ' '.join(str(val) for val in my_tuple)

my_list = [1,2,3]

str_list = ' '.join(map(str, my_list))
print(str_tuple)
print(str_list)

print(f'''
25. Creating Tuples with zip(): Combine lists into a tuple of pairs
Example: paired = tuple(zip([1, 2], [‘a’, ‘b’])) → paired is ((1, ‘a’), (2, ‘b’))


''')

l1 = [1,2]
l2 = [3,4]

paired_tuple = tuple(zip(l1,l2))
print(paired_tuple)
