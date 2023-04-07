package exam01;

public class SlidingDoor5 {

	public static void main(String[] args) {
		
		// 초기 2차원 배열
		int arrStart[][] = {{1,2,3},
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
		int arrEnd[][] = {{1,0,3},
				 		  {4,2,5},
				 		  {7,8,6}};
		
		
		// 4. 입력받은 2차원 배열에서 0의 위치를 찾는다.
		int row = 0,col=0;
		
		
		for(int i=0; i<arrEnd.length; i++){
            for(int j=0; j<arrEnd[i].length; j++){
                if( arrEnd[i][j] == 0) {
                	row = i;
                	col = j;
                	System.out.println("["+row+"] , ["+col+"]"); //->[0,1]           	      	
                }
            }
        }
		
		// 5. 시작 배열에서 0을 이동시킬 수 있는 위치를 확인한다.
		int chRow = 0;
		int chCol = 0;
		int temp; //임의의 자리
		
		//행이 3, 열이 3, 행이 0을 포함+클때, 열이 0을 포함+클때 이동 가능한지 확인하기
		
		//위로 이동할 때
		int arrEnd1[][] = {{1,0,3},
		 		  			{4,2,5},
		 		  			{7,8,6}};
		int count1 = 1;
		
		if(row-1>=0) {
			chRow = row-1;
			chCol = col;
			System.out.println("이동할 수 있는 인덱스 위치: ["+chRow+"],["+chCol+"]");
			
			//이동시키기
			temp = arrEnd1[row][col];
			arrEnd1[row][col] = arrEnd1[chRow][chCol];
			arrEnd1[chRow][chCol] = temp;
			
			//이동시킨 배열 출력하기
			System.out.println("=== 위로 한번 이동한 후 배열 출력 ===");
	       	for (int i = 0; i < arrEnd1.length; i++) {
	               int upArr[] = arrEnd1[i];
	               for (int j = 0; j < upArr.length; j++) {
	                   System.out.print(upArr[j] + " ");
	               }
	            System.out.println(); //->배열의 공간 할당
	        }
			
	       	//기존의 타깃배열(arrEnd)-한번옮긴배열(arrEnd1) 비교하기
	       	for(int i=0;i<num;i++) {
	       		for(int j=0; j<num; j++) {
	       			if(arrEnd[i][j]!=arrEnd1[i][j]) {
	       				count1++;
	       			}else {
	       				break;
	       			}
	       		}
	       	}
	       	System.out.println(count1);
		}
		
		//아래로 이동할 때
		int arrEnd2[][] = {{1,0,3},
		 		 		  {4,2,5},
		 		          {7,8,6}};
		int count2 = 1;
		
		if(row+1<num) {
			chRow = row+1;
			chCol = col;
			System.out.println("이동할 수 있는 인덱스 위치: ["+chRow+"],["+chCol+"]");
			
			//이동시키기
			temp = arrEnd2[row][col];
			arrEnd2[row][col] = arrEnd2[chRow][chCol];
			arrEnd2[chRow][chCol] = temp;
			
			//이동시킨 배열 출력하기
			System.out.println("=== 아래로 한번 이동한 후 배열 출력 ===");
	       	for (int i = 0; i < arrEnd2.length; i++) {
	               int downArr[] = arrEnd2[i];
	               for (int j = 0; j < downArr.length; j++) {
	                   System.out.print(downArr[j] + " ");
	               }
	            System.out.println(); //->배열의 공간 할당
	        }
	       System.out.println(arrEnd[0][0]+","+arrEnd2[0][0]);	
	       	
	      //기존의 타깃배열(arrEnd)-한번옮긴배열(arrEnd2) 비교하기
	       	for(int i=0;i<num;i++) {
	       		for(int j=0; j<num; j++) {
	       			if(arrEnd[i][j]!=arrEnd2[i][j]) {
	       				count2++;
	       			}else {
	       				break;
	       			}
	       		}
	       	}
	       	System.out.println(count2);
		}
		
		//왼쪽으로 이동할 때
		int arrEnd3[][] = {{1,0,3},
		 		  		   {4,2,5},
		 		  		   {7,8,6}};
		int count3 = 1;
		
		if(col-1>=0) {
			chRow = row;
			chCol = col-1;
			System.out.println("이동할 수 있는 인덱스 위치: ["+chRow+"],["+chCol+"]");
			
			//이동시키기
			temp = arrEnd3[row][col];
			arrEnd3[row][col] = arrEnd3[chRow][chCol];
			arrEnd3[chRow][chCol] = temp;
			
			//이동시킨 배열 출력하기
			System.out.println("=== 왼쪽으로 한번 이동한 후 배열 출력 ===");
	       	for (int i = 0; i < arrEnd3.length; i++) {
	               int leftArr[] = arrEnd3[i];
	               for (int j = 0; j < leftArr.length; j++) {
	                   System.out.print(leftArr[j] + " ");
	               }
	        System.out.println(); //->배열의 공간 할당
	        }
	       	
	      //기존의 타깃배열(arrEnd)-한번옮긴배열(arrEnd3) 비교하기
	       	for(int i=0;i<num; i++) {
	       		for(int j=0; j<num; j++) {
	       			if(arrEnd[i][j]!=arrEnd3[i][j]) {
	       				count3++;
	       			}else {
	       				break;
	       			}
	       		}
	       	}
	       	System.out.println(count3);
		}
		
		//오른쪽으로 이동할 때
		int arrEnd4[][] = {{1,0,3},
		 		  		   {4,2,5},
		 		  		   {7,8,6}};
		int count4 =1;
		
		if(col+1<num) {
			chRow = row;
			chCol = col+1;
			System.out.println("이동할 수 있는 인덱스 위치: ["+chRow+"],["+chCol+"]");
			
			//이동시키기
			temp = arrEnd4[row][col];
			arrEnd4[row][col] = arrEnd4[chRow][chCol];
			arrEnd4[chRow][chCol] = temp;
			
			//이동시킨 배열 출력하기
			System.out.println("=== 오른쪽으로 한번 이동한 후 배열 출력 ===");
	       	for (int i = 0; i < arrEnd4.length; i++) {
	               int rightArr[] = arrEnd4[i];
	               for (int j = 0; j < rightArr.length; j++) {
	                   System.out.print(rightArr[j] + " ");
	               }
	            System.out.println(); //->배열의 공간 할당
	        }
		}
		
		//기존의 타깃배열(arrEnd)-한번옮긴배열(arrEnd4) 비교하기
	
       	for(int i=0;i<num;i++) {
       		for(int j=0; j<num; j++) {
       			if(arrEnd[i][j]!=arrEnd4[i][j]) {
       				count4++;
       			}else {
       				break;
       			}
       		}
       	}
       	System.out.println(count4);
		
		
	}

}
