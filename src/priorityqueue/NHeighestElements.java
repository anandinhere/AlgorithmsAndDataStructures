package priorityqueue;

public class NHeighestElements {

	
	/*
	 * 
	 * 
	 * 

A couple of thoughts on this.

This task is well suited for using multiple processors. 
You could split the pages across a pool of threads and then combine the results as they complete.

It's unnecessary to insert each value, allow the collection to sort and then remove the smallest. 
Quicker would be to just check if each item is larger than the smallest (i.e. the last) item in the collection.

Here's a simple example finding the 100 largest integers in an array of 10,000 random integers.

    Queue<Integer> largest = new PriorityQueue<>(100);

    for (int item : new Random().ints(10000, 0, 100).toArray()) {
        if (largest.size() < 100 || largest.peek() < item) {
            if (largest.size() == 100)
                largest.remove();
            largest.add(item);
        }
    }
    System.out.println(largest);


	 */
}

