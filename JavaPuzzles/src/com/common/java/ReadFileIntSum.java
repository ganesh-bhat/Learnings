package com.common.java;

import java.io.*;

public class ReadFileIntSum {

    public static void main(String[] args) {


        File file = new File("integersOnePerLine.txt");
        sumOfAllNumbers(file);


    }

    private static int sumOfAllNumbers(File file) {
        int sum = 0;
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(file));
            String st;
            while((st= br.readLine())!=null) {
                sum+=Integer.parseInt(st);
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if(br!=null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sum;
    }
}
