package encryptdecrypt.algorithms;

public class UnicodeAlgorithmEncrypt implements Algorithms<Character, Integer, Character> {

    @Override
    public Character startWork(Character ch, Integer key) {
        return (char) (ch + key);
    }
}
