package com.company;

import java.util.Scanner;

public class YardGreening {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);

        double area = Double.parseDouble(scan.nextLine());
        double initialPrice = area * 7.61;
        double discount = initialPrice - initialPrice * 0.82;

        System.out.println("The final price is: " + (initialPrice - discount) + " lv.");
        System.out.println("The discount is: " + discount + " lv.");
    }
}
