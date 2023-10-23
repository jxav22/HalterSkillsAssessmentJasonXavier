package org.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import solution.DataProcessor;
import solution.TowerData;

import java.util.Hashtable;

import static org.junit.jupiter.api.Assertions.assertSame;

public class DataProcessorTest {

    private static Hashtable<String, TowerData> towerDataHashtable;
    private static DataProcessor dataProcessor;

    @BeforeAll
    public static void beforeAllTests(){
        towerDataHashtable = new Hashtable<>();
        dataProcessor = new DataProcessor(towerDataHashtable);
    }

    @BeforeEach
    public void setUp() {
        TowerData tower1 = new TowerData("tower1");
        tower1.addRssi(10);
        towerDataHashtable.put("tower1", tower1);

        TowerData tower2 = new TowerData("tower2");
        tower2.addRssi(15);
        towerDataHashtable.put("tower2", tower2);

        TowerData tower3 = new TowerData("tower3");
        tower3.addRssi(20);
        towerDataHashtable.put("tower3", tower3);
    }

    @AfterEach
    public void tearDown(){
        towerDataHashtable.clear();
    }

    @Test
    public void testGetTowerWithBestRssi() {
        String bestTowerID = dataProcessor.getTowerWithBestRssi();
        assertSame("tower3", bestTowerID);
    }

    @Test
    public void testGetTowerWithBestRssiNegative(){
        TowerData tower3 = towerDataHashtable.get("tower3");
        tower3.addRssi(-10);

        String bestTowerID = dataProcessor.getTowerWithBestRssi();
        assertSame("tower2", bestTowerID);
    }
}
