package encryptdecrypt.algorithms;


import java.util.Arrays;

public enum AlgorithmType {
    UNICODE("unicode"),
    SHIFT("shift");

    public final String algorithmName;

    AlgorithmType(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public static AlgorithmType findType(String type) {
        return Arrays.stream(values())
                .filter((crt) -> crt.algorithmName.equals(type))
                .findFirst()
                .orElse(null);
    }
}
