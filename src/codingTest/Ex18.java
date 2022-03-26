// 백준 11053 가장 긴 증가하는 부분 순열

package codingTest;

import java.util.Arrays;
import java.util.Scanner;

public class Ex18 {
	private static int N;
	private static int[][] arr ;
	private static Integer[] d;
	private static int MAX = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		arr = new int[N+1][2];
		d = new Integer[N+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 2; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		Arrays.sort(arr, (o1, o2) -> {
			if(o1[0] == o2[0]) {
				return o1[1] - o2[1];
			} else {
				return o1[0] - o2[0];
			}
		});
		
		for (int i = 1; i <= N; i++) {
			dp(i);
		}
		
		for(int i = 1; i <= N; i++) {
			MAX = Math.max(MAX, d[i]);
		}
		
		System.out.println(N - MAX);
	}
	
	private static int dp(int depth) {
        if (d[depth] == null) {
        	d[depth] = 1;
        	for (int i = 1; i < depth; i++) {
        		if (arr[depth][1] > arr[i][1]) {
        			d[depth] = Math.max(d[depth], d[i]+1);
        		}
        	}
        }
		return d[depth];
	}

}
