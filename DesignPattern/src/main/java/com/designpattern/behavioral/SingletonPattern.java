package com.designpattern.behavioral;

/**
 * Just Define a class that has only one object, and have global access point.
 * Class ensure that only one instance should be created.
 * 
 * Two forms of Singleton Design Pattern
 * 
 * Early Instantiation -> Creation of instance at load time Lazy Instantiation
 * -> Creation of instance when required
 * 
 * Use : Since only one instance is created per request memory savage, the same
 * instance re used again and again.
 * 
 * Application used Singleton pattern : Thread pool, Logging, Caching, JDBC
 * Connection
 * 
 * @author Yuvaraj
 *
 */
public class SingletonPattern {

	public static SingletonPattern singletonPattern;

	private SingletonPattern() {

	}

	public static SingletonPattern getSingletonPattern() {
		if (singletonPattern == null) {
			singletonPattern = new SingletonPattern();
		}
		return singletonPattern;
	}

}
