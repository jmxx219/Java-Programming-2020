/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진
 * CatSound 클래스
 */
public class CatSound implements MakeSoundStrategy {
	@Override
	public String getSound() {
		return "야옹";
	}

}
