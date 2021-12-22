package ru.netology;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryFormTest {

    public static String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    }


    @Test
    public void shouldSendFormWithOrdinaryName() {
        String planningDate = generateDate(3);
        open("http://localhost:9999");
        $("[data-test-id='city'] .input__control").setValue("Москва");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name='name']").setValue("Лебедева Ольга");
        $x("//*[@name='phone']").setValue("+79998887766");
        $(".checkbox__box").click();
        $$(".button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15)).shouldBe(visible);
    }

    @Test
    public void shouldSendFormWithNameContainingHyphen() {
        String planningDate = generateDate(3);
        open("http://localhost:9999");
        $("[data-test-id='city'] .input__control").setValue("Москва");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name='name']").setValue("Салтыков-Щедрин Михаил");
        $x("//*[@name='phone']").setValue("+79998887766");
        $(".checkbox__box").click();
        $$(".button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15)).shouldBe(visible);
    }

    @Test
    public void shouldSendFormWithNameConsistingOf2Letters() {
        String planningDate = generateDate(3);
        open("http://localhost:9999");
        $("[data-test-id='city'] .input__control").setValue("Москва");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name='name']").setValue("Я Э");
        $x("//*[@name='phone']").setValue("+79998887766");
        $(".checkbox__box").click();
        $$(".button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15)).shouldBe(visible);
    }

    @Test
    public void shouldSendFormWithoutSurname() {
        String planningDate = generateDate(3);
        open("http://localhost:9999");
        $("[data-test-id='city'] .input__control").setValue("Москва");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name='name']").setValue("Ольга");
        $x("//*[@name='phone']").setValue("+79998887766");
        $(".checkbox__box").click();
        $$(".button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15)).shouldBe(visible);
    }

    @Test
    public void shouldSendFormNonStandardNumber() {
        String planningDate = generateDate(3);
        open("http://localhost:9999");
        $("[data-test-id='city'] .input__control").setValue("Москва");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name='name']").setValue("Лебедева Ольга");
        $x("//*[@name='phone']").setValue("+00000000000");
        $(".checkbox__box").click();
        $$(".button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15)).shouldBe(visible);
    }

    @Test
    public void shouldSendFormWithCityContainingHyphen() {
        String planningDate = generateDate(3);
        open("http://localhost:9999");
        $("[data-test-id='city'] .input__control").setValue("Ростов-на-Дону");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name='name']").setValue("Лебедева Ольга");
        $x("//*[@name='phone']").setValue("+79998887766");
        $(".checkbox__box").click();
        $$(".button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15)).shouldBe(visible);
    }

    @Test
    public void shouldSendFormWithCityContainingSpace() {
        String planningDate = generateDate(3);
        open("http://localhost:9999");
        $("[data-test-id='city'] .input__control").setValue("Нижний Новгород");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name='name']").setValue("Лебедева Ольга");
        $x("//*[@name='phone']").setValue("+79998887766");
        $(".checkbox__box").click();
        $$(".button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15)).shouldBe(visible);
    }

    @Test
    public void shouldSendFormIn4Days() {
        String planningDate = generateDate(4);
        open("http://localhost:9999");
        $("[data-test-id='city'] .input__control").setValue("Москва");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name='name']").setValue("Лебедева Ольга");
        $x("//*[@name='phone']").setValue("+79998887766");
        $(".checkbox__box").click();
        $$(".button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15)).shouldBe(visible);
    }

    @Test
    public void shouldSendFormIn10Days() {
        String planningDate = generateDate(10);
        open("http://localhost:9999");
        $("[data-test-id='city'] .input__control").setValue("Москва");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name='name']").setValue("Лебедева Ольга");
        $x("//*[@name='phone']").setValue("+79998887766");
        $(".checkbox__box").click();
        $$(".button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15)).shouldBe(visible);
    }

    @Test
    public void shouldSendFormIn100Days() {
        String planningDate = generateDate(100);
        open("http://localhost:9999");
        $("[data-test-id='city'] .input__control").setValue("Москва");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $x("//*[@name='name']").setValue("Лебедева Ольга");
        $x("//*[@name='phone']").setValue("+79998887766");
        $(".checkbox__box").click();
        $$(".button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15)).shouldBe(visible);
    }

}
