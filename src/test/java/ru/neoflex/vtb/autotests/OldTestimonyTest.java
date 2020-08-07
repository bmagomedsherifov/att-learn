package ru.neoflex.vtb.autotests;

import org.junit.Assert;
import org.junit.Test;
import ru.neoflex.controllers.RequestTestController;

public class OldTestimonyTest {

    @Test
    public void checkSuccessOldtTestimony(){

        String oldTestimonyURI = "http://localhost:8080/services/testimony/get/old/testimony/01-2020";

        int actualStatusCode = RequestTestController.getRequestOldTestimony(oldTestimonyURI);


        Assert.assertEquals(200, actualStatusCode);
        System.out.println("statusCode : " + actualStatusCode);


    }
}
