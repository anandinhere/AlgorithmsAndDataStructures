package util;

import java.util.HashMap;
import java.util.Random;
import java.lang.Math;
import java.util.Map.Entry;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

public class UsualImports {

	public static void main(String[] args) throws InterruptedException {
		Random r = new Random();

		ReentrantLock lock = new ReentrantLock();
		boolean isLockAcquired = lock.tryLock(1, TimeUnit.SECONDS);
		ReadWriteLock lock1 = new ReentrantReadWriteLock();
	    //...
	    Lock writeLock = lock1.writeLock();
	    
	    Condition stackEmptyCondition = lock.newCondition();
	    Condition stackFullCondition = lock.newCondition();
		
		HashMap<Integer, String> m = new HashMap<Integer, String>();
		int[] test = new int[] { 1, 2, 3 };
		System.out.println(Arrays.toString(test));
		for (Entry e : m.entrySet()) {
			System.out.println(e.getKey());
			Math.max(3, 4);
		}
	
	}

}
