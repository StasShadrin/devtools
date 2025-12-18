package ru.mentee.power.devtools.progress;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Fail.fail;

@DisplayName("Тестирование ProgressTracker")
class ProgressLoopTest {

    @Test
    @DisplayName("Должен корректно вычислить суммарный прогресс когда передан массив mentee")
    void shouldCalculateTotalProgressWhenMultipleMentees() {
        // given - подготовка данных
        ProgressTracker tracker = new ProgressTracker();
        Mentee[] mentees = {
                new Mentee("Иван", "Москва", "Backend разработка", 5, 12),
                new Mentee("Мария", "Санкт-Петербург", "Fullstack", 8, 12),
                new Mentee("Пётр", "Казань", "Java Backend", 12, 12)
        };

        // when - выполнение действия
        String result = tracker.calculateTotalProgress(mentees);

        // then - проверка результата с assertJ
        assertThat(result)
                .contains("пройдено 25 из 36 уроков")
                .contains("осталось 11 уроков");
    }

    @Test
    @DisplayName("Должен корректно обработать массив когда все mentee завершили курс")
    void shouldCalculateTotalProgressWhenAllMenteesCompleted() {
        // given
        ProgressTracker tracker = new ProgressTracker();
        Mentee[] mentees = {
                new Mentee("Иван", "Москва", "Backend", 12, 12),
                new Mentee("Мария", "СПб", "Fullstack", 12, 12)
        };

        // when
        String result = tracker.calculateTotalProgress(mentees);

        // then
        assertThat(result)
                .contains("пройдено 24 из 24 уроков")
                .contains("осталось 0 уроков");
    }

    @Test
    @DisplayName("Должен выбросить исключение когда массив mentee равен null")
    void shouldThrowWhenMenteesIsNull() {
        ProgressTracker tracker = new ProgressTracker();
        assertThatThrownBy(() -> tracker.calculateTotalProgress(null))
                .isInstanceOf(UnsupportedOperationException.class)
                .hasMessage("Метод calculateTotalProgress ещё не реализован");
    }

    @Test
    @DisplayName("Должен выбросить исключение когда массив mentee пустой")
    void shouldThrowWhenMenteesIsEmpty() {
        ProgressTracker tracker = new ProgressTracker();
        assertThatThrownBy(() -> tracker.calculateTotalProgress(new Mentee[0]))
                .isInstanceOf(UnsupportedOperationException.class)
                .hasMessage("Метод calculateTotalProgress ещё не реализован");
    }

    @Test
    @DisplayName("Должен корректно работать main метод")
    void shouldWorkMainMethod() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            ProgressTracker.class.getDeclaredMethod("main").invoke(null);

            String output = outContent.toString().trim();
            assertThat(output)
                    .contains("пройдено 25 из 36 уроков")
                    .contains("осталось 11 уроков");
        } catch (Exception e) {
            fail("Ошибка при вызове main метода: " + e.getMessage());
        } finally {
            System.setOut(originalOut);
        }
    }
}