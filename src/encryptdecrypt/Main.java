package encryptdecrypt;

public class Main {

    public static void main(String[] args) {
        LoadArgs loadArgs = new LoadArgs(args);
        OutputHandler cmd = new OutputHandler(loadArgs);
        cmd.start();
    }
}
