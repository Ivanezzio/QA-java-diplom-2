import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;

public class IngredientClient extends BaseSpec {

    public final static String APIURL = "/api/ingredients/";
    public final static String Type = "Content-type";
    public final static String APP = "application/json";

    @Step("Получение списка ингредиентов")
    public String getIngredients(int massiveId) {
        return given()
                .spec(getBaseSpecs())
                .get(APIURL)
                .then()
                .extract()
                .path("data["+ massiveId + "]._id");

    }

}
