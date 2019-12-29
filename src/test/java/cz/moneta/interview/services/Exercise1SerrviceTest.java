package cz.moneta.interview.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Exercise1SerrviceTest {

    @Autowired
    Exercise1Serrvice service;

    @Test
    @DisplayName("String se vraci v opacnem poradi")
    public void stringIsInReversedOrder() {
        final String qwrtp = service.reverseString("qwrtp");
        Assertions.assertEquals("ptrwq", qwrtp);
    }

    @Test
    @DisplayName("Dvojite mezery se mazou")
    public void deleteMultipleSpaces() {
        final String qwrtp = service.reverseString("qw  rt  p    ");
        Assertions.assertEquals("p tr wq", qwrtp);
    }

    @Test
    @DisplayName("Samohlasky budou velkymi")
    public void aeiouToUpperCase() {
        final String qwrtp = service.reverseString("aeiou");
        Assertions.assertEquals("UOIEA", qwrtp);
    }

    @Test
    @DisplayName("Public test 1")
    public void publicTest1() {
        final String qwrtp = service.reverseString("Je mi fajn.");
        Assertions.assertEquals(".NjaF iM ej", qwrtp);
    }

    @Test
    @DisplayName("Public test 2")
    public void publicTest2() {
        final String qwrtp = service.reverseString("Ahoj, jak se máš?");
        Assertions.assertEquals("?šÁm es kaj ,jOha", qwrtp);
    }
}