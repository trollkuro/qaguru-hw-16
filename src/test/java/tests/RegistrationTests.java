package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.FakeDataSetter;

import static io.qameta.allure.Allure.step;

@Tag("user_creation")
public class RegistrationTests extends TestBase {

    private FakeDataSetter data = new FakeDataSetter();
    private String firstName = data.firstName();
    private String lastName = data.lastName();
    private String userEmail = data.email();
    private String sex = data.gender();
    private String userNumber = data.number();
    private String day = "04";
    private String month = "June";
    private String year = "1975";
    private String subject = data.subject();
    private String hobby = data.hobby();
    private String filePath = "src/test/resources/tiger.jpg";
    private String fileName = "tiger.jpg";
    private String currentAddress = data.currentAddress();
    private String state = data.state();
    private String city = data.city(state);
    private String resultTableTitle = "Thanks for submitting the form";
    private RegistrationPage registrationPage = new RegistrationPage();


    @Test
    @Tag("successful_test")
    @Feature("User creation")
    @Owner("kegorova")
    @DisplayName("Successful user creation with all fields")
    void successfulRegistrationWithAllFields() {
        step("Open page", () -> {
            registrationPage.openPage();
        });
        step("Remove footer and banner", () -> {
            registrationPage.removeFooterAndBanner();
        });
        step("Fill the form", () -> {
            registrationPage.setFirstName(firstName)
                            .setLastName(lastName)
                            .setEmail(userEmail)
                            .setGender(sex)
                            .setNumber(userNumber)
                            .setDate(day, month, year)
                            .setSubject(subject)
                            .setHobby(hobby)
                            .uploadFle(filePath)
                            .setAddress(currentAddress)
                            .setState(state)
                            .setCity(city);
        });
        step("Submit the form", () -> {
            registrationPage.submitForm();
        });
        step("Verify written data in the modal window", () -> {
            registrationPage.verifyResult(firstName + " " + lastName)
                    .verifyResult(userEmail)
                    .verifyResult(sex)
                    .verifyResult(userNumber)
                    .verifyResult(day + " " + month + "," + year)
                    .verifyResult(subject)
                    .verifyResult(hobby)
                    .verifyResult(fileName)
                    .verifyResult(currentAddress)
                    .verifyResult(state + " " + city);
        });
    }

    @Test
    @Tag("successful_test")
    @Feature("User creation")
    @Owner("kegorova")
    @DisplayName("Successful user creation only with required fields")
    void successfulRegistrationOnlyRequiredFields(){
        step("Open page", () -> {
            registrationPage.openPage();
        });
        step("Remove footer and banner", () -> {
            registrationPage.removeFooterAndBanner();
        });
        step("Fill required fields: first name, last name, gender, number", () -> {
            registrationPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setGender(sex)
                    .setNumber(userNumber);
        });
        step("Submit the form", () -> {
            registrationPage.submitForm();
        });
        step("Verify written data in the modal window", () -> {
            registrationPage.verifyResult(firstName + " " + lastName)
                    .verifyResult(sex)
                    .verifyResult(userNumber);
        });
    }

    @Test
    @Feature("User creation")
    @Owner("kegorova")
    @DisplayName("(Should not passed) Modal window with user data is closed")
    void modalIsClosedWithError(){
        step("Open page", () -> {
            registrationPage.openPage();
        });
        step("Remove footer and banner", () -> {
            registrationPage.removeFooterAndBanner();
        });
        step("Fill required fields: first name, last name, gender, number", () -> {
            registrationPage.setFirstName(firstName)
                            .setLastName(lastName)
                            .setGender(sex)
                            .setNumber(userNumber);
        });
        step("Submit the form", () -> {
            registrationPage.submitForm();
        });
        step("Check that modal is displayed", () -> {
            registrationPage.modalIsDisplayed()
                            .verifyModalTitle(resultTableTitle);
        });
        step("Close modal window", () -> {
            registrationPage.verifyModalTitle(resultTableTitle);
        });
        step("Check that modal is not displayed", () -> {
            registrationPage.modalIsNotDisplayed();
        });
    }

    @Test
    @Disabled("Disabled as example")
    @Feature("User creation")
    @Owner("kegorova")
    @DisplayName("(Disabled) Modal window with user data is closed")
    void modalIsClosed(){
        step("Open page", () -> {
            registrationPage.openPage();
        });
        step("Remove footer and banner", () -> {
            registrationPage.removeFooterAndBanner();
        });
        step("Fill required fields: first name, last name, gender, number", () -> {
            registrationPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setGender(sex)
                    .setNumber(userNumber);
        });
        step("Submit the form", () -> {
            registrationPage.submitForm();
        });
        step("Check that modal is displayed", () -> {
            registrationPage.modalIsDisplayed()
                    .verifyModalTitle(resultTableTitle);
        });
        step("Close modal window", () -> {
            registrationPage.closeModal();
        });
        step("Check that modal is not displayed", () -> {
            registrationPage.modalIsNotDisplayed();
        });
    }
}