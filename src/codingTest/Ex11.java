// 백준 1932 정수 삼각형

package codingTest;

import java.util.Scanner;

public class Ex11 {
	private static int N;
	private static int[][] arr ;
	private static int[][] d;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		arr = new int[N][N];
		d = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < N; i++) {
			d[N-1][i] = arr[N-1][i];
		}
		
        System.out.println(dfs(0,0));

	}
	
	private static int dfs(int depth, int n) {
        if (depth == N-1) {
            return d[depth][n];
        } else {
            if(d[depth][n]==0) {
			    d[depth][n] = Math.max(dfs(depth+1, n), dfs(depth+1, n+1)) + arr[depth][n];
		    }
            return d[depth][n];
        }
		
	}

}
