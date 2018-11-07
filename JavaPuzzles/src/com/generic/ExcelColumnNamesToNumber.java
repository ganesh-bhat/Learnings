package com.generic;

public class ExcelColumnNamesToNumber {

    private static int namesToNumber(String str) {

        String name = str.toUpperCase();

        int i = name.length()-1;

        int value = 0;
        while(i>=0) {
            char ch = name.charAt(i);
            int pos = name.length()-1-i;
            value += Math.pow(26,pos)*((ch -'A')+1);
            i--;
        }
        return value;
    }


    private static int namesToNumber2(String str) {
        int result = 0;
        for(int i = 0;i< str.length() ; i++)
        {
            result *= 26;
            result += str.charAt(i) - 'A' +1;
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(namesToNumber("AAB"));
        System.out.println(namesToNumber2("AAB"));
    }
}
