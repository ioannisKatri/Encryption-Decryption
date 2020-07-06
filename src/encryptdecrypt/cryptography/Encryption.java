package encryptdecrypt.cryptography;

import encryptdecrypt.algorithms.Algorithms;

import java.util.List;

public class Encryption<T, E, R> {

    public String startJob(Algorithms<T, E, R> algorithm, List<T> input, E key) {

        StringBuilder sb = new StringBuilder();
        for (T ch : input) {
            sb.append(algorithm.startWork(ch, key));
        }
        return sb.toString();
    }
}
