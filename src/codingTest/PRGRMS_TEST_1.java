package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PRGRMS_TEST_1 {
	public static String X = "100";
	public static String Y = "203045";
	public static void main(String[] args) {
		// 우선 문자열을 배열화 시켜주기
		String[] arrX = X.split("");
		String[] arrY = Y.split("");
		// 베열을 ArrayList화 시켜주기
		ArrayList<String> listX = new ArrayList<>(Arrays.asList(arrX));
		ArrayList<String> listY = new ArrayList<>(Arrays.asList(arrY));
;		// ArrayList에서 Set으로 중복을 제거한 값을 알아낸다
		Set<String> setX = new HashSet<String>(listX);
		// Map을 선언해서 어떤 숫자가 몇개씩 담겨있는지 담을것이다
		HashMap<String, Integer> mapX = new HashMap<String, Integer>();
		for(String str : setX) {
			// Map에는 어떤 숫자가 얼마나 자주 나오는지에 대하여 저장한다
			mapX.put(str, Collections.frequency(listX, str));
		}
		// 앞과 모두 동일함
		Set<String> setY = new HashSet<String>(listY);
		HashMap<String, Integer> mapY = new HashMap<String, Integer>();
		for(String str : setY) {
			mapY.put(str, Collections.frequency(listY, str));
		}
		int chkX;
		int chkY;
		
		String result = "";
		// result 문자열에는 높은 숫자부터 담겨야하므로 9부터 1까지 반복문 진행
		for(int i = 9; i >= 0; i--) {
			// from Int to String
			String to = Integer.toString(i);
			if(mapX.get(to) == null) {
				chkX = 0;
			} else {
				chkX = mapX.get(to);
			}
			
			if(mapY.get(to) == null) {
				chkY = 0;
			} else {
				chkY = mapY.get(to);
			}
			// 양쪽에서 모두 그 숫자를 가지고 있어야한다
			if(chkX != 0 && chkY != 0) {
				// 겹치는게 0만 있을때는 0 하나만 추가
				if(i == 0 && result == "") {
					result += to;
					break;
				}
				// 가지고 있는 개수가 더 적은쪽으로 result에 추가해준다
				if(chkX >= chkY) {
					for(int j = 0; j < chkY; j++) {
						result += to;
					}
				}
				else {
					for(int j = 0; j < chkX; j++) {
						result += to;
					}
				}
			}
		}
		if(result == "") {
			result = "-1";
		}
		System.out.println("정답 : " + result);
	}

}
