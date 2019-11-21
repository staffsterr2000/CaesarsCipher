package com.staffsterr.cipher;

import java.io.*;
import java.util.*;

public class Main {
    private static String[] alphabet;
    private static String[] alphabetChanged;
    private static String[] symbols;

    public static void alphabetChangeRight(int cells){
        int newCells = cells;
        alphabetChanged = new String[alphabet.length];
        for(int i = 0; i < alphabetChanged.length - cells; i++, newCells++){
            alphabetChanged[newCells] = alphabet[i];
        }
        for(int i = 0; i < alphabetChanged.length - (newCells - cells); i++){
            alphabetChanged[i] = alphabet[newCells - cells + i];
        }
        System.out.println(Arrays.toString(alphabetChanged));
    }

    public static void alphabetChangeLeft(int cells){
        int newCells = cells;
        alphabetChanged = new String[alphabet.length];
        for(int i = 0; i < alphabetChanged.length - cells; i++, newCells++){
            alphabetChanged[i] = alphabet[newCells];
        }
        for(int i = 0; i < alphabetChanged.length - (newCells - cells); i++){
            alphabetChanged[alphabetChanged.length - cells + i] = alphabet[i];
        }
        System.out.println(Arrays.toString(alphabetChanged));
    }

    public static String encrypt(String decryptMessageString){
        String[] decryptMessage = decryptMessageString.split("");
        String[] encryptMessage = new String[decryptMessage.length];
        for(int i = 0; i < encryptMessage.length; i++){
            if(findIndex(alphabet, decryptMessage[i]) != -1){
                encryptMessage[i] = alphabetChanged[findIndex(alphabet, decryptMessage[i])];
            }
            else if(findIndex(symbols, decryptMessage[i]) != -1){
                encryptMessage[i] = decryptMessage[i];
            }
            else{
                System.out.println("Symbol \"" + decryptMessage[i] + "\" is unknown!");
                encryptMessage[i] = "*";
            }
        }
        return toString(encryptMessage);
    }

    public static String decrypt(String encryptMessageString){
        String[] encryptMessage = encryptMessageString.split("");
        String[] decryptMessage = new String[encryptMessage.length];
        for(int i = 0; i < decryptMessage.length; i++){
            if(findIndex(alphabetChanged, encryptMessage[i]) != -1) {
                decryptMessage[i] = alphabet[findIndex(alphabetChanged, encryptMessage[i])];
            }
            else if(findIndex(symbols, encryptMessage[i]) != -1){
                decryptMessage[i] = encryptMessage[i];
            }
            else{
                System.out.println("Symbol \"" + encryptMessage[i] + "\" is unknown!");
                decryptMessage[i] = "*";
            }
        }
        return toString(decryptMessage);
    }

    public static int findIndex(String[] array, String symbol){
        int index = -1;
        for(int i = 0; i < array.length; i++){
            if(array[i].equals(symbol)){
                index = i;
                break;
            }
        }
        return index;
    }

    public static String toString(String[] array){
        String string = "";
        for(String s: array){
            string += s;
        }
        return string;
    }

    public static void end() throws IOException{
        System.out.println("\nError!");
        System.out.println("Press ENTER to exit...");
        System.in.read();
    }

    public static void happyEnd() throws IOException{
        System.out.println("\nPress ENTER to exit...");
        System.in.read();
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        alphabet = "abcdefghijklmnopqrstuvwxyz".split("");
        symbols = "0123456789 .,;:+-*/`~!@#№$%^&?_\"\'\\<>(){}[]".split("");

        System.out.print("Which side(L/R): ");
        String sideChoice = br.readLine();
        boolean isRight = (sideChoice.equalsIgnoreCase("r"));
        boolean isLeft = (sideChoice.equalsIgnoreCase("l"));
        System.out.println("Left: " + isLeft);
        System.out.println("Right: " + isRight);
        if(!(isRight || isLeft)) {
            end();
            return;
        }

        System.out.print("How many cells you want to skip in this side(>0): ");
        int cells = Integer.parseInt(br.readLine());
        System.out.println("Cells: " + cells);
        cells %= 26;
        if(cells <= 0) {
            end();
            return;
        }

        System.out.println(Arrays.toString(alphabet));

        if(isRight) alphabetChangeRight(cells);
        else if (isLeft) alphabetChangeLeft(cells);

        System.out.print("Do you want to encrypt or decrypt information?(E/D): ");
        String answer = br.readLine();
        boolean isEncrypt = answer.equalsIgnoreCase("e");
        boolean isDecrypt = answer.equalsIgnoreCase("d");

        System.out.println("Encrypt: " + isEncrypt);
        System.out.println("Decrypt: " + isDecrypt);

        if(isEncrypt){
            System.out.print("Input info to encrypt: ");
            String input = br.readLine();
            System.out.println(encrypt(input));
        }
        else if(isDecrypt){
            System.out.print("Input info to decrypt: ");
            String input = br.readLine();
            System.out.println(decrypt(input));
        }

        happyEnd();
    }
}
