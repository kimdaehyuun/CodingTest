// 백준 14888번 문제

package codetest;

import java.util.Scanner;

public class BackTracking {
	
	private static int N;
    private static int[] num;
    private static int[] cal = new int[4];
    private static long MAX = -100000001;
    private static long MIN = 100000001;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// 숫자 개수 입력
		N = sc.nextInt();
        // 숫자를 넣을 배열 생성
        num = new int[N];
        
        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }
        // 연산자 개수가 담길 배열 생성
        for (int i = 0; i < 4; i++) {
            cal[i] = sc.nextInt();
        }
        // 첫번째에 있는 숫자부터 연산 시작
		dfs(num[0], 1);
		// 연산으로 나올 수 있는 최대값과 최소값 출력
        System.out.println(MAX);
        System.out.println(MIN);
		
	}
	// 깊이 탐색 시작
	private static void dfs(int number, int idx) {
		// 마지막 연산까지 수행했으면 연산값과 기존 최대값 최소값 비교
		if (idx == N) {
			MAX = Math.max(MAX, number);
            MIN = Math.min(MIN, number);
            return;
		} else {
			for (int i=0; i<4; i++) {
				// 해당 연산자가 있다면 연산 수행
                if (cal[i] > 0) {
                	// 한번 연산자를 사용했으니 카운트 줄여주기
                    cal[i]--;
                    
                    switch(i) {
                        case 0:
                            dfs(number + num[idx], idx + 1); break;
                        case 1:
                            dfs(number - num[idx], idx + 1); break;
                        case 2:
                            dfs(number * num[idx], idx + 1); break;
                        case 3:
                            dfs(number / num[idx], idx + 1); break;
                    }
                    // 백트래킹 연산이므로 카운트를 줄였으니 다시 늘려주기
                    cal[i]++;
                }
			}
		}
		
		
	}
}