package cz.moneta.interview.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Exercise2ImplTest {

    @Autowired
    Exercise2Impl service;


    @Test
    void swapNumbersToRight() {
        String publicTest = "43256791";
        final String s = service.swapNumbersToRight(publicTest);
        Assertions.assertEquals("45326791", s);
    }

    @Test
    void multiplyTest() {
        String publicTest = "45326791";
        final String s = service.multiplyNumbers(publicTest);
        Assertions.assertEquals("453267181", s);
    }

    @Test
    void deleteSevens() {
        String publicTest = "453267181";
        final String s = service.deleteAllSevens(publicTest);
        Assertions.assertEquals("45326181", s);
    }

    @Test
    void countEvens() {
        String publicTest = "453267181";
        final Integer count = service.countEvenNumbers(publicTest);
        Assertions.assertEquals(4, count);
    }

    @Test
    void compute() {
        Long publicTest = 43256791L;
        final String ret = service.compute(publicTest);
        Assertions.assertEquals("11331545", ret);
    }
}