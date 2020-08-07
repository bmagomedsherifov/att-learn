package ru.neoflex.vtb.autotests;

import org.junit.Assert;
import org.junit.Test;
import ru.neoflex.controllers.RequestTestController;
import ru.neoflex.model.Price;
import ru.neoflex.model.RequestSetPrice;

public class ChangePriceTest {

    @Test
    public void changePriceCheckSuccess() {

        String changeTestimonyURI = "http://localhost:8080/services/testimony/changePrice";
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

}
