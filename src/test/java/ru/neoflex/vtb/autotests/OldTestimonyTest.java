package ru.neoflex.vtb.autotests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import ru.neoflex.controllers.RequestTestController;
import ru.neoflex.dao.MySqlConnector;
import ru.neoflex.model.ResponseOldTestimony;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OldTestimonyTest {

    String testimonyDate = "02-2020";
    String oldTestimonyURI = "http://localhost:8080/services/testimony/get/old/testimony/" + testimonyDate;

    @Test
    public void checkSuccessCodeTestimony(){

        int actualStatusCode = RequestTestController.getRequestOldTestimony(oldTestimonyURI);


        Assert.assertEquals(200, actualStatusCode);
        System.out.println("statusCode : " + actualStatusCode);


    }

    @Test
    public void checkBodyOldtTestimony() throws SQLException {

        ResponseOldTestimony responseOldTestimony = RequestTestController.getResponseBodyOld(oldTestimonyURI);
        String resultText = responseOldTestimony.getFaultcode().getResultText();
        String resultCode = responseOldTestimony.getFaultcode().getResultCode();

        Assert.assertEquals("success", resultText);
        Assert.assertEquals("0", resultCode);

        ResultSet expectedResultOld = MySqlConnector.selectAllFrommHistory(responseOldTestimony.getDate());
        while (expectedResultOld.next()) {
            String currentmonth = expectedResultOld.getString("currentmonth");
            String previous_month = expectedResultOld.getString("previous_month");
            int coldWater = expectedResultOld.getInt("coldWater");
            int hotWater = expectedResultOld.getInt("hotWater");
            int gas = expectedResultOld.getInt("gas");
            int electricity = expectedResultOld.getInt("electricity");
            String cost_coldWater = expectedResultOld.getString("cost_coldWater");
            String cost_hotWater = expectedResultOld.getString("cost_hotWater");
            String cost_gas = expectedResultOld.getString("cost_gas");
            String cost_electricity = expectedResultOld.getString("cost_electricity");
            String total_cost = expectedResultOld.getString("total_cost");

            Assertions.assertEquals(currentmonth, responseOldTestimony.getDate());
            Assertions.assertEquals(previous_month, responseOldTestimony.getPreviousDate());
            Assertions.assertEquals(coldWater, responseOldTestimony.getConsumed().getColdWater());
            Assertions.assertEquals(hotWater, responseOldTestimony.getConsumed().getHotWater());
            Assertions.assertEquals(gas, responseOldTestimony.getConsumed().getGas());
            Assertions.assertEquals(electricity, responseOldTestimony.getConsumed().getElectricity());
            Assertions.assertEquals(cost_coldWater, responseOldTestimony.getCost().getColdWater());
            Assertions.assertEquals(cost_hotWater, responseOldTestimony.getCost().getHotWater());
            Assertions.assertEquals(cost_gas, responseOldTestimony.getCost().getGas());
            Assertions.assertEquals(cost_electricity, responseOldTestimony.getCost().getElectricity());
            Assertions.assertEquals(total_cost, responseOldTestimony.getTotalCost());


        }


    }
}
