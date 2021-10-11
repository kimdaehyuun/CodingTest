//백준 n과 m(3)

package codingTest;

import java.util.Scanner;

public class ex3 {
	private static int N, M;
	private static int[] arr;
    private static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) {
		
		// 1 ~ N까지 수 중 M개 고른 수열
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[M];
		dfs(0);
        System.out.print(sb);
		
	}

	private static void dfs(int d) {
		//M = 2
		if (d == M) {
			for (int i=0; i<M; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
		} else {
			
			for (int i=1; i<=N; i++) {
				arr[d] = i;
				dfs(d+1);
			}
		}
		
		
	}
}
