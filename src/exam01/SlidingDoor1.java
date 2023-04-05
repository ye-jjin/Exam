package exam01;

import java.util.Arrays;

public class SlidingDoor1 {

	public static void main(String[] args) {
		
		//초기 2차원 배열
		int arrStart[][] = {{1,2,3},
							{4,5,6},
							{7,8,0}};
		
		
		//-> 테스트 위해서 여기까지 주석으로 막고 임의의 입력받은 배열 고정하기
		int arrEnd[][] = {{1,0,3},
						 {4,2,5},
						 {7,8,6}};
		
		
		// 6.입력받은 배열에 0 숫자가 들어있는 위치 확인하기 -> 행과 열 확인가능
		int row = 0,col=0;
		int findNum = 0;
		
		for(int i=0; i<arrEnd.length; i++){
            for(int j=0; j<arrEnd[i].length; j++){
                if( arrEnd[i][j] == 0) {
                	row = i;
                	col = j;
//                	System.out.println("["+row+"] , ["+col+"]"); //->[0,1]
                	
                	// 7. 최종 배열 0의 자리에 해당하는 초기 배열의 값 찾기 
                	findNum=arrStart[row][col];
//                	System.out.println(findNum); //-> 2
                	      	
                }
            }
        }
		
		System.out.println("입력받은 최종 배열의 0의 숫자가 들어있는 위치:["+row+"] , ["+col+"]"); 
		System.out.println("초기 배열의 [row][col] 자리에 해당하는 초기 값:"+findNum); 
		
		// 8. 최종 배열에서 찾은 값(findNum)이 위치하고 있는 행과 열 확인하기 arrEnd[chRow][chCol]
		int chRow = 0,chCol = 0;
		
		for(int i=0; i<arrEnd.length; i++){
            for(int j=0; j<arrEnd[i].length; j++){
                if( arrEnd[i][j] == findNum) {
                	chRow = i;
                	chCol = j;               	      	
                }
            }
        }
       	System.out.println("최종 배열에서 찾은 값이 위치하고 있는 위치:["+chRow+"] , ["+chCol+"]"); //->[1,1]
       	
       	// 9. 최종배열에서 [row,col]자리의 값과 [chRow,chCol]자리의 값을 바꾸기   
       	int temp = arrEnd[row][col];
       	arrEnd[row][col] = arrEnd[chRow][chCol];
       	arrEnd[chRow][chCol] = temp;
       	System.out.println("변경값 확인:"+arrEnd[row][col]); 
		

		// 10. 한번 이동한 후 변경된 arrEnd 2차원 배열 확인해보기
       	System.out.println("=== 한번 이동한 후 배열 출력 ===");
       	for (int i = 0; i < arrEnd.length; i++) {
               int inArr[] = arrEnd[i];
               for (int j = 0; j < inArr.length; j++) {
                   System.out.print(inArr[j] + " ");
               }
            System.out.println(); //->배열의 공간 할당
        }
       	
       	// 다시 반복
       	// 11. 한번 이동한 배열에서의 0의 행/열 찾기
       	//System.out.println("숫자 0 위치의 행과 열: ["+chRow+"], ["+chCol+"]"); //[1][1]
       	
       	for(int i=0; i<arrEnd.length; i++){
            for(int j=0; j<arrEnd[i].length; j++){
                if( arrEnd[i][j] == 0) {
                	row = i;
                	col = j;
                	//System.out.println("["+row+"] , ["+col+"]"); //->[1,1]
                	
                	// 12. 초기 배열에서의 위의 행/열에서의 값 찾기 
                	findNum=arrStart[row][col];
                	//System.out.println(findNum); //-> 5
                	      	
                }
            }
        }
       	
       	System.out.println("타깃 배열의 0의 숫자가 들어있는 위치:["+row+"] , ["+col+"]"); 
		System.out.println("초기 배열의 [row][col] 자리에 해당하는 초기 값:"+findNum); 
       	
       	// 13. 한번 이동한 배열에서의 찾은 타깃(findNum)값이 위치하고 있는 행/열 찾기
       	for(int i=0; i<arrEnd.length; i++){
            for(int j=0; j<arrEnd[i].length; j++){
                if( arrEnd[i][j] == findNum) {
                	chRow = i;
                	chCol = j;               	      	
                }
            }
        }
       	System.out.println("한번 이동한 배열에서 찾은 값이 위치하고 있는 위치:["+chRow+"] , ["+chCol+"]"); //->[1,2]
       	
       	
       	// 14. 타깃배열에서 [row,col]자리의 값과 [chRow,chCol]자리의 값을 바꾸기
    	temp = arrEnd[row][col];
       	arrEnd[row][col] = arrEnd[chRow][chCol];
       	arrEnd[chRow][chCol] = temp;
       	System.out.println("변경값 확인:"+arrEnd[row][col]);
       	
       	
       	// 15. 두번 이동한 후 2차원 배열 확인해보기
       	System.out.println("=== 두번 이동한 후 배열 출력 ===");
       	for (int i = 0; i < arrEnd.length; i++) {
               int inArr[] = arrEnd[i];
               for (int j = 0; j < inArr.length; j++) {
                   System.out.print(inArr[j] + " ");
               }
            System.out.println(); //->배열의 공간 할당
        }
       	
       	// 다시 반복
       	// 16. 두번 이동한 배열에서의 0의 행/열 찾기
       	for(int i=0; i<arrEnd.length; i++){
            for(int j=0; j<arrEnd[i].length; j++){
                if( arrEnd[i][j] == 0) {
                	row = i;
                	col = j;
                	//System.out.println("["+row+"] , ["+col+"]"); //->[1,2]
                	
                	// 17. 초기 배열에서의 위의 행/열에서의 값 찾기 
                	findNum=arrStart[row][col];
                	//System.out.println(findNum); //-> 6
                	      	
                }
            }
        }
       	
       	System.out.println("타깃 배열의 0의 숫자가 들어있는 위치:["+row+"] , ["+col+"]"); 
		System.out.println("초기 배열의 [row][col] 자리에 해당하는 초기 값:"+findNum); 
       
       	// 18. 두번 이동한 배열에서의 찾은 타깃(findNum)값이 위치하고 있는 행/열 찾기
		for(int i=0; i<arrEnd.length; i++){
            for(int j=0; j<arrEnd[i].length; j++){
                if( arrEnd[i][j] == findNum) {
                	chRow = i;
                	chCol = j;               	      	
                }
            }
        }
       	System.out.println("한번 이동한 배열에서 찾은 값이 위치하고 있는 위치:["+chRow+"] , ["+chCol+"]"); //->[2,2]
		
       	// 19. 타깃배열에서 [row,col]자리의 값과 [chRow,chCol]자리의 값을 바꾸기
       	
       	temp = arrEnd[row][col];
       	arrEnd[row][col] = arrEnd[chRow][chCol];
       	arrEnd[chRow][chCol] = temp;
       	System.out.println("변경값 확인:"+arrEnd[row][col]);
       	
       	// 20. 세번 이동한 후 2차원 배열 확인해보기
       	
    	System.out.println("=== 세번 이동한 후 배열 출력 ===");
       	for (int i = 0; i < arrEnd.length; i++) {
               int inArr[] = arrEnd[i];
               for (int j = 0; j < inArr.length; j++) {
                   System.out.print(inArr[j] + " ");
               }
            System.out.println(); //->배열의 공간 할당
        }
       	
       	
       	// 처음 배열과 최소 이동한 배열을 비교하기
       	if(Arrays.deepEquals(arrStart,arrEnd)) {
       		System.out.println("동일한 배열의 값을 가지고 있습니다.");
       	}else {
       		System.out.println("다른 배열의 값을 가지고 있습니다.");
       	}
       	
	}//main

}//Exam3

