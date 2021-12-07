//백준 스도쿠 문제

import java.util.Scanner;

public class ex5 {
	private static int[][] arr;
	private static boolean[] ok;
	private static int count = 0;
    private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[11][11];
		ok = new boolean[11];
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		sdoku2(0);
        System.out.print(sb);
		
	}
	
//	public static void sdoku(int depth) {
//		if(depth == 9) {
//			sdoku2(0);
//		}
//		for (int i = 0; i < 9; i++) {
//			// 해당 깊이에서 해당 위치값이 0이 아니라면
//			if(arr[depth][i] != 0) {
//				ok[arr[depth][i]] = true;
//			} else {
//				count++;
//			}
//		}
//		if(count == 1) {
//			count = 0;
//			for(int i = 0; i < 9; i++) {
//				if(ok[arr[depth][i]] == false) {
//					arr[depth][i] = i+1;
//					break;
//				}
//			}
//		}
//		sdoku(depth + 1);
//	}
	
	public static void sdoku2(int depth2) {
		if(depth2 == 9) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					sb.append(arr[i][j]).append(' ');
				}
				sb.append('\n');
			}
			return;
		}
		for (int i = 0; i < 9; i++) {
			// 해당 깊이에서 해당 위치값이 0이 아니라면
			if(arr[i][depth2] != 0) {
				ok[arr[i][depth2]] = true;
			} else {
				count++;
			}
		}
		if(count == 1) {
			count = 0;
			for(int i = 0; i < 9; i++) {
				if(ok[arr[i][depth2]] == false) {
					arr[i][depth2] = i+1;
					break;
				}
			}
		}
		sdoku2(depth2 + 1);
	}
	
	

	
}
