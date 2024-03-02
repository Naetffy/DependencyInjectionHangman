package co.edu.escuelaing.hangman.model.scores;

import org.springframework.stereotype.Component;

@Component("bonusScore")
public class BonusScore extends GameScore {
    @Override
    public int calculateScore() {
        gameScore = correctCount * 10 - incorrectCount * 5;
        return gameScore;
    }

    @Override
    public void reset() {
    }
}
