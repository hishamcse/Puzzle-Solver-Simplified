package com.Hisham.TowerOfHenoI;

import java.util.Scanner;

public class Hanoi {

    private static final StringBuilder sb = new StringBuilder();

    private static void Tower_of_Hanoi(String origin, String destination, String buffer, int number) {
        if (number == 0)
            return;
        Tower_of_Hanoi(origin, buffer, destination, number - 1);
        sb.append("Move Disk #").append(number).append(" from ").append(origin).
                append(" to ").append(destination).append("\n");
        Tower_of_Hanoi(buffer, destination, origin, number - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Tower_of_Hanoi("A", "C", "B", n);
        System.out.println(sb.toString());
        System.out.println("Total steps " + sb.toString().split("\n").length);
    }
}