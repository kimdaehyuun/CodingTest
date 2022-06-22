// 프로그래머스 dfs/bfs - 타겟넘버 43165번 https://programmers.co.kr/learn/courses/30/lessons/43165?language=java

package codingTest;

public class PRGRMS43165 {
//	public static int[] numbers = {1, 1, 1, 1, 1};
//	public static int targetNum = 3;
	public static int[] numbers = {4, 1, 2, 1};
	public static int targetNum = 4;
	public static int size = numbers.length;
	public static int count = 0;
	
	public static void main(String[] args) {
		dfs(numbers, 0, targetNum, 0);
		System.out.println(count);

	}
	
	public static void dfs(int[] numbers, int index, int target, int sum) {
		if(index == size) {
			if(sum == target) {
				count++;
			}
		} else {
			dfs(numbers, index + 1, target, sum + numbers[index]);
			dfs(numbers, index + 1, target, sum - numbers[index]);
		}
	}

}
