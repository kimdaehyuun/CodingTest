// 프로그래머스 스택/큐 - 프린터 42587번 https://programmers.co.kr/learn/courses/30/lessons/42587?language=java

package codingTest;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class PRGRMS42587 {
//	public static int[] priorities = {2, 1, 3, 2};
//	public static int location = 2;
	public static int[] priorities = {1, 1, 9, 1, 1, 1};
	public static int location = 0;
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> indexQueue = new LinkedList<>();
		Iterator<Integer> iter = null;
		for(int i = 0; i < priorities.length; i++) {
			queue.offer(priorities[i]);
			indexQueue.offer(i+1);
		}
		
		int printCnt = 0;
		while(!queue.isEmpty()) {
			boolean print = true;
			int num = queue.poll();
			int index = indexQueue.poll();
			iter = queue.iterator();
			while(iter.hasNext()) {
				if(num < iter.next()) {
					queue.offer(num);
					indexQueue.offer(index);
					print = false;
					System.out.println("swap : " + num + ", index : " + index);
					break;
				}
			}
			if(print) {
				System.out.println("print : " + num + ", index : " + index);
				printCnt++;
				if(location == index - 1) {
					System.out.println("정답 : " + printCnt);
				}
			}
		}
		
	}

}
