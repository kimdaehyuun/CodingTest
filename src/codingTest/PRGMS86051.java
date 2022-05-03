// 프로그래머스 없는 숫자 더하기

package codingTest;

class PRGMS86051 {
    public int solution(int[] numbers) {
        int answer = -1;
        int[] line = new int[10];
        for (int i = 0; i < 10; i++) {
            line[i] = 0;
        }
        int num = 0;
        int sum = 0;
        
        for (int i = 0; i < numbers.length; i++) {
            num = numbers[i];
            line[num] = 1;
        }
        
        for (int i = 0; i < 10; i++) {
            if (line[i] == 0) {
                sum += i;
            }
        }
        answer = sum;
        return answer;
    }
}