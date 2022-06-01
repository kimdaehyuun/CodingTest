// 프로그래머스 42888번 문제 https://programmers.co.kr/learn/courses/30/lessons/42888

package codingTest;

import java.util.HashMap;
class PRGRMS42888 {
    public String[] solution(String[] record) {

        int count = 0;
        
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < record.length; i++) {
            String[] sen = record[i].split(" ");
            String order = sen[0];
            String id = sen[1];
            String nick = "";
            if (sen.length > 2) {
                nick = sen[2];
            }
            switch(order) {
                case "Enter":
                    if(map.containsKey(id)) {
                        map.replace(id, nick);
                    } else {
                        map.put(id, nick);
                    }
                    count++;
                break;
                case "Leave":
                    count++;
                break;
                case "Change":
                    map.replace(id, nick);
                break;
            }
        }
        String[] answer = new String[count];
        int cnt = 0;
        for (int i = 0; i < record.length; i++) {
            String[] sen = record[i].split(" ");
            String order = sen[0];
            String id = sen[1];
            String nick = map.get(id);
            if(order.equals("Enter")) {
                answer[cnt] = nick + "님이 들어왔습니다.";
                cnt++;
            } else if (order.equals("Leave")) {
                answer[cnt] = nick + "님이 나갔습니다.";
                cnt++;
            }
        }
        return answer;
    }
}