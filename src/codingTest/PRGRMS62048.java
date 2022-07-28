// 프로그래머스 62048번 멀쩡한 사각형 https://school.programmers.co.kr/learn/courses/30/lessons/62048

package codingTest;

public class PRGRMS62048 {
	public static int w = 8;
	public static int h = 12;
	public static void main(String[] args) {
		int min = (w < h) ? w : h;
		int gcd = 0;
		for(int i = 1; i <= min; i++) {
			if(w % i == 0 && h % i == 0) {
				gcd = i;
			}
		}
		
		double banbokX = w / gcd;
		double banbokY = h / gcd;
		double tempY = banbokY;
		long answerCnt = 0;
		long cntLong = 0;
        long cnt = 0;
		
		for(int i = 1; i <= (int)banbokX; i++) {
			double y = banbokY - (banbokY / banbokX) * i;
            if(i == 1) {
                cnt = Long.valueOf((int)tempY - (int)y);
            } else {
                cnt = Long.valueOf((int)tempY - (int)y + 1);
            }
			tempY = y;
			answerCnt += cnt;
		}
		long banbokTotalCnt = (long)answerCnt * gcd;
		long totalCnt = (long)w * h;
		long result = (long)totalCnt - banbokTotalCnt;
		
		System.out.println(result);
	}

}
