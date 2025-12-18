package ru.mentee.power.devtools.student;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для управления списком студентов.
 * Предоставляет методы для добавления и фильтрации студентов.
 */
public class StudentList {
    private final List<Student> studentList;

    /**
     * Создает новый пустой список студентов.
     */
    public StudentList() {
        studentList = new ArrayList<>();
    }

    /**
     * Добавляет студента в список, если он не равен null.
     *
     * @param student студент для добавления
     */
    public void addStudent(Student student) {
        if (student != null) {
            studentList.add(student);
        }
    }

    /**
     * Возвращает список студентов из указанного города.
     *
     * @param city город для фильтрации
     * @return список студентов из указанного города
     */
    public List<Student> getStudentsFromCity(String city) {
        return studentList.stream()
                .filter(s -> s.city().equals(city))
                .toList();
    }
}
