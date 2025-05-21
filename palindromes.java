import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class palindromes {
    public static String getText() {
        // scanner for user input; the scanner is never closed so that the program is repeatable
        Scanner palindromeScanner = new Scanner(System.in);

        System.out.print("\nEnter the word you would like to test for palindromicity! \n\n");
        String text = palindromeScanner.nextLine();
        return text;
    }

    public static ArrayList<Character> sanitizeString(String text) {
        // turn the text to lowercase to make the comparison case insensitive
        text = text.toLowerCase();

        // put each character into an array using an array list; a static array would not work because the size would be immuatable
        // the for loop iterates over each character, and only inserts the character into the array if it is either a letter or digit. this gets rid of both whitespace and punctation. the string was already converted to lowercase earlier with the toLowerCase() function, so the case of the letters is not a concern
        ArrayList<Character> textArr = new ArrayList<>();
        for (char c : text.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                textArr.add(c);
            }
        }

        return textArr;
    }

    public static Stack<Character> charStack(ArrayList<Character> text) {
        // put all characters of the (now sanitized) stack. the stack produces the an array of the characters of the string in reverse form, as it is last in, first out. this means when the stack is popped later and added to a string, it will start at the end of the array, i.e. the last letter/digit in the user's string
        Stack<Character> stack = new Stack<>();
        for (char c : text) {
            stack.push(c);
        }
        return stack;
    }

    public static Queue<Character> charQueue(ArrayList<Character> text) {
        // also puts all of the characters into a data structure, this time a queue, which is first in, first out. so by adding the first character to the queue first, second chracter to the queue second, and so forth, when removing individual characters from the queue, it will start at the beginning, giving the original string without whitespace or punctuation
        Queue<Character> queue = new LinkedList<>();
        for (char c : text) {
            queue.add(c);
        }
        return queue;
    }

    public static boolean isPalindrome(Stack<Character> stack, Queue<Character> queue) {
        if (stack.size() == 0 && queue.size() == 0) {
            System.out.println("\nYou entered nothing, or entered a string solely comprised of symbols and whitespace. Try entering a word or sentence instead!");
            return false;
        }

        // get the size of the stack/queue for the for loop a few lines down. note that it does not matter whether stack.size() or queue.size() is used as they will always be identical in terms of length
        int length = stack.size();
        // can't use normal strings as the strings need to be dynamically added to; this kept tripping me up, coming from primarily doing stuff in JavaScript!!
        StringBuilder stackString = new StringBuilder();
        StringBuilder queueString = new StringBuilder();

        // this for loop created two strings: the string resulting from popping the stack, and the string resulting from removing elements from the queue. as stated earlier, the stack produces the reversed string as it starts at the last element and works backwards. the queue starts at the front of the line, meaning it simply creates the string that was input by the user, just having been cleaned of punctuation and whitespace
        for (int i = 0; i < length; i++) {
            stackString.append(stack.pop());
            queueString.append(queue.remove());
        }

        // this simply directly shows the user a comparison of the strings for visualization
        System.out.println("\n" + stackString + " is the reversed string, and " + queueString + " is the original.");

        // this checks whether or not the two strings are equal to one another. it returns true or false only after outputting the comparison of the two
        if (stackString.toString().equals(queueString.toString())) {
            System.out.println("" + stackString + " is identical to " + queueString);
            return true;
        } else {
            System.out.println("" + stackString + " is different from " + queueString);
            System.out.println("That is not a palindrome. Try something else!");
            return false;
        }
    }

    // recursive function which makes the program continuously run until it is terminated in the console
    public static void checkForPalindrome() {
        String text = getText();
        ArrayList<Character> sanitizedArr = sanitizeString(text);
        Stack<Character> stack = charStack(sanitizedArr);
        Queue<Character> queue = charQueue(sanitizedArr);
        boolean isPalindrome = isPalindrome(stack, queue);
        if (isPalindrome) {
            System.out.println("It's a palindrome!");
        }
        checkForPalindrome();
    }

    public static void main(String[] args) {
        checkForPalindrome();
    }
}