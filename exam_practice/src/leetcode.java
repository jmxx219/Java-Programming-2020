/*
A: <���� ���� ���� ã��>
�־��� ���ڿ����� ���� ���ڰ� ���������� �����ϴ� ���� �� �κй��ڿ��� ���̸� ã���ּ���.
ù �ٿ��� �׽�Ʈ���̽��� �� T(1<=T<=100)�� �־�����. �״��� �� �ٸ��� �ϳ��� �׽�Ʈ���̽��� �ش��ϴ� ���ڿ� S�� �־�����. 
S�� ��� �ҹ��ڷ� �����Ǹ�, 1<=length(S)<=500�̴�.
�� �׽�Ʈ���̽����� �־��� ���ڿ����� ���� ���ڰ� ���������� �����ϴ� ���� �� �κй��ڿ��� ���̸� ����ϼ���.

<�� �� �� �� ���� ���� ���� ���ϱ�>
�Ϸ��� ���� ����� ���� ��, �� ��Ͽ��� �� �� �� �� ���̰� ���� ���� ���̸� ���Ͻÿ�.
ù �ٿ��� �׽�Ʈ���̽��� �� T(1<=T<=100)�� �־�����. �״��� �ٺ��� �׽�Ʈ���̽��� �־����µ�, �� �׽�Ʈ���̽��� �� �ٷ� �־�����. 
ù �ٿ��� ������ ���� N(1<=N<=100,000)�� �־�����, �״��� �ٿ��� N���� ���� x(-100,000<=x<=100,000)�� �־�����.
�־��� ���� ��Ͽ��� �� �� �� �� ���̰� ���� ���� ���� ã�� �� ����(a-b, a>=b)�� ����Ͻÿ�

B: <���� ���� ã��>
�ҹ��ڷθ� ������ ���ڿ� ����� ���� ��, ��� ���ڿ��� �������� �����ϴ� ���ڸ� ���ĺ� ������ ����Ͻÿ�. ���� Ư�� ���ڰ� ���� �� �����ϸ� ������ ��ŭ ��µǾ�� �Ѵ�. 
���� ��� 4���� ���ڿ��� a�� ���� 3, 3, 6, 5�� �����Ͽ��ٸ� �信 a�� 3�� ��µǾ�� �Ѵ�.
ù �ٿ��� �׽�Ʈ���̽��� �� T(1<=T<=100)�� �־�����. �� �׽�Ʈ���̽��� �� �ٷ� �־�����. 
ù �ٿ��� ���ڿ��� ���� N(1<=N<=100)�� �־�����, �״��� �ٿ��� N���� ���ڿ�(1<=���ڿ� ����<=100)�� �־�����.
�������� �����ϴ� ���ڸ� ���ĺ� ������ ����Ͻÿ�.

<���� �ּ� �κ� ������ ������������ �����ϱ�>
�Ϸ��� ������ �־�����. �� �������� �κ� ���� �� �װ��� ���� ������ ���Ե��� ���� �͵��� �պ��� ū ������ ã���ÿ�. 
�̶� �ذ� ���� �� ������ ���� ���� ���� ������ ������ �����Ͻÿ�. �� ���̰� ���� ���� ���� �ذ� ���� ��� ���� ���� ū ������ �����Ͻÿ�. 
�̶� ������������ �����Ͻÿ�. ���� ��� [4, 3, 10, 9, 8]�� �־����� [10, 9]�� [10, 8]�� ���� ���� 19�� 18�̸�, �װ��� ������ ������ ���� ���� 15(=3+4+8), 16(=3+4+9)�̴�. 
���� �� �� �����ϴ� �������� [10, 9]�� ���� �� ū �����̹Ƿ� ���� [10, 9]�� �����ؾ� �Ѵ�.
ù �ٿ��� �׽�Ʈ���̽� T(1<=T<=100)�� �־�����. �״��� �ٿ��� ������ �� N(1<=N<=100)�� N���� ����(1<=n<=100)�� �־�����.
�� �׽�Ʈ���̽����� �� �ٿ� ������������ ������ �����Ѵ�. ���� �� ���̿��� ������ �����Ͽ��� �ϰ�, ������ �� �������� ������ ���� �ٹٲ��� ���ԵǾ�� �Ѵ�.
*/
import java.util.Arrays;
import java.util.Set;

public class leetcode {

	// 387. First Unique Character in a String
	public int firstUniqChar(String s) {
		if(s.length()==1) return 0;
		int[] count = new int[26];
		for(int i=0; i<s.length(); i++){
			++count[(int)(s.charAt(i)-'a')];
		}
		for(int i=0; i<s.length(); i++){
			if(count[(int)(s.charAt(i)-'a')] == 1) return i;
		}
		return -1;
	}

	//520. Detect Capital
	public int countUpperCase(String word){
		int count = 0;
		for(int i=0; i<word.length(); i++){
			if(Character.isUpperCase(word.charAt(i))) ++count; // �빮���̸�
		}
		return count;
	}
	public boolean detectCapitalUse(String word) { 
		int count = countUpperCase(word);
		if(count ==0||count==word.length()) return true; // ���� ��� �빮�� �Ǵ� �ҹ���
		else if(count==1&&Character.isUpperCase(word.charAt(0))) return true; //�Ǿ� ���ڸ� �빮���� ���
		else return false;
	}
	
	
	// 1089. Duplicate Zeros
	// 1,0,2,3,0,4,5,0 -> 1,0,0,2,3,0,0,4
	public void duplicateZeros(int[] arr) {
		int count = 0;
		for(var n: arr) if(n==0) ++count;
		if(count ==0||count==arr.length) return; //0�� ���ų� ��� 0�� ���
		int j = arr.length+count-1;
		for(int i=arr.length-1; i>=0; i--){
			if(j<arr.length) arr[j] = arr[i];
			if(arr[i] ==0){
				--j;
				if(j<arr.length) arr[j] = 0;
			}
			--j;
		}
	}
	
	
	// 263. Ugly Number
	public boolean isUgly(int num) {
		if(num==0) return false;
		while(num%2==0) num/=2;
		while(num%3==0) num/=3;
		while(num%5==0) num/=5;
		
		return num==1;
    }
	
	// 414. Third Maximum Number
	public int thirdMax(int[] nums) {
		Arrays.sort(nums);
        int answer = nums[nums.length - 1], count = 1;
        
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] != nums[i - 1]) count++;
            if (count == 3) {
                answer = nums[i - 1];
                break;
            }
        }
        return answer;
	}
	
	// 455. Assign Cookies
	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
        Arrays.sort(s);
        
        int cookieIdx = s.length - 1;
        int contentCount = 0;
        for(int childIdx = g.length - 1 ; childIdx >= 0 && cookieIdx >= 0; childIdx--) {
            if (s[cookieIdx] >= g[childIdx]) {
                contentCount++;
                cookieIdx--;
            }
        }
        return contentCount;
    }
	
	// 507. Perfect Number
	public boolean checkPerfectNumber(int num) {
		int sum = 1;
		for(int i=2; i<=Math.sqrt(num) ;i++) {
			if(num%i==0) {
				sum+=i+num/i;
			}
		}
		return sum==num&&num>1;
    }

}
