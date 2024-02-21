package co.edu.escuelaing.hangman.setup.factoryMethod;

import co.edu.escuelaing.hangman.model.scores.GameScore;
import co.edu.escuelaing.hangman.model.Language;
import co.edu.escuelaing.hangman.model.dictionary.HangmanDictionary;
import co.edu.escuelaing.hangman.view.HangmanPanel;

public interface HangmanFactoryMethod {
    Language createLanguage();

    HangmanDictionary createDictionary();

    HangmanPanel createHangmanPanel();

    GameScore createScore();
}
