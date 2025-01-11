'''
Exercise 1
of 2
17 min
Answer a Query
Imagine a length-N array of booleans, initially all false. Over time, some values are set to true, and at various points in time you would like to find the location of the nearest true to the right of given indices.
You will receive Q queries, each of which has a type and a value. SET queries have type = 1 and GET queries have type = 2.
When you receive a SET query, the value of the query denotes an index in the array that is set to true. Note that these indices start at 1. When you receive a GET query, you must return the smallest index that contains a true value that is greater than or equal to the given index, or -1 if no such index exists.
Signature
int[] answerQueries(ArrayList<Query> queries, int N)
Input
A list of Q queries, formatted as [type, index] where type is either 1 or 2, and index is <= N
1 <= N <= 1,000,000,000
1 <= Q <= 500,000
Output
Return an array containing the results of all GET queries. The result of queries[i] is the smallest index that contains a true value that is greater than or equal to i, or -1 if no index satisfies those conditions.
Example
N = 5
Q = 5
queries = [[2, 3], [1, 2], [2, 1], [2, 3], [2, 2]]
output = [-1, 2, -1, 2]
The initial state of the array is [false, false, false, false, false].
The first query is GET 3, but no values in the array are true, so the answer is -1.
The second query is SET 2, so the value at index 2 is set to true.
The new state of the array is [false, true, false, false, false].
The third query is GET 1, and the index of the true value nearest to 1 (to the right) is 2.
The fourth query is GET 3, but no values to the right of index 3 are true.
The fifth query is GET 2, and the value at index 2 is true.


'''

def getQueryResults(queries):
    if not queries:
        return None

    stateArray = [False] * len(queries)
    res = []

    for q in queries:
        if q[0] == 2:
            flag = False
            for i in range(q[1],len(queries)):
                if stateArray[i]:
                    res.append(i)
                    flag = True
            if not flag:
                res.append(-1)

        if q[0] == 1:
            stateArray[q[1]] = True

    return res


print(getQueryResults([[2, 3], [1, 2], [2, 1], [2, 3], [2, 2]]))


'''

Above-Average Subarrays
You are given an array A containing N integers. Your task is to find all subarrays whose average sum is greater than the average sum of the remaining array elements. You must return the start and end index of each subarray in sorted order.
A subarray that starts at position L1 and ends at position R1 comes before a subarray that starts at L2 and ends at R2 if L1 < L2, or if L1 = L2 and R1 ≤ R2.
Note that we'll define the average sum of an empty array to be 0, and we'll define the indicies of the array (for the purpose of output) to be 1 through N. A subarray that contains a single element will have L1 = R1.
Signature
Subarray[] aboveAverageSubarrays(int[] A)
Input
1 ≤ N ≤ 2,000
1 ≤ A[i] ≤ 1,000,000
Output
A Subarray is an object with two integer fields, left and right, defining the range that a given subarray covers. Return a list of all above-average subarrays sorted as explained above.
Example 1
A = [3, 4, 2]
output = [[1, 2], [1, 3], [2, 2]]
The above-average subarrays are [3, 4], [3, 4, 2], and [4].
'''



def aboveAverageSubarrays(a):
    if not a:
        return []
    len_a = len(a)
    res = []
    for i in range(0,len_a):
        for j in range(i+1,len_a+1):

            elements = a[i:j]
            arr_avg = sum(elements)/len(elements)

            other_elements = a[0:i] + a[j:]
            if other_elements:
                other_arr_avg = sum(other_elements)/len(other_elements)
            else:
                other_arr_avg = 0

            if arr_avg > other_arr_avg:
                res.append([i+1,j])
    return res


print(aboveAverageSubarrays([3, 4, 2]))