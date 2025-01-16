package dev.m3s.programming2.homework4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Hangman {


    private Random random = new Random();

   
    private String wordToGuess;
    private String hiddenWord;
    private int guessesLeft;

    private List<Character> guesses = new ArrayList<Character>();
    private List<Character> rightGuesses = new ArrayList<Character>();
    private List<Character> neededGuesses = new ArrayList<Character>();

    private Character result;        //W (win) or L (lose)


    public Hangman(WordList list, int guesses) {

        if (list != null) {
            List<String> words = list.giveWords();
            int i = random.nextInt(0, words.size());
            this.wordToGuess = words.get(i).toLowerCase();
            this.guessesLeft = guesses;
            setNeededGuesses();
        }
    }


    public String word() {
        
        return this.wordToGuess;
    }

    public boolean guess(Character c) {

        /*c and guess are the same. c is changed to String for method contains() */

        if (c != null) {
            c = Character.toLowerCase(c);
            String guess = String.valueOf(c);
            
            if (guesses == null || !guesses.contains(c))
                guesses.add(c);

            if (wordToGuess.contains(guess)) {
                if (rightGuesses == null || !rightGuesses.contains(c)) {
                    rightGuesses.add(c);
                }
                return true;
            } else {
                guessesLeft = Math.max(guessesLeft - 1, 0);
                return false;
            }
        } else {
            return false;
        }
    }

    public List<Character> guesses() {

        return guesses;
    }

    public int guessesLeft() {

        return guessesLeft;
    }

    public boolean theEnd() {

        if (guessesLeft == 0) {
            result = 'L';
            return true;
        } else if (rightGuesses.size() > 0 && rightGuesses.containsAll(neededGuesses)) {
            result = 'W';
            return true;
        } else {
            return false;        
        }
    }

    public String hideWord() {

        hiddenWord = wordToGuess;
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (!rightGuesses.contains(wordToGuess.charAt(i)))
                hiddenWord = hiddenWord.replace(wordToGuess.charAt(i), '*');
        }
        return hiddenWord;
        
    }
    
    public String getWordToGuess() {

        return this.wordToGuess;
    }

    public Character getResult() {

        return this.result;
    }

    public void setNeededGuesses() {

        for (int i = 0; i < wordToGuess.length(); i++) {
            if (neededGuesses == null || !neededGuesses.contains(Character.toLowerCase(wordToGuess.charAt(i))))
                neededGuesses.add(Character.toLowerCase(wordToGuess.charAt(i)));
        }
    } 
}
