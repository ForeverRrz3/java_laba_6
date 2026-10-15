import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Schoolchild> schoolchildren;
        ArrayList<Student> students;
        try {
            schoolchildren = createSchoolchildren();
            students = createStudents();
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка во входных данных: " + e.getMessage());
            return;
        }

        // Общий список кандидатов на специальную стипендию, по фамилиям
        ArrayList<Learner> candidates = new ArrayList<>();
        for (Schoolchild s : schoolchildren)
            if (s.hasSpecialScholarship())
                candidates.add(s);
        for (Student s : students)
            if (s.hasSpecialScholarship())
                candidates.add(s);
        Collections.sort(candidates);

        System.out.println("\nКандидаты на специальную стипендию (по фамилиям):");
        for (Learner l : candidates)
            System.out.println(l);

        // Лучшие по успеваемости
        RatingComparator byRating = new RatingComparator();
        System.out.println("\nЛучший школьник: " + Collections.min(schoolchildren, byRating));
        System.out.println("\nЛучший студент: " + Collections.min(students, byRating));

        // Школьники по рейтингу, затем по номеру школы
        schoolchildren.sort(new SchoolchildComparator());
        System.out.println("\nШкольники по рейтингу и номеру школы:");
        for (Schoolchild s : schoolchildren)
            System.out.println(s);

        //  Студенты по рейтингу
        students.sort(byRating);
        System.out.println("\nСтуденты по рейтингу:");
        for (Student s : students)
            System.out.println(s);
    }

    private static Schoolchild createSchoolchild(String surname, String name, String gender, int age, int school,
                                                 int math, int russian, int history, int english,
                                                 int literature, int physics, int biology) {
        Schoolchild s = new Schoolchild(surname, name, gender, age, school);
        s.addGrade("Математика", math);
        s.addGrade("Русский язык", russian);
        s.addGrade("История", history);
        s.addGrade("Английский язык", english);
        s.addGrade("Литература", literature);
        s.addGrade("Физика", physics);
        s.addGrade("Биология", biology);
        return s;
    }

    private static ArrayList<Schoolchild> createSchoolchildren() {
        ArrayList<Schoolchild> list = new ArrayList<>();

        Schoolchild anya = createSchoolchild("Кузнецова", "Аня", "ж", 15, 12, 5, 5, 5, 5, 4, 5, 5);
        anya.addOlympiad("Математика", "школьная", 1);
        list.add(anya);

        Schoolchild masha = createSchoolchild("Иванова", "Маша", "ж", 14, 31, 5, 5, 5, 5, 5, 3, 4);
        masha.addOlympiad("История", "городская", 1);
        list.add(masha);

        Schoolchild ivan = createSchoolchild("Смирнов", "Иван", "м", 16, 8, 5, 5, 5, 5, 4, 4, 4);
        ivan.addOlympiad("Физика", "областная", 0);
        list.add(ivan);

        Schoolchild olya = createSchoolchild("Андреева", "Оля", "ж", 13, 12, 5, 5, 5, 5, 5, 5, 5);
        olya.addOlympiad("Английский язык", "школьная", 2);
        list.add(olya);

        Schoolchild vanya = createSchoolchild("Угрюмов", "Ваня", "м", 15, 5, 5, 5, 4, 5, 5, 5, 5);
        vanya.addOlympiad("Математика", "городская", 1);
        list.add(vanya);

        Schoolchild veronika = createSchoolchild("Бобкова", "Вероника", "ж", 16, 8, 5, 5, 5, 5, 4, 5, 4);
        veronika.addOlympiad("Русский язык", "городская", 3);
        veronika.addOlympiad("Литература", "областная", 1);
        list.add(veronika);

        return list;
    }

    private static Student createStudent(String surname, String name, String gender, int age,
                                         int math, int programming, int physics, int history) {
        Student s = new Student(surname, name, gender, age);
        s.addSessionGrade("Математика", math);
        s.addSessionGrade("Программирование", programming);
        s.addSessionGrade("Физика", physics);
        s.addSessionGrade("История", history);
        return s;
    }

    private static ArrayList<Student> createStudents() {
        ArrayList<Student> list = new ArrayList<>();

        Student lesha = createStudent("Орлов", "Лёша", "м", 20, 5, 5, 5, 5);
        lesha.addCourseworkGrade("Программирование", 5);
        list.add(lesha);

        Student dasha = createStudent("Морозова", "Даша", "ж", 19, 5, 5, 5, 4);
        dasha.addCourseworkGrade("Математика", 5);
        dasha.addCourseworkGrade("Программирование", 5);
        list.add(dasha);

        Student seryozha = createStudent("Соловьев", "Серёжа", "м", 18, 5, 5, 4, 5);
        list.add(seryozha);

        Student katya = createStudent("Зайцева", "Катя", "ж", 21, 4, 5, 4, 4);
        katya.addCourseworkGrade("Программирование", 4);
        list.add(katya);

        Student dima = createStudent("Новиков", "Дима", "м", 20, 5, 4, 4, 3);
        dima.addCourseworkGrade("Математика", 5);
        list.add(dima);

        return list;
    }
}
