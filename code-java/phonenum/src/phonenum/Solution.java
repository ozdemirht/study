package phonenum;

import com.sun.applet2.AppletParameters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    static Map<Integer, List<Character>> digitMap = new HashMap<>();
    static {
        List<Character> values = new ArrayList<>();
        values.add('1');
        digitMap.put(1,values);

        values = new ArrayList<>();
        values.add('A'); values.add('B');values.add('C');
        digitMap.put(2,values);

        values = new ArrayList<>();
        values.add('D'); values.add('E');values.add('F');
        digitMap.put(3,values);

        values = new ArrayList<>();
        values.add('G'); values.add('H');values.add('I');
        digitMap.put(4,values);

        values = new ArrayList<>();
        values.add('J'); values.add('K');values.add('L');
        digitMap.put(5,values);

        values = new ArrayList<>();
        values.add('M'); values.add('N');values.add('O');
        digitMap.put(6,values);

        values = new ArrayList<>();
        values.add('P'); values.add('Q');values.add('R');values.add('S');
        digitMap.put(7,values);

        values = new ArrayList<>();
        values.add('T'); values.add('U');values.add('V');
        digitMap.put(8,values);

        values = new ArrayList<>();
        values.add('W'); values.add('X');values.add('Y');values.add('Z');
        digitMap.put(9,values);

    }
    public void solve(String phoneNumber,List<String> answer){
        generate(digitMap,phoneNumber,0,new char[phoneNumber.length()],answer);
    }

    void generate(Map<Integer, List<Character>> dmap, String phoneNumber,
                  int digit, char[] current, List<String> answer){
        if(digit>=phoneNumber.length())      // base case
            answer.add(new String(current)); // accumulate answers
        else {
            int cDigit = phoneNumber.charAt(digit) - '0'; // find key
            List<Character> options = dmap.get(cDigit); // get options
            for(int i=0;i<options.size();i++) {
                current[digit] = options.get(i);
                generate(dmap, phoneNumber, digit + 1, current, answer);
            }
        }
    }
}
