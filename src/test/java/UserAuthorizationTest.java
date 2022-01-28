import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class UserAuthorizationTest {
    private User user;
    private UserClient userClient;
    private UserData userData;

    @Before
    public void SetUp(){
        user = User.getRandom();
        userClient = new UserClient();
    }

    @Test
    @DisplayName("Авторизация существующего пользователя")
    public void authorizationRegisteredUser(){
        userClient.create(user);
        userClient.Authorization(userData.from(user))
                .then().assertThat()
                .body("success", equalTo(true))
                .and()
                .statusCode(200);
    }

    @Test
    @DisplayName("логин с неверным логином и паролем")
    public void authorizationWithIncorrectLoginPassword(){
        userClient.userAuthorizationWithIncorrectEmailPassword(userData.from(user))
                .then().assertThat()
                .body("message", equalTo("email or password are incorrect"))
                .and().
                statusCode(401);
    }


}
