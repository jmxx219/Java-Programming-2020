/*
A: <연속 동일 문자 찾기>
주어진 문자열에서 같은 문자가 연속적으로 등장하는 가장 긴 부분문자열의 길이를 찾아주세요.
첫 줄에는 테스트케이스의 수 T(1<=T<=100)가 주어진다. 그다음 각 줄마다 하나의 테스트케이스에 해당하는 문자열 S가 주어진다. 
S는 모두 소문자로 구성되며, 1<=length(S)<=500이다.
각 테스트케이스마다 주어진 문자열에서 같은 문자가 연속적으로 등장하는 가장 긴 부분문자열의 길이를 출력하세요.

<두 개 값 간 가장 작은 차이 구하기>
일련의 정수 목록이 있을 때, 이 목록에서 두 개 값 간 차이가 가장 작은 차이를 구하시오.
첫 줄에는 테스트케이스의 수 T(1<=T<=100)가 주어진다. 그다음 줄부터 테스트케이스가 주어지는데, 각 테스트케이스는 두 줄로 주어진다. 
첫 줄에는 정수의 개수 N(1<=N<=100,000)이 주어지고, 그다음 줄에는 N개의 정수 x(-100,000<=x<=100,000)가 주어진다.
주어진 정수 목록에서 두 개 값 간 차이가 가장 작은 것을 찾고 그 차이(a-b, a>=b)를 출력하시오

B: <공통 문자 찾기>
소문자로만 구성된 문자열 목록이 있을 때, 모든 문자열에 공통으로 등장하는 문자를 알파벳 순으로 출력하시오. 만약 특정 문자가 여러 번 등장하면 등장한 만큼 출력되어야 한다. 
예를 들어 4개의 문자열에 a가 각각 3, 3, 6, 5번 등장하였다면 답에 a가 3번 출력되어야 한다.
첫 줄에는 테스트케이스의 수 T(1<=T<=100)가 주어진다. 각 테스트케이스는 두 줄로 주어진다. 
첫 줄에는 문자열의 개수 N(1<=N<=100)이 주어지고, 그다음 줄에는 N개의 문자열(1<=문자열 길이<=100)이 주어진다.
공통으로 등장하는 문자를 알파벳 순으로 출력하시오.

<가장 최소 부분 수열을 내림차순으로 제시하기>
일련의 정수가 주어진다. 이 정수에서 부분 수열 중 그것의 합이 수열에 포함되지 않은 것들의 합보다 큰 수열을 찾으시오. 
이때 해가 여러 개 있으면 가장 작은 수로 구성된 수열을 제시하시오. 또 길이가 같은 여러 개의 해가 있을 경우 가장 합이 큰 수열을 제시하시오. 
이때 내림차순으로 제시하시오. 예를 들어 [4, 3, 10, 9, 8]이 주어지면 [10, 9]와 [10, 8]의 각각 합은 19와 18이며, 그것을 제외한 수들의 합은 각각 15(=3+4+8), 16(=3+4+9)이다. 
따라서 둘 다 만족하는 해이지만 [10, 9]가 합이 더 큰 수열이므로 답은 [10, 9]를 제시해야 한다.
첫 줄에는 테스트케이스 T(1<=T<=100)이 주어진다. 그다음 줄에는 수열의 수 N(1<=N<=100)과 N개의 정수(1<=n<=100)가 주어진다.
각 테스트케이스마다 한 줄에 내림차순으로 수열을 제시한다. 수와 수 사이에는 공백을 포함하여야 하고, 마지막 수 다음에는 공백이 없이 줄바꿈이 포함되어야 한다.
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
			if(Character.isUpperCase(word.charAt(i))) ++count; // 대문자이면
		}
		return count;
	}
	public boolean detectCapitalUse(String word) { 
		int count = countUpperCase(word);
		if(count ==0||count==word.length()) return true; // 영문 모두 대문자 또는 소문자
		else if(count==1&&Character.isUpperCase(word.charAt(0))) return true; //맨앞 문자만 대문자인 경우
		else return false;
	}
	
	
	// 1089. Duplicate Zeros
	// 1,0,2,3,0,4,5,0 -> 1,0,0,2,3,0,0,4
	public void duplicateZeros(int[] arr) {
		int count = 0;
		for(var n: arr) if(n==0) ++count;
		if(count ==0||count==arr.length) return; //0이 없거나 모두 0일 경우
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
