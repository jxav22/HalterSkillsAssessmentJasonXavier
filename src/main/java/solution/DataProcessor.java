package solution;

import java.util.*;

/**
 * A helper class, designed to determine the tower with
 * the best rssi from a collection of tower data
 */
public class DataProcessor {
    private final Hashtable<String, TowerData> data;

    public DataProcessor(Hashtable<String, TowerData> data) {
        this.data = data;
    }

    /**
     * Determines the tower with the best rssi
     * Where the best is defined as having the highest average (mean) rssi
     * @return The tower ID of the best tower
     */
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
