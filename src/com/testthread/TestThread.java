package com.testthread;
/*
 * ���̣߳����������������߳���ʵ����Thread-0��Thread-1������������ݡ�
 * ���������̺߳��߳���ʵ����ȷ�����������
 * ���������߳���ȫ�����ɺ󣬲��ֵ��߳���ʵ�����ж����������
 */

/*
 * �û����߳������̳���Thread�ࣨ��ʵ��Runnable�ӿڣ���
 * ������Thread���run()��������ʵ��Runnable�ӿ��е�run()��������
 * run()�������߳�����ʱ��ִ�еĴ��룬
 * start()�����������̡߳���start()����ֻ����Thread�߳��ࣩ��
 */
public class TestThread extends Thread {	//���߳����а���������
	String threadName;
	
	public TestThread(String threadName) {	//���췽���������߳����֡������
		System.out.println("���̵߳����֣�" + threadName);
		this.threadName = threadName;
	}
	
	public void run() {	//�����߳�����ʱ��ִ�еĴ���
		for(int i = 0; i < 3; i++) {
			System.out.println("�������е��߳���" + threadName);
			try {
				Thread.sleep((int)(Math.random() * 1000));	//���߳�����һ��ʱ�䣨�����
			} catch(InterruptedException e) {
				System.err.println(e.toString());	//System.err����Ӧ��׼������
			}
		}	//for
	}	//run
	
	public static void main(String[] args) {
		System.out.println("��ʼ����������");
		TestThread thread1 = new TestThread("����");		//�����߳���ʵ��
		TestThread thread2 = new TestThread("�����");
		thread1.start();	//���������߳�
		thread2.start();
		System.out.println("���������н���");
	}

}
