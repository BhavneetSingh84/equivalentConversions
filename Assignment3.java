package ca.sheridan.sin11051;

/*
The conversion of string to decimal and its equivalent
Author: Bhavneet Singh
Student ID: 991614899
Date: March 20, 2021
*/

import java.util.Scanner;

public class Assignment3 {
    public static void main(String[] args){

            //to read the input
            Scanner in = new Scanner(System.in);

            //prompt user to input the number
            System.out.print("Please enter the number(minimum 5 digits): ");
            String stringNumber = in.nextLine();

            // to get the 5 right most digits of the string
             String limitedStringDigits = stringNumber.substring(stringNumber.length()-5);


        // converting the string into decimal
        int number=0;
        for (int i=0;i<limitedStringDigits.length();i++) {
            //get the two numbers at a time instead of doing individual it uses 2 numbers for conversion
            number = number * 10;
            number=number +(int) limitedStringDigits.charAt(i) - 48;      // subtracting 48 because the value of '0' is 48 in Unicode
        }

        // Prompt user if he wishes to convert the number into its equivalent.
        System.out.print("Do you want to convert a numeric string to equivalent number? for yes press 1 and for no press 0: ");
        int reponse = in.nextInt();

        // loop for if user wants the number to convert multiple times
        while (reponse != 0) {

           // Prompt user for the equivalent conversion
            System.out.print("\t1 for Decimal number\n" + "\t2 for Binary number\n" + "\t3 for Octal number\n" +
                    "\t4 for Hexa number\n" + "Decide which equivalent value you would like to convert: ");
            int decide = in.nextInt();

            //outputs of the string
            System.out.printf("The initial String entered was: %10s",stringNumber);
            System.out.print("\nThe string with five right most digits: "+limitedStringDigits+"\nEquivalent to:");

            if (decide == 1){
                System.out.print("\nthe Decimal number is: "+number);
            }
            if (decide == 2) {
                System.out.print("\nThe Binary number is: ");
                int binary = decimalToBinary(number);
            }
            if (decide == 3) {
                System.out.print("\nThe Octal number is: ");
                int octal = decimalToOctal(number);
            }
            if (decide == 4) {
                System.out.print("\nThe Hexadecimal number is: ");
                char hexadecimal = decimalToHexadecimal(number);
            }

            // Prompt user if he wishes to convert the number into its equivalent again.
            System.out.print("\nDo you want to convert its equivalent number? for yes press 1 and for no press 0: ");
            reponse = in.nextInt();

        }

        //termination
        System.out.print("\nThanks for your response.\n");

    }

    public static int decimalToBinary(int number){
        int[] decimalToBinary = new int[20];
        int i=0;
        while (number>0){
            decimalToBinary[i]=number%2;             // for 0 or 1 as a remainder
            i++;
            number=number/2;                          // to get the half of the number
        }

        int k=0;
        for ( k=(i-1);k>=0;k--){                         // (i-1) because number got incremented at last in while loop
            System.out.print(decimalToBinary[k]);              // output of the array
        }
        return k;
    }

    public static int decimalToOctal(int number){
        int[] decimalToOctal = new int[6];
        int m = 0;
        while (number>0){
            decimalToOctal[m]=number%8;               // for remainder from 0 to 7
            m++;
            number=number/8;                   //to get the quotient for further conversion
        }

        int n =0;
        for (n=(m-1);n>=0;n--) {                      // (m-1) because num got incremented at last in while loop
            System.out.print(decimalToOctal[n]);      // output of the array
        }
        return n;
    }

    public static char decimalToHexadecimal(int number){
        char[] hexadecimal= new char [5];
        int remainder=0;
        int i=0;
        int j=0;
        while (number>0) {
            remainder = number % 16;                        // to get the remainder from 0 to 15
            if (remainder<10){
                hexadecimal[j++]= (char)(48+remainder);     // because char 0 has value 48 and suppose if the remainder is 2 then 48+2=50 which is 2
            }
            else{
                hexadecimal[j++]=(char)(55+remainder);   //because the A has value 65 and assume remainder is 10 then 10+55=65 which will give A as result
            }
            number = number/16;
        }
        for (i=(j-1);i>=0;i--){
            System.out.print(hexadecimal[i]);             // output of the array
        }
        return (char) i;
    }

}