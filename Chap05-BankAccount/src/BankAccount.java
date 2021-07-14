/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진
 * BankAccount 클래스: 5장 예외처리 연습
 * 은행 계좌>> 상태: 잔액, 행위: 입금, 인출, 잔액조회
 * 입금, 인출의 예외적 상황 처리
 */
public class BankAccount {
	private int balance = 0;
	public BankAccount(){
	} // BankAccount()
	public BankAccount(int amount){
		deposit(amount);
	} // BankAccount(int)
	public int getBalance(){
		return balance;
	} // getBalance()
	public void deposit(int amount){
		if(amount<=0) throw new IllegalArgumentException("음수 또는 0 입금");
		if(balance>Integer.MAX_VALUE-amount) throw new ArithmeticException("입금 과정 오버플로우");
		balance += amount;
	} // deposit(int)
	public void withdraw(int amount) throws InsufficientFundException{
		if(amount<=0) throw new IllegalArgumentException("음수 또는 0 출금");
		if(amount>balance) throw new InsufficientFundException(balance, amount,
				String.format("잔액부족> 현재잔액: %d, 인출시도액: %d", balance, amount));
		balance -= amount;
	} // withdraw(int)
	public static void transfer(BankAccount from, BankAccount to, int amount) throws InsufficientFundException{
		if(from==null||to==null) return;			
		try{			
			from.withdraw(amount);			
			to.deposit(amount);		
		}		
		catch(InsufficientFundException e){	
			throw new InsufficientFundException(from.getBalance(), amount, "계좌이체 잔액부족");
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());		
		}	
	} // transfer(BankAccount, BankAccount, int)
}
