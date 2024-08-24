package com.demoqa;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestsRegistrationForm extends TestBase {

    //in work
    @Test
    void successfulFillFormTest() {
        open("/automation-practice-form");

        //AdBlock!
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$ ('footer').remove ()");

        $("#firstName").setValue("Inna");
        $("#lastName").setValue("Yakunchenkova");
        $("#userEmail").setValue("yakunchenkovainna@yandex.ru");

        //Gender (radio b)
        $("[type='radio'][value='Male']").parent().click();
        //$("#gender-radio-1").parent().click(); //another solution

        $("#userNumber").setValue("0123456789");

        //Date of Birth
        //the best practices:
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1981");
        $(".react-datepicker__month-select").selectOptionByValue("9");
        $(".react-datepicker__day--026").click();


        $("#subjectsInput").setValue("Arts").pressEnter();

        $("#hobbies-checkbox-3").parent().click(); //Music

        $("#uploadPicture").uploadFromClasspath("foto.jpg");

        $("#currentAddress").setValue("Saransk, Russia");

        //State and City
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();



        $("#submit").click();


        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));


    }
}
