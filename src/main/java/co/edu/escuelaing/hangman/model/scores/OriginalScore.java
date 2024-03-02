package co.edu.escuelaing.hangman.model.scores;

import org.springframework.stereotype.Component;

@Component("originalScore")
public class OriginalScore extends GameScore {
    @Override
    public int calculateScore() {
        gameScore = 100-(incorrectCount * 10);
        return gameScore;
    }
    @Override
    public void reset() {
    }
}
