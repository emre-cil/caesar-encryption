
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;


class CeaserEncryptV2Test {
    String[] keys = { "", "quiz", "merHabA" };
    String[] msgs = { "HI", "Hello",
            "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet," + " consectetur, adipisci velit...",

            "'All the world's a stage,\n" + "and all the men and women merely players:\n"
                    + "they have their exits and their entrances'\t" + "Shakespeare, As You Like It, Act II, Scene 7" };



    @Test
    void removeDups() {
        String keyword = "MERHABA";
        String expected = "MERHAB";
        String actual = CeaserEncryptV2.removeDups(keyword);
        assertEquals(expected, actual);

        keyword = "999PIZZA11122233";
        expected = "9PIZA123";
        actual = CeaserEncryptV2.removeDups(keyword);
        assertEquals(expected, actual);

        keyword = "9012";
        expected = "9012";
        actual = CeaserEncryptV2.removeDups(keyword);
        assertEquals(expected, actual);

        keyword = "";
        expected = "";
        actual = CeaserEncryptV2.removeDups(keyword);
        assertEquals(expected, actual);
    }

    @Test
    void initCiphertextAlphabet() {
        String key = "";
        CeaserEncryptV2 c = new CeaserEncryptV2(key);
        String expected = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String actual = c.initCiphertextAlphabet();
        assertEquals(expected, actual);

        key = "quiz";
        c = new CeaserEncryptV2(key);
        expected = "QUIZABCDEFGHJKLMNOPRSTVWXY0123456789";
        actual = c.initCiphertextAlphabet();
        assertEquals(expected, actual);

        key = "MerhAba";
        c = new CeaserEncryptV2(key);
        expected = "MERHABCDFGIJKLNOPQSTUVWXYZ0123456789";
        actual = c.initCiphertextAlphabet();
        assertEquals(expected, actual);

        key = "9876543210ZYXWVUTSRQPONMLKJIHGFEDCBA";
        c = new CeaserEncryptV2(key);
        expected = "9876543210ZYXWVUTSRQPONMLKJIHGFEDCBA";
        actual = c.initCiphertextAlphabet();
        assertEquals(expected, actual);

        key = "99XXYYZZ111222";
        c = new CeaserEncryptV2(key);
        expected = "9XYZ12ABCDEFGHIJKLMNOPQRSTUVW0345678";
        actual = c.initCiphertextAlphabet();
        assertEquals(expected, actual);
    }

    @Test
    void encrypt() {
        String key = "quiz";
        CeaserEncryptV2 c = new CeaserEncryptV2(key);
        String[] em = { "DE", "DAHHL",
                "KANSA MLOOL NSEPNSQJ APR NSE ZLHLOAJ EMPSJ NSEQ ZLHLO PER QJAR, ILKPAIRARSO, QZEMEPIE TAHER...",
                "'QHH RDA VLOHZ'P Q PRQCA,\n" + "QKZ QHH RDA JAK QKZ VLJAK JAOAHX MHQXAOP:\n"
                        + "RDAX DQTA RDAEO AWERP QKZ RDAEO AKROQKIAP'\t"
                        + "PDQGAPMAQOA, QP XLS HEGA ER, QIR EE, PIAKA 7" };

        for (int i = 0; i < msgs.length; i++) {
            assertEquals( em[i], c.encrypt(msgs[i]));
        }
        //////////////////////////////////////
        key = "";
        c = new CeaserEncryptV2(key);
        em = msgs;
        for (int i = 0; i < msgs.length; i++) {
            assertEquals(em[i].toUpperCase(), c.encrypt(msgs[i]));
        }
    }

    @Test
    void decrypt() {
        String key = "quiz";
        CeaserEncryptV2 c = new CeaserEncryptV2(key);
        String[] em = { "DE", "DAHHL",

                "KANSA MLOOL NSEPNSQJ APR NSE ZLHLOAJ EMPSJ NSEQ ZLHLO PER QJAR, ILKPAIRARSO, QZEMEPIE TAHER...",

                "'QHH RDA VLOHZ'P Q PRQCA,\n" + "QKZ QHH RDA JAK QKZ VLJAK JAOAHX MHQXAOP:\n"
                        + "RDAX DQTA RDAEO AWERP QKZ RDAEO AKROQKIAP'\t"
                        + "PDQGAPMAQOA, QP XLS HEGA ER, QIR EE, PIAKA 7" };

        for (int i = 0; i < msgs.length; i++) {
            assertEquals( msgs[i].toUpperCase(), c.decrypt(em[i]));
        }
        //////////////////////////////////////
        key = "";
        c = new CeaserEncryptV2(key);
        em = msgs;
        for (int i = 0; i < msgs.length; i++) {
            assertEquals(msgs[i].toUpperCase(), c.decrypt(em[i]));
        }
    }
}
