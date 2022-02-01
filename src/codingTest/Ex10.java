// 백준 1149번

package codingTest;

import java.util.Scanner;

public class Ex10 {
	private static int N;
	private static int[][] arr ;
	private static int[][] d;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		arr = new int[N][4];
		d = new int[N][4];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		d[0][0] = arr[0][0];
		d[0][1] = arr[0][1];
		d[0][2] = arr[0][2];
		
		int a = dfs2(N-1, 0);
		int b = dfs2(N-1, 1);
		int c = dfs2(N-1, 2);
		
		System.out.println(Math.min(c, Math.min(a, b)));

	}
	
	private static int dfs2(int n, int color) {
		if(d[n][color]==0) {
			if(color==0) {
				d[n][color] = Math.min(dfs2(n-1, 1), dfs2(n-1, 2)) + arr[n][0];
			}else if(color==1) {
				d[n][color] = Math.min(dfs2(n-1, 0), dfs2(n-1, 2)) + arr[n][1];
			}else {
				d[n][color] = Math.min(dfs2(n-1, 0), dfs2(n-1, 1)) + arr[n][2];
			}
				  
		}
		
		return d[n][color];
		
	}

}
