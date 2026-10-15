import java.util.Comparator;

public class RatingComparator implements Comparator<Learner> {
    @Override
    public int compare(Learner a, Learner b) {
        return Double.compare(b.getAverageMark(), a.getAverageMark());
    }
}
