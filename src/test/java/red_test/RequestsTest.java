package red_test;

import net.bytebuddy.build.Plugin;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.*;

import java.util.function.BooleanSupplier;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RequestsTest {
    @Before
    public void login() throws InterruptedException {
        AuthPage auth = open(AuthPage.URL, AuthPage.class);
        auth.fillPasswordField("12345678")
                .fillUsernameField("SERKUZN")
                .clickLoginBtn()
                .goToRequestCreationForm()
                .clickCreateBtn();
    }

    @Test
    @DisplayName("Проверка на некорректное заполнение ИНН")
    public void testForIncorrectFillINNField() throws InterruptedException {
        PageForm form = page(PageForm.class);
        boolean isNotOk = form.enterINN("231003147").clickSaveBtn().isErrorDialogDisplayed();
        assertTrue(isNotOk, "The INN field is filled in incorrectly");
    }

    @Test
    @DisplayName("Проверка на корректное заполнение ОГРН")
    public void testForCorrectFillORGNField() throws InterruptedException {
        PageForm form = page(PageForm.class);
        boolean isOk = form.enterOGRN("1022301598549")
                .clickSaveBtn()
                .isErrorDialogDisplayed();
        assertTrue(isOk, "The form is filled in correctly");
    }
}
