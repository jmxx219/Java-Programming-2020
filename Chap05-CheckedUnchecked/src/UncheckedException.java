/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진
 * UncheckedException 클래스: 5장 예외처리 연습
 * Unchecked 사용자 정의 예외. 
 * Unchecked 예외는 RuntimeException을 상속받아 정의함
 */
public class UncheckedException extends RuntimeException {
	private static final long serialVersionUID = 2255732978776704762L;
	public UncheckedException() {
		super("Unchecked 예외 발생");
	}
	public UncheckedException(String msg) {
		super(msg);
	}
}
