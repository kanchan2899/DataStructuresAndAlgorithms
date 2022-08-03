package com.dsalgo.strings;

public class PrettyPrint {
    public static void main(String[] args) {
        float a = 453.83767734f;
        // printf() rounds off too
        System.out.printf("Formatted number is %.2f", a);
        System.out.println();
        System.out.printf("PI value is %.3f", Math.PI);
        System.out.println();
        System.out.printf("Hey, I am %s and I need %s", "robot", "food");
        /* List of all format specifiers in Java
        %c - Character
        %d - Decimal number (base 10)
        %e - Exponential floating-point number
        %f - Floating-point number
        %i - Integer (base 10)
        %o - Octal number (base 8)
        %s - String
        %u - Unsigned decimal (integer) number
        %x - Hexadecimal number (base 16)
        %t - Date/time
        %n - Newline
         */
    }
}
