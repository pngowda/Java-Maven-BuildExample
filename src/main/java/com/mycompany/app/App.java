package com.mycompany.app;

/**
 * Hello world!
 */
public class App
{

    private final String message1 = "Hello World!";
    private final String message2 = "Hello";

    public App() {}

    public static void main(String[] args) {
        System.out.println(new App().getMessage1());
        System.out.println(new App().getMessage2());
    }

    private final String getMessage1() {
        return message1;
    }
    
   private final String getMessage2() {
        return message2;
    }

}
