package ru.mentee.power.devtools.progress;

/**
 * Трекер прогресса для отслеживания выполнения уроков mentee.
 */
public class ProgressTracker {

    /**
     * Вычисляет суммарный прогресс группы mentee.
     *
     * @param mentees массив mentee
     * @return строка с информацией о суммарном прогрессе (пройдено/осталось уроков)
     */
    public String calculateTotalProgress(Mentee[] mentees) {
        // TODO: Реализовать логику подсчёта суммарного прогресса с использованием цикла while
        // Шаги:
        // 1. Проверить валидность массива (null, пустой)
        // 2. Инициализировать аккумуляторы: totalCompleted = 0, totalTotal = 0, index = 0
        // 3. Использовать цикл while (index < mentees.length) для перебора массива
        // 4. На каждой итерации: totalCompleted += mentees[index].completedLessons(), totalTotal += mentees[index].totalLessons(), index++
        // 5. Вычислить оставшиеся: totalRemaining = totalTotal - totalCompleted
        // 6. Вернуть строку формата: "Суммарно: пройдено X из Y уроков, осталось Z уроков"

        if (mentees == null || mentees.length == 0) {
            throw new UnsupportedOperationException("Метод calculateTotalProgress ещё не реализован");
        }
        var totalCompleted = 0;
        var totalTotal = 0;
        var index = 0;

        while (index < mentees.length) {
            totalCompleted += mentees[index].completedLessons();
            totalTotal += mentees[index].totalLessons();
            index++;
        }
        var totalRemaining = totalTotal - totalCompleted;
        return "Суммарно: пройдено %d из %d уроков, осталось %d уроков"
                .formatted(totalCompleted, totalTotal, totalRemaining);
    }

    static void main() {
        ProgressTracker tracker = new ProgressTracker();

        // Создаём массив mentee (продолжение DVT-2: добавляем прогресс к личной карточке)
        Mentee[] mentees = {
                new Mentee("Иван", "Москва", "Backend разработка", 5, 12),
                new Mentee("Мария", "Санкт-Петербург", "Fullstack", 8, 12),
                new Mentee("Пётр", "Казань", "Java Backend", 12, 12)
        };

        String progress = tracker.calculateTotalProgress(mentees);
        System.out.println(progress);
    }
}