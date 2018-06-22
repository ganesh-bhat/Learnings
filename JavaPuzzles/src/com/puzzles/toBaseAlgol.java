package com.puzzles;

public class toBaseAlgol {
    public static void main(String[] args) {

        int num = 45454;
        System.out.println(toBase(num,16));
        System.out.println(Integer.toString(num,16));
    }

    private static String toBase(int decimalNum, int base) {
        StringBuilder sb = new StringBuilder();
        int rem = 0;
        int num = decimalNum;
        while (num > 0) {
            rem = num%base;
            num = num/base;
            if(base == 16 && rem > 9) {
                sb.append(getHexaVal(rem));
            } else {
                sb.append(rem);
            }

        }
        return sb.reverse().toString();
    }

    private static char getHexaVal(int rem) {
        return (char)((byte)('a') + ( rem - 10));
    }
}
