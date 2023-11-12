package pages;

import com.codeborne.selenide.SelenideElement;
import components.DatePicker;
import components.ResultTableModal;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private DatePicker datePicker = new DatePicker();
    private ResultTableModal resultTableModal = new ResultTableModal();
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirth = $("#dateOfBirthInput"),
            subjectInputs = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            fileInput = $(".form-control-file"),
            addressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submitButton = $("[id=submit]");



    public RegistrationPage openPage(){
        open("/automation-practice-form");
        return this;
    }
    public RegistrationPage removeFooterAndBanner(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public RegistrationPage setFirstName(String firstName){
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName){
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setEmail(String email){
        userEmailInput.setValue(email);
        return this;
    }

    public RegistrationPage setGender(String gender){
        genderWrapper.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setNumber(String number){
        userNumberInput.setValue(number);
        return this;
    }

    public RegistrationPage setDate(String day, String month, String year){
        dateOfBirth.click();
        datePicker.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String subject){
        subjectInputs.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobby(String hobby){
        hobbiesWrapper.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage uploadFle(String filePath){
        fileInput.uploadFile(new File(filePath));
        return this;
    }

    public RegistrationPage setAddress(String address){
        addressInput.setValue(address);
        return this;
    }

    public RegistrationPage setState(String state){
        stateInput.setValue(state).pressEnter();
        return this;
    }

    public RegistrationPage setCity(String city){
        cityInput.setValue(city).pressEnter();
        return this;
    }

    public RegistrationPage submitForm(){
        submitButton.click();
        return this;
    }

    public RegistrationPage verifyResult(String value){
        resultTableModal.checkData(value);
        return this;
    }

    public RegistrationPage verifyModalTitle(String title){
        resultTableModal.checkTitle(title);
        return this;
    }

    public RegistrationPage closeModal(){
        resultTableModal.closeResultTableModal();
        return this;
    }

    public RegistrationPage modalIsDisplayed(){
        resultTableModal.checkIsDisplayed();
        return this;
    }

    public RegistrationPage modalIsNotDisplayed(){
        resultTableModal.checkIsNotDisplayed();
        return this;
    }
}
