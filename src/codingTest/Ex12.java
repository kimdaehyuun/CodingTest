package codingTest;

import java.util.Scanner;

public class Ex12 {
	private static int N;
	private static int[] arr;
	private static Integer[] d;
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		
		arr = new int[N+1];
		d = new Integer[N+1];
		
		for (int i = 1; i <=N; i++) {
			arr[i] = in.nextInt();
		}
		d[0]=arr[0];
		d[1]=arr[1];
        if(N>=2){
            d[2]=arr[1]+arr[2];    
        }
        
        System.out.println(dfs(N));

	}
	
	private static int dfs(int depth) {
		
		if(d[depth]==null){
			d[depth] = Math.max(arr[depth-1] + dfs(depth-3), dfs(depth-2)) + arr[depth];	
		}
		return d[depth];
		
	}

}
