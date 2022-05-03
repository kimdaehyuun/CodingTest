// 프로그래머스 음양 더하기

package codingTest;

class PRGMS76501 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 123456789;
        int sum = 0;
        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i] == true) {
                sum += absolutes[i];
            } else {
                sum -= absolutes[i];
            }
        }
        answer = sum;
        return answer;
    }
}