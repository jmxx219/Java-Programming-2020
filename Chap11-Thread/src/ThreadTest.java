import java.util.ArrayList;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진 
 * ThreadTest 클래스
 * 20개의 쓰레드를 생성하여 병행 수행
 */
public class ThreadTest{
	private static class Task implements Runnable{	
		private static int taskSequence = 0;
		private String taskNumber;
		public Task(){	
			++taskSequence;	
			if(taskSequence<10) taskNumber = ""+taskSequence;
			else taskNumber = ""+(char)('A'+taskSequence-10);
		}
		@Override
		public void run() {
			for(int i=0; i<50; i++) {
				System.out.print(taskNumber);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws InterruptedException{	
		ArrayList<Thread> list = new ArrayList<>();
		System.out.println("프로그램 시작: 2초만 쉬자");
		Thread.sleep(2000);
		System.out.println("20개 쓰레드 생성");
		for(int i=0; i<20; i++){
			list.add(new Thread(new Task()));
		}
		for(Thread thread: list) thread.start();
		// 아래 문장을 포함하여 실행하면 "Last Line of main"이 
		// 모든 thread가 종료된 후에 출력됨
		for(Thread thread: list) thread.join();
		System.out.println("\nLast Line of main");
	} // main
} // class ThreadTest
