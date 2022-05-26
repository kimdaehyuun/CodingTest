// https://programmers.co.kr/learn/courses/10302/lessons/62947

package codingTest;

import java.util.Arrays;
class PRGMS62947 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        // int temp = 0;
        // int count = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int numA = 0;
        int numB = 0;
        
        for(int i = 0; i < A.length; i++) {
            if (A[numA] < B[numB]) {
                numA++;
                numB++;
                answer++;
            } else {
                numB++;
            }
        }
        
        // for (int i = 0; i < A.length; i++) {
        //     for (int j = 0; j < B.length; j++) {
        //         if (B[j] != 0 && B[j] > A[i]) {
        //             // temp = B[j];
        //             // B[j] = B[i];
        //             // B[i] = temp;
        //             B[j] = 0;
        //             count++;
        //             // Arrays.sort(B, i+1, B.length);
        //             break;
        //         }
        //     }
        // }
        // answer = count;
        
        return answer;
    }
}