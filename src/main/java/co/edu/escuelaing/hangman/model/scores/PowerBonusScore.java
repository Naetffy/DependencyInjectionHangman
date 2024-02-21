package co.edu.escuelaing.hangman.model.scores;

import org.springframework.stereotype.Component;

import java.lang.Math;

@Component("powerBonusScore")
public class PowerBonusScore extends GameScore{

    public PowerBonusScore(){
        incorrectCount = 0;
        correctCount = 0;
        gameScore = 0;
    }

    @Override
    public void calculateScore() {
        gameScore = (correctCount > 0?(int)Math.pow(5,correctCount) : 0) - ( incorrectCount*8);
        if (gameScore > 500) gameScore = 500;

    }

    @Override
    public void reset() {
        incorrectCount = 0;
        correctCount = 0;
        gameScore = 0;
    }
}
