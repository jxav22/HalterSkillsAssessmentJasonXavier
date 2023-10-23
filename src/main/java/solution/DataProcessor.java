package solution;

import java.util.*;

public class DataProcessor {
    private Hashtable<String, TowerData> data;

    public DataProcessor(Hashtable<String, TowerData> data) {
        this.data = data;
    }

    public String getTowerWithBestRssi() {
        List<TowerData> towerData = new ArrayList<>(this.data.values());
        TowerData towerWithBestRssi = Collections.max(towerData, new TowerDataComparator());

        return towerWithBestRssi.getTowerID();
    }

    public static class TowerDataComparator implements Comparator<TowerData> {
        @Override
        public int compare(TowerData obj1, TowerData obj2) {
            return Double.compare(obj1.getAverageRssi(), obj2.getAverageRssi());
        }
    }
}
