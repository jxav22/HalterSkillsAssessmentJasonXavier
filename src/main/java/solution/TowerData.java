package solution;

public class TowerData {

    private int totalRssi = 0;
    private int dataPointsStored = 0;

    TowerData(){}

    public void addRssi(int rssi){
        this.totalRssi += rssi;
        this.dataPointsStored++;
    }

    public double getAverageRssi(){
        return (double) this.totalRssi / this.dataPointsStored;
    }
}
