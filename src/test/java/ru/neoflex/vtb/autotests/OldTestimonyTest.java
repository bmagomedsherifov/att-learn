package ru.neoflex.vtb.autotests;

import org.junit.Assert;
import org.junit.Test;
import ru.neoflex.controllers.RequestTestController;
import ru.neoflex.model.ResponseOldTestimony;

public class OldTestimonyTest {

    String oldTestimonyURI = "http://localhost:8080/services/testimony/get/old/testimony/02-2020";

    @Test
    public void checkSuccessCodeTestimony(){

        int actualStatusCode = RequestTestController.getRequestOldTestimony(oldTestimonyURI);


        Assert.assertEquals(200, actualStatusCode);
        System.out.println("statusCode : " + actualStatusCode);


    }

    @Test
    public void checkBodyOldtTestimony(){

        ResponseOldTestimony responseOldTestimony = RequestTestController.getResponseBodyOld(oldTestimonyURI);
        String resultText = responseOldTestimony.getFaultcode().getResultText();
        String resultCode = responseOldTestimony.getFaultcode().getResultCode();

        Assert.assertEquals("success", resultText);
        Assert.assertEquals("0", resultCode);


    }
}
