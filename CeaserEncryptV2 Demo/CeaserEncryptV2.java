public class CeaserEncryptV2 {
    final String plaintextAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; // Plaintext
    // Alphabet
    private String keyword; // The Secret Keyword
    private String ciphertextAlphabet; // Ciphertext Alphabet

    /**
     * Class constructor initializes the keyword and creates the Ciphertext Alphabet
     *
     * @param key the secret keyword used to create the ciphertext alphabet
     */
    public CeaserEncryptV2(String key) {
        keyword = key;
        initCiphertextAlphabet();
    }

    /**
     * removes all duplicate occurrences of characters from a String
     *
     * @param s String with duplicate occurrences of characters
     * @return String with no duplicate characters in it
     */
    public static String removeDups(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    s = s.substring(0, j) + s.substring(j + 1, s.length());
                    j--;
                }
            }
        }
        return s;
    }

    /**
     * generates the ciphertext alphabet from the keyword
     *
     * @return String of ciphertext alphabet generated from the keyword
     */
    public String initCiphertextAlphabet() {
        keyword = keyword.toUpperCase();
        keyword = keyword + plaintextAlphabet;
        keyword = removeDups(keyword);
        ciphertextAlphabet = keyword;

        return ciphertextAlphabet;
    }

    /**
     * Encrypts a message in plaintext
     *
     * @param message the message to be encrypted in ciphertext alphabet
     * @return the encrypted message in ciphertext alphabet
     */
    public String encrypt(String message) {
        message = message.toUpperCase();
        String result = "";
        for (int i = 0; i < message.length(); i++) {
            int counter = 0;
            for (int j = 0; j < plaintextAlphabet.length(); j++) {
                if (message.charAt(i) == plaintextAlphabet.charAt(j)) {
                    result += ciphertextAlphabet.charAt(j);
                } else {
                    counter++;
                }
            }
            if (counter == ciphertextAlphabet.length()) {
                result += message.charAt(i);
            }
        }

        return result;
    }

    /**
     * Encrypts a message in plaintext
     *
     * @param ciphertext ciphertext in ciphertext alphabet
     * @return the decrypted message in plaintext alphabet
     */
    public String decrypt(String ciphertext) {
        ciphertext = ciphertext.toUpperCase();
        String result = "";
        int counter = 0;
        for (int i = 0; i < ciphertext.length(); i++) {
            counter = 0;
            for (int j = 0; j < plaintextAlphabet.length(); j++) {
                if (ciphertext.charAt(i) == ciphertextAlphabet.charAt(j)) {
                    result += plaintextAlphabet.charAt(j);
                } else {
                    counter++;

                }
            }
            if (counter == plaintextAlphabet.length()) {
                result += ciphertext.charAt(i);
            }
        }

        return result;
    }

}

