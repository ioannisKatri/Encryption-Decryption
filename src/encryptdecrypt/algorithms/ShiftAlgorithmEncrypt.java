package encryptdecrypt.algorithms;

import static encryptdecrypt.algorithms.AlphabetBoundaries.*;
import static encryptdecrypt.algorithms.AlphabetBoundaries.LOWERCASE_END;

public class ShiftAlgorithmEncrypt implements Algorithms<Character, Integer, Character> {

    @Override
    public Character startWork(Character ch, Integer key) {
        if (ch >= UPPERCASE_START && ch <= UPPERCASE_END) {
            return encryptHelper(key, UPPERCASE_START, UPPERCASE_END, ch);
        } else if (ch >= LOWERCASE_START && ch <= LOWERCASE_END) {
            return encryptHelper(key, LOWERCASE_START, LOWERCASE_END, ch);
        }
        return ch;
    }


    private Character encryptHelper(int key, int start, int end, char ch) {
        boolean isGreatThanLowercaseEnd = (ch + key) > end;
        int findDifference = isGreatThanLowercaseEnd ? (ch + key) - end - 1 : 0;
        int num = isGreatThanLowercaseEnd ? start + findDifference : ch + key;
        return (char) num;
    }

}
