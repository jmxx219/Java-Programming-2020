public class Test {

	public static void main(String[] args) {
		Student s1 = new Student("홍길동", 1);
		Student s2 = new Student("장보고", 1);
		Student s3 = new Student("장길산", 1);
		Student s4 = new Student("임꺽정", 1);
		Student s5 = new Student("심춘향", 1);
		Student s6 = new Student("서장금", 1);
		s1.setFriends(s2,s3,s4);
		s2.setFriends(s1,s5);
		s3.setFriends(s1,s5);
		
		System.out.println(s2.equals(s3));
		System.out.println(s2.hashCode()==s3.hashCode());
		Student s7 = s1.clone();
		System.out.println(s1.equals(s7));
		System.out.println(s1.hashCode()==s7.hashCode());
		s7.setFriends(s2,s4,s6);
		System.out.println(s1.equals(s7));
		System.out.println(s1.hashCode()==s7.hashCode());
	}

}
