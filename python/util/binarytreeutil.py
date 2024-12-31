
from typing import List
from binarytree import Node

class TreeNode():
    def __init__(self,val):
        self.val = val
        self.left = None
        self.right = None




    def makeCompleteTreeFromPreOrder(preList:List) -> "TreeNode":

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


    def makePrettyTree(treeNode:["TreeNode"]) -> Node:

        if not treeNode:
            return None

        rootNode = Node(treeNode.val)
        rootNode.right = TreeNode.makePrettyTree(treeNode.right)
        rootNode.left = TreeNode.makePrettyTree(treeNode.left)
        return rootNode

    def getPre


if __name__ == "__main__":
    root = TreeNode.makeCompleteTreeFromPreOrder([1,2,3,4,5,6,7])
    print(root.val)

    prettyTree = TreeNode.makePrettyTree(root)

    prettyTree.pprint()



'''
 0 1 2 3
 pivot 1
 
 mid of 0,3 -> 1<=3 so left,  left = 0 right = 1, 
 mid of 0 and 1 is 1, so right

'''
