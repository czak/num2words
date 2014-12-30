package pl.czak.num2words;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Locale;

public class TranslatorTest {
    
    String[][] examples = {
        { "cero",                               "0" },
        { "ochenta y seis",                     "86" },
        { "ciento veintidós",                   "122" },
        { "trescientos",                        "300" },
        { "mil",                                "1000" },
        { "mil tres",                           "1003" },
        { "ochenta y seis mil ochenta y siete", "86087" },
        { "un millón",                          "1000000" },
    };

    String spanish(int number) {
        Locale l = new Locale("es");
        return new Translator(l).translate(number);
    }

    @Test
    public void spanishTranslations() {
        for (int i = 0; i < examples.length; i++) {
            String expected = examples[i][0];
            int number      = Integer.parseInt(examples[i][1]);
            assertEquals(expected, spanish(number));
        }
    }

    @Test(expected=IllegalArgumentException.class)
    public void unsupportedLocale() {
        new Translator(Locale.ENGLISH);
    }

}
