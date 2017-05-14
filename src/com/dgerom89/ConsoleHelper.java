package com.dgerom89;

import java.util.Arrays;
import java.util.Scanner;

public class ConsoleHelper {

    private int size;
    private Scanner in = new Scanner(System.in);


    public void start() {
        String possibilities;
        getInstruction();
        size = getIntegerFromScanner(in, getErrorMessage(), true);
        ArrayHolder arrayHolder = new ArrayHolder(size);
        System.out.println("Your initial array is: " + Arrays.toString(arrayHolder.getArray()));
        do {
            getChoose();
            possibilities = in.next();
            switch (possibilities) {
                case "1": {
                    System.out.print("What element do you want to find: ");
                    int element = in.nextInt();
                    System.out.println("The element " + element + " is(are) found on " + arrayHolder.findElement(element) + " positions of array.");
                    break;
                }
                case "2": {
                    arrayHolder.sortArrayUp();
                    System.out.println(Arrays.toString(arrayHolder.getArray()));
                    break;
                }
                case "3": {
                    arrayHolder.sortArrayDown();
                    System.out.println(Arrays.toString(arrayHolder.getArray()));
                    break;
                }
                case "4": {
                    getGoodByeMessage();
                    break;
                }
                default: {
                    System.err.println(getErrorMessage());
                    break;
                }
            }
        } while (!possibilities.equals("4"));
    }

    private void getInstruction() {
        System.out.println("Hello! \nPlease enter the size of the array and then enter elements of array: ");
    }

    private void getGoodByeMessage() {
        System.out.println("Have a good day or night! Good luck!");
    }

    private String getErrorMessage() {
        return "You entered wrong value! Please try again!";
    }

    private void getChoose() {
        System.out.println("Do you want:");
        System.out.println("1) to find an element?");
        System.out.println("2) to sort the array in ascending order?");
        System.out.println("3) to sort the array in descending order?");
        System.out.println("4) to quit the program?");

    }

    public static int getIntegerFromScanner(Scanner sc, String errorMessage, boolean LowZero) {     //переименовал Bull
        int i;

        try {
            i = sc.nextInt();
            if (LowZero) {
                if (i > 0) {

                } else {
                    System.out.println(errorMessage);
                    i = getIntegerFromScanner(sc, errorMessage, LowZero);
                }
            }
        } catch (Exception e) {
            System.out.println(errorMessage);
            sc.next();
            i = getIntegerFromScanner(sc, errorMessage, LowZero);
        }
        return i;
    }
}


