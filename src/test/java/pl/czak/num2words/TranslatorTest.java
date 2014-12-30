package pl.czak.num2words;

import static org.junit.Assert.*;

import org.junit.Test;

public class TranslatorTest {
    
    String t(int number) {
        return Translator.translate(number);
    }

    @Test
    public void testRegressions() {
        assertEquals("ciento veintidós", t(122));
        assertEquals("trescientos", t(300));
        assertEquals("ochenta y seis", t(86));
        assertEquals("cero", t(0));
    }

    @Test
    public void testOverOneThousand() {
        assertEquals("ochenta y seis mil ochenta y siete", t(86087));
        assertEquals("mil", t(1000));
        assertEquals("mil tres", t(1003));
        assertEquals("un millón", t(1000000));
    }

}
