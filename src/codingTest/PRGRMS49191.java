// 프로그래머스 그래프 순위 49191번 https://programmers.co.kr/learn/courses/30/lessons/49191

package codingTest;

import java.util.Arrays;

public class PRGRMS49191 {
	public static int n = 5;
	public static int[][] results = {{4,3},{4,2},{3,2},{1,2},{2,5}};

	public static void main(String[] args) {
		int[][] arr = new int[n+1][n+1];
		int answer = 0;
		// 기존에 주어진 승패 정보 기록하기
		for(int i = 0; i < results.length; i++) {
			int line = results[i][0]; // 행
			int row = results[i][1]; // 열
			arr[row][line] = -1; // lose
			arr[line][row] = 1; // win
		}
		// 플로이드 워셜 알고리즘 사용
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				for(int z=1; z<=n; z++) {
					// i번 선수가 j번 선수를 이겼고, z번 선수가 i번 선수를 이겼으면
					// z번 선수는 j번 선수를 이긴다는 삼단논법식 로직
					// 이걸로 승패 정보를 더 기입할 수 있다
					if(arr[j][i] == 1 && arr[i][z] == 1) {
						arr[j][z] = 1;
						arr[z][j] = -1;
					}
				}
			}
		}
		
		// 배열 출력
		for(int i = 1; i <=n; i++) {
			for(int j = 1; j <=n; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
			System.out.println();
		}
		
		int cnt;
		for(int i = 1; i <= n; i++) {
			cnt = 0;
			for(int j = 1; j <= n; j++) {
				if(arr[i][j] == 1 || arr[i][j] == -1) {
					cnt++;
					System.out.println("i : " + i + " j : " + j);
				}
			}
			System.out.println("out");
			if(cnt == n-1) {
				answer++;
				System.out.println("카운트 증가!");
			}
		}
		System.out.println("정답 : " + answer);
	}

}
