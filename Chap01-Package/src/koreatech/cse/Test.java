package koreatech.cse;

import koreatech.eec.Electronics;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진
 * Test 클래스
 */
public class Test {
	public static void main(String[] args) {
		ComputerSoftware track = new ComputerSoftware();
		track.output();
		Electronics major = new Electronics();
		major.output();
	}
}
