package me.practice;

public class LowerCase {

    public static void main(String[] args) {
        String input = "1HELLO-.";
        String ans = toLowerCase(input);
        System.out.println(ans);
    }

    private static String toLowerCase(String input) {
        if (input == null || input.isBlank())
            return input;
        char[] lowerCaseChars = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 97 || !Character.isAlphabetic(input.charAt(i))) {
                lowerCaseChars[i] = input.charAt(i);
            } else {
                lowerCaseChars[i] = (char) (input.charAt(i) + 32);
            }
        }
        return new String(lowerCaseChars);
    }


}
