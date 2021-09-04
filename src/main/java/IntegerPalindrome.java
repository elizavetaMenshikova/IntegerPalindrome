//4. Integer Palindrome
//This is generally asked as follow-up or alternative of the previous program.
// This time you need to check if given Integer is palindrome or not.
// An integer is called palindrome if it's equal to its reverse, e.g. 1001 is a palindrome,
// but 1234 is not because the reverse of 1234 is 4321 which is not equal to 1234.
// You can use divide by 10 to reduce the number and modulus 10 to get the last digit.
// This trick is used to solve this problem.

import java.util.Scanner;

public class IntegerPalindrome {


    public static void main(String[] args) {
        System.out.println("Введите число: ");
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println(number);
        int[] separatedNumber = toArray(number);
        System.out.println(isPalindrome(separatedNumber));
    }

    public static boolean isPalindrome(int[] separatedNumber) {
        for (int i = 0, j = separatedNumber.length - 1; i < separatedNumber.length/2; i++, j--) {
            if (separatedNumber[i] != separatedNumber[j]) {
                return false;
            }
        }
        return true;
    }

    public static int lengthOf(int number) {
        int length = 0;
        int temp = 1;
        while (temp <= number) {
            length++;
            temp *= 10;
        }
        return length;
    }

    public static int[] toArray(int number) {
        int numberLength = lengthOf(number);
        int[] separatedNumber = new int[numberLength];
        int tempLength = numberLength;
        for (int i = 0; i < numberLength; i++) {
            int divider = raceTenToPower(tempLength - 1);
            //1234 / 1000 = 1
            separatedNumber[i] = number / divider;
            //1234 % 1000 = 234
            number = number % divider;
            tempLength--;
        }
        return separatedNumber;
    }

    public static int raceTenToPower(int power) {
        int raisedNumber = 1;
        while (power > 0) {
            raisedNumber *= 10;
            power--;
        }
        return raisedNumber;
    }
}
