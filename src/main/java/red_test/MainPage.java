package red_test;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.sun.tools.javac.Main;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    //    private SelenideElement createBtn = $("#BTN-FRAME-INSERT2073412413");
    private SelenideElement createBtn = $$(".v-horizontallayout.v-layout.v-horizontal.v-widget.vn-bar.v-horizontallayout-vn-bar .v-slot").get(1);
    ;
    private SelenideElement smevLabel = $(byText("СМЭВ-клиенты"));
    private SelenideElement EGRULStatements = $(byText("Выписки по запросам органов власти [СМЭВ3] - ЕГРЮЛ"));

    public void clickCreateBtn() {
        createBtn.click();
    }

    public MainPage goToRequestCreationForm() {
        smevLabel.click();
        EGRULStatements.click();
        return this;
    }

}
