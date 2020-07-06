package encryptdecrypt.cryptography;

import encryptdecrypt.algorithms.AlgorithmType;

import java.util.Arrays;

public enum CryptographyType {

    ENCRYPTION("enc"),
    DECRYPTION("dec");

    public final String name;

    CryptographyType(String name) {
        this.name = name;
    }

    public static CryptographyType findType(String type) {
        return Arrays.stream(values())
                .filter((crt) -> crt.name.equals(type))
                .findFirst()
                .orElse(null);
    }
}
