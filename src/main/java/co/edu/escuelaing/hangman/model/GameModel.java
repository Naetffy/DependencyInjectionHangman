/***************************************************************
 * file: GameModel.java
 * author:   Christopher Santos
 *           Omar Rodriguez
 * class: CS 245 - Programming Graphical User Interfaces
 *
 * assignment: Swing Project v1.0
 * date last modified: 10/11/2016
 *
 * purpose: This is the model component for the game screen
 *
 ****************************************************************/
package co.edu.escuelaing.hangman.model;

import co.edu.escuelaing.hangman.model.dictionary.HangmanDictionary;
import co.edu.escuelaing.hangman.model.scores.GameScore;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class GameModel {
    private LocalDateTime dateTime;
    private GameScore score;
    private int[] lettersUsed;


    private HangmanDictionary dictionary;

    private Scanner scan;
    private String randomWord;
    private char[] randomWordCharArray;


    @Autowired
    public GameModel(HangmanDictionary dictionary, GameScore score) {
        //this.dictionary = new EnglishDictionaryDataSource();
        this.dictionary = dictionary;
        randomWord = selectRandomWord();
        randomWordCharArray = randomWord.toCharArray();
        this.score = score;

    }

    //method: reset
    //purpose: reset this game model for a new game
    public void reset() {
        randomWord = selectRandomWord();
        randomWordCharArray = randomWord.toCharArray();
        score.reset();
    }

    //setDateTime
    //purpose: sets game date/time to system date/time
    public void setDateTime() {
        this.dateTime = LocalDateTime.now();
    }

    //method: makeGuess
    //purpose: check if user guess is in string. Return a
    // list of positions if character is found in string
    public ArrayList<Integer> makeGuess(String guess) {
        char guessChar = guess.charAt(0);
        ArrayList<Integer> positions = new ArrayList<>();
        for (int i = 0; i < randomWordCharArray.length; i++) {
            if (randomWordCharArray[i] == guessChar) {
                positions.add(i);
            }
        }
        if (positions.isEmpty()) {
            score.increaseIncorrectCount(1);
        } else {
            score.increaseCorrectCount(positions.size());
        }
        score.calculateScore();
        return positions;

    }

    //getDateTime
    //purpose: returns current displayed date/time
    public String getDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM-dd-uuuu hh:mm:ss a");
        return dtf.format(dateTime);
    }

    //name: selectRandomWord()
    //purpose: selects random word from dictionary
    private String selectRandomWord() {
        Random rand = new Random();
        List<String> words = dictionary.getAvailableWords();
        return words.get(rand.nextInt(words.size()));
    }

    //method: getIncorrectCount
    //purpose: return number of incorrect guesses made so far
    public int getIncorrectCount() {
        return score.getIncorrectCount();
    }

    //method: getCorrectCount
    //purpose: return number of correct guesses made so far
    public int getCorrectCount() {
        return score.getCorrectCount();
    }

    //method: getGameScore
    //purpose: return current score
    public int getGameScore() {
        return score.getScore();
    }

    //method: setGameScore
    //purpose: set current game score
    public void setGameScore(int gameScore) {
        this.score.setScore(gameScore);
    }

    //method: getWordLength
    //purpose: return length of current word
    public int getWordLength() {
        return randomWord.length();
    }

    public List<Character> getCharacterSet() {
        return new ArrayList<>(dictionary.getCharacterSet());
    }
}
