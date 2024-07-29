package org.sun.service;

public class ArithmaticOperation {

    public int sum(int x , int y){
        System.out.println("Arithmatic Operation Addition Start: ");
        int z=0;
        z=x+y;
        System.out.println("Arithmatic Operation Addition End: ");
        return z;
    }

    public int sub(int x , int y){
        System.out.println("Arithmatic Operation Subtraction Start: ");
        int z=0;
        z=x-y;
        System.out.println("Arithmatic Operation Subtraction End: ");
        return z;
    }

    public static void main(String[] args) {
        ArithmaticOperation arithmaticOperation = new ArithmaticOperation();
        arithmaticOperation.sum(10, 20);
        arithmaticOperation.sub(10, 20);
        System.out.println("Arithmatic Operation Main End: ");
    }

}
