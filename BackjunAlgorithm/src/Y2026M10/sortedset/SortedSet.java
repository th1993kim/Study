package Y2026M10.sortedset;

import java.util.List;

public interface SortedSet {

    void add(String member, long score);
    boolean remove(String member);
    long score(String member);
    long rank(String member);

    List<String> range(long start, long end);
}
