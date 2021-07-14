import java.util.Arrays;
import java.util.Objects;

class A{
	private int a;
	private int b;
	public A(int a, int b) {
		this.a = a;
		this.b = b;
	}
	@Override public int hashCode() {
		return Objects.hash(a, b);
	}
}

class B{
	private String a;
	private String b;
	public B(String a, String b) {
		this.a = a;
		this.b = b;
	}
	@Override public int hashCode() {
		return Objects.hash(a, b);
	}
}

class C{
	private int n;
	private String s;
	private Student student;
	private int[] arr;
	public C(int n, String s, Student student, int[] arr) {
		this.n = n;
		this.s = s;
		this.student = student;
		this.arr = arr;
	}
	@Override public int hashCode() {
		return Objects.hash(n, s, student, Arrays.hashCode(arr));
	}
}


public class HashcodeTest {
	public static void testA() {
		A a1 = new A(1, 3);
		A a2 = new A(3, 1);
		System.out.println(a1.hashCode());
		System.out.println(a2.hashCode());
	}
	public static void testB() {
		B b1 = new B("apple", "banana");
		B b2 = new B("banana", "apple");
		System.out.println(b1.hashCode());
		System.out.println(b2.hashCode());
	}
	public static void testC() {
		Professor p1 = new Professor("김상진", ProfessorType.PROFESSOR);
		Student s1 = new Student("홍길동", 1, p1);
		int[] nums1 = {1,2,3,4,5};
		int[] nums2 = {1,2,3,6,5};
		C c1 = new C(1, "apple", s1, nums1);
		C c2 = new C(1, "apple", s1, nums2);
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
	}
	public static void arrayTest() {
		int[] list1 = {1,2,3,4,5};
		int[] list2 = {1,2,3,4,5};
		System.out.printf("list1 = %s%n", list1.toString());
		System.out.printf("list1.hashCode() = %x%n", list1.hashCode());
		System.out.printf("list1.hashCode() = %x%n", list2.hashCode());
		System.out.printf("Arrays.hashCode(list1) = %x%n", Arrays.hashCode(list1));
		System.out.printf("Arrays.hashCode(list2) = %x%n", Arrays.hashCode(list2));
		
		String[] x1 = {"apple", "banana", "graphe"};
		String[] x2 = {"apple", "banana", "graphe"};
		String[] x3 = {new String("apple"), "banana", "graphe"};
		System.out.printf("x1.hashCode() = %x%n", x1.hashCode());
		System.out.printf("x2.hashCode() = %x%n", x2.hashCode());
		System.out.printf("x3.hashCode() = %x%n", x3.hashCode());
		
		System.out.printf("Objects.hash(x1, 0) = %x%n", Objects.hash(x1, 0));
		System.out.printf("Objects.hash(x2, 0) = %x%n", Objects.hash(x2, 0));
		System.out.printf("Objects.hash(x3, 0) = %x%n", Objects.hash(x3, 0));
		
		System.out.printf("%x%n", Arrays.hashCode(x1));
		System.out.printf("%x%n", Arrays.hashCode(x2));
		System.out.printf("%x%n", Arrays.hashCode(x3));
	}
	public static void main(String[] args) {
		//testA();
		//testB();
		//testC();
		arrayTest();
	}

}
