package co.edu.escuelaing.hangman.model;

public interface GameScore {

    public abstract int calculateScore(int correctCount, int incorrectCount);

    public int getScore();

    public void reset();

    void setScore(int gameScore);
}
