package ru.mentee.power.devtools.progress;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MenteeTest {

    @Test
    void shouldThrowWhenCompletedLessonsIsNegative() {
        assertThatThrownBy(() -> new Mentee("Стас", "Сочи", "Java", -1, 10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Некорректные значения прогресса");
    }

    @Test
    void shouldThrowWhenTotalLessonsIsZero() {
        assertThatThrownBy(() -> new Mentee("Стас", "Сочи", "Java", 5, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Некорректные значения прогресса");
    }

    @Test
    void shouldThrowWhenCompletedExceedsTotal() {
        assertThatThrownBy(() -> new Mentee("Стас", "Сочи", "Java", 15, 10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Некорректные значения прогресса");
    }
}