package codingTest;

import java.util.Scanner;

public class sdokuEx {
	private static int[][] arr= new int[9][9];
    private static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		sdoku(0,0);
        System.out.println(sb);

	}
	
	public static void sdoku(int row, int column) {
		if(column == 9) {
			sdoku(row+1, 0);
			return;	
		}
		if(row == 9) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					sb.append(arr[i][j]).append(' ');
				}
				sb.append('\n');
			}
			return;
		}
		
		if(arr[row][column]==0) {
			for(int i=1; i<=9; i++) {
				if(sdoku2(row, column, i)) {
					arr[row][column] = i;
					sdoku(row, column+1);
				}
			}
            arr[row][column]=0;
		return;
		}
		sdoku(row, column+1);
		
	}
	
	public static boolean sdoku2(int row, int column, int num) {
		for(int i=0; i<9; i++) {
			if(arr[row][i] == num) {
				return false;
			}
		}
		
		for(int i=0; i<9; i++) {
			if(arr[i][column] == num) {
				return false;
			}
		}
		
		int r = (row/3) * 3;
		int c = (column/3) * 3;
		
		for(int i=r; i<r+3; i++) {
			for(int j=c; j<c+3; j++) {
				if(arr[i][j]==num) {
					return false;
				}
			}
		}
		return true;
	}

}
