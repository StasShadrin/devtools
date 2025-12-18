package ru.mentee.power;

/**
 * Представление прогресса mentee в спринте.
 * Содержит информацию о mentee, номере спринта и запланированных часах.
 *
 * @param menteeName имя mentee
 * @param sprintNumber номер спринта
 * @param plannedHoursPerWeek запланированные часы в неделю
 */
public record MenteeProgress(String menteeName, int sprintNumber, int plannedHoursPerWeek) {

    /**
     * Проверяет, готов ли mentee к спринту.
     * Mentee считается готовым, если запланировано не менее 3 часов в неделю.
     *
     * @return true если mentee готов к спринту
     */
    public boolean readyForSprint()  {
        return plannedHoursPerWeek >= 3;
    }

    /**
     * Возвращает текстовое описание прогресса mentee.
     *
     * @return строка с информацией о спринте
     */
    public String summary() {
        return "Sprint %d -> %s: planned %d h"
                .formatted(sprintNumber, menteeName, plannedHoursPerWeek);
    }
}