package exam01;

import java.util.Scanner;

public class Test4 {

	
	public static int pebo(int num) {
		if(num==0) return 0; //첫번째는 0
		if(num==1) return 1; //두번째는 1 -->  num이 어떤 값이든, 두개의 값은 고정
			return pebo(num-1)+pebo(num-2); //세번째의 합은 파보나치 1,2번째의 합 pebo(num) = pebo(num-2)+pebo(num-1)
	}
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		System.out.println(pebo(num));
	}

}
