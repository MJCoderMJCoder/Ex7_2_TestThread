package com.testthread;
/*
 * 主线程（主函数）和两个线程类实例（Thread-0与Thread-1）交替输出内容。
 * 往往是主线程和线程类实例不确定次序交替输出
 * 或者是主线程完全输出完成后，才轮到线程类实例运行而产生输出。
 */

/*
 * 用户的线程类必须继承自Thread类（或实现Runnable接口），
 * 并覆盖Thread类的run()方法（或实现Runnable接口中的run()方法）；
 * run()：包含线程运行时所执行的代码，
 * start()：用于启动线程。（start()方法只属于Thread线程类）。
 */
public class TestThread extends Thread {	//该线程类中包含主函数
	String threadName;
	
	public TestThread(String threadName) {	//构造方法（传入线程名字、输出）
		System.out.println("本线程的名字：" + threadName);
		this.threadName = threadName;
	}
	
	public void run() {	//包含线程运行时所执行的代码
		for(int i = 0; i < 3; i++) {
			System.out.println("正在运行的线程是" + threadName);
			try {
				Thread.sleep((int)(Math.random() * 1000));	//让线程休眠一段时间（随机）
			} catch(InterruptedException e) {
				System.err.println(e.toString());	//System.err：对应标准错误流
			}
		}	//for
	}	//run
	
	public static void main(String[] args) {
		System.out.println("开始运行主函数");
		TestThread thread1 = new TestThread("如来");		//创建线程类实例
		TestThread thread2 = new TestThread("孙悟空");
		thread1.start();	//用于启动线程
		thread2.start();
		System.out.println("主函数运行结束");
	}

}
