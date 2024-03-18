package red_test;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class AuthPage {
    public static final String URL = "https://shg-test.red-soft.ru/";

    private SelenideElement usernameField = $(byId("LOGIN-USERNAME"));
    private SelenideElement passwordField = $(byId("LOGIN-PASSWORD"));
    private SelenideElement loginBtn = $(byId("BTN-OK"));

    public AuthPage fillPasswordField(String password) {
        passwordField.setValue(password);
        return this;
    }

    public AuthPage fillUsernameField(String username) {
        usernameField.setValue(username);
        return this;
    }

    public MainPage clickLoginBtn() {
        loginBtn.click();
        return page(MainPage.class);
    }
}
