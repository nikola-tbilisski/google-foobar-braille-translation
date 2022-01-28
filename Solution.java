import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
            System.out.println(convStringToBraille(bf.readLine()));
            //System.out.println(Charset.defaultCharset().displayName());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String convStringToBraille(String input) {
        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();

        Map<Character, String> brailleAlp = new HashMap<>();
        brailleAlp.put('a', "100000");
        brailleAlp.put('b', "110000");
        brailleAlp.put('c', "100100");
        brailleAlp.put('d', "100110");
        brailleAlp.put('e', "100010");
        brailleAlp.put('f', "110100");
        brailleAlp.put('g', "110110");
        brailleAlp.put('h', "110010");
        brailleAlp.put('i', "010100");
        brailleAlp.put('j', "010110");
        brailleAlp.put('k', "101000");
        brailleAlp.put('l', "111000");
        brailleAlp.put('m', "101100");
        brailleAlp.put('n', "101110");
        brailleAlp.put('o', "101010");
        brailleAlp.put('p', "111100");
        brailleAlp.put('q', "111110");
        brailleAlp.put('r', "111010");
        brailleAlp.put('s', "011100");
        brailleAlp.put('t', "011110");
        brailleAlp.put('u', "101001");
        brailleAlp.put('v', "111001");
        brailleAlp.put('w', "010111");
        brailleAlp.put('x', "101101");
        brailleAlp.put('y', "101111");
        brailleAlp.put('z', "101011");
        brailleAlp.put(' ', "000000");

        for (Character ch : chars) {
            for (Map.Entry<Character, String> alp : brailleAlp.entrySet()) {
                if (Character.isUpperCase(ch)) {
                    result.append("000001");
                    ch = Character.toLowerCase(ch);
                    if (ch.equals(alp.getKey())) {
                        result.append(alp.getValue());
                    }
                } else if (ch.equals(alp.getKey())) {
                    result.append(alp.getValue());
                }
            }
        }
        return result.toString();
    }
}
