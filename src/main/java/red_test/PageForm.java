package red_test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PageForm {
    private SelenideElement INNField = $("#INN");
    private SelenideElement OGRNFiled = $("#OGRN");
    private SelenideElement saveBtnForm = $("[id*='BTN-Form.Save']");
    private SelenideElement errorDialog = $(".v-window-vn-user-error");

    public PageForm enterINN(String inn) {
        INNField.setValue(inn);
        return this;
    }

    public PageForm enterOGRN(String ogrn) {
        OGRNFiled.setValue(ogrn);
        return this;
    }

    public PageForm clickSaveBtn() {
        saveBtnForm.click();
        return this;
    }

    public boolean isErrorDialogDisplayed() {
        errorDialog.shouldBe(Condition.visible, Duration.ofSeconds(1));
        return errorDialog.isDisplayed();

    }
}
