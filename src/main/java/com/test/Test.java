package com.test;

/**
 * @author huangxl
 * @date 2018-06-14 22:56
 */
public class Test {

    void change(String str,String s2, Integer a, int b) {
        str = "b";
        s2 = new String("aaa");
        a = new Integer(11);
        b = 100;
    }

    public static void main(String[] args) {
        String str = "abc";
        String newStr = new String("qw");
        Integer a = 2;
        int b = 10;

        Test test = new Test();
        test.change(str,newStr, a, b);
        System.out.println(str);
        System.out.println(newStr);
        System.out.println(a);
        System.out.println(b);
    }

}
