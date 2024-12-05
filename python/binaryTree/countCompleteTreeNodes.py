# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#from ..util.binarytree import TreeNode,makeCompleteTreeFromPreOrder

from util.binarytree import TreeNode,makeCompleteTreeFromPreOrder

from typing import Optional
class Solution:

    def countNodes1(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        if not root.left and not root.right:
            return 1

        return 1 + self.countNodes1(root.left) + self.countNodes1(root.right)

    def countNodes2(self, root: Optional[TreeNode]) -> int:

        if not root:
            return 0

        height = 0
        temp = root
        while temp:
            temp = temp.left
            height += 1

        leafCount = 0
        def countNodesFlag( root: Optional[TreeNode], currheight:int) -> None:
            nonlocal leafCount
            if not root:
                return


            if not root.left and not root.right and currheight==height:
                leafCount += 1


            countNodesFlag(root.left,currheight+1)
            countNodesFlag(root.right,currheight+1)


        countNodesFlag(root,1)




        return (2 ** (height-1)) -1 +  leafCount


    def countNodes(self, root: Optional[TreeNode]) -> int:

        if not root:
            return 0

        height = 0
        temp = root
        while temp:
            temp = temp.left
            height += 1

        leafCount = 0
        def checkexists(idx:int, height:int, root: Optional[TreeNode]) -> bool:

            max_leaf_nodes = 2**height - 1
            left = 0
            right = max_leaf_nodes

            for _ in range(height):
                mid = left + (right - left) // 2
                if idx <= mid:
                    right = mid
                    root = root.left
                else:
                    left = mid + 1
                    root = root.right
            return root is not None



        max_leaf_nodes = 2 **height-1
        left = 1
        right = max_leaf_nodes
        while left<=right:
            mid = left + (right - left) // 2
            if checkexists(mid,height,root):
                left = mid + 1
            else:
                right = mid - 1
        #(2**(height -1 )) -1 +
        return   left



rootNode = makeCompleteTreeFromPreOrder([1,2,3,4,5,6])
print(rootNode)
