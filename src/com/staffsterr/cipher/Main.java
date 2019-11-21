package com.staffsterr.cipher;

import java.io.*;

public class Main {
    private static String[] alphabet;
    private static String[] alphabetChanged;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        alphabet = "abcdefghijklmnopqrstuvwxyz".split("");
        alphabetChanged = new String[alphabet.length];

        System.out.print("Which side(L/R): ");
        String sideChosen = br.readLine();
        boolean isRight = (sideChosen.equalsIgnoreCase("r"));
        boolean isLeft = (sideChosen.equalsIgnoreCase("l"));

        System.out.println("Left: " + isLeft);
        System.out.println("Right: " + isRight);

//        for(int i = 0; i < alphabetChanged.length; i++){
//
//        }
    }
}
