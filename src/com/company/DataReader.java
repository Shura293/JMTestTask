package com.company;

import java.util.Scanner;

public class DataReader {

    private int var1;
    private int var2;
    private char oper;
    private boolean exitFlag;
    private boolean romanFlag1;
    private boolean romanFlag2;
    private char exitCharacter;
    private char resultChar;

    public DataReader(char exitCharacter) {
        this.exitCharacter = exitCharacter;
    }

    public void read() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        String text = scanner.nextLine();
        text = text.replaceAll("\\s","");
        if (text.indexOf(exitCharacter) != -1) {
            exitFlag = true;
            return;
        }
        try {
            String[] blocks = text.split("[+-/*]");
            if(blocks[0].contains("I") || blocks[0].contains("V") || blocks[0].contains("X")){
                romanFlag1= true;
                var1 = RomanArabicConverter.romanToArabic(blocks[0]);
            } else {
                var1 = Integer.parseInt(blocks[0]);
            }
            oper = text.charAt(blocks[0].length());
            if(blocks[0].contains("I") || blocks[0].contains("V") || blocks[0].contains("X")){
                romanFlag2= true;
                var2 = RomanArabicConverter.romanToArabic(blocks[1]);
            } else {
                var2 = Integer.parseInt(blocks[1]);
            }
            if(var1 > 10 || var1 < 1 || var2 > 10 || var2 < 1) throw new IndexOutOfBoundsException("Out of Bounds statemant");
            if(romanFlag1 != romanFlag2) throw new IllegalArgumentException("Different types of numbers");
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Invalid data format");
        }
    }

    public boolean isRoman() {
        return romanFlag2;
    }
    public int getVar1() {
        return var1;
    }

    public int getVar2() {
        return var2;
    }

    public char getOper() {
        return oper;
    }

    public boolean isExitFlag() {
        return exitFlag;
    }
}
