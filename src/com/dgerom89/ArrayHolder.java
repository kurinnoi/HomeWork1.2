package com.dgerom89;

import java.util.Scanner;

/**
 * Created by Dgerom on 29.04.2017.
 */

public class ArrayHolder {

    private int[] array;

    Scanner input = new Scanner(System.in);


    ArrayHolder(int size1) {
            array = new int[size1];
            fillArray();
          }

    int[] getArray() {
        return array;
    }

    void fillArray() {
        System.out.println("Enter element of Array: ");
        for (int j = 0; j < array.length; j++) {
//            array[j] = input.nextInt();
            array[j] = ConsoleHelper.getIntegerFromScanner(input, "error", false);
            System.out.println(array[j]);
        }

    }


    void sortArrayUp() {
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j] < array[j - 1]) {
                    int swap = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = swap;
                }
            }
        }
    }

    void sortArrayDown() {
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j] > array[j - 1]) {
                    int swap = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = swap;
                }
            }
        }
    }

    String findElement(int element) {
        String string = "";
        boolean inArray = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                if (inArray)
                    string += ", ";
                string += (i+1);
                inArray = true;

            }
        }
        if (string.equals("")) return ("NOWHERE\n");
        return string;
    }

}
