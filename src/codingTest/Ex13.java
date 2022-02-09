// 백준 1463번 1로 만들기 동적계획법 

package codingTest;

import java.util.Scanner;

public class Ex13 {
	private static int N;
	private static Integer[] arr;
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		
		arr = new Integer[N+1];
		arr[1] = 0;
		
		System.out.println(dfs(N));

	}
	
	private static int dfs(int num) {
		if (arr[num] == null) {
			if (num % 6 == 0) {
				arr[num] = Math.min(dfs(num - 1), Math.min(dfs(num/3), dfs(num/2))) + 1;
			}
			else if(num % 3 == 0) {
				arr[num] = Math.min(dfs(num/3), dfs(num - 1)) + 1;
			} 
			else if (num % 2 == 0) {
				arr[num] = Math.min(dfs(num/2), dfs(num - 1)) + 1;
			}
			else {
				arr[num] = dfs(num - 1) + 1;
			}
			return arr[num];
		}
		else {
			return arr[num];
		}
	}

}