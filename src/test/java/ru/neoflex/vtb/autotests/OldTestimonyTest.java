package ru.neoflex.vtb.autotests;

import org.junit.Assert;
import org.junit.Test;
import ru.neoflex.controllers.RequestTestController;
import ru.neoflex.model.ResponseOldTestimony;

public class OldTestimonyTest {

    String oldTestimonyURI = "http://localhost:8080/services/testimony/get/old/testimony/01-2020";

    @Test
    public void checkSuccessOldtTestimony(){

        int actualStatusCode = RequestTestController.getRequestOldTestimony(oldTestimonyURI);


        Assert.assertEquals(200, actualStatusCode);
        System.out.println("statusCode : " + actualStatusCode);


    }

    @Test
    public void checkBodyOldtTestimony(){

        ResponseOldTestimony responseOldTestimony = RequestTestController.getResponseBodyOld(oldTestimonyURI);
        String date = responseOldTestimony.getDate();
        String previousDate = responseOldTestimony.getPreviousDate();
        int coldWater = responseOldTestimony.getConsumed().getColdWater();
        int hotWater = responseOldTestimony.getConsumed().getHotWater();
        int gas = responseOldTestimony.getConsumed().getGas();
        int electricity = responseOldTestimony.getConsumed().getElectricity();

        Assert.assertEquals("04-2020", date);
        Assert.assertEquals("03-2020", previousDate);
        Assert.assertEquals( 1, coldWater);
        Assert.assertEquals(1, hotWater);
        Assert.assertEquals(1, gas);

    }
}
