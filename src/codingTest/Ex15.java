// 백준 2156 포도주 시식

package codingTest;

import java.util.Scanner;

public class Ex15 {
	private static int N;
	private static int[] arr ;
	private static Integer[] d;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		arr = new int[N+1];
		d = new Integer[N+1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}
		
		d[0] = arr[0];
		d[1] = arr[1];
		d[2] = arr[1] + arr[2];
		
        System.out.println(dfs(N));

	}
	
	private static int dfs(int depth) {
        if (d[depth] == null) {
        	d[depth] = Math.max(dfs(depth - 1), Math.max(dfs(depth-2), dfs(depth - 3) + arr[depth-1])+ arr[depth]);
        	System.out.println(d[depth]);
        }
		return d[depth];
	}

}
