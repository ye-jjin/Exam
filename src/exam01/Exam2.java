package exam01;

import java.util.Scanner;

public class Exam2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int disk =scan.nextInt(); //원판의 갯수
		moveDisk(disk,1,2,3); // 원판의 갯수, 기둥 위치(start/to/end) = (1/2/3)


	}
	
	public static void moveDisk(int disk,int start,int to,int end) {
		if(disk==1) {
			System.out.println(start+"번에서-"+end+"번으로 이동");
			return;
		}
		else if(disk==2) {
			System.out.println(start+"번에서 "+to+"번으로 이동"); //큰원판 제외 나머지 원판 to로 이동
			System.out.println(start+"번에서 "+end+"번으로 이동"); //큰 원판 마지막 기둥으로 이동
			System.out.println(to+"번에서 "+end+"번으로 이동"); // 나머지 원판 마지막 기둥으로 이동
		}
		else if(disk==3) {
			//비재귀로 어떻게 만들지
			
		}
	}//moveRisk
	
	
	
	

}//Exam2
