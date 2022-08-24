package com.jap;

import java.util.Arrays;
import java.util.Scanner;

public class QuizDemo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of school");
        int size = scanner.nextInt();
        String[] schoolName = new String[size];
        System.out.println("Enter name of school");
        for (int i = 0; i < schoolName.length; i++) {
                schoolName[i] = scanner.next();
        }
        String[] quizScore = new String[size];
        System.out.println("Enter quiz score");
        for (int i = 0; i < quizScore.length; i++) {
            quizScore[i] = String.valueOf(scanner.nextInt());
        }

        QuizDemo quizDemo = new QuizDemo();

        System.out.println("Highest quiz score of school = " + quizDemo.highestScore(schoolName, quizScore));
        System.out.println("School name Convert to upper case " + Arrays.toString(quizDemo.convertAllNamesToCapital(schoolName)));
    }

    //return the school name which has got the highest score in quiz
    //Handle the NumberFormatException
    public String highestScore(String[] nameOfSchool, String[] scores) {
        String highest = null;
        try {
            for (int i = 0; i < scores.length; i++) {
                for (int j = 0; j < scores.length - 1; j++) {
                    if (Integer.parseInt(scores[i]) > Integer.parseInt(scores[j])) {
                        highest = nameOfSchool[i];
                    }
                }
            }
        } catch (NumberFormatException e) {
            return e.toString();
        }
        return highest;

    }

    //convert all the names in uppercase
    //Handle the NullPointerException
    public String[] convertAllNamesToCapital(String name[]) {
        String upperCase[] = new String[name.length];
        try {
            for (int i = 0; i < name.length; i++) {
                if (!upperCase[i].equals(null))
                    upperCase[i] = name[i].toUpperCase();
            }
        } catch (NullPointerException e) {
            System.out.println("Name of school should not be null");
            return new String[]{e.toString()};
        }
        return upperCase;
    }
}






