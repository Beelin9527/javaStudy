package cn.xx.thread;
/*
 * 使用实现Runnable接口和继承Thread类这两种开辟新线程的方法的选择应该优先选择实现Runnable接口这种方式去开辟一个新的线程。
 * 因为接口的实现可以实现多个，而类的继承只能是单继承。
 * 因此在开辟新线程时能够使用Runnable接口就尽量不要使用从Thread类继承的方式来开辟新的线程。
 */
/*
 * join、yield、notify
 */
public class TestThread {

	public static void main(String[] args) {
		run4();
	}
	
	public static void run1() {
		Runner1 r = new Runner1();
		//r.run();  /这个称为方法调用，方法调用的执行是等run()方法执行完之后才会继续执行main()方法
		
		Thread t = new Thread(r);
		
		t.start(); //启动新开辟的线程，新线程执行的是run()方法，新线程与主线程会一起并行执行
		for (int i = 0; i < 5; i++) {
			System.out.println("thread" + i);
		}
	}
	
	public static void run2() {
		Runner2 r = new Runner2();
		r.start();
		if (r.isAlive()) {
			System.out.println("ture");
		} else {
			 System.out.println("flase");
		}
		
	}
	
	/*
	 * 线程级别 MIN_PRIORITY 
	 * 		  NORM_PRIORITY
	 * 	      MAX_PRIORITY
	 */
	public static void run3() {
		Runner2 r = new Runner2();
		r.setPriority(Thread.NORM_PRIORITY);
		System.out.println("t1线程的优先级是：" + r.getPriority());
      // 使用getPriority()方法取得线程的优先级别
	}
	
	//同步锁
	public static void run4() {
		Runner3 r = new Runner3();
		for (int i = 0; i < 100; i ++) {
			Thread t = new Thread(r);
			t.start();
		}
		
	}

}

/*定义一个类用来实现Runnable接口，实现Runnable接口就表示这个类是一个线程类*/
class Runner1 implements Runnable {
	public void run() {
		System.out.println("Runner1 run");
	}
}

class Runner2 extends Thread {
	public void run() {
		System.out.println("Runner2 run");
	}
}

/*卖票 实现synchronized*/
class Runner3 implements Runnable {
	public static int tickerCount = 100;
	public void run() {
		synchronized (this) {
			if (tickerCount == 0) return;
			tickerCount --;
			System.out.println("票还剩" + tickerCount + "张");
		}
	}
}