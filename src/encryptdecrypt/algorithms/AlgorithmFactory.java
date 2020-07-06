package encryptdecrypt.algorithms;

import encryptdecrypt.cryptography.CryptographyType;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AlgorithmFactory {
    private static final Map<String, Algorithms<Character, Integer, Character>> encryptMap= new HashMap<>();

    static {
        encryptMap.put(AlgorithmType.UNICODE.algorithmName + "-" + CryptographyType.ENCRYPTION.name, new UnicodeAlgorithmEncrypt());
        encryptMap.put(AlgorithmType.UNICODE.algorithmName + "-" + CryptographyType.DECRYPTION.name, new UnicodeAlgorithmDecrypt());
        encryptMap.put(AlgorithmType.SHIFT.algorithmName + "-" + CryptographyType.ENCRYPTION.name, new ShiftAlgorithmEncrypt());
        encryptMap.put(AlgorithmType.SHIFT.algorithmName + "-" + CryptographyType.DECRYPTION.name, new ShiftAlgorithmDecrypt());
    }

    public static Algorithms<Character, Integer, Character> getInstance(String type) {
        return Objects.requireNonNull(encryptMap.get(type.toLowerCase()));
    }

}
