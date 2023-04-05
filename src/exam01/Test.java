package exam01;

public class Test {
	
	//1부터 n까지의 합을 계산하는 반복 함수
	public static int sum(int n) {
		int ret=0;
		for(int i=1; i<=n; i++) {
			ret +=i;
		}	
		return ret;		
	}
	
	//1부터 n까지의 합을 계산하는 재귀 함수
	public static int recursiveSum(int n) {
		//재귀함수 탈출문
		if(n==1) {			
			return 1;
		}
		return recursiveSum(n-1)+n;
		// n=5 4+5;
		// 	  n=4 3+4;
		//		 n=3 2+3;
		//			n=2 1+2;
		//			n=1 return;
		//1+2+3+4+5;
	}
	
	
	public static void main(String[] args) {
		System.out.println(sum(5)); //15
		System.out.println(recursiveSum(5)); //15
	}

}
