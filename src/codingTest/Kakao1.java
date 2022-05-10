// 2022 카카오 코딩테스트 - 카카오 성격 유형 검사지

package codingTest;

public class Kakao1 {
	public static void main(String[] args) {
		String[] survey = {"TR", "RT", "RT"};
		int[] choices = {7, 1, 3};
		String result = "";
		
		int Rjumsu = 0;
		int Tjumsu = 0;
		int Cjumsu = 0;
		int Fjumsu = 0;
		int Jjumsu = 0;
		int Mjumsu = 0;
		int Ajumsu = 0;
		int Njumsu = 0;
		
		for (int i = 0; i < choices.length; i++) {
			String[] split = survey[i].split("");
			String front = split[0];
			String back = split[1];
			if ( choices[i] - 4 > 0 ) { // 뒤에꺼 점수를 추가해야함
				switch(back) {
				case "R":
					Rjumsu += choices[i] - 4;
					break;
				case "T":
					Tjumsu += choices[i] - 4;
					break;
				case "C":
					Cjumsu += choices[i] - 4;
					break;
				case "F":
					Fjumsu += choices[i] - 4;
					break;
				case "J":
					Jjumsu += choices[i] - 4;
					break;
				case "M":
					Mjumsu += choices[i] - 4;
					break;
				case "A":
					Ajumsu += choices[i] - 4;
					break;
				case "N":
					Njumsu += choices[i] - 4;
					break;
				}
			} else if( choices[i] - 4 < 0 ) { // 앞에꺼 점수를 추가해야함
				switch(front) {
				case "R":
					Rjumsu += 4 - choices[i];
					break;
				case "T":
					Tjumsu += 4 - choices[i];
					break;
				case "C":
					Cjumsu += 4 - choices[i];
					break;
				case "F":
					Fjumsu += 4 - choices[i];
					break;
				case "J":
					Jjumsu += 4 - choices[i];
					break;
				case "M":
					Mjumsu += 4 - choices[i];
					break;
				case "A":
					Ajumsu += 4 - choices[i];
					break;
				case "N":
					Njumsu += 4 - choices[i];
					break;
				}
			}
		}
		
		if (Rjumsu > Tjumsu) {
			result += "R";
		} else if (Rjumsu < Tjumsu) {
			result += "T";
		} else {
			result += "R";
		}
		
		if (Cjumsu > Fjumsu) {
			result += "C";
		} else if (Cjumsu < Fjumsu) {
			result += "F";
		} else {
			result += "C";
		}
		
		if (Jjumsu > Mjumsu) {
			result += "J";
		} else if (Jjumsu < Mjumsu) {
			result += "M";
		} else {
			result += "J";
		}
		
		if (Ajumsu > Njumsu) {
			result += "A";
		} else if (Ajumsu < Njumsu) {
			result += "N";
		} else {
			result += "A";
		}
		
		System.out.println(result);
		
	}
	

}
