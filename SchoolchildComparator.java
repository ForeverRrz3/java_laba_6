import java.util.Comparator;

public class SchoolchildComparator implements Comparator<Schoolchild> {
    private static final RatingComparator byRating = new RatingComparator();

    @Override
    public int compare(Schoolchild a, Schoolchild b) {
        int result = byRating.compare(a, b);
        if (result != 0)
            return result;
        return Integer.compare(a.getSchoolNumber(), b.getSchoolNumber());
    }
}
