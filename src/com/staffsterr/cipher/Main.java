package com.staffsterr.cipher;

import java.io.*;
import java.util.*;

public class Main {
    private static String[] alphabet;
    private static String[] alphabetChanged;

    public static void alphabetChangeRight(int cells){
        int newCells = cells;
        alphabetChanged = new String[alphabet.length];
        for(int i = 0; i < alphabetChanged.length - cells; i++, newCells++){
            alphabetChanged[newCells] = alphabet[i];
        }
//        System.out.println(newCells);
//        System.out.println(newCells - cells);
//        System.out.println(alphabetChanged.length - (newCells - cells));
        System.out.println(alphabet[newCells - cells] + " " + alphabet[newCells - cells + 1]);
        for(int i = 0; i < alphabetChanged.length - (newCells - cells); i++){
            alphabetChanged[i] = alphabet[newCells - cells + i];
        }
        System.out.println(Arrays.toString(alphabetChanged));
    }

    public static void alphabetChangeLeft(int cells){
        alphabetChanged = new String[alphabet.length];
        for(int i = 0; i < alphabetChanged.length; i++){

        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        alphabet = "abcdefghijklmnopqrstuvwxyz".split("");

        System.out.print("Which side(L/R): ");
        String sideChoice = br.readLine();
        boolean isRight = (sideChoice.equalsIgnoreCase("r"));
        boolean isLeft = (sideChoice.equalsIgnoreCase("l"));

        System.out.println("Left: " + isLeft);
        System.out.println("Right: " + isRight);

        System.out.print("How many cells you want to skip in this side: ");
        int cells = (Integer.parseInt(br.readLine()) % 26);

        System.out.println("Cells: " + cells);

        if(isRight) alphabetChangeRight(cells);
        else if (isLeft) alphabetChangeLeft(cells);
    }
}
