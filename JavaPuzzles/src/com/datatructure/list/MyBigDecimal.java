package com.datatructure.list;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ganes on 10-06-2018.
 */
public class MyBigDecimal {

    //does the addition using the linked lists

    List<Byte> number = new ArrayList<>();

    public static void main(String[] args) {
            MyBigDecimal myBd = new MyBigDecimal("6273612783612");
        MyBigDecimal myBd2 = new MyBigDecimal("3261736217838");
        myBd.add(myBd2);

        System.out.println(myBd);

        BigDecimal bd = new BigDecimal("6273612783612");
        BigDecimal bd2 = new BigDecimal("3261736217838");
        BigDecimal res = bd.add(bd2);
        System.out.println(res);

    }

    MyBigDecimal(String largeNumber) {
        for(int i=0;i<largeNumber.length();i++  ) {
            number.add(Byte.parseByte(String.valueOf(largeNumber.charAt(i))));
        }
    }

    public void add(MyBigDecimal num) {
        int count2 = num.number.size();
        int selfCount = number.size();

        List<Byte> result = new ArrayList<>();
        byte carry = 0;
        for(int i=selfCount-1,j=count2-1;i>=0||j>=0;i--,j--) {
            byte res = 0;
            if(i>=0 && j>=0) {
                res = (byte) (num.number.get(j) + number.get(i));
            } else if(i>=0) {
                res = (byte) (number.get(i));
            } else if(j>=0) {
                res = (byte) (num.number.get(j));
            }
            res+=carry;


            carry = (byte) (res/10);

            res = (byte) (res%10);
            result.add((byte)res);
        }


        //reverse list
        List<Byte> finalRes = new ArrayList<>();
        for(int i=result.size()-1;i>=0;i--) {
            finalRes.add(result.get(i));
        }
        this.number = finalRes;
    }

    @Override
    public String toString() {
        return this.number.toString();
    }
}
