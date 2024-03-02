package co.edu.escuelaing.hangman.model.scores;

import org.springframework.stereotype.Component;

import java.lang.Math;

@Component("powerBonusScore")
public class PowerBonusScore extends GameScore{
    @Override
    public int calculateScore() {
        long tempScore = (correctCount > 0 ? (long) Math.pow(5, correctCount) : 0) - ((long) incorrectCount * 8);
        gameScore = tempScore > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) tempScore;
        if (gameScore > 500) gameScore = 500;
        return gameScore;
    }


    @Override
    public void reset() {
    }
}
