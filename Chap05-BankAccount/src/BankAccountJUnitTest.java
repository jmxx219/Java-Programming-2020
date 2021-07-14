import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진
 * BankAccountJUnitTest 클래스: 5장 예외처리 연습
 * JUnit5를 이용한 테스트 프로그램
 */
public class BankAccountJUnitTest {
	private BankAccount aliceAccount = null;
	private BankAccount bobAccount = null;
	
	@BeforeEach
	public void constructBankAccounts() {
		aliceAccount = new BankAccount();
		bobAccount = new BankAccount(10_000);
		assertEquals(aliceAccount.getBalance(), 0);
		assertEquals(bobAccount.getBalance(), 10_000);
	}
	
	@Test
	public void constructorTest() {
		// BankAccount aliceAccount = new BankAccount();
		// BankAccount bobAccount = new BankAccount(10000);	
		assertEquals(aliceAccount.getBalance(), 0);
		assertEquals(bobAccount.getBalance(), 10_000);
		assertThrows(IllegalArgumentException.class,
			()->{
				BankAccount charlieAccount = new BankAccount(-5000);
				assertNull(charlieAccount);
			});
	}
	
	@Test
	@DisplayName("deposit Method Tests")
	public void depositTest() {
		// BankAccount aliceAccount = new BankAccount();
		// BankAccount bobAccount = new BankAccount(10000);		
		aliceAccount.deposit(5_000);
		bobAccount.deposit(5_000);
		assertEquals(aliceAccount.getBalance(), 5_000);
		assertEquals(bobAccount.getBalance(), 15_000);
		assertThrows(InsufficientFundException.class, 
				()->aliceAccount.withdraw(10_000));
		assertThrows(IllegalArgumentException.class, 
				()->aliceAccount.deposit(-5_000));
		assertThrows(ArithmeticException.class, 
				()-> bobAccount.deposit(Integer.MAX_VALUE));
		assertEquals(aliceAccount.getBalance(), 5_000);
		assertEquals(bobAccount.getBalance(), 15_000);
	}

	@Test
	@DisplayName("withdraw Method Tests")
	public void withdrawTest() {
		// BankAccount aliceAccount = new BankAccount();
		// BankAccount bobAccount = new BankAccount(10000);
		assertThrows(InsufficientFundException.class, 
				()->aliceAccount.withdraw(5_000));
		assertDoesNotThrow(()->bobAccount.withdraw(5_000));
		assertEquals(aliceAccount.getBalance(), 0);
		assertEquals(bobAccount.getBalance(), 5_000);
		assertThrows(IllegalArgumentException.class, 
				()->bobAccount.withdraw(-10_000));
		assertEquals(bobAccount.getBalance(), 5_000);
		assertDoesNotThrow(()->bobAccount.withdraw(5_000));
		assertEquals(bobAccount.getBalance(), 0);
	}
	
	@Test
	public void transferTest() {
		assertDoesNotThrow(()->BankAccount.transfer(bobAccount, aliceAccount, 5_000));
		assertEquals(aliceAccount.getBalance(), 5_000);
		assertEquals(bobAccount.getBalance(), 5_000);
		assertThrows(InsufficientFundException.class, 
			()->BankAccount.transfer(bobAccount, aliceAccount, 10_000));
		assertEquals(aliceAccount.getBalance(), 5_000);
		assertEquals(bobAccount.getBalance(), 5_000);
	}
}
