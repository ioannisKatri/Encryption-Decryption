package encryptdecrypt;

import encryptdecrypt.algorithms.AlgorithmType;
import encryptdecrypt.cryptography.CryptographyType;

import java.util.HashMap;
import java.util.Map;

public final class LoadArgs {
    private final CryptographyType modeType;
    private final Integer key;
    private final String fileNameRead;
    private final String fileNameWrite;
    private final String message;
    private final String algorithm;
    private final Map<String, String> arguments = new HashMap<>();

    public LoadArgs(String[] operations) {
        operationHandler(operations);
        this.modeType = CryptographyType.findType(arguments.getOrDefault("-mode", "enc"));
        this.key = Integer.parseInt(arguments.getOrDefault("-key", "0"));
        this.fileNameRead = arguments.get("-in");
        this.fileNameWrite = arguments.get("-out");
        this.message = !arguments.containsKey("-data") && !arguments.containsKey("-i") ? "" : arguments.get("-data");
        this.algorithm = arguments.getOrDefault("-alg", AlgorithmType.SHIFT.algorithmName);

    }

    public CryptographyType getModeType() {
        return modeType;
    }

    public Integer getKey() {
        return key;
    }

    public String getFileNameRead() {
        return fileNameRead;
    }

    public String getFileNameWrite() {
        return fileNameWrite;
    }

    public String getMessage() {
        return message;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    private void operationHandler(String[] operations) {

        if (operations.length % 2 != 0) {
            System.out.println(operations.length);
            System.out.println("There im an Error in the arguments");
            return;
        }

        for (int index = 0; index < operations.length; index++) {
            arguments.put(operations[index], operations[index + 1]);
            index++;
        }
    }
}
