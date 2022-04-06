// 백준 1912번 연속 동적계획법

package codingTest;

import java.util.Arrays;
import java.util.Scanner;

public class Ex20 {
	public static int N;
	private static Integer[] d;
	private static int[] arr;
	private static int MAX = -1000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		arr = new int[N];
		d = new Integer[N];
		
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		dp(N-1);
		
		for (int i = 0; i < N; i++) {
			MAX = Math.max(MAX, d[i]);
		}
		
		System.out.println(MAX);
		
	}
	
	private static int dp(int index) {
        if(d[index] == null) {
            d[index] = 0;
            
            if (index == 0) {
			    d[index] = arr[index];
		    } else {
			    d[index] = Math.max( dp(index-1) + arr[index], arr[index] );
		    }
        } 
		
		return d[index];
	}

}
