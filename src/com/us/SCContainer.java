package com.us;

import java.util.Scanner;

public class SCContainer {
    private Scanner sc=  new Scanner(System.in);;
    private SCContainer(){
    }

    public static class ScannerHolder{
        public static SCContainer container = new SCContainer();
    }
    public static SCContainer getScanner(){
        return getScanner();
    }

}