// Участие в предметной олимпиаде
class Olympiad {
    private String subject;
    private String level;
    private int place;

    public Olympiad(String subject, String level, int place) {
        if (subject == null || subject.isEmpty())
            throw new IllegalArgumentException("Не указан предмет");
        if (level == null || !(level.equals("школьная") || level.equals("городская") || level.equals("областная")))
            throw new IllegalArgumentException("Неизвестный уровень олимпиады: " + level);
        if (place < 0)
            throw new IllegalArgumentException("Место не может быть отрицательным: " + place);
        this.subject = subject;
        this.level = level;
        this.place = place;
    }

    public String getLevel() {
        return level;
    }

    public int getPlace() {
        return place;
    }

    @Override
    public String toString() {
        return subject + " (" + level + ") - " + (place == 0 ? "участие" : place + " место");
    }
}
