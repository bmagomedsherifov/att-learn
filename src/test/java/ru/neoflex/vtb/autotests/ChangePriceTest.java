package ru.neoflex.vtb.autotests;

import org.junit.Assert;
import org.junit.Test;
import ru.neoflex.controllers.RequestTestController;
import ru.neoflex.model.Price;
import ru.neoflex.model.RequestSetPrice;
import ru.neoflex.model.ResponseSetPrice;

public class ChangePriceTest {

    String changeTestimonyURI = "http://localhost:8080/services/testimony/changePrice";

    @Test
    public void changePriceCheckSuccess() {

        RequestSetPrice requestSetPrice = new RequestSetPrice();
        Price price = new Price();

        price.setPriceHotWater(10);
        price.setPriceHotWater(20);
        price.setPriceGas(30);
        price.setPriceElectricity(40);
        requestSetPrice.setPrice(price);

        int actualStatusCode = RequestTestController.getRequestCodeChangePrice(changeTestimonyURI, requestSetPrice);


        Assert.assertEquals(200, actualStatusCode);
        System.out.println("statusCode : " + actualStatusCode);
    }

    @Test
    public void changePriceCheckBody() {

        RequestSetPrice requestSetPrice = new RequestSetPrice();
        Price price = new Price();

        price.setPriceColdWater(10);
        price.setPriceHotWater(20);
        price.setPriceGas(30);
        price.setPriceElectricity(40);
        requestSetPrice.setPrice(price);

        ResponseSetPrice responseSetPrice = RequestTestController.getResponseBodyChange(changeTestimonyURI, requestSetPrice);
        String resultCode = responseSetPrice.getResultCode();
        String resultText = responseSetPrice.getResultText();

        System.out.println(resultCode);
        System.out.println(resultText);

        Assert.assertEquals("0", resultCode);
        Assert.assertEquals("success", resultText);
    }

}
