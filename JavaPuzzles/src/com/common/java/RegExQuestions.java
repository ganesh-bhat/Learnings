package com.common.java;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExQuestions {

    public static void getAllNumsFromString(String str) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()) {
            System.out.println(matcher.group());
        }
    }


    public static void splitOnNewLine(String str) {
       Pattern p = Pattern.compile(System.getProperty("line.separator"));
       String[] strings = p.split(str);
        System.out.println(Arrays.toString(strings));
    }

    public static void countAnBn(String str) {
        Pattern p = Pattern.compile("a?+b?+");
        Matcher m = p.matcher(str);
        while(m.find()) {
            System.out.println("found "+m.group());
        }
    }

    public static void main(String[] args) {
        getAllNumsFromString("this is 1t time I have told to call this 3 times or 4 times");
        splitOnNewLine("dasdasd\r\n" +
                "nadAD\r\n" +
                "nADADADdsadasdasdasd\r\n" +
                "dsadsadasdasd\r\n" +
                "adasdadadasdas\r\n" +
                "aa");

        countAnBn("aaaabb");
    }




}
