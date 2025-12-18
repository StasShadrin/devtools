package ru.mentee.power;

/**
 * Демонстрационный класс для тестирования функционала MenteeProgress.
 */
public class ProgressDemo {
    static void main() {
        var progress = new MenteeProgress("Stas", 1, 7);

        System.out.println(progress.summary());
        if (progress.readyForSprint()) {
            System.out.println("Status: sprint ready");
        } else {
            System.out.println("Status: backlog first");
        }
    }
}
