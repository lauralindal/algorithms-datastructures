package erste_uebung;

import java.util.Scanner;

public class Main {

    public static int euklidOldIterative(int number1, int number2){
        if(number1==0){
            return number2;
        }
        else{
            while(number2 != number1){
                if(number1 > number2){
                    number1 = number1 - number2;
                }
                else{
                    number2 = number2- number1;
                }
            }
            return number1;
        }
    }

    public static int euklidOldRecursive(int number1, int number2){
        if(number2 == 0){
            return number1;
        }
        else if(number1 == 0){
            return number2;
        }
        else if(number1 > number2){
            return euklidOldRecursive(number1 - number2, number2);
        }
        else{
            return euklidOldRecursive(number1, number2 - number1);
        }
    }

    public static int euklidNewRecursive(int number1, int number2){
        if(number2 == 0){
            return number1;
        }
        else{
            return euklidNewRecursive(number2, number2%number1);
        }
    }

    public static int euklidNewIterative(int number1, int number2){
        while(number2 != 0){
            int r = number1 % number2;
            number1 = number2;
            number2 = r;
        }
        return number1;
    }

    public static void start(){
        String name;
        int choice;
        int number1;
        int number2;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Hello! What's your name?");
        name = keyboard.next();

        System.out.println("Nice to meet you, " + name + "! Let's do some math!");
        System.out.println("We want to find the greatest common divisor of two numbers.");
        System.out.println("First, I'll need two numbers. They need to be an integer (no decimal numbers) larger than zero.");
        System.out.println("What integer should I use first?");
        number1 = keyboard.nextInt();

        System.out.println("What integer should I use second?");
        number2 = keyboard.nextInt();

        System.out.println("There are many ways to calculate the greatest common divisor. " +
                "Please choose which algorithm you'd like to use.");
        System.out.println();
        System.out.println("1) The old Euclidean algorithm, iterative.");
        System.out.println("2) The old Euclidean algorithm, recursive.");
        System.out.println("3) The modern Euclidean algorithm, iterative.");
        System.out.println("4) The modern Euclidean algorithm, recursive.");
        choice = keyboard.nextInt();
        System.out.println();

        while(true){
            if (choice == 1) {
                printResult(euklidOldIterative(number1, number2));
                break;
            } else if (choice == 2) {
                printResult(euklidOldRecursive(number1, number2));
                break;
            } else if (choice == 3) {
                printResult(euklidNewIterative(number1, number2));
                break;
            } else if (choice == 4) {
                printResult(euklidNewRecursive(number1, number2));
                break;
            }
            else {
                System.out.println("I don't understand. Please choose between 1 and 4.");
            }
        }
    }

    public static void printResult(int result){
        System.out.println("The greatest common divisor is " + result + ".");
    }

    public static void main(String[] args) {
	    start();
    }
}
