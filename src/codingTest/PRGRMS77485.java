// 프로그래머스 77485번 행렬 테두리 회전하기 https://school.programmers.co.kr/learn/courses/30/lessons/77485

package codingTest;

import java.util.Arrays;

public class PRGRMS77485 {
	public static int rows = 6;
	public static int columns = 6;
	public static int[][] queries = {{2,2,5,4}, {3,3,6,6}, {5,1,6,3}};
	public static int[][] map = new int[rows+1][columns+1];
	public static int[] minArr = new int[queries.length];
	public static int MIN = Integer.MAX_VALUE;
	public static void main(String[] args) {
		int n = 1;
		for(int i = 1; i <= rows; i++) {
			for(int j = 1; j <= columns; j++) {
				map[i][j] = n++;
			}
		}
		
		for(int i = 0; i < queries.length; i++) {
			int startX = queries[i][0]; //2
			int startY = queries[i][1]; //2
			int endX = queries[i][2]; //5
			int endY = queries[i][3]; //4
			int tempA = map[startX][endY];
			int tempB = map[endX][endY];
			int tempC = map[endX][startY];
			MIN = Integer.MAX_VALUE;
			for(int j = endY; j >= startY + 1; j--) {
				map[startX][j] = map[startX][j-1];
				if(map[startX][j-1] < MIN) {
					MIN = map[startX][j-1];
				}
			}
			for(int j = endX; j >= startX + 2; j--) {
				map[j][endY] = map[j-1][endY];
				if(map[j-1][endY] < MIN) {
					MIN = map[j-1][endY];
				}
			}
			for(int j = startY; j <= endY - 2; j++) {
				map[endX][j] = map[endX][j+1];
				if(map[endX][j+1] < MIN) {
					MIN = map[endX][j+1];
				}
			}
			for(int j = startX; j <= endX - 1; j++) {
				map[j][startY] = map[j+1][startY];
				if(map[j+1][startY] < MIN) {
					MIN = map[j+1][startY];
				}
			}
			map[startX+1][endY] = tempA;
			map[endX][endY-1] = tempB;
			map[endX-1][startY] = tempC;
			if(tempA < MIN) {
				MIN = tempA;
			}
			if(tempB < MIN) {
				MIN = tempB;
			}
			if(tempC < MIN) {
				MIN = tempC;
			}
			minArr[i] = MIN;
		}
		System.out.println("정답 : ");
		System.out.println(Arrays.toString(minArr));

	}

}
