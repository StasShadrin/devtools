package ru.mentee.power.devtools.progress;

/**
 * Запись, представляющая mentee (ученика) с его прогрессом.
 * Содержит информацию об имени, городе, цели и прогрессе в уроках.
 *
 * @param name имя mentee
 * @param city город mentee
 * @param goal учебная цель mentee
 * @param completedLessons количество пройденных уроков
 * @param totalLessons общее количество уроков
 */
public record Mentee(String name,
                     String city,
                     String goal,
                     int completedLessons,
                     int totalLessons) {

    /**
     * Компактный конструктор для проверки корректности данных.
     */
    public Mentee {
        if (completedLessons < 0 || totalLessons <= 0 || completedLessons > totalLessons) {
            // закомментировал строчку для проведения само-ревью
            throw new IllegalArgumentException("Некорректные значения прогресса");
        }
    }
}
