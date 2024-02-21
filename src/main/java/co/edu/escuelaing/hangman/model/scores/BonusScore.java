package co.edu.escuelaing.hangman.model.scores;

import org.springframework.stereotype.Component;

@Component("bonusScore")
public class BonusScore extends GameScore {

    public BonusScore(){
        incorrectCount = 0;
        correctCount = 0;
        gameScore = 0;
    }

    @Override
    public void calculateScore() {
        gameScore = correctCount * 10 - incorrectCount * 5;
    }

    @Override
    public void reset() {
        incorrectCount = 0;
        correctCount = 0;
        gameScore = 0;
    }
}
