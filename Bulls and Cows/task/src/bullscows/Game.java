package bullscows;

import java.util.*;

public class Game {
    private final Scanner scanner;
    private Code secretCode;
    private int length;
    private int symbols;

    private String inputLength;

    private String inputSymbols;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    public void play() {
        prepareGame();
        if (!catchError() && !catchNotValidNumber()){
            secretCode = generateSecretCode();
            System.out.printf("The secret is prepared: %s (0-%s).\n", "*".repeat(length), getSymbols());
            System.out.println("Okay, let's start a game!");
            doGameLoop();
        }
    }

    private void prepareGame() {
        System.out.println("Input the length of the secret code:");
        inputLength = scanner.nextLine();
        if (!catchNotValidNumber()){
            System.out.println("Input the number of possible symbols in the code:");
            symbols = scanner.nextInt();
        }
    }

    private boolean catchNotValidNumber(){
        try {
            length = Integer.parseInt(inputLength);
            if (inputLength.equals("0")){
                System.out.println("Error: \""+inputLength+"\" isn't a valid number.");
                return true;
            }
        } catch (NumberFormatException e){
            System.out.println("Error: \""+inputLength+"\" isn't a valid number.");
            return true;
        }
        return false;
    }

    private boolean catchError(){

        if (symbols < length){
            System.out.println("Error: it's not possible to generate a code with a length of "+length+" with "+symbols+" unique symbols.");
            return true;
        } else if (symbols > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            return true;
        } else {
            return false;
        }
    }

    private String getSymbols() {
        return symbols > 10 ? "9, a-" + (char) ('a' + symbols - 11) : String.valueOf(symbols - 1);
    }

    private void doGameLoop() {
        int turn = 1;
        while (true) {
            System.out.println("Turn " + turn++);
            //System.out.print("> ");
            String guess = scanner.next();
            Grade grade = secretCode.check(new Code(guess, length, symbols)); // Pass length and symbols to check
            System.out.println("Grade: " + grade);
            if (grade.isSolved(length)) { // Check if solved using correct length
                System.out.println("Congratulations! You guessed the secret code.");
                break;
            }
        }
    }

    private Code generateSecretCode() {
        Random random = new Random();
        String dictionary = "0123456789abcdefghijklmnopqrstuvwxyz";
        StringBuilder code = new StringBuilder();

        if (length > symbols || length > dictionary.length()) {
            System.out.println("Error: can't generate a secret number because there aren't enough unique digits.");
            System.exit(0);
        }

        while (code.length() < length) {
            char c = dictionary.charAt(random.nextInt(symbols));
            if (code.indexOf(String.valueOf(c)) == -1) {
                code.append(c);
            }
        }

        return new Code(code.toString(), length, symbols); // Pass length and symbols to Code
    }
}