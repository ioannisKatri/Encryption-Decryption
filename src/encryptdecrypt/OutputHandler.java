package encryptdecrypt;

import encryptdecrypt.algorithms.AlgorithmFactory;
import encryptdecrypt.cryptography.CryptographyType;
import encryptdecrypt.cryptography.Decryption;
import encryptdecrypt.cryptography.Encryption;
import encryptdecrypt.filehandler.ReadFile;
import encryptdecrypt.filehandler.WriteFile;

import java.util.stream.Collectors;

public class OutputHandler {

    private final LoadArgs loadArgs;

    public OutputHandler(LoadArgs loadArgs) {
        this.loadArgs = loadArgs;
    }

    public void start() {
        String text = fileReader();
        fileWriter(CryptographyProcedure(loadArgs.getModeType(), text));
    }

    private void fileWriter(String text) {
        if (this.loadArgs.getFileNameWrite() != null) {
            new WriteFile(this.loadArgs.getFileNameWrite()).writeFile(text, false);
        } else {
            System.out.println(text);
        }
    }

    private String fileReader() {
        if (this.loadArgs.getFileNameRead() != null) {
            return new ReadFile(loadArgs.getFileNameRead()).readFile();
        }
        return loadArgs.getMessage();
    }

    private String CryptographyProcedure(CryptographyType operations, String text) {
        switch (operations) {
            case ENCRYPTION:
                Encryption<Character, Integer, Character> encryption = new Encryption<>();
                return encryption.startJob(AlgorithmFactory.getInstance(this.loadArgs.getAlgorithm() + "-" + this.loadArgs.getModeType().name),
                        text.chars()
                                .mapToObj(e -> (char) e)
                                .collect(Collectors.toList()),
                        this.loadArgs.getKey());
            case DECRYPTION:
                Decryption<Character, Integer, Character> decryption = new Decryption<>();
                return decryption.startJob(AlgorithmFactory.getInstance(this.loadArgs.getAlgorithm() + "-" + this.loadArgs.getModeType().name),
                        text.chars()
                                .mapToObj(e -> (char) e)
                                .collect(Collectors.toList()),
                        this.loadArgs.getKey());
            default:
                throw new IllegalArgumentException("Invalid Operation");
        }
    }
}
