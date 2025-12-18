package ru.mentee.power.devtools.student;

import java.util.List;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class StudentListTest {

    @Test
    void shouldAddStudentWhenStudentIsNotNull() {
        StudentList list = new StudentList();
        Student student = new Student("Стас", "Сочи");
        list.addStudent(student);
        assertThat(list.getStudentsFromCity("Сочи")).containsExactly(student);
    }

    @Test
    void shouldAddStudentWhenStudentIsNull() {
        StudentList list = new StudentList();
        list.addStudent(null);
        assertThat(list.getStudentsFromCity("Сочи")).isEmpty();
    }

    @Test
    void shouldReturnStudentsFromCityWhenCityExists() {
        StudentList list = new StudentList();
        list.addStudent(new Student("Анна", "Казань"));
        list.addStudent(new Student("Борис", "Москва"));
        list.addStudent(new Student("Вера", "Казань"));

        List<Student> kazanStudents = list.getStudentsFromCity("Казань");
        assertThat(kazanStudents)
                .hasSize(2)
                .containsExactly(
                        new Student("Анна", "Казань"),
                        new Student("Вера", "Казань")
                );
    }

    @Test
    void shouldReturnEmptyListWhenCityHasNoStudents() {
        StudentList list = new StudentList();
        list.addStudent(new Student("Иван", "Москва"));
        assertThat(list.getStudentsFromCity("Сочи")).isEmpty();
    }
}