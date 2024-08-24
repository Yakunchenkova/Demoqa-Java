package com.demoqa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestTextBox extends TestBase {

    @Test
    void successfulFillFormTest() {
        open("/text-box");

//        $("[id=userName]").setValue("Serge Lifar");
        $("#userName").setValue("Inna Yakunchenkova");
        $("#userEmail").setValue("yakunchenkovainna@yandex.ru");
        $("#currentAddress").setValue("Some street 1");
        $("#permanentAddress").setValue("Another street 1");
        $("#submit").click();

        $("#output").shouldHave(
                text("Inna Yakunchenkova"),
                text("yakunchenkovainna@yandex.ru"),
                text("Some street 1"), text("Another street 1"));

        $("#output #name").shouldHave(text("Inna Yakunchenkova"));

    }
}