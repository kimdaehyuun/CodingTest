// 카카오 모빌리티 코딩테스트

package codingTest;

public class KakaoMobility {

	public static void main(String[] args) {
//		int[] arr = {3, 2, 1, 2, 3};
//		int[] arr = {7, -5, -5, -5, 7, -1, 7};
//		int[] arr = {1};
		int[] arr = {1,2,4,2,1,2,3,4,5,4,3,2,1};
		// 가장 긴 묶음부터 검사
		loop:
		for (int len = arr.length; len > 0; len--) {
			for (int start = 0; start + len <= arr.length; start++) {
				boolean chk = true;
				for (int i = 0; i < len/2; i++) {
					if (arr[start + i] != arr[start + len - (i + 1)]) {
						chk = false;
						break;
					}
				}
				if (chk) {
					System.out.println(len);
					break loop;
				}
			}
		}

	}

}
