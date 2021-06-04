/*
Exercise 17 - Blood Alcohol Calculator

Sometimes you have to perform a more complex calculation based on some provided inputs and then use that result to make a determination.

Create a program that prompts for your weight, gender, number of drinks, the amount of alcohol by volume of the drinks consumed (as a percent), and the amount of time since your last drink. Calculate your blood alcohol content (BAC) using this formula

BAC = (A × 5.14 / W × r) − .015 × H

where

    A = (number of drinks * alcohol by volume) is total alcohol consumed, in ounces (oz).
    W is body weight in pounds.
    r is the alcohol distribution ratio:
        0.73 for men
        0.66 for women
    H is number of hours since the last drink.

Display whether or not it’s legal to drive by comparing the blood alcohol content to 0.08.
Example Output

Your BAC is 0.08
It is not legal for you to drive.

Constraint

    Prevent the user from entering non-numeric values.

Challenges

    Handle metric units.
    Look up the legal BAC limit by state and prompt for the state. Display a message that states whether or not it’s legal to drive based on the computed BAC.
    Develop this as a mobile application that makes it easy to record each drink, updating the BAC each time a drink is entered.

*/
/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 first_name last_name
 */
import java.util.Scanner;

public class ex17 {
    public static boolean isNumeric(String str){
        try{
            Double.parseDouble(str);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    public static void main(String[] args){
        Scanner cursor = new Scanner(System.in);


        System.out.print("What is your weight in pounds? ");
        String weight = cursor.nextLine();
        while(isNumeric(weight) == false){
            System.out.print("Please enter a numeric value. ");
            weight = cursor.nextLine();
        }
        double w = Double.parseDouble(weight);

        System.out.print("What is your gender? (Please enter 'Male' or 'Female') ");
        String Gender = cursor.nextLine();
        double r = ((Gender.equals("Male"))?0.73:0.66);

        System.out.print("How many drinks have you had? ");
        String drinks = cursor.nextLine();
        while(isNumeric(drinks) == false){
            System.out.print("Please enter a numeric value. ");
            drinks = cursor.nextLine();
        }
        int d = Integer.parseInt(drinks);

        System.out.print("What is the amount of alcohol by volume in the drinks you have had? ");
        String volume = cursor.nextLine();
        while(isNumeric(volume) == false){
            System.out.print("Please enter a numeric value. ");
            volume = cursor.nextLine();
        }
        double v = Double.parseDouble(volume);
        v /= 100;

        System.out.print("How many hours has it been since your last drink? ");
        String hours = cursor.nextLine();
        while(isNumeric(hours) == false){
            System.out.print("Please enter a numeric value. ");
            hours = cursor.nextLine();
        }
        double h = Double.parseDouble(hours);

        double BAC = ((d*v)*5.14/w*r) - 0.15 * h;

        System.out.println("Your BAC is " + BAC);

        String ret = ((BAC < 0.08)?"It is legal for you to drive":"It is not legal for you to drive.");

        System.out.println(ret);
    }
}
