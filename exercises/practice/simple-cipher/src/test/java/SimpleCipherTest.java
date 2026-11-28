import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleCipherTest {

    private Cipher randomKeyCipher;
    private Cipher substitutionCipher = new Cipher("abcdefghij");

    @BeforeEach
    public void setup() {
        randomKeyCipher = new Cipher();
    }

    @Test
    @DisplayName("Random key cipher -> Can encode")
    public void randomKeyCipherCanEncode() {
        String plainText = "aaaaaaaaaa";
        String cipherText = randomKeyCipher.getKey().substring(0, 10);
        assertThat(randomKeyCipher.encode(plainText)).isEqualTo(cipherText);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Random key cipher -> Can decode")
    public void randomKeyCipherCanDecode() {
        String cipherText = "aaaaaaaaaa";
        assertThat(randomKeyCipher.decode(randomKeyCipher.getKey().substring(0, 10)))
                .isEqualTo(cipherText);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Random key cipher -> Is reversible. I.e., if you apply decode in a "
            + "encoded result, you must see the same plaintext encode parameter as a "
            + "result of the decode method")
    public void randomKeyCipherIsReversibleIEIfYouApplyDecodeInAEncodedResultYouM() {
        String plainText = "abcdefghij";
        assertThat(randomKeyCipher.decode(randomKeyCipher.encode(plainText)))
                .isEqualTo(plainText);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Random key cipher -> Key is made only of lowercase letters")
    public void randomKeyCipherKeyIsMadeOnlyOfLowercaseLetters() {
        assertThat(randomKeyCipher.getKey()).matches("^[a-z]+$");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Substitution cipher -> Can encode")
    public void substitutionCipherCanEncode() {
        String plainText = "aaaaaaaaaa";
        assertThat(substitutionCipher.encode(plainText)).isEqualTo("abcdefghij");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Substitution cipher -> Can decode")
    public void substitutionCipherCanDecode() {
        String plainText = "aaaaaaaaaa";
        assertThat(substitutionCipher.decode("abcdefghij"))
                .isEqualTo(plainText);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Substitution cipher -> Is reversible. I.e., if you apply decode in a "
            + "encoded result, you must see the same plaintext encode parameter as a "
            + "result of the decode method")
    public void substitutionCipherIsReversibleIEIfYouApplyDecodeInAEncodedResultY() {
        String plainText = "abcdefghij";
        assertThat(substitutionCipher.decode(substitutionCipher.encode(plainText)))
                .isEqualTo(plainText);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Substitution cipher -> Can double shift encode")
    public void substitutionCipherCanDoubleShiftEncode() {
        String plainText = "iamapandabear";
        assertThat(new Cipher("iamapandabear").encode(plainText)).isEqualTo("qayaeaagaciai");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Substitution cipher -> Can wrap on encode")
    public void substitutionCipherCanWrapOnEncode() {
        String plainText = "zzzzzzzzzz";
        assertThat(substitutionCipher.encode(plainText)).isEqualTo("zabcdefghi");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Substitution cipher -> Can wrap on decode")
    public void substitutionCipherCanWrapOnDecode() {
        String plainText = "zzzzzzzzzz";
        assertThat(substitutionCipher.decode("zabcdefghi"))
                .isEqualTo(plainText);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Substitution cipher -> Can encode messages longer than the key")
    public void substitutionCipherCanEncodeMessagesLongerThanTheKey() {
        String plainText = "iamapandabear";
        assertThat(new Cipher("abc").encode(plainText)).isEqualTo("iboaqcnecbfcr");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Substitution cipher -> Can decode messages longer than the key")
    public void substitutionCipherCanDecodeMessagesLongerThanTheKey() {
        String plainText = "iamapandabear";
        assertThat(new Cipher("abc").decode("iboaqcnecbfcr"))
                .isEqualTo(plainText);
    }

}
