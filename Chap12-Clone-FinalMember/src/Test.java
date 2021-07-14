
public class Test {
	public static void main(String[] args) {
		Student s1 = new Student("홍길동", 1, 2020);
		Student s2 = s1.clone();
		System.out.println(s1);
		System.out.println(s2);
	}
}
