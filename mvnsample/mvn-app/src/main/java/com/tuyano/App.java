package com.tuyano;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        new App().printMessage("Taro");
    }
    
    public String getMessage(String name) {
        return "Hi," + name + ". Welcom to Maven World!";
    }
    
    public void printMessage(String name) {
        System.out.println("\n***** App class *****\n");
        System.out.println(this.getMessage(name));
        System.out.println("\n***** App class *****\n");
    }
}
