// 프로그래머스 크레인 인형뽑기 게임
package codingTest;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int boardSize = board[0].length;
        int[] stack = new int[moves.length];
        int cnt = 0;
        int result = 0;
        
        for (int i = 0; i < moves.length; i++) {
            int loc = moves[i] - 1;
            for (int j = 0; j < boardSize; j++) {
                if (board[j][loc] != 0) {
                    // 더 깊숙히 들어가다가 인형을 발견
                    stack[cnt] = board[j][loc];
                    board[j][loc] = 0;
                    if (cnt >= 1) {
                        if (stack[cnt] == stack[cnt-1]) {
                            stack[cnt] = 0;
                            stack[cnt-1] = 0;
                            cnt = cnt - 2;
                            result = result + 2;
                        }
                    }
                    cnt++;
                    break;
                }
                
            }
        }
        answer = result;
        return answer;
    }
}