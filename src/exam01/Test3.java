package exam01;

import java.util.Scanner;

public class Test3 {

	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		long num = scan.nextLong();
		
		System.out.println(fac(num));
	}

	public static long fac(long num) {
		if(num==0) {
			return 1; //입력된 값(num)이 0일때, 1리턴
		}else if(num==1){
			return num; //입력된 값(num)이 1일때, num 값 리턴
		}else {
			return fac(num-1)*num;//입력된 값이 0,1제외한 나머지 일 때, 재귀함수반복
		}
	}
}
