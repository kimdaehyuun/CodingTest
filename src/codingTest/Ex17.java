// 백준 11054 가장 긴 바이토닉 부분 수열

package codingTest;

import java.util.Scanner;

public class Ex17 {
	private static int N;
	private static int[] arr ;
	private static Integer[] d;
	private static int MAX = 0;
	private static Integer[] dA;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		arr = new int[N+1];
		d = new Integer[N+1];
		dA = new Integer[N+1];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 0; i < N; i++) {
			dp(i);
		}
		
		for (int i = N-1; i>=0; i--) {
			dpA(i);
		}
		
		
		for (int i = 0; i < N; i++) {
			if (d[i] + dA[i] > MAX) {
				MAX = d[i] + dA[i];
			}
		}
		
		
        
        System.out.println(MAX-1);
	}
	
	private static int dp(int depth) {
        if (d[depth] == null) {
        	d[depth] = 1;
        	for (int i = depth-1; i >=0; i--) {
        		if (arr[depth] > arr[i]) {
        			d[depth] = Math.max(d[depth], dp(i)+1);
        		}
        	}
        }
		return d[depth];
	}
	
	private static int dpA(int depth) {
        if (dA[depth] == null) {
        	dA[depth] = 1;
        	for (int i = depth+1; i < N ; i++) {
        		if (arr[depth] > arr[i]) {
        			dA[depth] = Math.max(dA[depth], dpA(i)+1);
        		}
        	}
        }
		return dA[depth];
	}
	

}
