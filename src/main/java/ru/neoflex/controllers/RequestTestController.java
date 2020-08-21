package ru.neoflex.controllers;
import io.restassured.http.ContentType;
import ru.neoflex.model.*;

import static io.restassured.RestAssured.given;

public class RequestTestController {

    //Метод для отправки Post запроса на микросервис.

    public static int getRequestCodeSaveTestimony(String uRL, RequestSaveTestimony requestSaveTestimony) {

        return given().
                contentType(ContentType.JSON).
                body(requestSaveTestimony).
                when().
                post(uRL).
                then().
                extract().
                response().
                getStatusCode();
    }

    //Метод для отправки Post запроса на микросервис.

    public static int getRequestCodeChangePrice(String uRL, RequestSetPrice requestSetPrice) {

        return given().
                contentType(ContentType.JSON).
                body(requestSetPrice).
                when().
                post(uRL).
                then().
                extract().
                response().
                getStatusCode();
    }

    //Метод для отправки Get запроса на микросервис.

    public static int getRequestOldTestimony(String uRL) {

        return given().
                contentType(ContentType.JSON).
                when().
                post(uRL).
                then().
                extract().
                response().
                getStatusCode();
    }

    public static ResponseSaveTestimony getResponseBodySave(String uRL, RequestSaveTestimony requestSaveTestimony) {

        return given().
                contentType(ContentType.JSON).
                when().
                post(uRL).
                then().
                extract().
                response().
                as(ResponseSaveTestimony.class);
    }

    public static ResponseSetPrice getResponseBodyChange(String uRL, RequestSetPrice requestSetPrice) {

        return given().
                contentType(ContentType.JSON).
                when().
                post(uRL).
                then().
                extract().
                response().
                as(ResponseSetPrice.class);
    }

    public static ResponseOldTestimony getResponseBodyOld(String uRL) {

        return given().
                contentType(ContentType.JSON).
                when().
                post(uRL).
                then().
                extract().
                response().
                as(ResponseOldTestimony.class);
    }

}