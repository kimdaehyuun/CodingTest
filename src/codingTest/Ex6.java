package codingTest;

import java.util.Scanner;
// 백준 1003번
public class Ex6 {
	private static int N = 0;
	private static int[] num;
	private static int[] zero;
	private static int[] one;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		num = new int[N+1];
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		
		zero = new int[41];
		one = new int[41];
		zero[0] = 1;
		one[0] = 0;
		zero[1] = 0;
		one[1] = 1;
		
		for (int i = 2; i < 41; i++) {
			zero[i] = zero[i-1] + zero[i-2];
			one[i] = one[i-1] + one[i-2];
		}
		
		for (int i = 0; i < N; i++) {
			System.out.printf("%d %d\n", zero[num[i]], one[num[i]]);
		}

	}

}
