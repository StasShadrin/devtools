package ru.mentee.power.devtools;

/**
 * Задание на практику LiveCoding.
 * */
public class LiveCodingDemo {
    static int[] array = new int[]{1, 3, 5, -6, 45, 6, 2, 77};

    static void main() {
        printFizzBuzz(15);
        sumEven(array);
        findMax(array);
    }

    /**
     * Метод, который выводит числа от 1 до n.
     * Если число делится на 3 — выведи "Fizz", на 5 — "Buzz", на оба — "FizzBuzz", иначе само число.
     * <p>
     * Пример вывода для n = 15:
     * 1
     * 2
     * Fizz
     * 4
     * Buzz
     * Fizz
     * 7
     * 8
     * Fizz
     * Buzz
     * 11
     * Fizz
     * 13
     * 14
     * FizzBuzz
     * */
    static void printFizzBuzz(int n) {
        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println("FizzBuzz");
                } else if (i % 3 == 0) {
                    System.out.println("Fizz");
                } else if (i % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(i);
                }
            }
        }
    }

    /**
     * Метод, который возвращает сумму всех чётных чисел в массиве.
     * */
    static void sumEven(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (array[i] % 2 == 0) {
                sum = sum + array[i];
            }
        }
        System.out.println(sum);
    }

    /**
     * Метод, который находит максимальное значение в массиве.
     * Обработай случай пустого массива: верни Integer.MIN_VALUE или брось IllegalArgumentException.
     * */
    static void findMax(int[] numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException();
        }
        int max = Integer.MIN_VALUE;
        for (int i : numbers) {
            if (i > max) {
                max = i;
            }
        }
        System.out.println(max);
    }
}
