package Silver;

import java.util.Scanner;

public class BOJ_2477_참외밭_정유준 {
	static Scanner sc = new Scanner(System.in);
	static int east[] = new int[2];
	static int west[] = new int[2];
	static int south[] = new int[2];
	static int north[] = new int[2];
	static int chamwaeAmount;
	static int fullSquare;
	static int minSquare;

	static void input() {
		chamwaeAmount = sc.nextInt();
		for (int idx = 0; idx < 6; idx++) {
			int direction = sc.nextInt();
			if (direction == 1) {
				if (east[0] == 0) {
					east[0] = sc.nextInt();
				} else {
					east[1] = sc.nextInt();
				}
			}
			if (direction == 2) {
				if (west[0] == 0) {
					west[0] = sc.nextInt();
				} else {
					west[1] = sc.nextInt();
				}
			}
			if (direction == 3) {
				if (south[0] == 0) {
					south[0] = sc.nextInt();
				} else {
					south[1] = sc.nextInt();
				}
			}
			if (direction == 4) {
				if (north[0] == 0) {
					north[0] = sc.nextInt();
				} else {
					north[1] = sc.nextInt();
				}
			}
		}
	}

	static void findFullSquare() {
		// 최대 가로값
		int maxHorizon;
		// 최대 세로값
		int maxVertiacl;

		// 2개가 있는 값은 1개가 있는 값의 인덱스 0 값보다 무조건 작을 수 밖에 없다.
		// 따라서 0번째 인덱스만 비교
		// 가로 최대값
		if (south[0] > north[0]) {
			maxHorizon = south[0];
		} else {
			maxHorizon = north[0];
		}

		if (east[0] > west[0]) {
			maxVertiacl = east[0];
		} else {
			maxVertiacl = west[0];
		}

		fullSquare = maxHorizon * maxVertiacl;
	}

	static int findMinSquare() {
		// 비어있는 값이 남동쪽
		if (east[1] != 0 && south[1] != 0) {
			minSquare = east[0] * south[1];
			return minSquare;
		}

		// 비어있는 값이 북동쪽
		else if (east[1] != 0 && north[1] != 0) {
			minSquare = east[1] * north[0];
			return minSquare;
		}

		// 비어있는 값이 남서쪽
		else if (west[1] != 0 && south[1] != 0) {
			minSquare = south[0] * west[1];
			return minSquare;
		}

		// 비어있는쪽이 북서쪽
		else if (west[1] != 0 && north[1] != 0) {
			minSquare = south[0] * north[1];
			return minSquare;
		}
		return -1;
	}
	
	static void calChamwaeNum() {
		//확인용
//		System.out.println(fullSquare);
//		System.out.println(minSquare);
//		System.out.println(fullSquare * chamwaeAmount);
//		System.out.println(minSquare * chamwaeAmount);
		int squareSize = fullSquare - minSquare;
		System.out.printf("%d", squareSize*chamwaeAmount);
	}
	
	static void solve() {
		input();
		findFullSquare();
		findMinSquare();
		calChamwaeNum();
	}
	
	public static void main(String[] args) {
		solve();
	}
}
