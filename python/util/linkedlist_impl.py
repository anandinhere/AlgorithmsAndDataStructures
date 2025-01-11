    def __init__(self, value):
        self.value = value
        self.next = None
        self.previous = None


class LinkedList:
    def __init__(self):
        self.head = None
        self.tail = None
        self.size = 0

    def insert(self, val:int) -> None:
        node = Node(val)
        if self.head is None:
            self.head = node
            self.tail = node
        else:
            self.tail.next = Node(val)
            self.tail = self.tail.next

        self.size += 1

    def remove(self, value:int) -> None:

        if self.head is None:
            return

        curr = self.head
        if curr.value==value:
            self.head= curr.next
            self.tail= curr.next
            return

        while curr is not None and curr.next is not None:
            if curr.next.value==value:
                curr.next = curr.next.next

                self.size -= 1
                return

            curr = curr.next




    def printList(self) -> None:
        curr = self.head
        while curr is not None:
            print(curr.value, end = '->')
            curr = curr.next
        print()



if __name__ == '__main__':

    linkedList = LinkedList()
    linkedList.insert(1)
    linkedList.insert(2)
    linkedList.insert(3)
    linkedList.insert(4)
    linkedList.printList()
    linkedList.remove(1)
    linkedList.printList()






