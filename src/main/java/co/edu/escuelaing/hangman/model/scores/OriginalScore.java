package co.edu.escuelaing.hangman.model.scores;

import org.springframework.stereotype.Component;

@Component("originalScore")
public class OriginalScore extends GameScore {
    public OriginalScore(){
        incorrectCount = 0;
        correctCount = 0;
        gameScore = 100;
    }
    @Override
    public int calculateScore() {
        gameScore = 100-(incorrectCount * 10);
        return gameScore;
    }
    @Override
    public void reset() {
        incorrectCount = 0;
        correctCount = 0;
        gameScore = 100;
    }
}
