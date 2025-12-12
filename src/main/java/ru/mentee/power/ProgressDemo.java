package ru.mentee.power;

public class ProgressDemo {
    public static void main(String[] args) {
        var progress = new MenteeProgress("Stas", 1, 7);

        System.out.println(progress.summary());
        if (progress.readyForSprint()) {
            System.out.println("Status: sprint ready");
        } else {
            System.out.println("Status: backlog first");
        }
    }
}
