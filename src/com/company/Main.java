package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите x от -1 до 1:");
        double x = in.nextDouble();
        System.out.println("Введите n:");
        int n = in.nextInt();
        System.out.println("Введите e:");
        double e = in.nextDouble();
        double s1 = 0.0, s2 = 0.0, s3 = 0.0;
        s1 = Fun(x, n, s1);
        s2 = Fun1(x, e, n, s2);
        s3 = Fun2(x, e, n, s3);
        double arcsin;
        arcsin = Math.asin(x);
        System.out.print("Сумма " + n + " слагаемых ряда равна: " + s1 + "\n");
        System.out.print("Сумма слагаемых по абсолютной величине больше е: " + s2 + "\n");
        System.out.print("Сумма слагаемых по абсолютной величине больше е/10: " + s3 + "\n");
        System.out.print("Значение функции: " + arcsin + "\n");
    }

    public static double Fun(double x, int n, double s1) {
        double p = 1;
        s1 += x;
        int j1 = 1;
        for (int i = 1; i < n; i++) {
            p *= (double) j1 /(j1+1);
            s1 += p * (Math.pow(x, j1 + 2) / (j1 + 2));
            j1 += 2;
        }
        return s1;
    }

    public static double Fun1(double x, double e, int n, double s2) {
        double k, p = 1;
        s2 += x;
        int j1 = 1;
        if (s2 > e){
            for (int i = 1; i < n; i++) {
                p *= (double) j1 /(j1+1);
                s2 += p * (Math.pow(x, j1 + 2) / (j1 + 2));
                j1 += 2;
            }
        } else {
            for (int i = 1; i < n; i++) {
                p *= (double) j1 /(j1+1);
                k = p * (Math.pow(x, j1 + 2) / (j1 + 2));
                if (k > e) {
                    s2 += p * (Math.pow(x, j1 + 2) / (j1 + 2));
                }
                j1 += 2;
            }
        }
        return s2;
    }

    public static double Fun2(double x, double e, int n, double s3) {
        double k, p = 1;
        s3 += x;
        int j1 = 1;
        if (s3 > e / 10){
            for (int i = 1; i < n; i++) {
                p *= (double) j1 /(j1+1);
                s3 += p * (Math.pow(x, j1 + 2) / (j1 + 2));
                j1 += 2;
            }
        } else {
            for (int i = 1; i < n; i++) {
                p *= (double) j1 /(j1+1);
                k = p * (Math.pow(x, j1 + 2) / (j1 + 2));
                if (k > e / 10) {
                    s3 += p * (Math.pow(x, j1 + 2) / (j1 + 2));
                }
                j1 += 2;
            }
        }
        return s3;
    }}
