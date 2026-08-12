package Y2026M08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NeetCode103 {

    static class TimeMap {

        Map<String, List<TimeValue>> timeMap;
        public TimeMap() {
            timeMap = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            timeMap.computeIfAbsent(key, k -> new ArrayList<>())
                    .add(new TimeValue(timestamp, value));
        }

        public String get(String key, int timestamp) {
            List<TimeValue> tvList = timeMap.get(key);
            if (tvList == null || tvList.size() == 0) return "";

            int lt = 0;
            int rt = tvList.size();

            while (lt < rt) {
                int mid = (lt + rt) / 2;
                if (tvList.get(mid).timestamp <= timestamp) {
                    lt = mid + 1;
                } else {
                    rt = mid;
                }

            }

            if (lt - 1 < 0) {
                return "";
            }

            return tvList.get(lt - 1).value;

        }

        private static class TimeValue {
            private int timestamp;
            private String value;


            public TimeValue(int timestamp, String value) {
                this.timestamp = timestamp;
                this.value = value;
            }
        }

    }

}
