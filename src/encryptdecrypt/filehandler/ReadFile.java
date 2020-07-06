package encryptdecrypt.filehandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public final class ReadFile implements Reader<String> {

    private final String filename;

    public ReadFile(String filename) {
        this.filename = filename;
    }

    @Override
    public String readFile(){
        File file = new File(this.filename);
        StringBuilder sb = new StringBuilder();

        try (Scanner sc = new Scanner(file)) {
            while(sc.hasNextLine()) {
                sb.append(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        return sb.toString();
    }
}
