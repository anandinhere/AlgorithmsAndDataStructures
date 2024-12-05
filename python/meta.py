

books = [1,2,3,4,5,6,7]
avg_books = sum(books)/len(books)
print(avg_books)

avg_books = sum(books)//len(books)
print(avg_books)



books = [1,2,3,4,5,6,7,3,4,1,5,8]
budget = 6

books_set = set(books)

books_sorted_list = sorted(list(books_set))
print(books_sorted_list)


i = 0
while i<len(books_sorted_list):
    if budget - books_sorted_list[i] < 0:
        break
    else:
        budget -= books_sorted_list[i]
    i += 1
print(i)



names = ['GOT', 'Troy', 'Batman', 'Batman Returns', 'Troy Returns', 'No Returns']

names_set = set(names)
sol = []
for name in names_set:
    if name + ' Returns' in names_set:
        sol.append(name + ' Returns')
print(sol)

book_store_dict = {1 : ['good', 'bad', 'avg', 'ok' ,'good'],
                   2 : ['good','good'],
                   3 : ['good', 'bad', 'avg'],
                   5 : ['good', 'bad']}

for k in book_store_dict.keys():

    book_store_dict[k] = set(book_store_dict[k])

print(book_store_dict)

max_v = 0
max_key = None

max_dict = {}

for v in book_store_dict.values():
    for r in v:
        if r not in max_dict:
            max_dict[r] = 1
        else:
            max_dict[r] += 1

        if max_v < max_dict[r]:
            max_v = max_dict[r]
            max_key = r

print(max_key)
print(max_v)


num = '9230084'

num_l = list(num)
num_r = sorted(num,reverse=True)
print(''.join(num_r))


meets = [[0,20], [0,10] ,[0,5]]
meets.sort()
print(meets)


nums = [3,7,3,7,3,0,2,5,84]
import heapq

heapq.heapify(nums)

while len(nums)>0:
    print(heapq.heappop(nums))



data = [[3, 2], [1, 4], [3, 1], [2, 3], [1, 2]]

data.sort(key=lambda x:(x[0],x[1]))
print(data)

data = [[3, 2], [1, 4], [3, 1], [2, 3], [1, 2]]

data_new = sorted(data, key=lambda x:(x[0],x[1]))
print(data_new)



print('nth')
def nth(nums, n):

    if not nums or len(nums)==0:
        return None
    sorted_items = sorted(nums.items(), key = lambda x: (x[1],x[0]))
    print(sorted_items)

    list2 = [ (x[1],x[0]) for x in sorted_items]
    dicts = {}
    for l in list2:
        if l[0] not in dicts:
            dicts[l[0]]=l[1]

    list3 = sorted(dicts.items(), key = lambda x: (x[0],x[1]))
    print(list3)

    if n==0 or n>=len(list3):
        return None
    return list3[n-1][1]

    # if n==1:
    #     return sorted_items[0][0]
    #
    # i = 1
    # unique_count = 1
    # while i< len(sorted_items):
    #     while(sorted_items[i]==sorted_items[i-1]):
    #         i += 1
    #     i += 1
    #     unique_count+=1
    #     if unique_count==n:
    #         return sorted_items[i][0]

    #return None




    #return sorted_items[n]

x = {1:2, 4:3,5:3,2:7,8:5,9:4}

print(nth(x, 0))


words =  ["word","world","row"]

new_words = sorted(words,key=lambda x:(tuple(list(words))))
print(new_words)


def balanced_str(string):
    ref = {'0':'a','1':'b','2':'c','3':'d','4':'e','5':'f','6':'g','7':'h','8':'i','9':'j'}
    stk = []
    cnt = 0
    for i in string:
        if i in ref and ref[i] in stk:
            stk.pop(stk.index(ref[i]))
        elif i in ref and ref[i] not in stk:
            cnt+=1
        else:
            stk.append(i)
    return len(stk) + cnt

res = balanced_str('ab00a')
print(res)

print('fillNull')

def fillNull(input):
    for i in range(1,len(input)):
        if not input[i]:
            input[i] = input[i-1]

    print(input)



print(fillNull([1,2, None,None,7,None,None,None,6]))



print('balancelist')
def balancelist(nums):
    dict_count = {}
    max_count = 0
    for i in nums:
        if i not in dict_count:
            dict_count[i] = 1
        else:
            dict_count[i] += 1

        max_count = max(max_count, dict_count[i])

    res = {}
    for k,v in dict_count.items():
        if v!=max_count:
            res[k] = max_count-v
    return res



nums = [1, 1, 1, 5, 3, 2, 2]
print(nums)
print(balancelist(nums))


print("\nCount Chars")
def countChars(input):
    dict_count = {}
    for i in input:
        if i not in dict_count:
            dict_count[i] = 1
        else:
            dict_count[i] += 1

    res = ''
    for i in input:
        if i in dict_count:
            res = res + i + str(dict_count[i])
            del dict_count[i]
    return res

input = 'I am back.'
print(input)
print(countChars(input))


print('Check Balanced')
def is_balanced(string):
    stack = []
    opening = "({["
    closing = ")}]"
    b_map = {'(' : ')', '{' :'}', '[':']'}
    for c in string:
        if c in b_map:
            stack.append(b_map[c]) #remember to append value of the dict so
        else:
            if not stack or stack.pop()!=c:
                return False

    if stack:
        return False
    else:
        return True

string1 = "{[()]}"  # Balanced
string2 = "{(})"  # Not balanced
print(is_balanced(string1))  # True
print(is_balanced(string2))  # False


print('Check Balanced 2 ')
def is_balanced2(string):
    stack = []
    chars = ['abcdefghij']
    digits = ['0123456789']
    b_map = dict(zip(chars, digits))

    for c in string:
        if c in b_map:
            stack.append(b_map[c]) #remember to append value of the dict so
        else:
            if not stack or stack.pop()!=c:
                return False

    if stack:
        return False
    else:
        return True

string1 = "ab00a"  # 3
string2 = "bj19"  # Balanced so 0
print(is_balanced2(string1))  # True
print(is_balanced2(string2))  # False


def balanced_str(string):
    chars = list('abcdefghij')
    digits = list('0123456789')
    b_map = dict(zip(chars, digits))
    stk = []

    cnt = 0
    i = 0
    while i < len(string):
        c = string[i]
        if c in chars:
            stk.append(b_map[c])
            i += 1
        elif c in digits:
            if not stk:
                cnt +=1
                i += 1
            else:
                pop = stk.pop()
                if pop!=c:
                    cnt +=1
                else:
                    i += 1
    if stk:
        cnt += len(stk)
    return cnt

res = balanced_str('ab01') # ab10

print(res)

'''
stack
a b
a  1
[] 1
   2
[a] 2


ab00a

if char:
    add to stack
if digit:
    if stack empty
        increment count
    if stack not empty
        pop is not a match:
            increment 2
        pop is a match:
            do nothing

if stack not empty:
    add stack length to count
        
    

   
'''






print('\n balanced_str_chatgpt')

def balanced_str_chatgpt(s):
    alphabets = sum(c.isalpha() for c in s)
    numbers = sum(c.isdigit() for c in s)

    # Calculate the difference
    changes = abs(alphabets - numbers)

    return changes

# Example usage
s = "ab00a"
print(balanced_str_chatgpt(s))  # Output: How many changes are needed

print('missing words')



from collections import Counter

list1 = ['one', 'two','three','four','one']
list2 = ['three','four']

list1_count = dict(Counter(list1))
list2_count = dict(Counter(list2))

print(list1_count)
print(list2_count)

for k,v in list1_count.items():
    if k in list2_count:
        list2_count[k] = abs(list2_count[k]-list1_count[k])
        if list2_count[k] == 0:
            del list2_count[k]
    else:
        list2_count[k] = v

print(list2_count)



print('\nRemove dups')


def removeDups(nums):

    if not nums:
        return 0
    p1 = 0
    p2 = 1
    k = 1
    while p1<len(nums):
        while p2<len(nums) and p1<len(nums) and nums[p2] == nums[p1] :
            p2 += 1
        if p2<len(nums) and p1<len(nums):
            k += 1
            nums[p1+1] = nums[p2]
        p1+=1
        p2+=1
    return k

nums = [0,0,1]
print(nums)
print(removeDups(nums))
print(nums)





print('\Hash Function')

def simple_hash(key, range_size):
    """
    A simple hash function that returns a value within a given range.
    """

    return hash(key) % range_size


print(simple_hash('anand',3))


print('\Count Words')

def count_words(string):
    if not string:
        return 0
    string_split = string.strip().split(' ')
    return len(string_split)



string = ' hi my name leetcode'
print(count_words(string))


print('\ncheckMonotonicArray')
def checkMonotonicArray(input):

    if not input:
        return True
    if len(input) == 1:
        return True
    curr_max = input[0]
    for i in range(1,len(input)):

        curr_max = max(input[i],curr_max)
        if input[i] < curr_max:
            return False
    return True

array1 = [1,2,3,4,6,3,7,4,5,8]
array2 = [1,2,3,4,6]
print(checkMonotonicArray(array1))
print(checkMonotonicArray(array2))
array2 = []
print(checkMonotonicArray(array2))
array2 = [None]
print(checkMonotonicArray(array2))



print('\n Flatten list')

def flattenList(input):

    def flatten(sublist,i,list_l):
        if i == list_l:
            return []
        e = sublist[i]
        if isinstance(e,list):
            return flatten(e,0,len(e)) + flatten(sublist,i+1,list_l)
        else:
            return [e] + flatten(sublist,i+1,list_l)

    return flatten(input,0,len(input))



def flattenList2(input):
    result = []

    for i in input:
        if isinstance(i,list):
            result.extend(flattenList2(i))
        else:
            result.append(i)
    return result


input = [1,2,[3,4, [5],[6,7,[8,[9]]]]]
print(input)
print(flattenList(input))


input = [1,2,[3,4, [5],[6,7,[8,[9]]]]]
print(input)
print(flattenList2(input))



print('\nAll subsequences')
def allSubseqs(input):


    def allSubseqsIn(in_list, start):

        if start == len(in_list):
            return [[]]

        this_item = [in_list[start]]
        subseqs_without_this = allSubseqsIn(in_list,start+1)

        subseqs_with_this = [ this_item + subseq  for subseq in allSubseqsIn(in_list,start+1)]

        all_subs = subseqs_without_this + subseqs_with_this
        return all_subs

    return allSubseqsIn(input,0)

print('\nAll subsequences')

#bad code. loop does nothing. it only iterates once.
def allSubseqs2(input):


    def allSubseqs2(in_list, start):

        if start == len(in_list):
            return [[]]

        for i in range(start,len(in_list)):

            this_item = [in_list[i]]
            subseqs_without_this = allSubseqs2(in_list,start+1)

            subseqs_with_this = [ this_item + subseq  for subseq in allSubseqs2(in_list,start+1)]

            all_subs = subseqs_without_this + subseqs_with_this
            return all_subs

    return allSubseqs2(input,0)

input = 'abc'
print(input)
print(allSubseqs(input))


input = 'abc'
print(input)
print(allSubseqs2(input))




print('\nCheck IP')

def checkIp(ip):

    if not ip:
        return False

    split_ip = ip.split('.')
    if len(split_ip)!=4:
        return False

    for split in split_ip:
        if split.startswith('0'):
            return False
        try:
            if not 0 <=int(split)<=255:
                return False
        except ValueError:
            return False
    return True

ip = ''
print(checkIp(ip))


print('\nFriends Count')


def frindsCount(f_list):

    if not f_list:
        return {}
    res = {}
    for item in f_list:
        if len(item)==2:
            if item[0] not in res:
                res[item[0]] = {item[1]}
            else:
                res[item[0]].add(item[1])
    return res




f_list = [['A','B'],['A','C'],['B','D'],['B','C'],['R','M'], ['S'],['P'], ['A']]
print(frindsCount(f_list))


print('\nFlatten Map')
def flattenMap(nested_map):

    if not nested_map:
        return {}
    res = {}

    def flattenNested(p,n_map):

        if not n_map:
            return {}

        inner_res = {}
        for k,v in n_map.items():
            new_key = p + '_' + k
            if isinstance(v,dict):
                inner_res.update(flattenNested(new_key,v))
            else:
                inner_res[new_key] =  v
        return inner_res



    for k,v in nested_map.items():
        if isinstance(v,dict):
            res.update(flattenNested(k,v))
        else:
            res[k] =  v
    return res



#
# nested_map = { 1 : { 2:3,3:4,5:6},
#                2: { 2:3,3:4,5:6}}

'''
{'a': 1,
 'c': {'a': 2,
       'b': {'x': 5,
             'y' : 10}},
 'd': [1, 2, 3]}
 
{'a': 1,
 'c_a': 2,
 'c_b_x': 5,
 'c_b_y': 10,
 'd': [1, 2, 3]}
 
 
'''
nested_map = {'a': 1,
              'c': {'a': 2,
                    'b': {'x': 5,
                          'y' : 10}},
              'd': [1, 2, 3]}


print(flattenMap(nested_map))





print('\nGCD math.gcd()')
print('Euclidean Algorithm -  It works by repeatedly replacing the larger '
      'of two numbers with the remainder of dividing the larger by the smaller, '
      'until the remainder is zero. ')

def gcd(a, b):
    while b:
        a, b = b, a % b
        print(f'a-{a}\nb-{b} \n')
    return a

def gcdRecursion(a, b):
    if b == 0:
        return a
    return gcd(b, a % b)

print(gcd(12,24))


string = '10122'

print(int(string))







