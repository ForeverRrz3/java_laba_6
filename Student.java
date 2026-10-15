import java.util.ArrayList;

public class Student extends Learner {
    private ArrayList<SubjectGrade> sessionGrades = new ArrayList<>();
    private ArrayList<SubjectGrade> courseworkGrades = new ArrayList<>();

    public Student(String surname, String name, String gender, int age) {
        super(surname, name, gender, age);
    }

    public void addSessionGrade(String subject, int grade) {
        sessionGrades.add(new SubjectGrade(subject, grade));
    }

    public void addCourseworkGrade(String subject, int grade) {
        courseworkGrades.add(new SubjectGrade(subject, grade));
    }

    public boolean hasCourseworks() {
        return !courseworkGrades.isEmpty();
    }

    private boolean allCourseworksExcellent() {
        if (courseworkGrades.isEmpty())
            return false;
        for (SubjectGrade g : courseworkGrades)
            if (g.getGrade() != 5)
                return false;
        return true;
    }

    @Override
    public double getAverageMark() {
        return average(sessionGrades);
    }

    @Override
    public boolean hasSpecialScholarship() {
        return getAverageMark() >= 4.75 && allCourseworksExcellent();
    }

    @Override
    public String toString() {
        return "Студент " + super.toString()
                + "\n  Сессия: " + sessionGrades
                + "\n  Курсовые: " + courseworkGrades;
    }
}
