# devtools — Mentee Progress Tracker

## Quick Start

1. Убедись, что установлены **JDK 25** и **Gradle** (рекомендуется использовать Wrapper).
2. Собери и запусти приложение:
   ```bash
   ./gradlew run
3. Запусти автоматические тесты:
   ```bash
   ./gradlew test

## Описание

Проект демонстрирует использование record в Java 25 для отслеживания прогресса менти по программе обучения.  
Основной класс: ru.mentee.power.ProgressDemo.  
Содержит логику расчёта готовности к спринту на основе отработанных часов.

## Структура MenteeProgress

| Поле                     | Тип      | Описание                      |
|--------------------------|----------|-------------------------------|
| `menteeName`             | `String` | Имя менти                     |
| `sprintNumber`           | `int`    | Номер спринта                 |
| `plannedHoursPerWeek`    | `int`    | Количество затраченных часов  |


## Методы

- `summary()` — возвращает строку вида `"Sprint '№' -> 'имя менти': planned 'время' h"`.
- `readyForSprint()` — возвращает `Status: sprint ready/backlog first`.

## Правило веток: feature/DVT-X

Все фичи и задачи разрабатываются в отдельных ветках по шаблону:  
**`feature/DVT-<номер>`**

Примеры:
- `master` — основная (стабильная) ветка
- `feature/DVT-3` — ветка для реализации задачи DVT-3

## Git локальный цикл: шаги и команды

1. **Настройка пользователя и проверка Git в IDEA**
   - В терминале:
     ```bash
     git config --global user.name "Имя Фамилия"
     git config --global user.email "student@example.com"
     git config --list | grep user
     ```
   - В IntelliJ IDEA:  
     `Settings (Ctrl+Alt+S) → Version Control → Git → Test`

2. **Инициализация репозитория**
   - Через UI: правый клик по корню проекта → **Git → Initialize Repository**

3. **Первый коммит в ветке `master` (через CLI)**
   ```bash
   git add .gitignore README.md
   git status
   git commit -m "Добавить локальный шаблон и правило веток"
   ```

4. **Создание и переключение на ветку задачи**
   - Через UI: Git Branches popup → New Branch → feature/DVT-3 → Checkout
   - Проверка через CLI:  
     ```bash
     git branch --show-current  # ожидаем: feature/DVT-3

5. **Коммит изменений в коде (через CLI)**
   - Изменить ProgressDemo.java (например, добавить вывод имени ветки)
   - Выполнить:
     ```bash
     git add src/main/java/ru/mentee/power/ProgressDemo.java
     git commit -m "Добавить вывод ветки в ProgressDemo"
     git log --oneline
     ```
     
6. **Коммит изменений в документации (через Commit Tool Window)**
   - Обновить README.md (раздел «Git локальный цикл»)
   - Открыть Commit Tool Window (Alt+0)
   - Ввести сообщение: Обновить README для локального Git → нажать Commit

7. **Проверка истории**
   - Выполнить:
     ```bash
     git log --oneline
     git status
     ```

## Правило «git status clean»

1. **Проверка индекса**
    - Выполнить:
     ```bash
     git status
     ```
    - Убедиться, что мусор не попадает в изменения
2. **Проверка .gitignore в соответствии с паттерном**

       #Gradle Wrapper
       .gradle/
       build/
       !gradle/wrapper/gradle-wrapper.jar
       !gradle/wrapper/gradle-wrapper.properties

       #IntelliJ IDEA
       .idea/
       *.iml
       out/
3. **Проверьте фильтрацию паттернов (после правки .gitignore)**
   - Выполнить:
   ```bash
     git check-ignore -v .DS_Store || true
     git check-ignore -v .idea/workspace.xml || true
    ```
4. **Удалите мусор из индекса (без удаления с диска)**
   - Выполнить:
    ```bash
     git rm -r --cached .idea build out
    ```
5. **Сделайте санитарный коммит и проверьте историю/дифф**
   - Выполнить:
   ```bash
    git commit -m "Очистить репозиторий; обновить .gitignore"
    git log --oneline -n 1
    git diff --name-status HEAD~1..HEAD
   ```
6. **Проверить по правилу «Перед push: git status clean»**

## Сценарий ручной проверки DVT-7

### Запуск приложения
1. Откройте Gradle Tool Window (View → Tool Windows → Gradle)
2. Выполните: devtools → Tasks → application → run
3. Ожидаемый вывод в Run Tool Window:
   Суммарно: пройдено 25 из 36 уроков, осталось 11 уроков

### Запуск тестов
1. Откройте Gradle Tool Window
2. Выполните: devtools → Tasks → verification → test
3. Ожидаемый вывод: BUILD SUCCESSFUL, все тесты зелёные

### Отладка через Debug
1. Установите breakpoint на строке цикла while в ProgressTracker.calculateProgress
2. Запустите Debug: кликните правой кнопкой на main → Debug 'ProgressTracker.main()'
3. Используйте Step Over (F8) для прохождения итераций
4. Проверьте Variables: counter, remainingHours должны изменяться корректно
5. Используйте Evaluate Expression (Alt+F8): вычислите remainingLessons * 2
6. Ожидаемый результат Evaluate: 14 (для completedLessons=5, totalLessons=12)

### Что делать при ошибках
- Если вывод некорректен: проверьте логику цикла через Debug
- Если тесты красные: откройте вывод теста, найдите AssertionError, скорректируйте метод
- Если Debug не останавливается: убедитесь, что breakpoint установлен (красный кружок)  

## Кодстайл-гайд проекта devtools

Проект следует правилам Google Java Style Guide с адаптацией.
Автоматическая проверка: ./gradlew checkstyleMain

### 1. Именование методов: camelCase

До:    public void add_student(Student s) { }
После: public void addStudent(Student student) { }

Почему: Java Convention требует camelCase для методов.
Источник: https://google.github.io/styleguide/javaguide.html#s5.3-camel-case

### 2. Пробелы после if/for/while

До:    if(condition) {
После: if (condition) {

Почему: улучшает читаемость, отделяет ключевое слово от выражения.
Источник: Oracle Code Conventions — Whitespace

### 3. Длина строки: максимум 120 символов

До:    public List getStudentsFromSpecificCityWithVeryLongName...
После: public List getStudentsByCity(String city) {

Почему: длинные строки затрудняют чтение в редакторе и при code review.
Источник: https://google.github.io/styleguide/javaguide.html#s4.4-column-limit

### 4. Порядок импортов

До:    import java.util.List; import java.util.ArrayList; import java.io.File;
После: import java.io.File; import java.util.ArrayList; import java.util.List;

Почему: алфавитный порядок упрощает поиск импортов.
Источник: IntelliJ IDEA → Code → Optimize Imports

### 5. Фигурные скобки для if

До:    if (condition) doSomething();
После: if (condition) { doSomething(); }

Почему: скобки обязательны даже для однострочных блоков.
Источник: https://google.github.io/styleguide/javaguide.html#s4.1.1-braces-always-used

## Ссылки

📚 [DVT-1 — Установка JDK и IntelliJ IDEA, первый запуск](https://mentee-power.xl.ru/learn/eZTCGC3TuEW8P6jDvNRFZw/theory)    
📚 [DVT-2 — Gradle-проект и базовый](https://mentee-power.xl.ru/learn/MCIneBj4KkyH-GIRCspFvA/theory)  
📚 [DVT-3 — Git Essentials: локальный цикл](https://mentee-power.xl.ru/learn/YkPmAouqvkG_WPo9QL1ZrA/theory)  
📚 [DVT-4 — GitHub и первый Pull Request](https://mentee-power.xl.ru/learn/A_btRUb8mkOIhdfHpFvh5g/theory)  
📚 [DVT-5 — Чистый Git‑репозиторий](https://mentee-power.xl.ru/learn/YAyt18jq5Ei8UrJbIjlkVA/theory)  
📚 [DVT-6 — Один цикл и контроль прогресса — освоение Debug](https://mentee-power.xl.ru/learn/sjF69ienA0-9D3WhGYqhuA/theory)  
📚 [DVT-7 — Checkstyle и культура кода — автоматизация стандартов](https://mentee-power.xl.ru/learn/H-BwIbNy-0uWKVNhmmR_xA/theory)  