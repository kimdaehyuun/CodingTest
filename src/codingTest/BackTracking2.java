// 백준 14889번 문제

package codingTest;

import java.util.Scanner;

public class BackTracking2 {
	
	private static int N;
    private static int[][] num;
    private static boolean[] visit;
    private static int MIN = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// 숫자 개수 입력
		N = sc.nextInt();
        // 숫자를 넣을 배열 생성
        num = new int[N][N];
        visit = new boolean[N];
        
        for (int i = 0; i < N; i++) {
           for (int j = 0; j < N; j++) {
        	   num[i][j] = sc.nextInt();
           }
        }
        
        dfs(0, 0);
        
        System.out.println(MIN);
		
	}
	// 깊이 탐색 시작
	private static void dfs(int depth, int a) {
		if (depth == N/2) {
			func();
			return;
		}
		for (int i = a; i < N; i++) {
			visit[i] = true;
			dfs(depth+1, i+1);
			visit[i] = false;
		}
		
	}
	
	private static void func() {
		int start = 0;
		int link = 0;
		
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				if (visit[i] == true && visit[j] == true) {
					start += num[i][j] + num[j][i];
				}
				else if (visit[i] == false && visit[j] == false) {
					link += num[i][j] + num[j][i];
				}
			}
		}
		
		int sub = Math.abs(start - link);
		
		if (sub == 0) {
			System.out.println(sub);
			System.exit(0);
		}
		MIN = Math.min(sub, MIN);
	}
}