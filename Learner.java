import java.util.ArrayList;

abstract public class Learner implements Comparable<Learner> {
    private String surname, name, gender;
    private int age;

    public Learner(String surname, String name, String gender, int age) {
        if (!isCapitalized(surname))
            throw new IllegalArgumentException("Фамилия должна начинаться с большой буквы: " + surname);
        if (!isCapitalized(name))
            throw new IllegalArgumentException("Имя должно начинаться с большой буквы: " + name);
        if (gender == null || !(gender.equals("м") || gender.equals("ж")))
            throw new IllegalArgumentException("Пол должен быть \"м\" или \"ж\"");
        if (age <= 0)
            throw new IllegalArgumentException("Возраст должен быть положительным");
        this.surname = surname;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    // Строка не пустая и начинается с большой буквы
    private static boolean isCapitalized(String s) {
        return s != null && !s.isEmpty() && Character.isUpperCase(s.charAt(0));
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public boolean isFemale() {
        return gender.equals("ж");
    }

    public abstract boolean hasSpecialScholarship();

    public abstract double getAverageMark();

    protected static double average(ArrayList<SubjectGrade> grades) {
        if (grades.isEmpty())
            return 0;
        int sum = 0;
        for (SubjectGrade g : grades)
            sum += g.getGrade();
        return (double) sum / grades.size();
    }

    @Override
    public int compareTo(Learner other) {
        return surname.compareTo(other.surname);
    }

    @Override
    public String toString() {
        return surname + " " + name + ", пол: " + gender + ", возраст: " + age
                + String.format(", средний балл: %.2f", getAverageMark());
    }
}
