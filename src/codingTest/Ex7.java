// 백준 9184번

package codingTest;

import java.util.Scanner;

public class Ex7 {
	private static int a = 0;
	private static int b = 0;
	private static int c = 0;
	private static StringBuilder sb = new StringBuilder();
	private static int[][][] d = new int[21][21][21];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			sb.setLength(0);
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			
			if (a == -1 && b == -1 && c == -1) {
				break;
			}
			sb.append("w(").append(a).append(", ").append(b)
			.append(", ").append(c).append(") = ").append(w(a,b,c));
			System.out.println(sb);
		}
	}
	
	private static int w(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		else if (a > 20 || b > 20 || c > 20) {
			return d[20][20][20] = w(20, 20, 20);
		}
		else if (d[a][b][c] != 0) {
			return d[a][b][c];
		}
		else if (a < b && b < c) {
			return d[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
		}
		else return d[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) +w(a-1, b, c-1) - w(a-1, b-1, c-1);
	}

}
