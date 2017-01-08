package com.mm.restaurant.input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputManager {
    Scanner reader = new Scanner(System.in);
    final String WRONG_INPUT_FORMAT = "Incorrect Input, please enter number in range 0 to ";
    int zero = 0;
    int input;

    public int readInput(int upperLimit) {
        try {
            input = reader.nextInt();
            if (input < zero || input > upperLimit) throw new InputOutOfBorders();
        } catch (InputMismatchException | InputOutOfBorders e) {
            System.out.println(WRONG_INPUT_FORMAT + upperLimit);
            reader.nextLine();
            readInput(upperLimit);
        }
        return input;
    }
}
