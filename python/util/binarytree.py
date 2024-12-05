
from typing import List

class TreeNode():
    def __init__(self,val):
        self.val = val
        self.left = None
        self.right = None




def makeCompleteTreeFromPreOrder(preList:List) -> TreeNode:

    def makeTree(l:List,i):

        if i>=len(l):
            return None

        root = TreeNode(l[i])
        leftIndex = (i*2) + 1
        rightIndex = (i*2) + 2

        leftNode = makeTree(l,leftIndex)
        rightNode = makeTree(l,rightIndex)

        root.left = leftNode
        root.right = rightNode
        return root

    return makeTree(preList,0)


root = makeCompleteTreeFromPreOrder([1,2,3,4,5,6,7])
print(root.val)




