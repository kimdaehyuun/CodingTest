package codingTest;

import java.util.*;

public class PRGMS42862 {
	public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        int answer = 0;
        int numA = 0;
        int numB = 0;
        int numC = 0;
        int[] line = new int[n]; // 각자 체육복을 가지고있는 개수를 저장할 배열
        for (int i = 0; i < n; i++) {
            line[i] = 1; // 1번부터 n번까지 모두 원래는 1개씩 체육복이 있다.
        }
        // 체육복이 여벌로 있는 학생들은 체육복을 1개씩 증가시켜준다.
        for (int i = 0; i < reserve.length; i++) {
            numA = reserve[i];
            line[numA-1] += 1;
        }
        
        for (int i = 0; i < lost.length; i++) {
            numC = lost[i];
            line[numC-1] -= 1;
        }
        
        
        for (int i = 0; i < reserve.length; i++) {
            numA = reserve[i];
            for (int j = 0; j < lost.length; j++) {
                // 만약 잃어버린 학생들 중 아직 체육복이 없으면서
                // 여분 체육복이 있는 학생과 맞닿은 번호를 가진 학생이 있다면
                if (line[ lost[j]-1 ] == 0 && line[numA-1] == 2 &&
                    (lost[j] == numA - 1 || lost[j] == numA + 1)) {
                    numB = lost[j]; // 여분 체육복을 받게될 도난당한 학생의 번호 변수에 저장
                    line[numA-1] -= 1; // 우선 여분 체육복을 가지고있던 학생꺼는 1개 차감
                    line[numB-1] += 1; // 여분 체육복 받은 학생은 1개 증가
                    break;
                } 
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (line[i] != 0) {
                answer += 1;
            }
        }
        
        return answer;
    }
}
