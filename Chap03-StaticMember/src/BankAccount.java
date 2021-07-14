/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진
 * BankAccount 클래스: 3장 static 멤버변수 연습
 * 은행 계좌>> 상태: 잔액, 계좌번호, 행위: 입금, 인출, 잔액조회
 * 계좌번호: 생성된 순서에 따라 1, 2, ...
 * 생성자에서 계좌번호 설정
 * 입금, 인출의 예외적 상황 처리: 예외적 상황이 발생하면 아무것도 하지 않음
 */
public class BankAccount {
	private int balance = 0;
	private int accountNumber;
	private static int lastAssignedNumber = 1;
	
	public BankAccount(){
		accountNumber = lastAssignedNumber;
		++lastAssignedNumber;
	} // BankAccount()
	public BankAccount(int amount){
		this();
		deposit(amount);
	} // BankAccount(int)
	public int getAccountNumber() {
		return accountNumber;
	}
	public int getBalance(){
		return balance;
	} // getBalance()
	public void deposit(int amount){
		if(amount>0) balance += amount;
	} // deposit(int)
	public void withdraw(int amount){
		if(amount>0 && balance>=amount) balance -= amount;
	} // withdraw(int)
}
