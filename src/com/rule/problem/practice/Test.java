package com.rule.problem.practice;

/**
 * @description:
 * @author: rule
 * @date: 2020-08-04 22:57
 **/
public class Test {
    int i = f();
    private int j = g(i);

    private int f() {
        return 10;
    }

    private int g(int n) {
        return n * 10;
    }

    public Test() {
        System.out.println("ccnstruct");
    }

    static Test a;
    static {
        System.out.println("static");
        a  =  new Test();
    }

    @Override
    protected void finalize() throws Throwable {
//        super.finalize();
        System.out.println("clean up");
    }

    public static void main(String[] args) {
        ;
    }
}
