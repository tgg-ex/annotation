package com.zj.demo;

public class Test {

    public static void main(String[] args) throws NoSuchMethodException {
        TestInfo testInfo = new TestInfo();
        testInfo.setName("87845");
        Check.chech(testInfo);
        System.out.println("校验通过");
    }


}
