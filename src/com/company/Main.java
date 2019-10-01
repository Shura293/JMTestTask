package com.company;

import java.io.*;
import java.util.*;

public class Main {
    private static final char exitCharacter = '!';

    public static void main(String[] args) {
        DataReader reader = new DataReader(exitCharacter);
        String ans = "";
        while (true) {
            try {
                reader.read();
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                continue;
            }
            if (reader.isExitFlag()) {
                System.out.println("In expression contains Exit Character: " + exitCharacter);
                System.out.println("End of the programme.");
                break;
            }
            int result = Calculator.calculate(reader.getVar1(), reader.getVar2(), reader.getOper(), reader.isRoman());
            if(reader.isRoman()){
                ans = RomanArabicConverter.arabicToRoman(result);
                System.out.println(ans);
            } else {
                System.out.println(result);
            }
        }
    }
}