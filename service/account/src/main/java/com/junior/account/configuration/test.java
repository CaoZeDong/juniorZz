package com.junior.account.configuration;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author caozedong
 * @date 2020/12/25 16:26
 */
public class test {




    public static void main(String[] args) {
        int [] a ={1,4,5,72,23,67,113,7,8,9,33};
        int tem;
        for (int i=0;i<a.length-1;i++){

            for (int j=i+1;j<a.length;j++){
                if (a[i] > a[j]) {
                    tem = a[i];
                    a[i] = a[j];
                    a[j] = tem;
                }
            }
        }


        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+",");
        }

    }

}
