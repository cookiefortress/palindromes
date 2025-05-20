import java.util.Scanner;

public class palindromes {
    public static void main(String[] args) {
        Scanner palindromeScanner = new Scanner(System.in);

        System.out.print("Enter the word you would like to test for palindromicity! \n\n");
        String text = palindromeScanner.nextLine(); // Program waits here for input

        System.out.println("\nAllow me to check if '" + text + "' is a palindrome...");

        palindromeScanner.close();
    }
}