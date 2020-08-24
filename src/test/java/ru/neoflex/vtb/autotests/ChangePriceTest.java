package ru.neoflex.vtb.autotests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import ru.neoflex.controllers.RequestTestController;
import ru.neoflex.dao.MySqlConnector;
import ru.neoflex.model.Price;
import ru.neoflex.model.RequestSetPrice;
import ru.neoflex.model.ResponseSetPrice;

import java.sql.ResultSet;
import java.sql.SQLException;

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
    public void changePriceCheckBody() throws SQLException {

        RequestSetPrice requestSetPrice = new RequestSetPrice();
        Price price = new Price();

        price.setPriceColdWater(11);
        price.setPriceHotWater(21);
        price.setPriceGas(31);
        price.setPriceElectricity(41);
        requestSetPrice.setPrice(price);

        ResponseSetPrice responseSetPrice = RequestTestController.getResponseBodyChange(changeTestimonyURI, requestSetPrice);
        String resultCode = responseSetPrice.getResultCode();
        String resultText = responseSetPrice.getResultText();

        System.out.println(resultCode);
        System.out.println(resultText);

        Assert.assertEquals("0", resultCode);
        Assert.assertEquals("success", resultText);

        ResultSet expectedResultChange = MySqlConnector.selectAllFrommPriceGuide(requestSetPrice.getPrice().getPriceColdWater());
        while (expectedResultChange.next()) {
            int priceColdWater = expectedResultChange.getInt("priceColdWater");
            int priceHotWater = expectedResultChange.getInt("priceHotWater");
            int priceGas = expectedResultChange.getInt("priceGas");
            int priceElectricity = expectedResultChange.getInt("priceElectricity");
            Assertions.assertEquals(priceColdWater, requestSetPrice.getPrice().getPriceColdWater());
            Assertions.assertEquals(priceHotWater, requestSetPrice.getPrice().getPriceHotWater());
            Assertions.assertEquals(priceGas, requestSetPrice.getPrice().getPriceGas());
            Assertions.assertEquals(priceElectricity, requestSetPrice.getPrice().getPriceElectricity());
        }
    }

}
