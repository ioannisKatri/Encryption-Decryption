package encryptdecrypt.filehandler;

import java.io.FileNotFoundException;

public interface Reader<T> {

    public T readFile() throws FileNotFoundException;
}
