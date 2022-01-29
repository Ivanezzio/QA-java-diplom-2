import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class OrderClient extends BaseSpec {
    public final static String APIURL = "/api/orders/";

    @Step("Создание заказа с авторизацией")
    public Response newOrderWithAuthorization(String ingredient, String accessToken){
        String orderRequest = "{\"ingredients\": \"" + ingredient + "\"}";
        return given()
                .spec(getBaseSpecs())
                .headers("authorization", accessToken)
                .body(orderRequest)
                .when()
                .post(APIURL);
    }

    @Step ("Создание заказа без авторизации")
    public Response newOrderWithoutAuthorization(String ingredient){
        String orderRequest = "{\"ingredients\": \"" + ingredient + "\"}";
        return given()
                .spec(getBaseSpecs())
                .body(orderRequest)
                .when()
                .post(APIURL);
    }

    @Step ("Создание заказа без ингридиентов")
    public Response newOrderWithoutIngredients(String accessToken){
        return given()
                .spec(getBaseSpecs())
                .headers("Authorization", accessToken)
                .when()
                .post(APIURL);
    }

    @Step ("Получение заказов авторизованного пользователя")
    public Response getOrdersList (String accessToken) {
        return given()
                .spec(getBaseSpecs())
                .headers("Authorization", accessToken)
                .when()
                .get(APIURL+ "all");
    }
    @Step ("Получение заказов не авторизованного пользовалетя")
    public Response getOrdersListWithoutUserAuthorization () {
        return given()
                .spec(getBaseSpecs())
                .when()
                .get(APIURL);
    }
}
