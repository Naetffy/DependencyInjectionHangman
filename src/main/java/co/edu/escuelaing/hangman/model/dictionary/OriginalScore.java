package co.edu.escuelaing.hangman.model.dictionary;

import co.edu.escuelaing.hangman.model.GameScore;
import org.springframework.stereotype.Component;

@Component("originalScore")
public class OriginalScore implements GameScore {
    public int gameScore = 0;
    public OriginalScore(){
        gameScore = 100;
    }

    @Override
    public int calculateScore(int correctCount, int incorrectCount) {
        return 0;
    }

    @Override
    public int getScore() {
        return gameScore;
    }
}
