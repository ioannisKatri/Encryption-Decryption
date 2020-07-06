package encryptdecrypt.filehandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public final class WriteFile implements Writer<String> {

    private final String fileName;

    public WriteFile(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean writeFile(String str, boolean overwrite) {
        File file = new File(this.fileName);

        try (FileWriter writer = new FileWriter(file, overwrite)) {
            System.out.println(str);
            writer.write(str);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
