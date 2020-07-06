package encryptdecrypt.filehandler;

public interface Writer<T> {

    boolean writeFile(T t, boolean overwrite);
}
