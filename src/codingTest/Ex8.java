// 백준 1904번

package codingTest;

import java.util.Scanner;

public class Ex8 {
	private static int N;
	private static int[] arr = new int[1000001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long before = System.currentTimeMillis();
		
		N = sc.nextInt();
		
		
		arr[1] = 1;
		arr[2] = 2;
		
		
		for(int i=3; i<arr.length; i++) {
			arr[i] = -1;
		}
		
		
		System.out.println(fibo(N) );
		
		long after = System.currentTimeMillis();
		long time = (after - before)/1000;
		System.out.println(time);
		
		

	}
	
	private static int fibo(int a) {
//		if (a == 1) {
//			return 1;
//		}
//		else if (a == 2) {
//			return 2;
//		}
//		if (arr[a] != 0) {
//			return arr[a];
//		}
		if(arr[a]==-1){
			arr[a] = (fibo(a-1) + fibo(a-2) )% 15746;
		}
		return arr[a];
	}

}
