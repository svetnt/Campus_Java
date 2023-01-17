package org.example;

public class Java_Part1_completed {
    public static void main(String[] args) {

        int firstSide = 20;
        int secondSide = 10;
        int angleGrad = 90;
        double areaTriangle = getAreaTriangle(firstSide, secondSide, angleGrad);
        System.out.printf("Площадь треугольника со сторонами %d и %d и углом %d равна %.0f \n",
                firstSide, secondSide, angleGrad, areaTriangle);

        int radius = 5;
        double areaCircle = getAreaCircle(radius);
        System.out.printf("Площадь круга с радиусом %d равна %.0f \n", radius, areaCircle);

        int min = 0;
        int max = 100;
        int randomInt = getRandomInt(min, max);
        System.out.printf("Случайное целое число от %d до %d: %d \n", min, max, randomInt);

        int n = 5;
        int m = 5;
        System.out.printf("Двумерный массив размера %d на %d, заполненный случайными числами от 0 до 9:\n", n, m);
        printRandomArray(n, m, 0, 9);
    }

    public static double getAreaTriangle(int firstSide, int secondSide, int angleGrad) {
        return Math.round(0.5 * firstSide * secondSide * Math.sin(Math.toRadians(angleGrad)));
    }

    public static double getAreaCircle(int radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    public static int getRandomInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static void printRandomArray(int n, int m, int min, int max) {
        int[][] array = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = getRandomInt(min, max);
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}

