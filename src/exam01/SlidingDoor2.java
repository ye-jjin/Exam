package exam01;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SlidingDoor2 {
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

	
	public static int moveNum(int arrEnd[][],int arrStart[][],int row,int col, int findNum,int chRow, int chCol) {
		
		count++;
		
		// arrEnd에서 0의 위치를 확인하기
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
		int num;
		
		// 1.스캐너생성
		Scanner scan = new Scanner(System.in);
		
		// 2.만들 배열의 행/열 수 입력 받기
		num = scan.nextInt(); //->3
		
		// 3.입력 받은 행/열 수로 2차원 배열 공간 만들기
		int arrEnd[][]= new int[num][num]; //[3][3] 배열 생성
		
		
		// 4.입력받은 예제 값을 배열에 넣기
		for(int i=0; i<arrEnd.length; i++){
            for(int j=0; j<arrEnd[i].length; j++){
                arrEnd[i][j] = scan.nextInt();
            }
        }
		
		//======================================================
		
		
		// 조건 1. 2차원 배열 1차원 배열로 변경
		// 1. 1차원 배열 공간 만들기
		int intArr[] = new int[num*num];
		
		// 2. arrEnd 값 arr1으로 넣어주기
		for(int i = 0; i < arrEnd.length; i ++) {	//0 1 2
			for(int j= 0; j< arrEnd[0].length; j ++) { // 0 1 2 3
				intArr[ i * arrEnd[0].length + j] = arrEnd[i][j];
			}
		}
		
		// 3. arr1에 데이터 정상 입력 - 확인용
//		for (int i : intArr) {
//			System.out.print(i + " ");
//		}
		
//		// 조건 2. int 배열 -> String 배열로 변경		
//		// 1. int 배열의 길이만큼의 String 배열 공간 만들기
//        String strArr[] = new String[intArr.length];
//        
//        // 2. int 배열의 i번째 값을 String 배열의 i번째 값으로 넣기
//        for (int i = 0; i < intArr.length; i++) {
//            strArr[i] = String.valueOf(intArr[i]);
//        }
//        
//        // 3. String 배열에 데이터 정상 입력 - 확인용
//        //System.out.println("String 배열:"+Arrays.toString(strArr));
//        
//        // 조건 3. String 배열 ->String 리스트로 변경
//        List<String> listArr = new ArrayList<>(Arrays.asList(strArr));
//        
//        // 조건 4. String 리스트에서 0의 값을 제거
//        listArr.remove(listArr.indexOf("0"));
//        System.out.println("listArr: "+listArr);
//        
//        // 조건 5. String list -> String 배열로 변경
//        String strArr2[] = new String[listArr.size()];
//        strArr2 = listArr.toArray(strArr2);
//        
//        // String 배열에 데이터 - 확인용
//        for (String i : strArr2) {
//			System.out.print(i + " ");
//		}
//        
//        // 조건 6. String 배열 -> int 배열로 변경
//        int intArr2[] = new int[strArr2.length];
//        
//        for (int i = 0; i < strArr2.length; i++) {
//        	intArr2[i] = Integer.parseInt(strArr2[i]);
//        }
//        
//        // int 배열 데이터 - 확인용
//        for (int i : intArr2) {
//			System.out.print(i + " ");
//		}
        
        //====================================================
        
        // 1. 역전 카운트 수 구하기
        int countInversion=0;
        
        for(int i=0; i<intArr.length; i++) {
        	for(int j=i+1; j<intArr.length; j++) {
        		if(intArr[i] != 0 && intArr[j] !=0 && intArr[i]>intArr[j]) {
        			countInversion += 1;
        		}
        	}
        }
        System.out.println("역전 카운트 수:"+countInversion);
        
       //=====================================================
        
        boolean result=true;
        
        // 1. 이동 가능성 확인하기
        // 행/열이 홀수일 때
        if(num%2==1) {
        	//역전 카운트 수가 짝수이면
        	if(countInversion % 2 == 0) {
        		//알고리즘 정상 실행
        		while(result) {			
        			moveNum(arrEnd, arrStart, row, col, findNum,chRow,chCol);
        			
        			if(Arrays.deepEquals(arrStart, arrEnd)) {
        				result=false; //break문
        			}			
        			System.out.println("최종이동횟수:"+count);
        			System.out.println("====================================");
        		}
        	}//역전 카운트 수가 홀수이면
        	else if(countInversion % 2 == 1) {
        		//안내문구 출력
        		System.out.println("잘못된 문제를 입력하셨습니다.");
        	}        	
        }
        //행/열이 짝수일 때
        else if(num%2==0) {
        	//0이 위치한 행이 짝수
        		//역전 카운트가 홀수이면
        			//알고리즘 정상 실행
        	
        		//역전 카운트가 짝수이면
        			//안내문구 출력
        	
        	//0이 위치한 행이 홀수
        		//역전 카운트가 홀수이면
        			//안내문구 출력
        	
        		//역전 카운트가 짝수이면
        			//알고리즘 정상 실행
        }
        
        
        
       //======================================================
           
		
		
		
		
	}//main

}//SlidingDoor2

