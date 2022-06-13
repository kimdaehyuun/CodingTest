package codingTest;

import java.util.*;

public class SSG1 {
	
	static HashMap<String, String> map;
	static ArrayList<ArrayList<String>> list;

	public static void main(String[] args) {
		
		String[] logs = {"0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95",
						 "0001 7 80", "0001 8 80", "0001 10 90", "0002 10 90",
					 	 "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90"};
//		String[] logs = {"1901 10 50", "1909 10 50"};
		
		System.out.println("정답 : " + Arrays.toString(solution(logs)));

	}

	private static String[] solution(String[] logs) {
		ArrayList<String> result = new ArrayList<String>();
		
		// 일단 각 사람별로 구분하기 위해 map 생성
		map = new HashMap<String, String>();
		// 각 사람별로 어떤 문제에 몇점을 받았는지 정렬하기 위해 arraylist안에 arraylist를 넣는
		// 2차원 arraylist 생성
		list = new ArrayList<ArrayList<String>>();
		List<String> list2 = new ArrayList<String>(); 
		// 사람별 구분을 위한 map에 값 입력
		for(String s : logs) {
			String[] str = s.split(" ");
			map.put(str[0], str[1]);
		}
		// map은 key가 중복되면 value를 덮어쓰기때문에 어떤 사람들이 문제를 풀었는지 확인 가능
		for(String key : map.keySet()) {
			System.out.println("key : " + key + " value : " + map.get(key));
		}
		// 사람 수 만큼 arraylist 속에 arraylist를 여러개 만들어준다
		for(int i=0; i<map.size(); i++) {
			list.add(new ArrayList<String>());
		}
		
		int cnt = 0;
		// map에서의 수험번호를 for문을 돌려서 각 사람들마다 순회
		for(String key : map.keySet()) {
			// cnt를 0부터 시작하므로 첫번째 사람부터, 즉 첫번째 arraylist부터 시작하고
			// 값은 우선 key값 즉 수험번호를 해당 arraylist의 맨 처음에 넣고 시작한다
			list.get(cnt).add(key);
			// log 배열을 순회해서 예를 들어 0001이라는 수험번호를 가지고있는 사람이 어떻게되는지 순회
			for(int j=0; j<logs.length; j++) {
				String[] str2 = logs[j].split(" ");
				// log 배열에서 해당 수험번호를 가지고있는 사람을 발견했다면
				if(str2[0].equals(key)) {
					// 만약 arraylist에 실려있는 점수값이라면 즉, 이미 풀었던 문제를 또 푼거라면
					// 해당 arraylist에서 새 점수로 교체를 해준다.
					if(list.get(cnt).contains(str2[1])) {
						list.get(cnt).set(list.get(cnt).indexOf(str2[1])+1, str2[2]);
					}else {
						// 만약 아직 arraylist에 실리지않은 점수 값이라면 해당 arraylist에
						// 해당 문제 번호와 점수값을 add해준다.
						list.get(cnt).add(str2[1]);
						list.get(cnt).add(str2[2]);
					}
				}
			}
			cnt++;
		}
		
		System.out.println(list);
		
		int n = 1;
		for(int i=0; i<list.size()-1; i++) {
			for(int j=i+1; j<list.size(); j++) {
				// arraylist list에서 2개씩 비교하기위해 2중 for문 생성
				// 우선 푼 문제가 5 미만인 경우는 제외해야하므로 해당 arraylist 크기가 10을 넘어야함.
				if(list.get(i).size() > 10 && list.get(j).size() > 10) {
					// 그리고 푼 문제의 수가 같아야하므로 둘의 사이즈가 같아야함.
					if(list.get(i).size() == list.get(j).size()) {
						System.out.println(check(i, j));
						// check 메소드를 돌렸을때 true가 반환됐다면 해당 부정행위 조건을 모두 만족한거
						if(check(i, j)) {
							System.out.println("list "+list.get(i).get(0));
							list2.add(list.get(i).get(0));
							list2.add(list.get(j).get(0));
						}
					}
				}
			}
			
		}
		// list2 arraylist가 비어있다는건 부정행위 검출을 아무도 못했다는것이므로 none을 add
		if (list2.size() == 0) {
			list2.add("None");
		}
		
		String[] resultArr = new String[list2.size()];
		int arrSize = 0;
		for (String temp : list2) {
			resultArr[arrSize++] = temp;
		}
		
		return resultArr;
	}
	// 인덱스1번째 arraylist와 인덱스2번째 arraylist를 비교하는 메소드
	private static boolean check(int index1, int index2) {
		boolean answer = false;
		Map<String, String> map1 = new HashMap<String, String>();
		Map<String, String> map2 = new HashMap<String, String>();
		// 해당 사람이 푼 문제수까지 for문을 돌린다.
		for(int i=1; i<list.get(index1).size()-1; i+=2) {
			// 인덱스1번째 사람의 arraylist에서 특정 문제번호와 그 문제의 점수를 map에 입력
			map1.put(list.get(index1).get(i), list.get(index1).get(i+1));
			// 인덱스2번째 사람의 arraylist에서 특정 문제번호와 그 문제의 점수를 map에 입력
			map2.put(list.get(index2).get(i), list.get(index2).get(i+1));
		}
		int score = 0;
		int cnt = 0;
		for(String key : map1.keySet()) {
			// map1을 순회하며 해당 key값이 map2에서도 그 key를 가지고있다면 cnt 점점 증가
			// 이건 A사람 B사람이 푼 문제번호가 같은지 확인하는 과정
			if(map2.containsKey(key)) {
				cnt++;
			}
			// 이건 둘의 푼 문제번호가 같았을 경우, 그 문제 점수들도 같은지 보는 과정
			if(map1.get(key).equals(map2.get(key))) {
				score++;
			}
			// 부정행위인지 검출하려면 cnt와 score 모두 푼 문제 숫자만큼 채워져야 true로 반환됨
		}
		
		if(cnt == map1.size() && score == map1.size()) {
			answer = true;
		}
		
		System.out.println("score : " + score + " cnt : " + cnt + " size : " + map1.size());
		
		return answer;
	}
}