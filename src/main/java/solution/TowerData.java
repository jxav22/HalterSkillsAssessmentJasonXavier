package solution;

/**
 * A data class, for storing tower data
 * The goal was to effectively store the average (mean) rssi for a particular tower
 */
public class TowerData {
    private final String towerID;

    private int totalRssi = 0;
    private int dataPointsStored = 0;

    public TowerData(String towerID) {
        this.towerID = towerID;
    }

    public void addRssi(int rssi) {
        this.totalRssi += rssi;
        this.dataPointsStored++;
    }

    public double getAverageRssi() {
        return (double) this.totalRssi / this.dataPointsStored;
    }

    public String getTowerID() {
        return towerID;
    }
}
