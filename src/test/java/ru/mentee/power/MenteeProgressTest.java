package ru.mentee.power;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MenteeProgressTest {
    @Test
    void shouldFormatSummary_whenProgressCreated() {
        var progress = new MenteeProgress("Bob", 1, 10);

        String result = progress.summary();

        assertThat(result).isEqualTo("Sprint 1 -> Bob: planned 10 h");
    }

    @Test
    void shouldFormatSummary_withDifferentSprintNumber() {
        var progress = new MenteeProgress("Дима", 5, 8);
        assertThat(progress.summary()).isEqualTo("Sprint 5 -> Дима: planned 8 h");
    }

    @Test
    void shouldDetectReadiness_whenHoursAboveThreshold() {
        var progress = new MenteeProgress("Sam", 1, 4);

        assertThat(progress.readyForSprint()).isTrue();
    }

    @Test
    void shouldDetectLackOfReadiness_whenHoursBelowThreshold() {
        var progress = new MenteeProgress("Ирина", 1, 2);

        assertThat(progress.readyForSprint()).isFalse();
    }

    @Test
    void shouldDetectReadiness_whenHoursExactlyAtThreshold() {
        var progress = new MenteeProgress("Alex", 1, 3);
        assertThat(progress.readyForSprint()).isTrue();
    }
}