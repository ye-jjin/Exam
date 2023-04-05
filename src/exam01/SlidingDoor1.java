package exam01;

import java.util.Arrays;
import java.util.Scanner;

public class SlidingDoor1 {
	static int row;
	static int col;
	static int findNum;
	static int chRow;
	static int chCol;
	static int temp;
	static int count;
	
	//초기 2차원 배열
	private static int arrStart[][] = {{1,2,3},
									   {4,5,6},
									   {7,8,0}};	
	
	private static int arrEnd[][];

	// arrEnd에서 0의 위치를 확인하기
	public static int moveNum(int arrEnd[][],int arrStart[][],int row,int col, int findNum,int chRow, int chCol) {
		
		count++;
		
		for(int i=0; i<arrEnd.length; i++){
            for(int j=0; j<arrEnd[i].length; j++){
                if( arrEnd[i][j] == 0) {
                	row = i;
                	col = j;
                	System.out.println("arrEnd에서 0의 위치: ["+row+"] , ["+col+"]");
                	
                	// arrStart의 [row][col] 번째에 위치한 findNum 찾기
                	findNum=arrStart[row][col];
                	System.out.println("arrStart의 ["+row+"]["+col+"] 번째에 위치한 수:"+findNum);      	
                }
            }
        }
		
		//arrEnd에서 findNum이 위치하고 있는 행과 열 확인하기
		for(int i=0; i<arrEnd.length; i++){
			for(int j=0; j<arrEnd[i].length; j++){
				if( arrEnd[i][j] == findNum) {
					chRow = i;
					chCol = j;               	      	
				}
			}
		}
		System.out.println("arrEnd에서 findNum이 위치하고 있는 위치:["+chRow+"] , ["+chCol+"]");
		
		// arrEnd[row][col] 값과 arrEnd[chRow][chCol] 값 바꾸기
		temp = arrEnd[row][col];
	   	arrEnd[row][col] = arrEnd[chRow][chCol];
	   	arrEnd[chRow][chCol] = temp;
	   	System.out.println("변경값 확인:"+arrEnd[row][col]);
	   	
	   	
	   	//이동 후 배열 출력하기-확인용
	   	
	   	for (int i = 0; i < arrEnd.length; i++) {
	           int inArr[] = arrEnd[i];
	           for (int j = 0; j < inArr.length; j++) {
	               System.out.print(inArr[j] + " ");
	           }
	        System.out.println(); //->배열의 공간 할당
	    }	   	
	   	
	   	
		return count; 
	}	
	

	public static void main(String[] args) {
		
		// 1.스캐너생성
		Scanner scan = new Scanner(System.in);
		
		// 2.만들 배열의 행/열 수 입력 받기
		int num = scan.nextInt(); //->3
		
		// 3.입력 받은 행/열 수로 2차원 배열 공간 만들기
		int arrEnd[][]= new int[num][num]; //[3][3] 배열 생성
		
		
		// 4.입력받은 예제 값을 배열에 넣기
		for(int i=0; i<arrEnd.length; i++){
            for(int j=0; j<arrEnd[i].length; j++){
                arrEnd[i][j] = scan.nextInt();
            }
        }		
				
		// 5. 위의 함수 반복해서 실행하기
		boolean result=true;
		while(result) {			
			moveNum(arrEnd, arrStart, row, col, findNum,chRow,chCol);
			
			if(Arrays.deepEquals(arrStart, arrEnd)) {
				result=false; //break문
			}			
			System.out.println("최종이동횟수:"+count);
			System.out.println("====================================");
		}

	}//main

}//SlidingDoor1

