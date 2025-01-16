package dev.m3s.programming2.homework4;

import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {

      
    private static WordList wordList;
    private static Hangman hangman;

    public static void main(String[] args) throws FileNotFoundException {

        try {
            wordList = new WordList("C:\\Users\\nikla\\Documents\\Ohjelmointi\\ohjelmointi2\\homework4\\src\\main\\java\\dev\\m3s\\programming2\\homework4\\words.txt");
            //wordList = new WordList("words.txt");
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
            System.exit(0);
        }
        hangman = new Hangman(wordList, 5);

        Scanner reader = new Scanner(System.in);

        System.out.println("The hidden word...");
        System.out.println(hangman.hideWord());

        while (!hangman.theEnd()) {
            System.out.println("Guess a letter: ");
            char guess = reader.next().charAt(0);
            hangman.guess(guess);
            printGame();    
            
        }
        reader.close();
        printResult();
    }

    public static void printGame() {

        System.out.println("The hidden word...");
        System.out.println(hangman.hideWord());
        System.out.println("Guesses left: " + hangman.guessesLeft());
        System.out.println("Guessed letters: " + hangman.guesses());
    }

    public static void printResult() {

        if (hangman.getResult().equals('W')) {
            System.out.println("Congratulations! You won!!!\n" + 
            "The hidden word was: " + hangman.getWordToGuess());
        } else if (hangman.getResult().equals('L')) {
            System.out.println("Sorry, you lost! The hidden word was: " + hangman.getWordToGuess());
        }
    }   
}
