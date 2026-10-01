package Y2026M10.sortedset;

import java.util.*;

public class TreeSortedSet implements SortedSet {

    private record Entry(String member, long score) {}
    private final HashMap<String, Entry> scoreMap = new HashMap<>();
    private final NavigableSet<Entry> scoreSet = new TreeSet<>(
            Comparator.comparingLong(Entry::score)
                    .thenComparing(Entry::member)
    );

    @Override
    public void add(String member, long score) {
        var entry = scoreMap.get(member);
        if (entry  != null) {
            scoreSet.remove(entry);
        }
        Entry newEntry = new Entry(member, score);

        scoreSet.add(newEntry);
        scoreMap.put(member, newEntry);
    }

    @Override
    public boolean remove(String member) {
        var entry = scoreMap.get(member);
        if (entry == null) return false;

        scoreSet.remove(entry);
        scoreMap.remove(member);
        return true;
    }

    @Override
    public long score(String member) {
        Entry entry = scoreMap.get(member);
        return entry != null ? entry.score() : -1L;
    }

    @Override
    public long rank(String member) {
        long rank = 0L;
        for (var scoreEntry : scoreSet) {
            if (scoreEntry.member.equals(member)) {
                return rank;
            }
            rank++;
        }
        return -1L;
    }

    @Override
    public List<String> range(long start, long end) {
        if (start < 0 || end < start) return List.of();

        List<String> results = new ArrayList<>();
        long index = 0;

        for (var entry : scoreSet) {
            if (index > end) {
                break;
            }

            if (index >= start) {
                results.add(entry.member());
            }

            index++;
        }

        return results;
    }
}
