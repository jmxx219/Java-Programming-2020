/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진
 * BankAccountTest 클래스: 5장 예외처리 연습
 */
public class BankAccountNormalTest {
	// 계좌이체 테스트
	// 잔액부족 예외 발생
	public static void transferTest() {
		BankAccount aliceAccount = new BankAccount(10_000); 
		BankAccount bobAccount = new BankAccount(5_000); 
		try {
			BankAccount.transfer(aliceAccount, bobAccount, 15_000);
			System.out.printf("%,d원%n",aliceAccount.getBalance()); 
			System.out.printf("%,d원%n",bobAccount.getBalance());
		}
		catch(InsufficientFundException e){
			System.out.printf("잔액이 부족하여 %,d원을 이체할 수 없습니다. 현재 잔액은 %,d원입니다.",
				e.getRequestAmount(), e.getCurrentAmount());
		}
		
	}
	// assert를 이용한 예외 처리
	public static void exceptionTest() {
		BankAccount aliceAccount = new BankAccount(10_000); 
		BankAccount bobAccount = new BankAccount (5_000); 
		try {
			aliceAccount.withdraw(5_000); 
			bobAccount.deposit(Integer.MAX_VALUE); 
			System.out.printf("%,d원%n",aliceAccount.getBalance()); 
			System.out.printf("%,d원%n",bobAccount.getBalance());
		}
		catch(InsufficientFundException e){
			System.out.printf("잔액이 부족하여 %,d원을 이체할 수 없습니다. 현재 잔액은 %,d원입니다.",
					e.getRequestAmount(), e.getCurrentAmount());
		}
	}
	public static void generalTest() {
		BankAccount aliceAccount = new BankAccount(10_000); 
		BankAccount bobAccount = new BankAccount (5_000); 
		try {
			aliceAccount.withdraw(5_000); 
			bobAccount.deposit(5_000); 
			System.out.printf("%,d원%n",aliceAccount.getBalance()); 
			System.out.printf("%,d원%n",bobAccount.getBalance());
		}
		catch(InsufficientFundException e){
			System.out.printf("잔액이 부족하여 %,d원을 인출할 수 없습니다. 현재 잔액은 %,d원입니다.",
					e.getRequestAmount(), e.getCurrentAmount());
		}	
	}
	public static void main(String[] args) {
		generalTest();
		//exceptionTest();
		transferTest();
	}

}
