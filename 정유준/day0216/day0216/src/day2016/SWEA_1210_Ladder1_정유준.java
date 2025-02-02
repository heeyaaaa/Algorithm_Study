package day2016;

import java.util.Scanner;

public class SWEA_1210_Ladder1_정유준 {
	static Scanner sc = new Scanner(System.in);
	static int[][] ladder = new int[100][100];
	static int[] xWay = { 0, 1, -1 };
	static int[] yWay = { 1, 0, 0 };
	static int direction = 0;
	static int x;
	static int y;
	static int answer;

	static void input() {
		int testCase = sc.nextInt();
		for (int yidx = 0; yidx < 100; yidx++) {
			for (int xidx = 0; xidx < 100; xidx++) {
				ladder[yidx][xidx] = sc.nextInt();
			}
		}
	}

	static void findWay() {
		for (int idx = 0; idx < 100; idx++) {
			x = idx;
			y = 0;
			if (ladder[0][x] == 1) {
				while (y != 99) {
					findDirection();
					x += xWay[direction];
					y += yWay[direction];
				}
			}
			if (ladder[99][x] == 2) {
				answer = idx;
				break;
			}
		}
	}

	static void findDirection() {
		// 왼쪽 끝에서 오른쪽이 1인경우 -> 오른쪽으로
		if (x == 0 && ladder[y][1] == 1) {
			direction = 1;
			// 왼쪽 끝에서 오른쪽이 1이 아닌경우 -> 아래로
		} else if (x == 0 && ladder[y][1] == 0) {
			direction = 0;
			// 오른쪽 끝에서 왼쪽이 1인경우 -> 왼쪽으로
		} else if (x == 99 & ladder[y][98] == 1) {
			direction = 2;
			// 오른쪽 끝에서 왼쪽이 1이 아닌경우 -> 아래로
		} else if (x == 99 && ladder[y][98] == 0) {
			direction = 0;
			// 양쪽 사이드가 아닌 곳에서의 방향찾기
		} else if (x != 99 && x != 0) {
			if (ladder[y][x + 1] == 1) {
				direction = 1;
			} else if (ladder[y][x - 1] == 1) {
				direction = 2;
			} else if (ladder[y][x + 1] != 1 && ladder[y][x - 1] != 1) {
				direction = 0;
			}
		}
	}

	static void solve() {
		for (int idx = 1; idx < 11; idx++) {
			input();
			findWay();
			System.out.println("#" + idx + " " + answer);
		}
	}

	public static void main(String[] args) {
		solve();
		sc.close();
		// 문제를 알았다.
		// 좌우 반복(왔다갔다)를 해버린다.
		// 어떻게해야할까
	}
}
