// 프로그래머스 42586번 스택/큐 기능개발 https://programmers.co.kr/learn/courses/30/lessons/42586?language=java

package codingTest;

import java.util.ArrayList;
import java.util.Arrays;

public class PRGRMS42586 {
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) {
//		int[] progresses = {93, 30, 55};
//		int[] speeds = {1, 30, 5};
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};
		int[] days = new int[speeds.length];
		for(int i = 0; i < days.length; i++) {
			int remPro = 100 - progresses[i]; // 남은 진도
			int remDay = 0;
			if(remPro % speeds[i] == 0) { // 나누어떨어지면
				remDay = remPro / speeds[i];
			} else {
				remDay = remPro / speeds[i] + 1;
			}
			days[i] = remDay;
		}
		System.out.println(Arrays.toString(days)); // 각 진도별 앞으로 걸리는 날짜
		
		
		int cnt = 0;
		int max = 0;
		for(int i = 0; i < progresses.length; i++) {
			// 우선 맨 첫번째 작업
			if(i == 0) {
				list.add(new ArrayList<Integer>()); // 우선 첫번째 arraylist 생성
				list.get(cnt).add(days[i]);
				max = days[i]; // 우선 맨 처음값이 최댓값
			} // 그 이후부터는
			else {
				// 만약 앞에꺼보다 더 오래걸리는 거라면 그 다음 배포로 넘겨야함
				if(days[i] > max) {
					cnt++;
					max = days[i]; // 최댓값 교체
					list.add(new ArrayList<Integer>());
				}
				list.get(cnt).add(days[i]);
			}
			
		}
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		// arraylist에 어떻게 담겼는지 확인
//		for(int i = 0; i < list.size(); i++) {
//			int total = list.get(i).size();
//			for(int j = 0; j < total; j++) {
//				System.out.print(list.get(i).get(j) + " ");
//			}
//			System.out.println();
//		}
		
		for(int i = 0; i < list.size(); i++) {
			result.add(list.get(i).size());
		}
		int[] resultArr = new int[result.size()];
		int size = 0;
		for(int temp : result) {
			resultArr[size++] = temp;
		}
		
		System.out.println(Arrays.toString(resultArr));

	}

}
