package exam01;

import java.util.Arrays;
import java.util.Scanner;

public class SlidingDoor6 {

	public static void main(String[] args) {
		// 초기 2차원 배열
		String arrStart[][] = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "0" } };
		String strStart = "123456780";

//		// 1. 행과 열의 숫자를 입력받는다.
//		Scanner scan = new Scanner(System.in);
//		int num = scan.nextInt();
//		
//		// 2. 2차원 배열의 공간을 만든다.
//		String arrEnd[][]= new String[num][num];
//		
//		// 3. 2차원 배열을 입력받는다.
//		for(int i=0; i<arrEnd.length; i++){
//          for(int j=0; j<arrEnd[i].length; j++){
//        	  arrEnd[i][j] = scan.nextInt();
//          }
//		}

		// 테스트를 위한 목표 배열+행/열 고정하기
		int num = 3;
		String arrEnd[][] = { { "1", "0", "3" }, { "4", "2", "5" }, { "7", "8", "6" } };

		// 2차 배열->1차 배열로 변경
		String arrTarget[] = new String[num * num];

		// arrEnd 값 arrTarget으로 넣어주기 2차원 배열-> 1차원 배열
		for (int i = 0; i < arrEnd.length; i++) { // 0 1 2
			for (int j = 0; j < arrEnd[0].length; j++) { // 0 1 2 3
				arrTarget[i * arrEnd[0].length + j] = arrEnd[i][j];
			}
		}

		// arrTarget에 데이터 정상 입력 - 확인용
		for (String i : arrTarget) {
			System.out.print(i + " ");
		}

		// String arr -> String 으로 변환
		String strT = Arrays.toString(arrTarget);
		System.out.println("\n" + strT);
		String strTT = strT.replace(", ", ""); // ,제거하기
		String strTTT = strTT.replace("[", ""); // 괄호제거하기
		String strTarget = strTTT.replace("]", ""); // 괄호제거하기
		System.out.println(strTarget);

		// arrTarget에서 0의 위치 찾기
		int zeroIndex = strTarget.indexOf("0");
		System.out.println("arrTarget(1차원)에서 0의 인덱스:" + zeroIndex);

		// 0의 위치에서 이동할 수 있는 범위 찾기
		int[] rowX = { 0, 0, -1, 1 }; // 상,하
		int[] colY = { -1, 1, 0, 0 }; // 좌,우

		// 1차원 배열의 인덱스 /num(3) = 행 + 1차원 배열의 인덱스 % num(3) = 열
		// 만약에 인덱스가 1이라면
		int row = zeroIndex / num; // 행은 0
		int col = zeroIndex % num; // 열은 1
		System.out.println("arrTarget(2차원)에서 0의 인덱스: [" + row + "],[" + col + "]");

		for (int i = 0; i < 4; i++) {
			int moveX = row + rowX[i]; // 상=0+(-1)(x) 하=0+1(o)
			int moveY = col + colY[i]; // 좌=1+(-1)(o) 우=1+1(o)

			// moveX와 moveY가 0이상 num 미만일 때만, 상/하/좌/우 이동가능
			if (moveX >= 0 && moveX < num && moveY >= 0 && moveY < num) {
				// 이동가능한 인덱스찾기
				int changeIndex = (3 * moveX) + moveY;
				System.out.println(zeroIndex + "에서 " + changeIndex + "번째로 이동가능");

				// 0의 자리 인덱스와 이동가능한 인덱스 자리 바꾸기
				StringBuilder sb = new StringBuilder(strTarget);
				char ch = sb.charAt(changeIndex);
				sb.setCharAt(changeIndex, '0');
				sb.setCharAt(zeroIndex, ch);

				System.out.println("이동한 후:" + sb);
				System.out.println("--->");

				int zeroIndex1 = sb.indexOf("0");
				System.out.println("sb(1차원)에서 0의 인덱스:" + zeroIndex1);

				int row1 = zeroIndex / num; // 행은 0
				int col1 = zeroIndex % num; // 열은 1
				System.out.println("arrTarget(2차원)에서 0의 인덱스: [" + row + "],[" + col + "]");

				for (int i1 = 0; i1 < 4; i1++) {
					int moveX1 = row + rowX[i1]; // 상=0+(-1)(x) 하=0+1(o)
					int moveY1 = col + colY[i1]; // 좌=1+(-1)(o) 우=1+1(o)

					if (moveX1 >= 0 && moveX1 < num && moveY1 >= 0 && moveY1 < num) {
						// 이동가능한 인덱스찾기
						int changeIndex1 = (3 * moveX) + moveY;
						System.out.println(zeroIndex1 + "에서 " + changeIndex1 + "번째로 이동가능");

						// 0의 자리 인덱스와 이동가능한 인덱스 자리 바꾸기
						StringBuilder sb1 = new StringBuilder(strTarget);
						char ch1 = sb1.charAt(changeIndex1);
						sb.setCharAt(changeIndex1, '0');
						sb.setCharAt(zeroIndex1, ch1);

						System.out.println("이동한 후:" + sb1);

					}
				}
				System.out.println("======================");

//				// sb와 arrStart 비교하기
//				int count = 0; // 서로 다른 데이터 수
//				for (int j = 0; j < strStart.length(); j++) {
//					if (strStart.charAt(j) != sb.charAt(j)) {
//						count++;
//					}
//				}
//
//				System.out.println("서로 다른 데이터 수:" + count);
//				System.out.println("======================");

			} // if문 끝

		} // for문 끝

	}

}
