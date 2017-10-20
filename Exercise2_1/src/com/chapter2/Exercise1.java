package com.chapter2;
 import java.time.*;
 import java.util.*;
public class Exercise1 {
    public static void main(String[] args){
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
        LocalDate date = LocalDate.of(2017, 11, 1);
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue();
        for (int i = 1; i< (value+1)%7; i++){
            System.out.printf("    ");
        }
        while (date.getMonthValue() == 11) {
            System.out.printf("%4d", date.getDayOfMonth());
            weekday = date.getDayOfWeek();
            value = weekday.getValue();
            if (value == 6) {
                System.out.println("");
            }
            date = date.plusDays(1);
        }
        System.out.println();

        String input = "1 fish 2 fish red fish blue fish";
        Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");
        System.out.println(s.nextInt());
        System.out.println(s.nextInt());
        System.out.println(s.next());
        System.out.println(s.next());
        s.close();

        int numTests = 20;

        // create a new Java Random object
        Random random = new Random();
        for ( int i=0; i<numTests; i++ )
        {
            // get the next random int
            int randomInt = random.nextInt(100);
            System.out.format("test %2d, randomInt = %d\n", i+1, randomInt );
        }

        Integer aa=new Integer(10);
        Integer bb=new Integer(20);
        System.out.printf("%4d____%4d", aa, bb);
        mswap(aa,bb);
        System.out.printf("%d____%d", aa, bb);
    }
    public static void mswap(Integer a, Integer b){
        System.out.printf("%d____%d", a, b);
        int t = a.intValue();
        a = b.intValue();
        b = t;
        System.out.printf("%d____%d", a, b);
    }
}
