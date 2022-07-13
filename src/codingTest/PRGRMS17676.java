// 프로그래머스 17676번 추석 트래픽 https://school.programmers.co.kr/learn/courses/30/lessons/17676

package codingTest;

public class PRGRMS17676 {
//	public static String[] lines = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};
	public static String[] lines = {"2016-09-15 20:59:57.421 0.351s",
			"2016-09-15 20:59:58.233 1.181s",
			"2016-09-15 20:59:58.299 0.8s",
			"2016-09-15 20:59:58.688 1.041s",
			"2016-09-15 20:59:59.591 1.412s",
			"2016-09-15 21:00:00.464 1.466s",
			"2016-09-15 21:00:00.741 1.581s",
			"2016-09-15 21:00:00.748 2.31s",
			"2016-09-15 21:00:00.966 0.381s",
			"2016-09-15 21:00:02.066 2.62s"};
	public static void main(String[] args){
		
		double[] times = new double[lines.length];
		double[] run = new double[lines.length];
		
		for(int i = 0; i < lines.length; i++) {
			String[] split = lines[i].split(" ");
			String[] aa = split[1].split(":");
			
			double hour = Double.parseDouble(aa[0]) * 3600;
			double min = Double.parseDouble(aa[1]) * 60;
			double sec = Double.parseDouble(aa[2]);
			
			times[i] = hour + min + sec;
			run[i] = Double.parseDouble(split[2].replace("s", ""));
		}
		int[] MAX = new int[lines.length];
		for(int i=0; i<lines.length; i++) {
			double start = times[i];
			int cnt = 0;
			for(int j=i+1; j<lines.length; j++) {
				double end = times[j] - (run[j] - 0.0001);
				double mid = end - start;
				if(mid <= 0.999) {
					cnt++;
				}
			}
			MAX[i] = cnt + 1;
		}
		int Maximum = 0;
		for(int i = 0; i < MAX.length; i++) {
			if(MAX[i] > Maximum) {
				Maximum = MAX[i];
			}
		}
		
		System.out.println("답 : " + Maximum);
	}

}
