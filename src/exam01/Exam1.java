package exam01;

import java.util.Scanner;

public class Exam1 {

//	private static int count=0;

	// 하노이의 탑
	// 조건1. 한 번에 한개의 원판
	// 조건2. 가장 위에 있는 원판만 이동
	// 조건3. 큰 원판이 작은 원판 위에 있으면 안됨.

	public static void moveDisk(int disk,int start,int to, int end) {		
//		count++;
		
		//원판의 개수가 1개일때, disk를 start->end
		//재귀함수 연산끝내는 코드
		if(disk == 1) {
			System.out.println(start+"번에서 "+end+"번으로 이동");
			return;
		}
			//원판의 개수가 2개이상일때, (disk-1)를 start->to
			//제일 큰 원판을 end 기둥으로 옮기기 시작 -> 그외 다른 원판은 to 기둥으로 옮기기
			moveDisk(disk-1, start, end, to);
			
			//제일 큰 원판 1개를 옮기기
			//disk를 start->end
			moveDisk(1,start,to,end);
					
			//나머지 원판을 end기둥으로 옮기기
			moveDisk(disk-1,to,start,end);			
			
	}
		
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int disk = scan.nextInt(); //원판 개수 - 3개
		int total = (int)Math.pow(2, disk)-1; // 총 이동 횟수 - 7번
		
		System.out.println("원판의 수:"+disk);
		System.out.println("=============");
		System.out.println("총 이동횟수:"+total+"번");
//		System.out.println("총 이동횟수:"+count+"번");
		System.out.println("=============");
		moveDisk(disk,1,2,3); //원판의 수, 기둥 1,2,3

	}	
	
}
