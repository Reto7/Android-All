package com.androidatc.helloworldandroidapplication;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rk on 14.04.17.
 */
public class BmiBusinessComponentTest {
    @Test
    public void calculateBMItest1() throws Exception {
        String bmi = BmiBusinessComponent.calculateBMI(78, 180);
        Assert.assertEquals("24.074076 (Normalgewicht)", bmi);
    }
    @Test
    public void calculateBMItest2() throws Exception {
        String bmi = BmiBusinessComponent.calculateBMI(95, 140);
        Assert.assertEquals("48.46939 (Starkes Uebergewicht, Adipositas Grad III)", bmi);
    }
    @Test
    public void calculateBMItest3() throws Exception {
        String bmi = BmiBusinessComponent.calculateBMI(61, 190);
        Assert.assertEquals("16.897507 (Untergewicht)", bmi);
    }
}