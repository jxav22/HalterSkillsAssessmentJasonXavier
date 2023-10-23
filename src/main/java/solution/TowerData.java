package solution;

public class TowerData {
    private final String towerID;

    private int totalRssi = 0;
    private int dataPointsStored = 0;

    TowerData(String towerID) {
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
