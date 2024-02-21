package co.edu.escuelaing.hangman.setup.factoryMethod;

import co.edu.escuelaing.hangman.model.scores.GameScore;
import co.edu.escuelaing.hangman.model.Language;
import co.edu.escuelaing.hangman.model.dictionary.HangmanDictionary;
import co.edu.escuelaing.hangman.view.HangmanPanel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class HangmanDefaultFactoryMethod implements HangmanFactoryMethod {
    private Language language;
    private HangmanDictionary dictionary;
    private HangmanPanel hangmanPanel;
    private GameScore score;

    public HangmanDefaultFactoryMethod(
            @Qualifier("spanishLanguage") Language language,
            @Qualifier("spanishDictionary") HangmanDictionary dictionary,
            @Qualifier("hangmanStickmanPanel") HangmanPanel hangmanPanel,
            @Qualifier("powerBonusScore") GameScore score
            ) {
        this.language = language;
        this.dictionary = dictionary;
        this.hangmanPanel = hangmanPanel;
        this.score = score;
    }

    public Language createLanguage() {
        return language;
    }

    public HangmanDictionary createDictionary() {
        return dictionary;
    }

    public HangmanPanel createHangmanPanel() {
        return hangmanPanel;
    }
    public GameScore createScore() {
        return score;
    }
}
