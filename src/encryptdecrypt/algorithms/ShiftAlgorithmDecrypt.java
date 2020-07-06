package encryptdecrypt.algorithms;

import encryptdecrypt.algorithms.Algorithms;

import static encryptdecrypt.algorithms.AlphabetBoundaries.*;
import static encryptdecrypt.algorithms.AlphabetBoundaries.LOWERCASE_END;

public class ShiftAlgorithmDecrypt implements Algorithms<Character, Integer, Character> {

    @Override
    public Character startWork(Character ch, Integer key) {
        if (ch >= UPPERCASE_START && ch <= UPPERCASE_END) {
            return decryptHelper(key, UPPERCASE_START, UPPERCASE_END, ch);
        } else if (ch >= LOWERCASE_START && ch <= LOWERCASE_END) {
            return decryptHelper(key, LOWERCASE_START, LOWERCASE_END, ch);
        }
        return ch;
    }


    private Character decryptHelper(int key, int start, int end, char ch) {
        boolean isSmallerThanLowerStart = (ch - key) < start;
        int findDifference = isSmallerThanLowerStart ?  start -  (ch - key) - 1  : 0;
        int num = isSmallerThanLowerStart ? end - findDifference : ch - key;
        return (char) num;
    }
}
