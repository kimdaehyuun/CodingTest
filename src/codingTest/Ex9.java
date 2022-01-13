// 백준 9461번

package codingTest;

import java.util.Scanner;

public class Ex9 {
	private static int T;
	private static long[] arr = new long[101];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		arr[0] = 0L;
		arr[1] = 1L;
		arr[2] = 1L;
		arr[3] = 1L;
		
		
		for (int i = 0; i < T; i++) {
			int a = sc.nextInt();
			System.out.println(p(a));
		}
		

	}
	
	private static long p(int a) {
		if (arr[a] == 0) {
			arr[a] = p(a-2) + p(a-3);
		}
		return arr[a];
	}

}
