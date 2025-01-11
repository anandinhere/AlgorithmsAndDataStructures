class Trie:

    #return ord(char.lower()) - ord('a')
    def __init__(self):
        self.root = None


    def insert(self, word: str) -> None:
        if not self.root:
            self.root = Node()

        def insert(index,word,root):
            char_at_i = word[index]
            trie_node_index = ord(char_at_i.lower()) - ord('a')

            if not root.children[trie_node_index]:
                root.children[trie_node_index] = Node()

            root = root.children[trie_node_index]
            if index == len(word)-1:
                root.leaf = True
                root.count += 1
                return

            insert(index+1,word,root)

        insert(0,word,self.root)


    def search(self, word: str) -> bool:

        if not word:
            return False
        if not self.root:
            return False

        def search(index,word,root):
            char_at_i = word[index]
            trie_node_index = ord(char_at_i.lower()) - ord('a')

            root = root.children[trie_node_index]
            if index <= len(word)-1 and not root:
                return False
            if index == len(word)-1 and not root.leaf:
                return False

            if index == len(word)-1 and root.leaf:
                return True

            return search(index+1,word,root)

        return search(0,word,self.root)


    def startsWith(self, prefix: str) -> bool:
        if not prefix:
            return False
        if not self.root:
            return False

        def check(index,word,root):
            char_at_i = word[index]
            trie_node_index = ord(char_at_i.lower()) - ord('a')

            root = root.children[trie_node_index]

            if index == len(word)-1 and root:
                return True

            if index == len(word)-1 and not root:
                return True

            if not root:
                return False

            return check(index+1,word,root)

        return check(0,prefix,self.root)



class Node:
    def __init__(self):
        self.leaf = False
        self.count = 0
        self.children = [None for _ in range(26)]


trie =  Trie()
print(trie.insert("apple"))
print(trie.search("apple"))  # return True
print(trie.search("app"))    # return False
print(trie.startsWith("app")) # return True
print(trie.insert("app"))
print(trie.search("app"))     # return True

# Your Trie object will be instantiated a)nd called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)