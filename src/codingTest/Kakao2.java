// 2022 카카오 코딩테스트

package codingTest;

import java.util.Arrays;

public class Kakao2 {
	public static void main(String[] args) {
//		int[] queue1 = {3, 2, 7, 2};
//		int[] queue2 = {4, 6, 5, 1};
//		int[] queue1 = {1, 2, 1, 2};
//		int[] queue2 = {1, 10, 1, 2};
		int[] queue1 = {1, 1};
		int[] queue2 = {1, 5};
		int queueLength = queue1.length + queue2.length;
		int[] finalQueue = new int[queueLength];
		int allSum = 0;
		int sum = 0;
		int startIndex = 0;
		int endIndex = 0;
		int count = 0;
		int MIN = 10000;
		
		System.arraycopy(queue1, 0, finalQueue, 0, queue1.length);
		System.arraycopy(queue2, 0, finalQueue, queue1.length, queue2.length);
		
		for (int i = 0; i < queueLength; i++) {
			allSum += finalQueue[i];
		}
		
		for (int i = 0; i < queueLength; i++) {
			sum = 0;
			for (int j = i; j < queueLength; j++) {
				sum += finalQueue[j];
				if (sum > allSum / 2) {
					break;
				} else if (sum == allSum / 2) {
					count = 0;
					startIndex = i;
					endIndex = j;
					// case 1 : 묶음이 큐1에 다 있으면서 맨 처음부터 시작 ex) 0~2, 3~7
					if ( startIndex == 0 && endIndex < queue1.length - 1 ) {
						count += endIndex + 1; // 일단 묶음 그대로 큐2로 이동
						count += queue2.length; // 큐2에 있던거 통째로 큐1로 이동
						System.out.println("case1");
					}
					// case 2 : 묶음 상태가 이미 그대로 목표 성공 ex) 0~3, 4~7
					else if ( startIndex == 0 && endIndex == queue1.length - 1 ) {
						count = 0;
						System.out.println("case2");
					}
					// case 3 : ex) 0~4, 5~7
					else if ( startIndex == 0 && endIndex >= queue1.length ) {
						count += endIndex + 1 - queue1.length; // 큐2에서만 일부 이동
						System.out.println("case3");
					}
					// case 4 : ex) 1~4, 5~0
					else if ( startIndex > 0 && startIndex < queue1.length && endIndex >= queue1.length ) {
						count += startIndex;
						count += endIndex + 1 - queue1.length;
						System.out.println("case4");
					}
					// case 5 : ex) 4~6, 7~3
					else if ( startIndex == queue1.length && endIndex < queueLength - 1 ) {
						count += endIndex + 1 - queue1.length; 
						count += queue1.length;
						System.out.println("case5");
					}
					// case 6 : ex) 5~6, 7~4
					else if ( startIndex > queue1.length && endIndex < queueLength - 1 ) {
						count += endIndex + 1 - queue1.length; 
						count += queue1.length;
						count += startIndex - queue1.length;
						System.out.println("case6");
					}
					if (count < MIN) {
						MIN = count;
					}
					System.out.println("시작점: "+startIndex+",끝점: "+endIndex+",cnt: "+count);
					break;
				}
			}
		}
		if (MIN == 10000) {
			MIN = -1;
		}
		
		
		System.out.println(Arrays.toString(finalQueue));
		System.out.println(MIN);
	}

}
