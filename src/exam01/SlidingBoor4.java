package exam01;

import java.util.Scanner;

public class SlidingBoor4 {

	public static void main(String[] args) {
		
		// 초기 2차원 배열
		int arrMark[][] = {{1,2,3},
						   {4,5,6},
						   {7,8,0}};
			
//		// 1. 행과 열의 숫자를 입력받는다.
//		Scanner scan = new Scanner(System.in);
//		int num = scan.nextInt();
//		
//		// 2. 2차원 배열의 공간을 만든다.
//		int arrTarget[][]= new int[num][num];
//		
//		// 3. 2차원 배열을 입력받는다.
//		for(int i=0; i<arrTarget.length; i++){
//          for(int j=0; j<arrTarget[i].length; j++){
//        	  arrTarget[i][j] = scan.nextInt();
//          }
//		}
		
		// 테스트를 위한 목표 배열+행/열 고정하기
		int num = 3;
		int arrTarget[][] = {{1,0,3},
				 		  	 {4,2,5},
				 		  	 {7,8,6}};	
		
		// 4. 입력받은 2차원 배열에서 0의 위치를 찾는다.
		int row = 0,col=0;
		
		
		for(int i=0; i<arrTarget.length; i++){
            for(int j=0; j<arrTarget[i].length; j++){
                if( arrTarget[i][j] == 0) {
                	row = i;
                	col = j;
                	System.out.println("["+row+"] , ["+col+"]"); //->[0,1]           	      	
                }
            }
        }
		
		// 5. 시작 배열에서 0을 이동시킬 수 있는 위치를 확인한다.
		int chRow = 0;
		int chCol = 0;
		String chNum[] = new String[4]; //이동시킬수 있는 행과 열의 데이터가 담길 1차원 배열
		
		//행이 3, 열이 3, 행이 0을 포함+클때, 열이 0을 포함+클때 이동 가능한지 확인하기 
		//위로 이동할 때
		if(row-1>=0) {
			chRow = row-1;
			chCol = col;
			System.out.println("이동할 수 있는 인덱스 위치: ["+chRow+"],["+chCol+"]");
			chNum[0]="["+chRow+"],["+chCol+"]";
			
		}
		//아래로 이동할 때
		if(row+1<num) {
			chRow = row+1;
			chCol = col;
			System.out.println("이동할 수 있는 인덱스 위치: ["+chRow+"],["+chCol+"]");
			chNum[1]="["+chRow+"],["+chCol+"]";
		}
		//왼쪽으로 이동할 때
		if(col-1>=0) {
			chRow = row;
			chCol = col-1;
			System.out.println("이동할 수 있는 인덱스 위치: ["+chRow+"],["+chCol+"]");
			chNum[2]="["+chRow+"],["+chCol+"]";
		}
		//오른쪽으로 이동할 때
		if(col+1<num) {
			chRow = row;
			chCol = col+1;
			System.out.println("이동할 수 있는 인덱스 위치: ["+chRow+"],["+chCol+"]");
			chNum[3]="["+chRow+"],["+chCol+"]";
		}
		
		//이동할 수 있는 인덱스를 담은 1차 배열
		for (int i = 0; i < chNum.length; i++) {
	           System.out.println(chNum[i]);
	    }
		
	}

}
