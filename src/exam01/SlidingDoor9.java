package exam01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SlidingDoor9 {

	public static void main(String[] args) {
		// 초기 2차원 배열
		String arrStart[][] = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "0" } };
		String strStart = "123456780";

		// 1. 행과 열의 숫자를 입력받는다.
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		// 2. 2차원 배열의 공간을 만든다.
		String arrEnd[][]= new String[num][num];
		
		// 3. 2차원 배열을 입력받는다.
		for(int i=0; i<arrEnd.length; i++){
          for(int j=0; j<arrEnd[i].length; j++){
        	  arrEnd[i][j] = scan.next();
          }
		}

		// 테스트를 위한 목표 배열+행/열 고정하기
//		int num = 3;
//		String arrEnd[][] = { { "1", "0", "3" }, { "4", "4", "5" }, { "7", "8", "6" } };

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

		Queue<String> queue = new LinkedList<>(); // BFS
		HashMap<String, String> map = new HashMap<>(); // 중복체크
		map.put(strTarget, strTarget);
		System.out.println("map:" + map);

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
				char temp = sb.charAt(changeIndex);
				sb.setCharAt(changeIndex, '0');
				sb.setCharAt(zeroIndex, temp);

				System.out.println("이동한 후(sb):" + sb);
				System.out.println("-------->");

				// map에 있는 초기 배열이랑 한번 이동한 후 sb의 값이 같지 않다면 큐에 저장
				if (!map.containsKey(sb.toString())) {
					queue.offer(sb.toString()); //
					map.put(sb.toString(), sb.toString());

					System.out.println("1번 이동 queue:" + queue);
					System.out.println("1번 이동 map:" + map);

					String str = queue.poll();

					int zeroIndex1 = str.indexOf("0");
					System.out.println("str(1차원)에서 0의 인덱스:" + zeroIndex1);

					int row1 = zeroIndex1 / num; // 행
					int col1 = zeroIndex1 % num; // 열

					for (int i1 = 0; i1 < 4; i1++) {
						int moveX1 = row1 + rowX[i1]; // 상=0+(-1)(x) 하=0+1(o)
						int moveY1 = col1 + colY[i1]; // 좌=1+(-1)(o) 우=1+1(o)

						// moveX와 moveY가 0이상 num 미만일 때만, 상/하/좌/우 이동가능
						if (moveX1 >= 0 && moveX1 < num && moveY1 >= 0 && moveY1 < num) {
							// 이동가능한 인덱스찾기
							int changeIndex1 = (3 * moveX1) + moveY1;
							System.out.println(zeroIndex1 + "에서 " + changeIndex1 + "번째로 이동가능");

							// 0의 자리 인덱스와 이동가능한 인덱스 자리 바꾸기
							StringBuilder sb1 = new StringBuilder(str);
							char temp1 = sb1.charAt(changeIndex1);
							sb1.setCharAt(changeIndex1, '0');
							sb1.setCharAt(zeroIndex1, temp1);

							System.out.println("이동한 후(sb1):" + sb1);
							System.out.println("-------->");

							if (!map.containsKey(sb1.toString())) {
								queue.offer(sb1.toString());
								map.put(sb1.toString(), sb1.toString());

								// 3번째
								System.out.println("2번 이동 queue:" + queue);
								System.out.println("2번 이동 map:" + map);

							}

							if (sb1.toString().equals(strStart.toString())) {
								System.out.println("같습니다!");
							}
						}
					}

					System.out.println("=====================");
				}

				// 같다면 종료하기
				if (sb.toString().equals(strStart.toString())) {
					System.out.println("같습니다!");
				}
			} // if문 끝

		} // for문 끝

	}

}
