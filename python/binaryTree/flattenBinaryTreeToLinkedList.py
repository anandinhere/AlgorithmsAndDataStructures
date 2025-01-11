# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from util.binarytreeutil import TreeNode

from binarytree import Node

from typing import Optional
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return None
        left = root.left
        right = root.right

        root.left = None
        root.right = None

        if left:
            root.right = self.flatten(left)

        if root.right:
            last_right = root.right
            while last_right.right is not None:
                last_right.right = last_right.right.right

            last_right.right = self.flatten(right)
        else:
            root.right = self.flatten(right)

        return root



rootNode = TreeNode.makeCompleteTreeFromPreOrder([1,2,5,3,4,None,6])
print(TreeNode.makePrettyTree(rootNode))
#print(rootNode)

s = Solution()
res = s.flatten(rootNode)

print(res)