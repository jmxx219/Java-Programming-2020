/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진 
 * Object에 있는 중요 메소드 재정의하기
 */
public class Test {
	public static void shallow_copy_test() {
		Professor p1 = new Professor("김상진", ProfessorType.PROFESSOR);
		Professor p2 = p1.clone();
		System.out.println(p1);
		// 복제 후 주소, equals, hashCode 비교
		System.out.println(p1==p2);
		System.out.println(p1.equals(p2));
		System.out.println(p1.hashCode()==p2.hashCode());
		p2.setName("정약용");
		System.out.println(p1.equals(p2));
		System.out.println(p1.hashCode()==p2.hashCode());
	}
	public static void deep_copy_test() {
		Professor p1 = new Professor("김상진", ProfessorType.PROFESSOR);
		Student s1 = new Student("홍길동", 1, p1);
		System.out.println(s1);
		Student s2 = s1.clone();
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode()==s2.hashCode());
		s2.setYear(3);
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode()==s2.hashCode());
	}
	public static void class_test() {
		Professor p = new Professor("김상진", ProfessorType.PROFESSOR);
		Class<? extends Professor> c1 = p.getClass();
		System.out.println(c1.getName());
		Class<Professor> c2 = Professor.class;
		System.out.println(c2.getName());
	}
	public static void main(String[] args) {
		//shallow_copy_test();
		deep_copy_test();
	}

}
