// 2022 하반기 카카오 블라인드 코딩테스트 문제

package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Kakao0928 {
//	public static String today = "2022.05.19";
//	public static String[] terms = {"A 6", "B 12", "C 3"};
//	public static String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
	public static String today = "2020.01.01";
	public static String[] terms = {"Z 3", "D 5"};
	public static String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.20 Z"};
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		ArrayList<Integer> list = new ArrayList<>();
		String[] todayArr = today.split("\\.");
		int todayYear = Integer.parseInt(todayArr[0]); // 오늘의 연도
		int todayMonth = Integer.parseInt(todayArr[1]); // 오늘의 월
		int todayDay = Integer.parseInt(todayArr[2]); // 오늘의 일
		for(int i = 0; i < terms.length; i++) {
			String[] arr = terms[i].split(" ");
			String term = arr[0]; // 약관명
			int time = Integer.parseInt(arr[1]); // 약관 유효기간
			map.put(term, time); // Map에 약관별로 유효기간 어느정도인지 저장
		}
		// 해당 약관 유효기간 정보 담겨있는 map 로그찍기
		for(String key : map.keySet()) {
			Integer value = map.get(key);
		}
		
		for(int i = 0; i < privacies.length; i++) {
			String[] arr = privacies[i].split(" ");
			String startYear = arr[0]; // 약관 시작 날짜
			String term = arr[1]; // 약관명
			int gigan = map.get(term); // 해당 약관명이 어떤 유효기간을 가지고있는지 체크
			String[] yearArr = startYear.split("\\.");
			int year = Integer.parseInt(yearArr[0]); // 약관 시간날짜 연도
			int month = Integer.parseInt(yearArr[1]); // 약관 시간날짜 월
			int day = Integer.parseInt(yearArr[2]); // 약관 시간날짜 일
			// 우선 해당 개월수만큼 늘려줘야하는데 연도가 바뀌는 작업을 해줘야함
			if(month + gigan > 12) {
				// 근데 2년, 3년 이렇게 돌수도 있으니까 12로 나눠주고 나온 몫만큼 연도를 더해준다
				year += (month+gigan)/12;
				month = month + gigan - 12*((month+gigan)/12);
			} else {
				month = month + gigan;
			}
			// 일에서 1일을 빼서 생각해야한다. 근데 1일의 전날은 28일로 생각.
			if(day == 1) {
				if(month == 1) {
					year -= 1;
					month = 12;
				} else {
					month -= 1;
				}
				day = 28;
			} else {
				day -= 1;
			}
			// 여기까지 데드라인을 구했다. year, month, day에 해당 약관의 데드라인이 들어가있다.
			if(todayYear > year) {
				list.add(i+1);
			}
			else if(todayYear == year) {
				if(todayMonth > month) {
					list.add(i+1);
				}
				else if(todayMonth == month) {
					if(todayDay > day) {
						list.add(i+1);
					}
				}
			}
		}
		System.out.println("정답은!");
		System.out.println(list);
	}

}
