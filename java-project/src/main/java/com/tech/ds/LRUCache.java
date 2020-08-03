package com.tech.ds;

import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;


/**
 * LRU Cache:
	Least Recently used values will be removed from cache if the cache size is full.
	
	
	Pseudo Logic:
	1. Use the Dequeue where Order element will be added to the rear end of the linkedList.
	2. Whenever put operation involves, check the cache size, if it reaches maximum capacity,
		Remove the last element(Rear element) using dequeue.removeLast.
	3. If Cache already contains the value,bring that value to first position of that queue.
	
 * @author Yuvaraj.
 *
 */
public class LRUCache {
	public Deque<Integer> dequeue;
	public Integer CAPACITY;
	public Map<Integer, Integer> map; // To Store the Reference if already exist or not.

	public LRUCache(int size) {
		this.dequeue = new LinkedList<Integer>();
		this.CAPACITY = size;
		map = new HashMap<Integer, Integer>();
	}

	/**
	 * Pseudo Logic:
			1. Use the Dequeue where Order element will be added to the rear end of the linkedList.
			2. Whenever put operation involves, check the cache size, if it reaches maximum capacity,
				Remove the last element(Rear element) using dequeue.removeLast.
			3. If Cache already contains the value,bring that value to first position of that queue.
	 * @param value
	 */
	public void add(Integer value) {
		if (map.get(value) == null) {
			if (dequeue.size() == CAPACITY) {
				dequeue.removeLast();
				map.remove(value);
			}
		} else {
			dequeue.remove(value);
		}
		dequeue.push(value);
		map.put(value, null);
	}

	
	/**
	 * Method used to display the Queue
	 */
	public void display() {
		Iterator<Integer> it = dequeue.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
	}

	public static void main(String[] str) {
		LRUCache lruCache = new LRUCache(4);

		lruCache.add(1);
		lruCache.add(2);
		lruCache.add(3);
		lruCache.add(4);

		System.out.println("Elements added");
		lruCache.display();

		System.out.println("Add element which is not already present");
		lruCache.add(5);
		lruCache.display();
		
		System.out.println("Add element which is already present");
		lruCache.add(3);
		lruCache.display();

	}
}
