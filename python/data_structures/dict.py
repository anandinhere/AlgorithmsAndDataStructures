
print(f'''
Dictionary is one of the built-in datatype that allows us to store data 
in key-value pair which is unordered and mutable.


''')


print(f'''


1. Creating a Dictionary: Create a dictionary using curly braces
Example: my_dict = {{"key1": "value1", "key2": "value2"}}

''')


my_dict = {"key1": "value1", "key2": "value2"}

print(f'''
2. Creating an Empty Dictionary: Create an empty dictionary
Example: empty_dict = {{}}


''')

empty_dict = {}


print(f'''
3. Accessing Values: Get a value by its key
Example: value = my_dict["key1"] → value is "value1"

''')

value = my_dict["key1"]
print(value)

print(f'''
4. Adding or Updating Values: Add a new key-value pair or update an existing key
Example: my_dict["key3"] = "value3" → my_dict becomes 
{{"key1": "value1", "key2": "value2", "key3": "value3"}}


''')

my_dict["key3"] = "value3"
print(my_dict)

print(f'''
5. Removing a Key-Value Pair: Remove a key-value pair using del
Example: del my_dict["key2"] → my_dict becomes {{"key1": "value1", "key3": "value3"}}

''')

del my_dict["key1"]
print(my_dict)

print(f'''
6. Popping a Key-Value Pair: Remove and return a value using pop()
Example: value = my_dict.pop("key1") → my_dict becomes {{"key3": "value3"}}


''')

value = my_dict.pop("key3")
print(value)
print(my_dict)


print(f'''
7. Clearing a Dictionary: Remove all key-value pairs using clear()
Example: my_dict.clear() → my_dict becomes {{}}

''')

my_dict.clear()
print(my_dict)

print(f'''
8. Checking for a Key: Check if a key exists using in
Example: exists = "key1" in my_dict → exists is True

9. Getting the Length: Get the number of key-value pairs using len()
Example: length = len(my_dict) → length is the count of pairs

10. Getting Keys: Get all keys using keys()
Example: keys = my_dict.keys() → keys is a view of all keys

11. Getting Values: Get all values using values()
Example: values = my_dict.values() → values is a view of all values

12. Getting Items: Get all key-value pairs using items()
Example: items = my_dict.items() → items is a view of all key-value pairs



''')


my_dict = {"key1": "value1", "key2": "value2"}

keys = my_dict.keys()
print(list(keys))
vals = my_dict.values()
print(vals)

items = my_dict.items()
print(items)


print(f'''
13. Copying a Dictionary: Create a shallow copy using copy()
Example: my_dict_copy = my_dict.copy() → my_dict_copy is a new dictionary with the same items

14. Merging Dictionaries: Merge two dictionaries using update()
Example: my_dict.update({{"key4": "value4"}}) → adds key4 to my_dict


''')
my_dict_copy = my_dict.copy()
print(my_dict_copy)

print(f'''
15. Dictionary Comprehension: Create a dictionary using a comprehension
Example: squared_dict = {{x: x**2 for x in range(5)}} → squared_dict is {{0: 0, 1: 1, 2: 4, 3: 9, 4: 16}}



''')

my_dict_comp = {x:x*x for x in range(0,10)}
print(my_dict_comp)

print(f'''
16. Nested Dictionaries: Dictionaries can contain other dictionaries
Example: nested_dict = {{"outer": {{"inner": "value"}}}} → Accessing: nested_dict["outer"]["inner"] → "value"


''')

nested_dict = {"outer" : {"inner":"value"}}
print(nested_dict["outer"]["inner"])

print(f'''
17. Default Values: Use get() to return a value with a default if the key is not found
Example: value = my_dict.get("key5", "default") → value is "default"


''')

val = my_dict.get("key69","69")
print(val)

print(f'''
18. Popitem: Remove and return the last inserted key-value pair using popitem()
Example: last_item = my_dict.popitem() → my_dict is modified


''')

last_item = my_dict.popitem()
print(last_item)



print(f'''
19. Dictionary from Keys: Create a dictionary with keys from an iterable and a default value
Example: new_dict = dict.fromkeys(["a", "b", "c"], 0) → new_dict is {{"a": 0, "b": 0, "c": 0}}



''')
new_dict = dict.fromkeys(["a", "b", "c"], 0)
print(new_dict)


print(f'''
20. Updating Multiple Keys: Update multiple key-value pairs at once
Example: my_dict.update({{"key1": "new_value", "key3": "new_value"}}) → updates specified keys

21. Iterating Over Keys :Loop through keys in a dictionary
Example: for key in my_dict: print(key)

22. Iterating Over Values: Loop through values in a dictionary
Example: for value in my_dict.values(): print(value)


''')

print(my_dict)
my_dict.update({"key1": "new_value", "key3": "new_value"})
print(my_dict)

print(f'''
23. Iterating Over Items: Loop through key-value pairs in a dictionary
Example: for key, value in my_dict.items(): print(key, value)


''')

for key, value in my_dict.items(): print(key, value)


print(f'''
24. Finding Key Index: Use next() with an iterator to find the index of a key
Example: index = next((i for i, k in enumerate(my_dict) if k == “key1”), None)

''')

index = next((i for i, k in enumerate(my_dict) if k == "key12"), None)
print(index)

print(f'''
25. Converting to List: Convert keys, values, or items to a list
Example: keys_list = list(my_dict.keys()) → keys_list contains the keys of my_dict


''')

keys_list = list(my_dict.keys())
print(keys_list)