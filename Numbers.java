package Ironhack.C1;

import java.util.Arrays;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Numbers {

    public enum Num {
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        OTHER
    }

    // EX 1 - VERSION 1
    public static int getMaxValueFromInput(){
        // Read from the input stream
        Scanner in = new Scanner(System.in);
        String entry = in.nextLine();
        in.close();

        // Replace all whitespaces with empty
        entry = entry.replaceAll("\\s+","");

        // Parse input string to Array int
        int[] numArr = Arrays.stream(entry.split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Array passed: " + Arrays.toString(numArr));

        // Sort array elements
        Arrays.sort(numArr);
        System.out.println("Sorted array: " + Arrays.toString(numArr));

        // Return the maximum value
        return numArr[numArr.length-1];
    }

    // EX 1 - VERSION 2
    public static int getMaxValueFromArr(Integer[] numList){
        int currentMax = 0;
        for (int m: numList){
            if (m > currentMax){
                currentMax = m;
            }
        }
        return currentMax;
    }

    // EX 2 - VERSION 1
    public static Num printNumberFromWord(int number){
        switch (number){
            case 1:
                return Num.ONE;
            case 2:
                return Num.TWO;
            case 3:
                return Num.THREE;
            case 4:
                return Num.FOUR;
            case 5:
                return Num.FIVE;
            case 6:
                return Num.SIX;
            case 7:
                return Num.SEVEN;
            case 8:
                return Num.EIGHT;
            case 9:
                return Num.NINE;
            default:
                return Num.OTHER;
        }
    }
    // EX 2 - VERSION 2
    public static Num printNumberFromWord2(int number){
        if (number == 1){
            return Num.ONE;
        } else if (number == 2) {
            return Num.TWO;
        } else if (number == 3){
            return Num.THREE;
        } else if (number == 4){
            return Num.FOUR;
        } else if (number == 5){
            return Num.FIVE;
        } else if (number == 6){
            return Num.SIX;
        } else if (number == 7){
            return Num.SEVEN;
        } else if (number == 8) {
            return Num.EIGHT;
        } else if (number == 9) {
            return Num.NINE;
        } else {
            return Num.OTHER;
        }
    }

    // EX 3 - using functional interfaces
    public static void checkOddEven(int num, Predicate<Integer> checker, Function<Integer,String> mapper, Consumer<String> block){
        if(checker.test(num)){
            block.accept(mapper.apply(num));
        }
    }

    // EX 4 - VERSION 1
    public static double calculateAverage(int[] numList) {
        return (double)IntStream.of(numList).sum() / numList.length;
    }
    // EX 4 - VERSION 2
    public static double calculateAverage(Integer[] numList){
        return (double)Arrays.stream(numList).mapToInt(Integer::intValue).sum()/numList.length;
    }
    // EX 4 - VERSION 3
    public static double calculateAverage(List<Integer> numList){
        return (double)numList.stream().mapToInt(Integer::intValue).sum()/numList.size();
    }
    public static void main(String[] args){
        System.out.println(Numbers.getMaxValueFromInput());
        System.out.println(Numbers.getMaxValueFromArr(new Integer[] {1, 45, 20, 845, 2, 34, 110}));
        checkOddEven(231456, num -> {return num % 2 == 0;}, num -> {return "Number " + num + " is even.";}, System.out::println);
    }
}
