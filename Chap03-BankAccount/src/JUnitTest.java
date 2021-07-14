import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class JUnitTest {
	
	private int be = 0;
	private int ae = 0;

	@BeforeAll
	public static void beforeAll() {
		System.out.println("Before All");
	}
	
	@AfterAll
	public static void afterAll() {
		System.out.println("After All");
	}
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("Before Each: "+be);
		++be;
	}
	
	@AfterEach
	public void afterEach() {
		System.out.println("After Each: "+ae);
		++ae;
	}
	
	@Test
	public void test01() {
		System.out.println("test01");
	}
	
	@Test
	public void test02() {
		System.out.println("test02");
	}
	
	@ParameterizedTest
	@ValueSource(ints= {Integer.MIN_VALUE, -5, 0, 5, Integer.MAX_VALUE})
	public void Test(int n) {
		System.out.println(n);
	}
	
	@Test
	public void test03() {
		System.out.println("test03");
	}

}
