import java.util.ArrayList;
import java.util.List;

public class Range {
    private long startPoint;
    private long endPoint;

    public long getStartPoint() {
        return startPoint;
    }

    public long getEndPoint() {
        return endPoint;
    }

    public Range(long startPoint, long endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public boolean isBefore(Range otherRange) {
        return this.endPoint <= otherRange.getStartPoint();
    }

    public boolean isAfter(Range otherRange) {
        return this.startPoint >= otherRange.getEndPoint();
    }

    public boolean isConcurrent(Range otherRange) {
        return this.startPoint == otherRange.getStartPoint()
                && this.endPoint == otherRange.getEndPoint();
    }

    public long getLowerBound() {
        return startPoint;
    }

    public long getUpperBound() {
        return endPoint;
    }

    public boolean contains(long value) {
        return value >= this.startPoint && value <= this.endPoint;
    }

    public List<Long> asList() {
        List<Long> values = new ArrayList<>();
        for (long i = startPoint; i <- endPoint; i++) {
            values.add(i);
        }
        return values;
    }
}
