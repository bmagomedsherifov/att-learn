package ru.neoflex.vtb.autotests;

import ru.neoflex.model.CurrentTestimony;
import ru.neoflex.model.RequestSaveTestimony;

public class SaveTestimonyTest {

    @Test
    public void checkCodeSuccess() {

        String saveTestimonyURI = "http://localhost:8080/services/testimony/save";
        RequestSaveTestimony requestSaveTestimony = new RequestSaveTestimony();
        CurrentTestimony currentTestimony = new CurrentTestimony();

        requestSaveTestimony.setDate("02-2020");
        currentTestimony.setColdWater(30);
        currentTestimony.setHotWater(40);
        currentTestimony.setGas(50);
        currentTestimony.setElectricity(60);
        requestSaveTestimony.setCurrentTestimony(currentTestimony);


    }

}
