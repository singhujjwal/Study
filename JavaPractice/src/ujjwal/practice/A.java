package ujjwal.practice;

import java.io.IOException;

public class A {

    public static String binaryAddition(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int first = s1.length()-1;
        int second = s2.length()-1;
        
        int carry = 0;
        while(first >= 0 || second >= 0){
            int sum = carry;
            
            if(first >= 0){
                sum += s1.charAt(first) - '0';
                first--;
            }
            
            if (second >= 0) {
                sum += s2.charAt(second) - '0';
                second--;
            }
            carry = sum >> 1;
            sum = sum & 1;
            sb.append(sum == 0 ? '0' : '1');
        }
        if(carry == 1){
            sb.append("1");
        }

        return sb.reverse().toString();
    }

    /*
     * Method to subtract s2 from s1 return negative/positive whatever
     * 
     * 1100 - 10
     */
    public String binarySubtraction(String s1, String s2) {

        if (s1 == null || s2 == null) {
            System.out.println("Cant subtract");
            return "";
        }

        return null;
    }

    public static void main(String[] args) throws IOException {
        String result = binaryAddition("1010", "10");
        System.out.println(result);
        System.out.println("Decimal equivalent " + Integer.parseInt(result, 2));
    }

}