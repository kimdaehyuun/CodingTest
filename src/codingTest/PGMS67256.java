//프로그래머스 키패드 누르기

package codingTest;

class PGMS67256 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        String result = "";
        int LX = 0;
        int LY = 3;
        int RX = 2;
        int RY = 3;
        int Lcha = 0;
        int Rcha = 0;
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 1) {
                result += "L";
                LX = 0;
                LY = 0;
            } 
            else if(numbers[i] == 4) {
                result += "L";
                LX = 0;
                LY = 1;
            }
            else if(numbers[i] == 7) {
                result += "L";
                LX = 0;
                LY = 2;
            }
            else if(numbers[i] == 3) {
                result += "R";
                RX = 2;
                RY = 0;
            }
            else if(numbers[i] == 6) {
                result += "R";
                RX = 2;
                RY = 1;
            }
            else if(numbers[i] == 9) {
                result += "R";
                RX = 2;
                RY = 2;
            }
            else if(numbers[i] == 2) {
                Lcha = Math.abs(LX - 1) + Math.abs(LY - 0); // 왼손에서 거리
                Rcha = Math.abs(RX - 1) + Math.abs(RY - 0); // 오른손에서 거리
                // 왼손거리가 더 짧으면
                if(Lcha < Rcha) {
                    result += "L";
                    LX = 1;
                    LY = 0;
                } 
                // 오른손거리가 더 짧으면
                else if (Lcha > Rcha) {
                    result += "R";
                    RX = 1;
                    RY = 0;
                }
                // 거리가 같으면 손잡이 대로
                else {
                    if(hand.indexOf("right") > -1){
                        result += "R";
                        RX = 1;
                        RY = 0;
                    } else {
                        result += "L";
                        LX = 1;
                        LY = 0;
                    }
                }
            }
            else if(numbers[i] == 5) {
                Lcha = Math.abs(LX - 1) + Math.abs(LY - 1); // 왼손에서 거리
                Rcha = Math.abs(RX - 1) + Math.abs(RY - 1); // 오른손에서 거리
                // 왼손거리가 더 짧으면
                if(Lcha < Rcha) {
                    result += "L";
                    LX = 1;
                    LY = 1;
                } 
                // 오른손거리가 더 짧으면
                else if (Lcha > Rcha) {
                    result += "R";
                    RX = 1;
                    RY = 1;
                }
                // 거리가 같으면 손잡이 대로
                else {
                    if(hand.indexOf("right") > -1){
                        result += "R";
                        RX = 1;
                        RY = 1;
                    } else {
                        result += "L";
                        LX = 1;
                        LY = 1;
                    }
                }
            }
            else if(numbers[i] == 8) {
                Lcha = Math.abs(LX - 1) + Math.abs(LY - 2); // 왼손에서 거리
                Rcha = Math.abs(RX - 1) + Math.abs(RY - 2); // 오른손에서 거리
                // 왼손거리가 더 짧으면
                if(Lcha < Rcha) {
                    result += "L";
                    LX = 1;
                    LY = 2;
                } 
                // 오른손거리가 더 짧으면
                else if (Lcha > Rcha) {
                    result += "R";
                    RX = 1;
                    RY = 2;
                }
                // 거리가 같으면 손잡이 대로
                else {
                    if(hand.indexOf("right") > -1){
                        result += "R";
                        RX = 1;
                        RY = 2;
                    } else {
                        result += "L";
                        LX = 1;
                        LY = 2;
                    }
                }
            }
            else if(numbers[i] == 0) {
                Lcha = Math.abs(LX - 1) + Math.abs(LY - 3); // 왼손에서 거리
                Rcha = Math.abs(RX - 1) + Math.abs(RY - 3); // 오른손에서 거리
                // 왼손거리가 더 짧으면
                if(Lcha < Rcha) {
                    result += "L";
                    LX = 1;
                    LY = 3;
                } 
                // 오른손거리가 더 짧으면
                else if (Lcha > Rcha) {
                    result += "R";
                    RX = 1;
                    RY = 3;
                }
                // 거리가 같으면 손잡이 대로
                else {
                    if(hand.indexOf("right") > -1){
                        result += "R";
                        RX = 1;
                        RY = 3;
                    } else {
                        result += "L";
                        LX = 1;
                        LY = 3;
                    }
                }
            }
            
            
        }
        answer = result;
        return answer;
    }
}