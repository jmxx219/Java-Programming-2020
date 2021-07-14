/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진
 * CheckedException 클래스: 5장 예외처리 연습
 * Checked 사용자 정의 예외. 
 * Checked 예외는 Exception을 상속받아 정의함
 */
public class CheckedException extends Exception {
	private static final long serialVersionUID = 3572524678561213823L;
	public CheckedException() {
		super("Checked 예외 발생");
	}
	public CheckedException(String msg) {
		super(msg);
	}
}
