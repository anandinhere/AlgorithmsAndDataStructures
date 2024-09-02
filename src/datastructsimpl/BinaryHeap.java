package datastructsimpl;


/*
https://www.baeldung.com/cs/heap-vs-binary-search-tree

Java implements these structures with the PriorityQueue and the TreeMap. PriorityQueue is a Max-Heap by default. TreeMap has a balanced binary search tree as a backbone. Its implementation is based on a Red-Black Tree.



0   1   2   3   4   5   6   7   8   9   10

                0
         1                    2
     3        4             5   6
   7   8    9  10
children 2i + 1, 2i + 2  parent : (i-1)/2
i=0
1 2 parent 0 0


i=1
3 4 parent 1 1

i=2
5 6

i=3
7 8

i=4
9 10



 */

class BinaryHeap {

    Node[] nodeArray;
    int currHeapSize;
    int maxHeapZise;


    public BinaryHeap() {
    }

    public BinaryHeap(int heapSize) {
        nodeArray = new Node[heapSize];
        currHeapSize = 0;
        maxHeapZise = heapSize;
    }

    public void add(Node node) {
        if (currHeapSize < maxHeapZise) {

            nodeArray[currHeapSize] = node;
            trickleUp(currHeapSize);
            currHeapSize++;

        }


    }


    public Node remove() {

/*
The minimum element can be found at the root, which is the first element of the array. We remove the root and replace it with the last element of the heap and then restore the heap property by percolating down. Similar to insertion, the worst-case runtime is O{log n).

 */


        Node root = nodeArray[0];
        nodeArray[0] = nodeArray[currHeapSize - 1];
        currHeapSize = currHeapSize - 1;
        trickleDown(0);
        return root;

    }

    /*https://stackoverflow.com/questions/1787252/is-there-a-on-algorithm-to-build-a-max-heap
    * check both children. break if both good
     *
     */
    private void trickleDown(int index) { // swap with child with higher key


        while (index < currHeapSize) {

            int child1 = 2 * index + 1;
            int child2 = 2 * index + 2;


            if (child1 < currHeapSize && nodeArray[child1].key < nodeArray[index].key) {

                swap(child1, index);
                index = child1;
                continue;

            }

            if (child2 < currHeapSize && nodeArray[child2].key < nodeArray[index].key) {

                swap(child2, index);
                index = child2;
                continue;

            }

            break;


        }


    }


    private void swap(int index1, int index2) {

        Node temp = nodeArray[index1];
        nodeArray[index1] = nodeArray[index2];
        nodeArray[index2] = temp;

    }

    public void printHeap() {


        for (int i = 0; i < currHeapSize; i++) {
            System.out.println(nodeArray[i].getKey());
        }


    }

    private void trickleUp(int i) {

        if (i == 0) {
            return;
        } else {
            int parent = (i - 1) / 2;
            while (nodeArray[parent].getKey() > nodeArray[i].getKey()) {
                Node temp = nodeArray[parent];
                nodeArray[parent] = nodeArray[i];
                nodeArray[i] = temp;
                i = parent;
                parent = (i - 1) / 2;
            }

        }
    }


    public static void main(String[] args) {

        System.out.println("Hello There!");


        BinaryHeap h = new BinaryHeap(12);
        h.add(new Node(4));
        h.add(new Node(3));
        h.add(new Node(2));
        h.add(new Node(1));
        h.add(new Node(5));
        h.add(new Node(6));
        h.add(new Node(7));
        h.add(new Node(8));
        h.add(new Node(0));
        h.add(new Node(9));
        h.add(new Node(10));
        h.add(new Node(11));
        h.printHeap();

        Node top = h.remove();
        System.out.println("\n");
        System.out.println(top.key);
        System.out.println("\n");
        h.printHeap();
    }


}


class Node {

    int key;

    public Node(int key) {
        this.key = key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return this.key;
    }

}


/*

0  1  2  3  4  5  6  7  8  9  10  11
0  1  3  2  5  6  7  8  4  9  10  11

0
1 3

1
2 5

3
6 7

2
8 4

5
9 10

6
11






 */
