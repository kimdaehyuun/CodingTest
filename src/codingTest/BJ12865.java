// 백준 12865번 동적계획법

package codingTest;

import java.util.Arrays;
import java.util.Scanner;

public class BJ12865 {
	public static int N;
	public static int K;
	private static int[][] d;
	private static int[][] arr;
	private static int MAX = -1000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		arr = new int[N+1][K+1];
		d = new int[N+1][K+1];
		
		
		for(int i = 1; i <= N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		for (int i = 1; i <= K; i++) {
			d[0][i] = 0;
		}
		for (int i = 1; i <= N; i++) {
			d[i][0] = 0;
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if (arr[i][0] <= j) {
					d[i][j] = Math.max( d[i-1][j], d[i-1][ j - arr[i][0] ] + arr[i][1] );
					System.out.println(i+"일때%%%초과안함 " + d[i][j]);
				} else {
					d[i][j] = d[i-1][j];
					System.out.println(i+"일때%%% 초과함" + d[i][j]);
				}
			}
		}
		
		System.out.println( d[N][K] );
		
	}
	

}
