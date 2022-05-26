package codingTest;
import java.util.Arrays;

public class Kakao3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker";
		String C = "Example";
		
		String[] str = S.split(", ");
        String first;
        String middle;
        String last;
        String email;
        String[] emailStr = new String[1000];
        int peopleCnt = str.length;
        for (int i = 0; i < str.length; i++) {
            String[] name = str[i].split(" ");
            if (name.length > 2) { // 중간 이름이 있는거
                first = name[0];
                first = first.substring(0,1).toLowerCase();
                middle = name[1];
                middle = middle.substring(0,1).toLowerCase();
                last = name[2];
                last = last.replace("-","").toLowerCase();
                if ( last.length() > 8 ) {
                	last = last.substring(0,8);
                }
                email = first + middle + last + "@" + C.toLowerCase() + ".com";
            } else {
                first = name[0];
                first = first.substring(0,1).toLowerCase();
                last = name[1];
                last = last.replace("-","").toLowerCase();
                if ( last.length() > 8 ) {
                	last = last.substring(0,8);
                }
                email = first + last + "@" + C.toLowerCase() + ".com";
            }
            emailStr[i] = email;
        }
        
        for (int i = 0; i < peopleCnt; i++) {
        	int count = 1;
        	for (int j = 0; j < peopleCnt; j++) {
        		if (i == j) {
        			continue;
        		}
        		if ( emailStr[i].equals(emailStr[j]) ) {
        			count++;
        			int golbang = emailStr[j].indexOf("@");
        			emailStr[j] = emailStr[j].substring(0,golbang) +
        					Integer.toString(count) + "@" + emailStr[j].substring(golbang + 1);
        		}
        	}
        }
        
//        System.out.println(Arrays.toString(emailStr));
        
        String result = "";
        for (int i = 0; i <= peopleCnt-2; i++) {
            result += str[i] + " <";
            result += emailStr[i];
            result += ">, ";
        }
        result += str[peopleCnt-1] + " <";
        result += emailStr[peopleCnt-1];
        result += ">";
        System.out.println(result);

	}

}
