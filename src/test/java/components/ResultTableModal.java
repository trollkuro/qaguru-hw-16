package components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableModal {

    private SelenideElement resultTable = $(".modal-content"),
                            closeButton = $("#closeLargeModal"),
                            tableTitle = $("#example-modal-sizes-title-lg");


    public void checkData(String value){
        resultTable.shouldHave(text(value));
    }

    public void checkTitle(String title){
        tableTitle.shouldHave(text(title));
    }

    public void closeResultTableModal(){
        closeButton.click();
    }

    public void checkIsDisplayed(){
        resultTable.shouldBe(visible);
    }

    public void checkIsNotDisplayed(){
        resultTable.shouldBe(hidden);
    }

}
