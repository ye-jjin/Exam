package exam01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SlidingPuzzle {
	static String strStart;
	static String strTarget;
	static int num;
	static String str;
	static StringBuilder sb;

	public static void main(String[] args) {
		// 초기 2차원 배열
//		String arrStart[][] = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "0" } };
		strStart = "123456780";

		// 1. 행과 열의 숫자를 입력받는다.
		Scanner scan = new Scanner(System.in);
		num = scan.nextInt();

		// 2. 2차원 배열의 공간을 만든다.
		String arrEnd[][] = new String[num][num];

		// 3. 2차원 배열을 입력받는다.
		for (int i = 0; i < arrEnd.length; i++) {
			for (int j = 0; j < arrEnd[i].length; j++) {
				arrEnd[i][j] = scan.next();
			}
		}

		// 2차 배열->1차 배열로 변경
		String arrTarget[] = new String[num * num];

		// arrEnd 값 arrTarget으로 넣어주기 2차원 배열-> 1차원 배열
		for (int i = 0; i < arrEnd.length; i++) { // 0 1 2
			for (int j = 0; j < arrEnd[0].length; j++) { // 0 1 2 3
				arrTarget[i * arrEnd[0].length + j] = arrEnd[i][j];
			}
		}

		// String arr -> String 으로 변환
		String strT = Arrays.toString(arrTarget);
		System.out.println("\n" + strT);
		String strTT = strT.replace(", ", ""); // ,제거하기
		String strTTT = strTT.replace("[", ""); // 괄호제거하기
		strTarget = strTTT.replace("]", ""); // 괄호제거하기
		System.out.println("입력예제:" + strTarget);

		// Queue + Map
		Queue<String> queue = new LinkedList<>(); // BFS
		HashMap<String, Integer> map = new HashMap<>(); // 중복체크

		if (strTarget.toString().equals(strStart.toString())) {
			System.out.println("처음 배열과 같은 배열입니다.");
			System.out.println("최종 이동횟수: 0");
		} else {
			map.put(strTarget.toString(), 0);
			queue.offer(strTarget.toString());
			movePuzzle(queue, map);

		}
	}

	public static int movePuzzle(Queue<String> queue, HashMap<String, Integer> map) {
		// 0의 위치에서 이동할 수 있는 범위 찾기
		int[] rowX = { 0, 0, -1, 1 }; // 상,하
		int[] colY = { -1, 1, 0, 0 }; // 좌,우

		while (!queue.isEmpty()) {
			str = queue.poll();

			// arrTarget에서 0의 위치 찾기
			int zeroIndex = str.indexOf("0");
			System.out.println("arrTarget(1차원)에서 0의 인덱스:" + zeroIndex);

			int row = zeroIndex / num; // 행은 0
			int col = zeroIndex % num; // 열은 1
			System.out.println("arrTarget(2차원)에서 0의 인덱스: [" + row + "],[" + col + "]");

			for (int i = 0; i < 4; i++) {
				int moveX = row + rowX[i]; // 상=0+(-1)(x) 하=0+1(o)
				int moveY = col + colY[i]; // 좌=1+(-1)(o) 우=1+1(o)

				// moveX와 moveY가 0이상 num 미만일 때만, 상/하/좌/우 이동가능
				if (moveX >= 0 && moveX < num && moveY >= 0 && moveY < num) {
					// 이동가능한 인덱스찾기
					int changeIndex = (num * moveX) + moveY;
					System.out.println(zeroIndex + "에서 " + changeIndex + "번째로 이동가능");

					// 0의 자리 인덱스와 이동가능한 인덱스 자리 바꾸기
					sb = new StringBuilder(str);
					char temp = sb.charAt(changeIndex);
					sb.setCharAt(changeIndex, '0');
					sb.setCharAt(zeroIndex, temp);

					System.out.println("이동한 후(sb):" + sb);
					System.out.println("-------->");

					// map에 있는 초기 배열이랑 한번 이동한 후 sb의 값이 같지 않다면 큐에 저장
					if (!map.containsKey(sb.toString())) {
						queue.offer(sb.toString()); //
						map.put(sb.toString(), map.get(str) + 1);

						System.out.println("queue:" + queue);
						System.out.println(" map:" + map);
						System.out.println("=====================");
					}

					// 같다면 종료하기
					if (sb.toString().equals(strStart.toString())) {
						System.out.println("같습니다!");
						System.out.println("총 이동 횟수:" + map.get(str) + 1);

					} // if

				} // if

			} // for
		} // while
		return -1;
	}// movePuzzle

}
