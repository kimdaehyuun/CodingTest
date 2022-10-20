package codingTest;

import java.util.Arrays;

public class KakaoBlind3 {
//	public static String[] users = {"40,10000", "25,10000"};
//	public static String[] emoticons = {"7000", "9000"};
	public static String[] users = {"40,2900","23,10000","11,5200","5,5900","40,3100","27,9200","32,6900"};
	public static String[] emoticons = {"1300", "1500","1600","4900"};
			
	public static boolean[] bool = new boolean[emoticons.length];
	public static int[] arr = new int[emoticons.length];
	public static int totalService = 0;
	public static int totalSum = 0;
	public static int MAX = 0;
	public static int MAX_A = 0;
	public static void main(String[] args) {
		Arrays.fill(bool, false);
		recursion(0);
		
		System.out.println("totalService : " + MAX + ", totalSum : " + MAX_A);
	}
	
	public static void recursion(int K) {
		if(K == emoticons.length) {
			for(int i = 0; i < users.length; i++) {
				System.out.println(i+1 + "번째 사람============================================");
				String[] split = users[i].split(",");
				int percent = Integer.parseInt(split[0]);
				int price = Integer.parseInt(split[1]);
				int total = 0;
				System.out.println("이때 할인 적용 어떻게 됐는지");
				System.out.println(Arrays.toString(arr));
				for(int j = 0; j < arr.length; j++) {
					if(arr[j] >= percent) {
						System.out.println((j+1) + "번째 " + arr[j] + " 가 percent보다 크거나 같으니까 -> " + percent);
						total += Integer.parseInt(emoticons[j]) * (100 - arr[j]) / 100;
						System.out.println("정가 : " + emoticons[j] + ", 할인적용가 : "
						+Integer.parseInt(emoticons[j]) * (100 - arr[j]) / 100 + ", 총 할인 적용가 : " + total);
					}
				}
				System.out.println("할인 적용된 최종 가격 : " + total);
				if(total >= price) {
					totalService++;
					System.out.println("멤버십 인원이 추가!!");
				} else if(total < price && total != 0) {
					totalSum += total;
					System.out.println("매출만 증가!!!");
				}
			}
			System.out.println("이때의 증가한 멤버십 인원수 : " + totalService + ", 증가한 매출액 : " + totalSum);
			if(totalService > MAX) {
				MAX = totalService;
				System.out.println("$$$$$$$$$$멤버십 인원 추가 : " + MAX);
				MAX_A = totalSum;
			} else if (totalService == MAX) {
				if(totalSum > MAX_A) {
					MAX_A = totalSum;
					System.out.println("$$$$$$$$멤버십 인원은 같은데 매출 증가 : " + MAX_A);
				}
			}
			
			totalService = 0;
			totalSum = 0;
			System.out.println();
		}
		for(int i = K; i < emoticons.length; i++) {
			if(!bool[i]) {
				for(int j = 10; j <= 40; j = j + 10) {
					arr[i] = j;
					bool[i] = true;
					recursion(K + 1);
					bool[i] = false;
				}
			}
		}
	}
}
