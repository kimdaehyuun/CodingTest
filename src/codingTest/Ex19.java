// 백준 9251번 LCS 동적계획법

package codingTest;

import java.util.Arrays;
import java.util.Scanner;

public class Ex19 {
	private static Integer[][] d;
	private static char[] arr1;
	private static char[] arr2;
	private static int lengthA = 0;
	private static int lengthB = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
        
        arr1 = str1.toCharArray();
		arr2 = str2.toCharArray();
		
		lengthA = arr1.length;
		lengthB = arr2.length;
		
		d = new Integer[lengthA+1][lengthB+1];
		
		System.out.println(dp(lengthA, lengthB));
	}
	
	private static int dp(int i, int j) {
        if(d[i][j] == null) {
            d[i][j] = 0;
            
            if (i == 0 || j == 0) {
			    d[i][j] = 0;
		    } else if (arr1[i-1] == arr2[j-1]) {
			    d[i][j] = dp(i-1, j-1) + 1;
		    } else {
			    d[i][j] = Math.max(dp(i-1, j), dp(i, j-1));
		    }
        } 
		
		return d[i][j];
	}

}
