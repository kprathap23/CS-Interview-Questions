package codeeval.easy.matrixrotation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(final String[] args) throws Exception {
//        final BufferedReader buffer = new BufferedReader(new FileReader(new File(args[0])));
        final BufferedReader buffer = new BufferedReader(new FileReader(new File("/Users/noname/repo/CS-Interview-Questions/src/main/java/codeeval/easy/matrixrotation/input.txt")));

        String line;
        while ((line = buffer.readLine()) != null) {
            final String[] strings = line.trim().split(" ");
            int length = strings.length / 2;
            char[][] originalMatrix = new char[length][length];
            char[][] rotatedMatrix = new char[length][length];

            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    originalMatrix[i][j] = strings[i].charAt(0);
                    System.out.print(strings[i].charAt(0));
                }
            }

            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    rotatedMatrix[i][j] = rotatedMatrix[length - j - 1][i];
                    System.out.print(rotatedMatrix[i][j] + "");
                }
            }

            System.out.println("");
        }
    }
}
