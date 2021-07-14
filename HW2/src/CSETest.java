
class CSE{
	private String title;
	public void setTitle(String _title) {
		title = _title;
	}
	public String getTitle() {
		return title;
	}
}
public class CSETest {
	public static void main(String[] args) {
		CSE cse = new CSE();
		cse.setTitle("¼ÕÁö¹Î");
		System.out.println(cse.getTitle());
	}
}
