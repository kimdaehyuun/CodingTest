// 백준 1463번 1로 만들기 동적계획법 

package codingTest;

import java.util.Scanner;

public class Ex14 {
	private static int N;
	private static Long[][] arr;
	final static long MOD = 1000000000;
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		
		arr = new Long[N+1][10];
		
		for (int i = 0; i < 10; i++) {
			arr[1][i] = 1L;
		}
		
		long result = 0;
		
		for (int i = 1; i <= 9; i++) {
			result += dfs(N, i);
		}
		
		System.out.println(result % MOD);

	}
	
	private static Long dfs(int depth, int num) {
		// 첫째 자리수에 도착했다면 더이상 탐색하지 않아도
		if (depth == 1) {
			return arr[depth][num];
		}
		// 아직 탐색하지 못한 자리수일 경우
		if (arr[depth][num] == null) {
			// 해당 자리수 숫자가 0이라면 그 앞자리 숫자는 1밖에 못옴
			if (num == 0) {
				arr[depth][num] = dfs(depth-1, 1);
			} 
			// 해당 자리수 숫자가 9라면 그 앞자리 숫자는 8밖에 못옴
			else if (num == 9) {
				arr[depth][num] = dfs(depth-1, 8);
			} 
			// 그 외의 경우는 하나뺀경우 하나더한경우의 경우의 수를 더해줌
			else {
				arr[depth][num] = dfs(depth-1, num-1) + dfs(depth-1, num+1);
			}
		}
		return arr[depth][num] % MOD;
	}

}