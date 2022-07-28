// 프로그래머스 72414번 광고 삽입 https://school.programmers.co.kr/learn/courses/30/lessons/72414

package codingTest;

import java.util.Arrays;

public class PRGRMS72414 {
	public static String play_time = "02:03:55";
	public static String adv_time = "00:14:15";
	public static String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
//	public static String play_time = "50:00:00";
//	public static String adv_time = "50:00:00";
//	public static String[] logs = {"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"};
	public static void main(String[] args) {
		long[] start = new long[logs.length];
		long[] end = new long[logs.length];
		int result = 0;
		
		String[] playSplit = play_time.split(":");
		long playHour = Long.parseLong(playSplit[0]);
		long playMin = Long.parseLong(playSplit[1]);
		long playSec = Long.parseLong(playSplit[2]);
		long playT = 3600 * playHour + 60 * playMin + playSec;
		System.out.println("총 플레이 시간 : " + playT);
		
		String[] advSplit = adv_time.split(":");
		long advHour = Long.parseLong(advSplit[0]);
		long advMin = Long.parseLong(advSplit[1]);
		long advSec = Long.parseLong(advSplit[2]);
		long advT = 3600 * advHour + 60 * advMin + advSec;
		System.out.println("광고 길이 : " + advT);
		
		for(int i = 0; i < logs.length; i++) {
			String[] split = logs[i].split("-");
			
			String[] startSplit = split[0].split(":");
			long startHour = Long.parseLong(startSplit[0]);
			long startMin = Long.parseLong(startSplit[1]);
			long startSec = Long.parseLong(startSplit[2]);
			long startT = 3600 * startHour + 60 * startMin + startSec;
			start[i] = startT;
			
			String[] endSplit = split[1].split(":");
			long endHour = Long.parseLong(endSplit[0]);
			long endMin = Long.parseLong(endSplit[1]);
			long endSec = Long.parseLong(endSplit[2]);
			long endT = 3600 * endHour + 60 * endMin + endSec;
			end[i] = endT;
		}
		
		System.out.println(Arrays.toString(start));
		System.out.println(Arrays.toString(end));
		
		int[] MAX = new int[logs.length + 1];
		
		long advStart = 0;
		long advEnd = 0;
		
		for(int i = 0; i < logs.length; i++) {
			result = 0;
			advStart = start[i]; // 광고 시작하는 시간
			advEnd = advStart + advT; // 광고 끝나는 시간
			for(int j = 0; j < logs.length; j++) {
				if(j != i) {
					if(start[j] < advEnd && advStart < end[j]) {
						if(start[j] >= start[i]) {
							if(advEnd <= end[j]) {
								result += advEnd - start[j];
								System.out.println((i+1) + "번에서 시작한 광고가 " + (j+1) + "번과 겹쳐서 " + (advEnd - start[j]) + "만큼 재생");
							} else {
								result += end[j] - start[j];
								System.out.println((i+1) + "번에서 시작한 광고가 " + (j+1) + "번과 겹쳐서 " + (end[j] - start[j]) + "만큼 재생");
							}
							
						} else {
							if(advEnd > end[j]) {
								result += end[j] - advStart;
								System.out.println((i+1) + "번에서 시작한 광고가 " + (j+1) + "번과 겹쳐서 " + (end[j] - advStart) + "만큼 재생");
							} else {
								result += advT;
								System.out.println((i+1) + "번에서 시작한 광고가 " + (j+1) + "번과 겹쳐서 " + (advT) + "만큼 재생");
							}
							
						}
						
					}
				} else {
					if(advStart + advT <= end[j]) {
						System.out.println((i+1) + "번에서 시작한 광고가 " + (advT) + "만큼 재생");
						result += (advT);
					} else {
						System.out.println((i+1) + "번에서 시작한 광고가 " + (end[j] - start[j]) + "만큼 재생");
						result += (end[j] - start[j]);
					}
				}
			}
			MAX[i] = result;
		}
		
		advStart = 0; // 광고 시작하는 시간
		advEnd = advStart + advT; // 광고 끝나는 시간
		result = 0;
		for(int j = 0; j < logs.length; j++) {
			if(advEnd <= end[j]) {
				result += advEnd - start[j];
				System.out.println("00:00에 시작한 광고가 " + (j+1) + "번과 겹쳐서 " + (advEnd - start[j]) + "만큼 재생");
			} else {
				result += end[j] - start[j];
				System.out.println("00:00에 시작한 광고가 " + (j+1) + "번과 겹쳐서 " + (end[j] - start[j]) + "만큼 재생");
			}
		}
		MAX[logs.length] = result;
		
		System.out.println(Arrays.toString(MAX));
		
		int[] indexArr = new int[logs.length + 1];
		int idx = 0;
		
		int Maximum = 0;
		int index = 0;
		for(int i = 0; i < MAX.length; i++) {
			Maximum = Math.max(MAX[i], Maximum);
		}
		
		for(int i = 0; i < MAX.length; i++) {
			if(MAX[i] == Maximum) {
				System.out.println("max : " + i);
				indexArr[i] = i;
		}
			
		}
		
		System.out.println(Maximum);
		
		long maxBigyo = Integer.MAX_VALUE;
		long startTimeBigyo = 0;
		for(int i = 0; i < indexArr.length; i++) {
			System.out.println("indexArr : " + indexArr[i]);
			if(indexArr[i] != 0) {
				if(i == indexArr.length - 1) {
					startTimeBigyo = 0;
				} else {
					startTimeBigyo = start[indexArr[i]];
				}
				if(startTimeBigyo < maxBigyo) {
					maxBigyo = startTimeBigyo;
				}
			}
		}
		long resultTime = maxBigyo;
		long resultHour = resultTime / 3600;
		resultTime -= resultHour * 3600;
		long resultMin = resultTime / 60;
		resultTime -= resultMin * 60;
		long resultSec = resultTime;
		
		String resultMent = "";
		
		if(resultHour < 10) {
			resultMent += "0" + Long.toString(resultHour) + ":";
		} else {
			resultMent += Long.toString(resultHour) + ":";
		}
		if(resultMin < 10) {
			resultMent += "0" + Long.toString(resultMin) + ":";
		} else {
			resultMent += Long.toString(resultMin) + ":";
		}
		if(resultSec < 10) {
			resultMent += "0" + Long.toString(resultSec);
		} else {
			resultMent += Long.toString(resultSec);
		}
		
		System.out.println(resultMent);
	}

}
