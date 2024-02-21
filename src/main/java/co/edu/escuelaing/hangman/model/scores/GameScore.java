package co.edu.escuelaing.hangman.model.scores;

public abstract class GameScore {
    protected int gameScore;
    protected int correctCount;
    protected int incorrectCount;
    public abstract void calculateScore();
    public abstract void reset();

    public int getScore(){return gameScore;}
    public void setScore(int gameScore){this.gameScore = gameScore;}
    public void increaseCorrectCount(int correct){correctCount += correct;}
    public void increaseIncorrectCount(int incorrect){incorrectCount += incorrect;}
    public int getIncorrectCount(){return incorrectCount;}
    public int getCorrectCount(){return correctCount;}
}
