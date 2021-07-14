/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * 2020년도 2학기 
 * @author 김상진
 * Size 열거형
 */
public enum Size {
	SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");
	public final String abbreviation;
	Size(String abbreviation){
		this.abbreviation = abbreviation;
	}
	public Size nextSize() {
		Size[] sizes = Size.values();
		int curr = this.ordinal();
		if(curr!=sizes.length-1) ++curr;
		return sizes[curr];
	}
	public Size prevSize() {
		Size[] sizes = Size.values();
		int curr = this.ordinal();
		if(curr!=0) --curr;
		return sizes[curr];
	}
	
}
