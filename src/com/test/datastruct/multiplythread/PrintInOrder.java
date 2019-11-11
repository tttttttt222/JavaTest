package com.test.datastruct.multiplythread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2019/10/12
 */
public class PrintInOrder {

	private CountDownLatch second = new CountDownLatch(1);
	private CountDownLatch third = new CountDownLatch(1);


	public static void main(String[] args) throws InterruptedException {
		PrintInOrder printInOrder = new PrintInOrder();
	}

	public PrintInOrder() throws InterruptedException {

	}

	public void first(Runnable printFirst) throws InterruptedException {

		// printFirst.run() outputs "first". Do not change or remove this line.
		printFirst.run();
		second.countDown();
	}

	public void second(Runnable printSecond) throws InterruptedException {

		second.await();
		// printSecond.run() outputs "second". Do not change or remove this line.
		printSecond.run();
		third.countDown();

	}

	public void third(Runnable printThird) throws InterruptedException {

		third.await();
		// printThird.run() outputs "third". Do not change or remove this line.
		printThird.run();
	}

}
