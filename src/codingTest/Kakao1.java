// 2022 카카오 코딩테스트 - 카카오 성격 유형 검사지

package codingTest;

import java.util.HashMap;

public class Kakao1 {
	public static void main(String[] args) {
		String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
		int[] choices = {5, 3, 2, 7, 5};
		String result = "";
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("Rjumsu", 0);
		map.put("Tjumsu", 0);
		map.put("Cjumsu", 0);
		map.put("Fjumsu", 0);
		map.put("Jjumsu", 0);
		map.put("Mjumsu", 0);
		map.put("Ajumsu", 0);
		map.put("Njumsu", 0);
		
		for (int i = 0; i < choices.length; i++) {
			String[] split = survey[i].split("");
			String front = split[0];
			String back = split[1];
			String frontJumsu = front + "jumsu";
			String backJumsu = back + "jumsu";
			int originalJumsu = 0;
			
			if ( choices[i] - 4 > 0 ) { // 뒤에꺼 점수를 추가해야함
				originalJumsu = map.get(backJumsu);
				int sub = choices[i] - 4;
				originalJumsu += sub;
				map.replace(backJumsu, originalJumsu);
			} else if( choices[i] - 4 < 0 ) { // 앞에꺼 점수를 추가해야함
				originalJumsu = map.get(frontJumsu);
				int sub = 4 - choices[i];
				originalJumsu += sub;
				map.replace(frontJumsu, originalJumsu);
			}
		}
		result += (map.get("Rjumsu") >= map.get("Tjumsu")) ? "R" : "T";
		result += (map.get("Cjumsu") >= map.get("Fjumsu")) ? "C" : "F";
		result += (map.get("Jjumsu") >= map.get("Mjumsu")) ? "J" : "M";
		result += (map.get("Ajumsu") >= map.get("Njumsu")) ? "A" : "N";
		
		System.out.println(result);
	}

}
