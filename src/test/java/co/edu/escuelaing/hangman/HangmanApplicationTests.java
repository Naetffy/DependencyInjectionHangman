package co.edu.escuelaing.hangman;

import co.edu.escuelaing.hangman.model.scores.BonusScore;
import co.edu.escuelaing.hangman.model.scores.GameScore;
import co.edu.escuelaing.hangman.model.scores.OriginalScore;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class HangmanApplicationTests {
	@Test
	public void calculateScore_WithZeroCorrectAndZeroIncorrect_ShouldReturnHundred() {
		// Arrange
		OriginalScore scoreCalculator = new OriginalScore();

		// Act
		int score = scoreCalculator.calculateScore();

		// Assert
		assertEquals(100, score);
	}

	@Test
	public void calculateScore_WithZeroCorrectAndFiveIncorrect_ShouldReturnFifty() {
		// Arrange
		OriginalScore scoreCalculator = new OriginalScore();
		scoreCalculator.increaseIncorrectCount(5);

		// Act
		int score = scoreCalculator.calculateScore();

		// Assert
		assertEquals(50, score);
	}

	@Test
	public void calculateScore_WithZeroCorrectAndZeroIncorrect_ShouldReturnZero() {
		// Arrange
		BonusScore scoreCalculator = new BonusScore();

		// Act
		int score = scoreCalculator.calculateScore();

		// Assert
		assertEquals(0, score);
	}

	@Test
	public void calculateScore_WithFiveCorrectAndZeroIncorrect_ShouldReturnFifty() {
		// Arrange
		BonusScore scoreCalculator = new BonusScore();
		scoreCalculator.increaseCorrectCount(5);

		// Act
		int score = scoreCalculator.calculateScore();

		// Assert
		assertEquals(50, score);
	}

	@Test
	public void increaseCorrectCount_CorrectCountIncreased_AfterAnswer() {
		// Arrange
		GameScore score = new OriginalScore();

		// Act
		score.increaseCorrectCount(2);

		// Assert
		assertEquals(2, score.getCorrectCount());
	}

	@Test
	public void calculateScore_ScoreWithinLimits_ShouldReturnScore() {
		// Arrange
		GameScore score = new OriginalScore();
		score.increaseCorrectCount(5);
		score.increaseIncorrectCount(3);

		// Act
		int calculatedScore = score.calculateScore();

		// Assert
		assertTrue(calculatedScore >= 0 && calculatedScore <= 100);
	}

}
