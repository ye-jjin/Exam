package exam01;

public class SlidingDoor6 {

	public static void main(String[] args) {
		// 초기 2차원 배열
		int arrMark[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0 } };

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
		int row;
		int col;
		int arrTarget[][] = { { 1, 0, 3 }, { 4, 2, 5 }, { 7, 8, 6 } };

		// 2차 배열->1차 배열로 변경
		int intArr[] = new int[num * num];

		// arrTarget 값 intArr으로 넣어주기
		for (int i = 0; i < arrTarget.length; i++) { // 0 1 2
			for (int j = 0; j < arrTarget[0].length; j++) { // 0 1 2 3
				intArr[i * arrTarget[0].length + j] = arrTarget[i][j];
			}
		}

		// intArr에 데이터 정상 입력 - 확인용
		for (int i : intArr) {
			System.out.print(i + " ");
		}

		// 상 / 하 / 왼 / 오 이동하는 식

	}

}
