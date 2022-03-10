// 백준 11053 가장 긴 증가하는 부분 순열

package codingTest;

import java.util.Scanner;

public class Ex16 {
	private static int N;
	private static int[] arr ;
	private static Integer[] d;
	private static int MAX = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		arr = new int[N+1];
		d = new Integer[N+1];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 0; i < N; i++) {
			dfs(i);
		}
		
		for (int i = 0; i < N; i++) {
			if (d[i] > MAX) {
				MAX = d[i];
			}
		}
		
		
        System.out.println(MAX);

	}
	
	private static int dfs(int depth) {
        if (d[depth] == null) {
        	d[depth] = 1;
        	for (int i = depth-1; i >=0; i--) {
        		if (arr[depth] > arr[i]) {
        			d[depth] = Math.max(d[depth], dfs(i)+1);
        		}
        	}
        }
		return d[depth];
	}

}
