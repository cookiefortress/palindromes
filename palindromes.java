import java.util.Scanner;
import java.util.ArrayList;

public class palindromes {
    public static String getText() {
        Scanner palindromeScanner = new Scanner(System.in);

        System.out.print("Enter the word you would like to test for palindromicity! \n\n");
        String text = palindromeScanner.nextLine();
        System.out.println("\nAllow me to check if '" + text + "' is a palindrome...");
        palindromeScanner.close();
        return text;
    }

    public static ArrayList<Character> sanitizeString(String text) {
        ArrayList<Character> textArr = new ArrayList<>();
        for(char c : text.toCharArray()) {
            if(Character.isLetterOrDigit(c)) {
                textArr.add(c);
            }
        }
        return textArr;
    }

    public static ArrayList<Character> reverseArr(ArrayList<Character> textArr) {
        ArrayList<Character> reversedArray = new ArrayList<>();

        for (int i = 0; i < textArr.size(); i++) {
            reversedArray.add(textArr.get(textArr.size() - 1 - i));
        }

        return reversedArray;
    }

    public static String convertToString(ArrayList<Character> textArr) {
        StringBuilder sb = new StringBuilder();
        for (char ch : textArr) {
            sb.append(ch);
        }
        String result = sb.toString();
        return result;
    }

    public static void main(String[] args) {
        String text = getText();
        ArrayList<Character> sanitizedArr = sanitizeString(text);
        ArrayList<Character> reversedArr = reverseArr(sanitizedArr);
        String reversedText = convertToString(reversedArr);
        System.out.println(reversedText);
    }
}